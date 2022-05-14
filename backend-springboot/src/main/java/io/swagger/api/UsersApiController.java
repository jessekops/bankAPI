package io.swagger.api;

import io.swagger.annotations.Api;
import io.swagger.model.LoginResponseDTO;
import io.swagger.model.UserDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-05-14T10:32:11.943Z[GMT]")
@RestController
@Api(tags = {"Customer", "Employee"})
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

    public ResponseEntity<LoginResponseDTO> login(@Parameter(in = ParameterIn.DEFAULT, description = "User object to compare to existing user", required=true, schema=@Schema()) @Valid @RequestBody UserDTO body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<LoginResponseDTO>(objectMapper.readValue("{\n  \"token\" : \"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c\"\n}", LoginResponseDTO.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<LoginResponseDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<LoginResponseDTO>(HttpStatus.NOT_IMPLEMENTED);
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
