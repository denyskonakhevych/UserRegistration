package com.staxter.service;

import com.staxter.exceptions.UserAlreadyExistsException;
import com.staxter.model.RegistrationData;
import com.staxter.userrepository.User;
import com.staxter.userrepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by Denys on 2017-05-20.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(RegistrationData registrationData) throws UserAlreadyExistsException {
        final User user = new User().setId(UUID.randomUUID().toString())
                .setFirstName(registrationData.getFirstName())
                .setLastName(registrationData.getLastName())
                .setUserName(registrationData.getUserName())
                .setPlainTextPassword(registrationData.getPassword())
                .setHashedPassword(hashPassword(registrationData.getPassword()));
        return userRepository.createUser(user);
    }

    private String hashPassword(String password) {
        return "" + password.hashCode();
    }
}
