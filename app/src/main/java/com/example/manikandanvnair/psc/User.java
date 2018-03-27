package com.example.manikandanvnair.psc;

/**
 * Created by manikandanvnair on 22/03/18.
 */

public class User {

    public String username;
    public String email;
    public String avatharURL;

    public static String UserRef = "Users";

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String username, String email, String avatharURL) {
        this.username = username;
        this.email = email;
        this.avatharURL = avatharURL;
    }
}
