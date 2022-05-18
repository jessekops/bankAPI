package io.swagger.api;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-05-18T15:53:51.610Z[GMT]")
@RestController
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
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<UserDTO>(objectMapper.readValue("{\n  \"firstname\" : \"John\",\n  \"address\" : \"Wolkenweg 15 8324AD Haarlem\",\n  \"active\" : true,\n  \"transLimit\" : 2000,\n  \"lastname\" : \"Doe\",\n  \"dayLimit\" : 5000,\n  \"phone\" : \"+31 0634534565\",\n  \"dob\" : \"1956-04-24T00:00:00.000+00:00\",\n  \"id\" : \"d290f1ee-6c54-4b01-90e6-d701748f0851\",\n  \"userType\" : \"employee\",\n  \"registeredOn\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"email\" : \"johndoe@example.com\",\n  \"username\" : \"FluffyUnicorn77\"\n}", UserDTO.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<UserDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<UserDTO>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<UserDTO> getUserByPhone(@Parameter(in = ParameterIn.PATH, description = "Phone Number input", required=true, schema=@Schema()) @PathVariable("phone") String phone) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<UserDTO>(objectMapper.readValue("{\n  \"firstname\" : \"John\",\n  \"address\" : \"Wolkenweg 15 8324AD Haarlem\",\n  \"active\" : true,\n  \"transLimit\" : 2000,\n  \"lastname\" : \"Doe\",\n  \"dayLimit\" : 5000,\n  \"phone\" : \"+31 0634534565\",\n  \"dob\" : \"1956-04-24T00:00:00.000+00:00\",\n  \"id\" : \"d290f1ee-6c54-4b01-90e6-d701748f0851\",\n  \"userType\" : \"employee\",\n  \"registeredOn\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"email\" : \"johndoe@example.com\",\n  \"username\" : \"FluffyUnicorn77\"\n}", UserDTO.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<UserDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<UserDTO>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<UserDTO> getUserByUsername(@Parameter(in = ParameterIn.PATH, description = "Username input", required=true, schema=@Schema()) @PathVariable("username") String username) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<UserDTO>(objectMapper.readValue("{\n  \"firstname\" : \"John\",\n  \"address\" : \"Wolkenweg 15 8324AD Haarlem\",\n  \"active\" : true,\n  \"transLimit\" : 2000,\n  \"lastname\" : \"Doe\",\n  \"dayLimit\" : 5000,\n  \"phone\" : \"+31 0634534565\",\n  \"dob\" : \"1956-04-24T00:00:00.000+00:00\",\n  \"id\" : \"d290f1ee-6c54-4b01-90e6-d701748f0851\",\n  \"userType\" : \"employee\",\n  \"registeredOn\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"email\" : \"johndoe@example.com\",\n  \"username\" : \"FluffyUnicorn77\"\n}", UserDTO.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<UserDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<UserDTO>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<TokenDTO> login(@Parameter(in = ParameterIn.DEFAULT, description = "Object with username and password to compare to existing data in DB", required=true, schema=@Schema()) @Valid @RequestBody LoginDTO body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<TokenDTO>(objectMapper.readValue("{\n  \"token\" : \"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c\"\n}", TokenDTO.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<TokenDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<TokenDTO>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<UserDTO> updateUser(@Parameter(in = ParameterIn.PATH, description = "Username input", required=true, schema=@Schema()) @PathVariable("username") String username,@Parameter(in = ParameterIn.DEFAULT, description = "Updated user object", required=true, schema=@Schema()) @Valid @RequestBody UserDTO body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<UserDTO>(objectMapper.readValue("{\n  \"firstname\" : \"John\",\n  \"address\" : \"Wolkenweg 15 8324AD Haarlem\",\n  \"active\" : true,\n  \"transLimit\" : 2000,\n  \"lastname\" : \"Doe\",\n  \"dayLimit\" : 5000,\n  \"phone\" : \"+31 0634534565\",\n  \"dob\" : \"1956-04-24T00:00:00.000+00:00\",\n  \"id\" : \"d290f1ee-6c54-4b01-90e6-d701748f0851\",\n  \"userType\" : \"employee\",\n  \"registeredOn\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"email\" : \"johndoe@example.com\",\n  \"username\" : \"FluffyUnicorn77\"\n}", UserDTO.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<UserDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<UserDTO>(HttpStatus.NOT_IMPLEMENTED);
    }

}
