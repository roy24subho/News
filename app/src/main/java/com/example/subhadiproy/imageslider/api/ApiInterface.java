package com.example.subhadiproy.imageslider.api;

import com.example.subhadiproy.imageslider.models.News;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("top-headlines?country=in&category=health")
    Call<News> getNews(

        @Query("country") String country ,
        @Query("apiKey") String apiKey

    );

}
