package com.staxter.userrepository;

/**
 * Created by Denys on 2017-05-20.
 */
public class User {
    private String id;
    private String firstName;
    private String lastName;
    private String userName;
    private String plainTextPassword;
    private String hashedPassword;

    public User() {
    }

    public User(User userToCopy) {
        this.id = userToCopy.id;
        this.firstName = userToCopy.firstName;
        this.lastName = userToCopy.lastName;
        this.userName = userToCopy.userName;
        this.plainTextPassword = userToCopy.plainTextPassword;
        this.hashedPassword = userToCopy.hashedPassword;
    }

    public User(String id, String firstName, String lastName, String userName, String plainTextPassword, String hashedPassword) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.plainTextPassword = plainTextPassword;
        this.hashedPassword = hashedPassword;
    }

    public String getId() {
        return id;
    }

    public User setId(String id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPlainTextPassword() {
        return plainTextPassword;
    }

    public User setPlainTextPassword(String plainTextPassword) {
        this.plainTextPassword = plainTextPassword;
        return this;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public User setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
        return this;
    }
}
