package com.example.studentapplication;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String ROOT_URL="https://api.myjson.com/";

    private static Retrofit getInstance(){
        return new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static APIService getAPIService(){
        return getInstance().create(APIService.class);
    }
}
