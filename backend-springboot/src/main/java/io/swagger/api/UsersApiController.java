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
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-05-23T13:04:25.984Z[GMT]")
@RestController
@Api(tags = {"Employee", "Customer"})
public class UsersApiController implements UsersApi {

    @Autowired
    private UserService userService;

    private ModelMapper mapper;

    private static final Logger log = LoggerFactory.getLogger(UsersApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    public UsersApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.mapper = new ModelMapper();
        this.request = request;
    }

    public ResponseEntity<UserDTO> addUser(@Parameter(in = ParameterIn.DEFAULT, description = "New user object", required=true, schema=@Schema()) @Valid @RequestBody UserDTO body) {

        // Map the UserDTO object from the body to a new User object
        User user = mapper.map(body, User.class);


        List<User> existingUsers = userService.getAll();
        for (User u : existingUsers)
        {
            // Check if the chosen username is already in use
            if(u.getUsername().equals(user.getUsername())){
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Username is already in use! Please try again");
            }

            // Check if the chosen email address is already in use
            if(u.getEmail().equals(user.getEmail())){
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Email address is already in use! Please try again");
            }

            // Check if the chosen phone number is already in use
            if(u.getPhone().equals(user.getPhone())){
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Phone number is already in use! Please try again");
            }
        }

        // Add the user to the DB
        user = userService.addUser(user);

        // Respond with the new User, mapped to a UserDTO object
        UserDTO response = mapper.map(user, UserDTO.class);
        return new ResponseEntity<UserDTO>(response,HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('EMPLOYEE')")
    public ResponseEntity<UserDTO> getByEmail(@Parameter(in = ParameterIn.PATH, description = "Email input", required=true, schema=@Schema()) @PathVariable("email") String email) {

        try{
            User searchResult = userService.findByEmail(email);

            UserDTO response = mapper.map(searchResult, UserDTO.class);

            return new ResponseEntity<UserDTO>(response, HttpStatus.OK);
        }
        catch (IllegalArgumentException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with given email address not found.");
        }


    }

    @PreAuthorize("hasRole('EMPLOYEE')")
    public ResponseEntity<UserDTO> getByUsername(@Parameter(in = ParameterIn.PATH, description = "Username input", required=true, schema=@Schema()) @PathVariable("username") String username) {

        try{
            User searchResult = userService.findByUsername(username);

            UserDTO response = mapper.map(searchResult, UserDTO.class);

            return new ResponseEntity<UserDTO>(response, HttpStatus.OK);
        }
        catch (IllegalArgumentException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with given username not found.");
        }
    }

    // Does the JpaRepo just know which record in the DB to override?? --> Nope!
    @PreAuthorize("hasAnyRole('EMPLOYEE', 'CUSTOMER')") //hasAnyRole('EMPLOYEE', 'CUSTOMER') //hasRole('CUSTOMER')
    public ResponseEntity<UserDTO> updateUser(@Parameter(in = ParameterIn.PATH, description = "Username input", required=true, schema=@Schema()) @PathVariable("username") String username,@Parameter(in = ParameterIn.DEFAULT, description = "Updated user object", required=true, schema=@Schema()) @Valid @RequestBody UserDTO body) {

        User user = mapper.map(body, User.class);
        user = userService.updateUser(user);

        UserDTO response = mapper.map(user, UserDTO.class);
        return new ResponseEntity<UserDTO>(response, HttpStatus.CREATED);
    }

}
