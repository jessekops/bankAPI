package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.model.dto.AccountDTO;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.IOException;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-05-23T13:04:25.984Z[GMT]")
@RestController
@Api(tags = {"Employee", "Customer"})
public class AccountsApiController implements AccountsApi {

    private static final Logger log = LoggerFactory.getLogger(AccountsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public AccountsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<AccountDTO> addAccount(@Parameter(in = ParameterIn.DEFAULT, description = "New account object", required=true, schema=@Schema()) @Valid @RequestBody AccountDTO body) {

        return new ResponseEntity<AccountDTO>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<AccountDTO> getAccount(@Parameter(in = ParameterIn.PATH, description = "IBAN input", required=true, schema=@Schema()) @PathVariable("iban") String iban) {

        return new ResponseEntity<AccountDTO>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<AccountDTO>> getAccounts(@Min(0)@Parameter(in = ParameterIn.QUERY, description = "Number of records to skip for pagination" ,schema=@Schema(allowableValues={  }
)) @Valid @RequestParam(value = "skip", required = false) Integer skip,@Min(1) @Max(200000) @Parameter(in = ParameterIn.QUERY, description = "Maximum number of records to return" ,schema=@Schema(allowableValues={  }, minimum="1", maximum="200000"
)) @Valid @RequestParam(value = "limit", required = false) Integer limit) {

        return new ResponseEntity<List<AccountDTO>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<AccountDTO> updateAccount(@Parameter(in = ParameterIn.PATH, description = "IBAN input", required=true, schema=@Schema()) @PathVariable("iban") String iban,@Parameter(in = ParameterIn.DEFAULT, description = "Updated account object", required=true, schema=@Schema()) @Valid @RequestBody AccountDTO body) {

        return new ResponseEntity<AccountDTO>(HttpStatus.NOT_IMPLEMENTED);
    }

}
