package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.model.dto.TransactionDTO;
import io.swagger.model.dto.UserDTO;
import io.swagger.model.entity.Transaction;
import io.swagger.model.entity.User;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.UUID;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-05-23T13:04:25.984Z[GMT]")
@RestController
@Api(tags = {"Employee", "Customer"})
public class TransactionsApiController implements TransactionsApi {

    @Autowired
    private TransactionService transService;

    private static final Logger log = LoggerFactory.getLogger(TransactionsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public TransactionsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<TransactionDTO> createTransaction(@Parameter(in = ParameterIn.DEFAULT, description = "New transaction object", required=true, schema=@Schema()) @Valid @RequestBody TransactionDTO body) {

        ModelMapper mapper = new ModelMapper();

        Transaction trans = mapper.map(body, Transaction.class);
        trans = transService.createTransaction(trans);

        TransactionDTO response = mapper.map(trans, TransactionDTO.class);
        return new ResponseEntity<TransactionDTO>(response, HttpStatus.CREATED);
    }

    public ResponseEntity<Void> deleteTransaction(@Parameter(in = ParameterIn.PATH, description = "Transaction ID input", required=true, schema=@Schema()) @PathVariable("id") UUID id) {

        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<TransactionDTO> getTransaction(@Parameter(in = ParameterIn.PATH, description = "Transaction ID input", required=true, schema=@Schema()) @PathVariable("id") UUID id) {

        return new ResponseEntity<TransactionDTO>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<TransactionDTO> updateTransaction(@Parameter(in = ParameterIn.PATH, description = "Transaction ID input", required=true, schema=@Schema()) @PathVariable("id") UUID id,@Parameter(in = ParameterIn.DEFAULT, description = "Updated transaction object", required=true, schema=@Schema()) @Valid @RequestBody TransactionDTO body) {

        return new ResponseEntity<TransactionDTO>(HttpStatus.NOT_IMPLEMENTED);
    }

}
