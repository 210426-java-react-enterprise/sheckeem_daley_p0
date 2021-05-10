package com.revature.bank.users;

import com.revature.bank.utils.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AppUser {
    private boolean clientActive;
    private char sex;
    private int id;
    private int ssn;
    private String clientSince;
    private String username;
    private String password; //No getter for password is intentional
    private String email;
    private String firstName;
    private String lastName;
    private String phone;

    public AppUser() {}

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    // returns full name rather than individual getters
    public String getName() {
        return firstName + " " + lastName;
    }

    public String getEmail() {
        return email;
    }

    //might not be necessary since id should be serial
    public void setId (int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // No getter for Password is intentional
    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setClientActive(boolean clientActive) {
        this.clientActive = clientActive;
    }

    public void setClientSince(String clientSince) {
        this.clientSince = clientSince;
    }

    public void setSex(String sex) {
        this.sex = sex.toCharArray()[0];
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

