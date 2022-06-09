package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.model.dto.AccountDTO;
import io.swagger.model.entity.Account;
import io.swagger.model.entity.User;
import io.swagger.service.AccountIbanGenService;
import io.swagger.service.AccountService;
import io.swagger.service.UserService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-06-01T10:34:07.804Z[GMT]")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(tags = {"Employee", "Customer"})
public class AccountsApiController implements AccountsApi {


    private static final Logger log = LoggerFactory.getLogger(AccountsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private ModelMapper modelMapper;

    @Autowired
    private AccountService accountService;
    @Autowired
    private UserService userService;
    @Autowired
    private AccountIbanGenService accountIbanService;

    @org.springframework.beans.factory.annotation.Autowired
    public AccountsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.modelMapper = new ModelMapper();
        this.request = request;
    }

    @PreAuthorize("hasRole('EMPLOYEE')")
    public ResponseEntity<AccountDTO> addAccount(@Parameter(in = ParameterIn.DEFAULT, description = "New account object", required=true, schema=@Schema()) @Valid @RequestBody AccountDTO body) {
            try {
                Account a = modelMapper.map(body, Account.class);
                User u = userService.findById(body.getOwnerId());
                a.setUser(u);

                a = accountService.addAccount(a);

                AccountDTO resp = modelMapper.map(a, AccountDTO.class);
                resp.setOwnerId(u.getId());

                return new ResponseEntity<AccountDTO>(resp, HttpStatus.CREATED);
            }
            catch (IllegalArgumentException ex) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Something went wrong");
            }
    }

    @PreAuthorize("hasAnyRole('EMPLOYEE', 'CUSTOMER')")
    public ResponseEntity<List<AccountDTO>> getAccountsByOwnerID(@Parameter(in = ParameterIn.PATH, description = "User ID input", required=true, schema=@Schema()) @PathVariable("userID") UUID userID) {

        List<Account> accountList = accountService.findAccountsByUserId(userID);
        List<AccountDTO> responsedto = accountList
                .stream()
                .map(user -> modelMapper.map(user, AccountDTO.class))
                .collect(Collectors.toList());

        for (int i = 0; i < responsedto.size(); i++) {
            responsedto.get(i).setOwnerId(accountList.get(i).getUser().getId());
        }

        return new ResponseEntity<List<AccountDTO>>(responsedto, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('EMPLOYEE', 'CUSTOMER')")
    public ResponseEntity<AccountDTO> getAccountByIban(@Parameter(in = ParameterIn.PATH, description = "IBAN input", required=true, schema=@Schema()) @PathVariable("iban") String iban) {

        try{
            Account foundAccount = accountService.findAccountByIban(iban);

            AccountDTO response = modelMapper.map(foundAccount, AccountDTO.class);

            response.setOwnerId(foundAccount.getUser().getId());

            return new ResponseEntity<AccountDTO>(response, HttpStatus.OK);
        }
        catch (IllegalArgumentException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account with given Iban not found.");
        }

    }
    @PreAuthorize("hasAnyRole('EMPLOYEE')")
    public ResponseEntity<List<AccountDTO>> getAccounts(@Min(0)@Parameter(in = ParameterIn.QUERY, description = "Number of records to skip for pagination" ,schema=@Schema(allowableValues={  }
)) @Valid @RequestParam(value = "skip", required = false) Integer skip,@Min(1) @Max(200000) @Parameter(in = ParameterIn.QUERY, description = "Maximum number of records to return" ,schema=@Schema(allowableValues={  }, minimum="1", maximum="200000"
)) @Valid @RequestParam(value = "limit", required = false) Integer limit) {

        List<Account> accountList = accountService.getAll();
        //logic for skip limit
        Long newLimit = null;
        if(skip == null ) skip = 0;
        if(limit == null) {
             newLimit = Long.MAX_VALUE;
        }
        else {
             newLimit = limit.longValue();
        }
        List<AccountDTO> dtos = accountList
                    .stream()
                    .map(user -> modelMapper.map(user, AccountDTO.class))
                    .skip(skip).limit(newLimit)
                    .collect(Collectors.toList());
        for (int i = 0; i < dtos.size(); i++) {
            dtos.get(i).setOwnerId(accountList.get(i).getUser().getId());
        }

        return new ResponseEntity<List<AccountDTO>>(dtos, HttpStatus.OK);
    }
    @PreAuthorize("hasAnyRole('EMPLOYEE', 'CUSTOMER')")
    public ResponseEntity<AccountDTO> updateAccount(@Parameter(in = ParameterIn.PATH, description = "IBAN input", required=true, schema=@Schema()) @PathVariable("iban") String iban,@Parameter(in = ParameterIn.DEFAULT, description = "Updated account object", required=true, schema=@Schema()) @Valid @RequestBody AccountDTO body) {

        Account account = modelMapper.map(body, Account.class);
        account = accountService.updateAccount(account);
        AccountDTO response = modelMapper.map(account, AccountDTO.class);


        return new ResponseEntity<AccountDTO>(response, HttpStatus.CREATED);
    }

}
