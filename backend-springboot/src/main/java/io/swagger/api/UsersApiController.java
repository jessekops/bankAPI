package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.model.dto.UserDTO;
import io.swagger.model.entity.User;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-05-23T13:04:25.984Z[GMT]")
@RestController
@Api(tags = {"Employee", "Customer"})
public class UsersApiController implements UsersApi {

    @Autowired
    private UserService userService;

    private static final Logger log = LoggerFactory.getLogger(UsersApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public UsersApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<UserDTO> addUser(@Parameter(in = ParameterIn.DEFAULT, description = "New user object", required=true, schema=@Schema()) @Valid @RequestBody UserDTO body) {

        ModelMapper mapper = new ModelMapper();

        User user = mapper.map(body, User.class);
        user = userService.addUser(user);

        UserDTO response = mapper.map(user, UserDTO.class);
        return new ResponseEntity<UserDTO>(HttpStatus.CREATED);
    }

    public ResponseEntity<UserDTO> getByEmail(@Parameter(in = ParameterIn.PATH, description = "Email input", required=true, schema=@Schema()) @PathVariable("email") String email) {

        return new ResponseEntity<UserDTO>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<UserDTO> getByUsername(@Parameter(in = ParameterIn.PATH, description = "Username input", required=true, schema=@Schema()) @PathVariable("username") String username) {
        return new ResponseEntity<UserDTO>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PreAuthorize("hasRole({'CUSTOMER', 'EMPLOYEE'})")
    public ResponseEntity<UserDTO> updateUser(@Parameter(in = ParameterIn.PATH, description = "Username input", required=true, schema=@Schema()) @PathVariable("username") String username,@Parameter(in = ParameterIn.DEFAULT, description = "Updated user object", required=true, schema=@Schema()) @Valid @RequestBody UserDTO body) {
        return new ResponseEntity<UserDTO>(HttpStatus.NOT_IMPLEMENTED);
    }

}
