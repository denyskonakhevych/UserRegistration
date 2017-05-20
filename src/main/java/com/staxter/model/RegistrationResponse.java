package com.staxter.model;

import com.staxter.userrepository.User;

/**
 * Created by Denys on 2017-05-20.
 */
public class RegistrationResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String userName;

    public RegistrationResponse() {
    }

    public RegistrationResponse(String id, String firstName, String lastName, String userName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
    }

    public RegistrationResponse(User user) {
        this(user.getId(), user.getFirstName(), user.getLastName(), user.getUserName());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
