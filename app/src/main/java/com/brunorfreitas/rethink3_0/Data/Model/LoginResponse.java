package com.brunorfreitas.rethink3_0.Data.Model;

import com.brunorfreitas.rethink3_0.Data.Model.User;

public class LoginResponse {

    private String token;
    private User user;

    public LoginResponse() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
