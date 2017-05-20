package com.staxter.userrepository.impl;

import com.staxter.exceptions.UserAlreadyExistsException;
import com.staxter.userrepository.User;
import com.staxter.userrepository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Denys on 2017-05-20.
 */
@Repository("mockedUserRepository")
public class MockedUserRepository implements UserRepository{
    private final Map<String, User> table = new ConcurrentHashMap<>();
    @Override
    public User createUser(User user) throws UserAlreadyExistsException {
        User result = table.putIfAbsent(user.getUserName(), user);
        if(result == null)
            return user;
        else
            throw new UserAlreadyExistsException();
    }
}
