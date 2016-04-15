package com.google.everloser12.loginexample.rest.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by al-ev on 11.04.2016.
 */
public class Users {

    @SerializedName("user-token")
    private String userToken;
    private String email;
    private Date lastLogin;
    private String name;

    private String objectId;
    private Date updated;
    private Date created;
    private String ownerId;

    @Override
    public String toString() {
        return "Users{" +
                "\nuserToken = '" + userToken + '\'' +
                ",\nemail = '" + email + '\'' +
                ",\nlastLogin = " + lastLogin +
                ",\nname = '" + name + '\'' +
                ",\nobjectId = '" + objectId + '\'' +
                ",\nupdated = " + updated +
                ",\ncreated = " + created +
                ",\nownerId = '" + ownerId + '\'' +
                '}';
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getEmail() {
        return email;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public String getName() {
        return name;
    }

    public String getObjectId() {
        return objectId;
    }

    public Date getUpdated() {
        return updated;
    }

    public Date getCreated() {
        return created;
    }

    public String getOwnerId() {
        return ownerId;
    }
}
