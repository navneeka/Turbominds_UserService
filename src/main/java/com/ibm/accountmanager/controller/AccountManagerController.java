package com.ibm.accountmanager.controller;

import com.ibm.accountmanager.api.AccountAPI;
import com.ibm.accountmanager.domain.User;
import com.ibm.accountmanager.domain.UserData;
import com.ibm.accountmanager.impl.AccountManagerServiceImpl;
import com.ibm.accountmanager.domain.Error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;


/**
 * Controller layer test cases for account manager.
 * 
 * @author LingarajSahoo
 *
 */
@Api(value = "osb")
@RequestMapping(value = "/osb/account",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
@RestController
public class AccountManagerController implements AccountAPI {

	@Autowired
	private AccountManagerServiceImpl accountAPI;
		
	@ApiOperation(value = "Generate the token which will be used while calling other API.", nickname = "login", notes = "This API will validate the user with the given user id and password and return the acccess token which will be used to call other API", response = String.class, tags={ "Service API" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Token string", response = String.class),
        @ApiResponse(code = 400, message = "Invalid input", response = Error.class),
        @ApiResponse(code = 404, message = "User Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Validation Exception", response = Error.class) })
    @RequestMapping(value = "/_login",
        method = RequestMethod.PUT)
	@CrossOrigin(origins = "*")
    public String login(@ApiParam(value = "A valid user with valid user id and password." ,required=true ) @RequestBody User validUser) {
		return accountAPI.login(validUser);
	}


    @ApiOperation(value = "Logout API to delete the token after uses.", nickname = "logout", notes = "This API delete the generated token which was generated by login operation", response = Boolean.class, tags={ "Service API" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Returns true or false based on the successfull and unsuccessfull posting", response = Boolean.class),
        @ApiResponse(code = 400, message = "Invalid input", response = Error.class),
        @ApiResponse(code = 404, message = "User Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Validation Exception", response = Error.class) })
    @RequestMapping(value = "/_logout",
        method = RequestMethod.PUT)
    @CrossOrigin(origins = "*")
    public Boolean logout(@ApiParam(value = "Token for valid user." ,required=true) @RequestHeader(value="tokenId", required=true) String tokenId) {
    	return accountAPI.logout(tokenId);
    }


    @ApiOperation(value = "Register user", nickname = "registerUser", notes = "Register user", response = Boolean.class, tags={ "Service API" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Returns true or false based on the successfull and unsuccessfull posting", response = Boolean.class),
        @ApiResponse(code = 400, message = "Invalid input", response = Error.class),
        @ApiResponse(code = 404, message = "Error while registering", response = Error.class),
        @ApiResponse(code = 405, message = "Validation Exception", response = Error.class) })
    @RequestMapping(value = "/_register",
        method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public Boolean registerUser(@ApiParam(value = "User data to create a user." ,required=true ) @RequestBody UserData userData) {
    	return accountAPI.registerUser(userData);
    }


    @ApiOperation(value = "Validate the user if user is valid and logged in.", nickname = "validateUser", notes = "This API will validate the user based on the token id provided", response = Boolean.class, tags={ "Service API" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Returns true or false based on the successfull and unsuccessfull posting", response = Boolean.class),
        @ApiResponse(code = 400, message = "Invalid input", response = Error.class),
        @ApiResponse(code = 404, message = "Error while validating", response = Error.class),
        @ApiResponse(code = 405, message = "Validation Exception", response = Error.class) })
    @RequestMapping(value = "/_validate",
        method = RequestMethod.GET)
    @CrossOrigin(origins = "*")
    public Boolean validateUser(@ApiParam(value = "Token for valid user." ,required=true) @RequestHeader(value="tokenId", required=true) String tokenId) {
    	return accountAPI.validateUser(tokenId);
    }
}