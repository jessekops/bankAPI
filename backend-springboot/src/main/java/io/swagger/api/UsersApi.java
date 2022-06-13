/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.34).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.dto.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-06-13T15:28:15.134Z[GMT]")
@Validated
public interface UsersApi {

    @Operation(summary = "Register User Data", description = "", tags = {"Customer"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserDTO.class))),

            @ApiResponse(responseCode = "400", description = "Invalid user object")})
    @RequestMapping(value = "/users",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<UserDTO> addUser(@Parameter(in = ParameterIn.DEFAULT, description = "New user object", required = true, schema = @Schema()) @Valid @RequestBody UserDTO body);


    @Operation(summary = "Search a user list with pagination", description = "By passing in the appropriate options, you can search for users in the DB ", security = {
            @SecurityRequirement(name = "bearerAuth")}, tags = {"Employee"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Users found", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = UserDTO.class)))),

            @ApiResponse(responseCode = "404", description = "No users found")})
    @RequestMapping(value = "/users",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<UserDTO>> getAllUsers(@Min(0) @Parameter(in = ParameterIn.QUERY, description = "Number of records to skip for pagination", schema = @Schema(allowableValues = {}
    )) @Valid @RequestParam(value = "skip", required = false) Integer skip, @Min(1) @Max(200000) @Parameter(in = ParameterIn.QUERY, description = "Maximum number of records to return", schema = @Schema(allowableValues = {}, minimum = "1", maximum = "200000"
    )) @Valid @RequestParam(value = "limit", required = false) Integer limit);


    @Operation(summary = "Find all user without an account", description = "", security = {
            @SecurityRequirement(name = "bearerAuth")}, tags = {"Employee"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Users found", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = UserDTO.class)))),

            @ApiResponse(responseCode = "404", description = "All users have an account or user not found")})
    @RequestMapping(value = "/users/getAllWithoutAccount",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<UserDTO>> getAllUsersWithoutAccount();


    @Operation(summary = "Search a user list on email address", description = "", security = {
            @SecurityRequirement(name = "bearerAuth")}, tags = {"Employee"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserDTO.class))),

            @ApiResponse(responseCode = "404", description = "User not found")})
    @RequestMapping(value = "/users/getByEmail/{email}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<UserDTO> getByEmail(@Parameter(in = ParameterIn.PATH, description = "Email input", required = true, schema = @Schema()) @PathVariable("email") String email);


    @Operation(summary = "Search a user list on username", description = "", security = {
            @SecurityRequirement(name = "bearerAuth")}, tags = {"Employee"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserDTO.class))),

            @ApiResponse(responseCode = "404", description = "User not found")})
    @RequestMapping(value = "/users/getByUsername/{username}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<UserDTO> getByUsername(@Parameter(in = ParameterIn.PATH, description = "Username input", required = true, schema = @Schema()) @PathVariable("username") String username);


    @Operation(summary = "Updates a user", description = "By sending this request, an employee or customer can update the information of one user ", security = {
            @SecurityRequirement(name = "bearerAuth")}, tags = {"Employee", "Customer"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found and updated", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserDTO.class))),

            @ApiResponse(responseCode = "404", description = "User not found")})
    @RequestMapping(value = "/users/getByUsername/{username}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    ResponseEntity<UserDTO> updateUser(@Parameter(in = ParameterIn.PATH, description = "Username input", required = true, schema = @Schema()) @PathVariable("username") String username, @Parameter(in = ParameterIn.DEFAULT, description = "Updated user object", required = true, schema = @Schema()) @Valid @RequestBody UserDTO body);

}

