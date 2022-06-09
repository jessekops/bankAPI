package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.model.dto.TransactionDTO;
import io.swagger.model.entity.Account;
import io.swagger.model.entity.Transaction;
import io.swagger.model.entity.User;
import io.swagger.service.AccountService;
import io.swagger.service.TransactionService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.threeten.bp.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;
import java.util.UUID;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-05-23T13:04:25.984Z[GMT]")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(tags = {"Employee", "Customer"})
public class TransactionsApiController implements TransactionsApi {

    @Autowired
    private TransactionService transService;

    @Autowired
    private AccountService accountService;

    private ModelMapper modelMapper;

    private static final Logger log = LoggerFactory.getLogger(TransactionsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public TransactionsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.modelMapper = new ModelMapper();
    }

    public ResponseEntity<TransactionDTO> createTransaction(@Parameter(in = ParameterIn.PATH, description = "Method input; specify if transaction is Regular, Withdrawal or Deposit", required=true, schema=@Schema()) @PathVariable("transactionMethod") String transactionMethod,@Parameter(in = ParameterIn.DEFAULT, description = "New transaction object", required=true, schema=@Schema()) @Valid @RequestBody TransactionDTO body) {

        try {

            Transaction trans = modelMapper.map(body, Transaction.class);
            trans.setId(UUID.randomUUID());
            trans.setFrom(accountService.findAccountByIban(body.getFrom()));

            switch (transactionMethod){
                case "Regular":
                    trans = transService.createTransaction(trans);
                    break;
                case "Withdrawal":
                    trans = transService.createWithdrawal(trans);
                    break;
                case "Deposit":
                    trans = transService.createDeposit(trans);
                    break;
            }

//            trans.setFrom(null);

            TransactionDTO response = modelMapper.map(trans, TransactionDTO.class);

            response.setFrom(body.getFrom());

            return new ResponseEntity<TransactionDTO>(response, HttpStatus.CREATED);

        } catch (IllegalArgumentException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }

    public ResponseEntity<Void> deleteTransaction(@Parameter(in = ParameterIn.PATH, description = "Transaction ID input", required = true, schema = @Schema()) @PathVariable("id") UUID id) {
        try {
            transService.deleteTransaction(id);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No transactions found with given ID");
        }
    }

    public ResponseEntity<TransactionDTO> getTransaction(@Parameter(in = ParameterIn.PATH, description = "Transaction ID input", required = true, schema = @Schema()) @PathVariable("id") UUID id) {
        try {
            Transaction trans = transService.findTransactionById(id);
            TransactionDTO response = modelMapper.map(trans, TransactionDTO.class);
            return new ResponseEntity<TransactionDTO>(response, HttpStatus.OK);

        } catch (IllegalArgumentException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No transactions found with given ID");
        }
    }

    public ResponseEntity<TransactionDTO> updateTransaction(@Parameter(in = ParameterIn.PATH, description = "Transaction ID input", required = true, schema = @Schema()) @PathVariable("id") UUID id, @Parameter(in = ParameterIn.DEFAULT, description = "Updated transaction object", required = true, schema = @Schema()) @Valid @RequestBody TransactionDTO body) {
        try {
            Transaction trans = modelMapper.map(body, Transaction.class);
            trans = transService.updateTransaction(trans);

            TransactionDTO response = modelMapper.map(trans, TransactionDTO.class);
            return new ResponseEntity<TransactionDTO>(response, HttpStatus.CREATED);
        } catch (IllegalArgumentException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No transactions found with given ID");
        }
    }

}
