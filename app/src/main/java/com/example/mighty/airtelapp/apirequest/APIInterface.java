package com.example.mighty.airtelapp.apirequest;

import com.example.mighty.airtelapp.model.Feed;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface APIInterface {

    String BASE_URL = "http://phplaravel-116401-370897.cloudwaysapps.com/";

    @Headers("Content-Type: application/json")
    @GET("api/admin/data_request")
    Call<Feed> getData();
}
