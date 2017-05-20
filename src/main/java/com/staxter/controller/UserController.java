package com.staxter.controller;

import com.staxter.exceptions.UserAlreadyExistsException;
import com.staxter.model.FaultResponse;
import com.staxter.model.FaultResponses;
import com.staxter.model.RegistrationData;
import com.staxter.model.RegistrationResponse;
import com.staxter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Denys on 2017-05-20.
 */
@RestController
@RequestMapping("/userservice")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello!";
    }

    @RequestMapping("/register")
    @PostMapping
    public RegistrationResponse register(@RequestBody RegistrationData registrationData) throws UserAlreadyExistsException {
        return new RegistrationResponse(userService.createUser(registrationData));
    }

    @ExceptionHandler({ UserAlreadyExistsException.class })
    @ResponseStatus(HttpStatus.CONFLICT)
    public FaultResponse handleException(UserAlreadyExistsException exception) {
        return FaultResponses.USER_ALREADY_EXISTS.getResponse();
    }
}
