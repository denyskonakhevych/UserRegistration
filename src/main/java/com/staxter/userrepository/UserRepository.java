package com.staxter.userrepository;

import com.staxter.exceptions.UserAlreadyExistsException;

/**
 * Created by Denys on 2017-05-20.
 */
public interface UserRepository {
    User createUser(User user) throws UserAlreadyExistsException;
}
