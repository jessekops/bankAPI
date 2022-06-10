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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-05-23T13:04:25.984Z[GMT]")
@RestController

@CrossOrigin(origins = "*", allowedHeaders = "*")
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

    // No role is needed for this endpoint, since there isn't a token yet.
    public ResponseEntity<UserDTO> addUser(@Parameter(in = ParameterIn.DEFAULT, description = "New user object", required = true, schema = @Schema()) @Valid @RequestBody UserDTO body) {

        try{
            // Map the UserDTO object from the body to a new User object
            User user = mapper.map(body, User.class);

            // Check if user exist with the given user's username, email or phone number
            userService.doesUserExist(user);

            // Add the user to the DB
            user = userService.addUser(user);

            // Respond with the new User, mapped to a UserDTO object
            UserDTO response = mapper.map(user, UserDTO.class);
            return new ResponseEntity<UserDTO>(response, HttpStatus.CREATED);
        }
        catch(IllegalArgumentException ex){
            throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage());
        }

    }

    @PreAuthorize("hasAnyRole('EMPLOYEE', 'CUSTOMER')")
    public ResponseEntity<UserDTO> updateUser(@Parameter(in = ParameterIn.PATH, description = "Username input", required = true, schema = @Schema()) @PathVariable("username") String username, @Parameter(in = ParameterIn.DEFAULT, description = "Updated user object", required = true, schema = @Schema()) @Valid @RequestBody UserDTO body) {

        User user = mapper.map(body, User.class);

        // Get a list of all the existing user in the DB
        List<User> existingUsers = userService.getAll();
        boolean userExists = true;
        for (User u : existingUsers) {
            // Check if the request user to be updated, exists in the DB
            if (user.getId().compareTo(u.getId()) != 0) {
                userExists = false;
            } else {
                userExists = true;
                break;
            }
        }

        // If the user does not exist, throw an exception
        if (!userExists) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "The user with the requested ID" + " (" + user.getId() + ") " + "could not be updated; user does not exist");
        }

        user = userService.updateUser(user);

        UserDTO response = mapper.map(user, UserDTO.class);
        return new ResponseEntity<UserDTO>(response, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('EMPLOYEE')")
    public ResponseEntity<UserDTO> getByEmail(@Parameter(in = ParameterIn.PATH, description = "Email input", required = true, schema = @Schema()) @PathVariable("email") String email) {

        try {
            User searchResult = userService.findByEmail(email);

            UserDTO response = mapper.map(searchResult, UserDTO.class);

            return new ResponseEntity<UserDTO>(response, HttpStatus.OK);
        } catch (IllegalArgumentException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with given email address not found.");
        }


    }

    @PreAuthorize("hasRole('EMPLOYEE')")
    public ResponseEntity<UserDTO> getByUsername(@Parameter(in = ParameterIn.PATH, description = "Username input", required = true, schema = @Schema()) @PathVariable("username") String username) {

        try {
            User searchResult = userService.findByUsername(username);

            UserDTO response = mapper.map(searchResult, UserDTO.class);

            return new ResponseEntity<UserDTO>(response, HttpStatus.OK);
        } catch (IllegalArgumentException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with given username not found.");
        }
    }

    @PreAuthorize("hasRole('EMPLOYEE')")
    public ResponseEntity<List<UserDTO>> getAllUsersWithoutAccount() {

        List<User> users = userService.getAllWithoutAccount();

        List<UserDTO> dtos = users
                .stream()
                .map(user -> mapper.map(user, UserDTO.class))
                .collect(Collectors.toList());

        return new ResponseEntity<List<UserDTO>>(dtos, HttpStatus.OK);
    }
}
