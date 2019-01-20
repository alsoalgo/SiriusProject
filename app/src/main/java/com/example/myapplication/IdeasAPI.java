package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IdeasAPI {
    @GET("ideas/{id}")
    public Call<Idea> getIdeaWithID(@Path("id") int id);

    @GET("ideas")
    public Call<List<Idea>> getAllIdeas();

    @POST("ideas")
    public Call<Idea> postIdea(@Body ToPost request);

    @PUT("ideas/{id}")
    Call<Idea> updateIdea(@Path("id") int id, @Body ToPost idea);
}
