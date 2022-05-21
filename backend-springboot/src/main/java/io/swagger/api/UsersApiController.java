package io.swagger.api;

import io.swagger.annotations.Api;
import io.swagger.model.dto.LoginDTO;
import io.swagger.model.dto.TokenDTO;
import io.swagger.model.dto.UserDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-05-18T15:53:51.610Z[GMT]")
@RestController
@Api(tags = {"Employee", "Customer"})
public class UsersApiController implements UsersApi {

    private static final Logger log = LoggerFactory.getLogger(UsersApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public UsersApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }


    public ResponseEntity<UserDTO> addUser(@Parameter(in = ParameterIn.DEFAULT, description = "New user object", required=true, schema=@Schema()) @Valid @RequestBody UserDTO body) {

        return new ResponseEntity<UserDTO>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<UserDTO> getUserByPhone(@Parameter(in = ParameterIn.PATH, description = "Phone Number input", required=true, schema=@Schema()) @PathVariable("phone") String phone) {

        return new ResponseEntity<UserDTO>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<UserDTO> getUserByUsername(@Parameter(in = ParameterIn.PATH, description = "Username input", required=true, schema=@Schema()) @PathVariable("username") String username) {

        return new ResponseEntity<UserDTO>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<TokenDTO> login(@Parameter(in = ParameterIn.DEFAULT, description = "Object with username and password to compare to existing data in DB", required=true, schema=@Schema()) @Valid @RequestBody LoginDTO body) {

        return new ResponseEntity<TokenDTO>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PreAuthorize("hasRole('CUSTOMER')")
    public ResponseEntity<UserDTO> updateUser(@Parameter(in = ParameterIn.PATH, description = "Username input", required=true, schema=@Schema()) @PathVariable("username") String username,@Parameter(in = ParameterIn.DEFAULT, description = "Updated user object", required=true, schema=@Schema()) @Valid @RequestBody UserDTO body) {

        return new ResponseEntity<UserDTO>(HttpStatus.NOT_IMPLEMENTED);
    }

}
