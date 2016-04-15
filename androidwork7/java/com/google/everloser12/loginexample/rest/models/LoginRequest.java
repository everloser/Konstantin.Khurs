package com.google.everloser12.loginexample.rest.models;

/**

 * Created by al-ev on 13.04.2016.
 */
public class LoginRequest {
    private String login;
    private String password;

    public LoginRequest(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
