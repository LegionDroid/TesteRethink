package com.brunorfreitas.rethink3_0.Data.Model;

public class Login {

    private String username;
    private String password;

    public Login(String username) {
        this.username = username;
        this.password = username+"@123";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

}
