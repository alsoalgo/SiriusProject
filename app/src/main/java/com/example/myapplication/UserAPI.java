package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserAPI {
    @GET("users/{token}")
    public Call<Idea> getIdeaWithID(@Path("token") String token);

    @POST("auth")
    public Call<User> authorize(@Body ToAuthorize request);

    @GET("users")
    public Call<List<User>> getAllUsers();

    @POST("users")
    public Call<User> register(@Body ToRegister request);

    @PUT("users/{token}")
    Call<Idea> updateUser(@Path("token") String token, @Body ToRegister request);

}