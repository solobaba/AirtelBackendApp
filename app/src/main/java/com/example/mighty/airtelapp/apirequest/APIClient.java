package com.example.mighty.airtelapp.apirequest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    public static final String BASE_URL = "http://phplaravel-116401-370897.cloudwaysapps.com/";
    public static Retrofit retrofit = null;
    public static Retrofit getAPIClient(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }return retrofit;
    }
}
