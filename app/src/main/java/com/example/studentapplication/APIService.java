package com.example.studentapplication;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("bins/lxm9e")
    Call<StudentList> getJSON();

}
