package com.google.everloser12.loginexample.rest;

import com.google.everloser12.loginexample.rest.models.LoginRequest;
import com.google.everloser12.loginexample.rest.models.RegisterRequest;
import com.google.everloser12.loginexample.rest.models.Users;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by al-ev on 11.04.2016.
 */
public interface IBaasApi {

//    @GET("profile/{id}/")
//    Call<Users> getProfile(@Path("id") String userId);

    @POST("v1/users/login")
    Call<Users> login(@Body LoginRequest loginRequest);

    @POST("v1/users/register")
    Call<Users> register(@Body RegisterRequest registerRequest);

}
