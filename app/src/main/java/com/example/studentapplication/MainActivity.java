package com.example.studentapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<Student> studentList;
    Student student;
    ProgressBar progressBar;
    RecyclerView recyclerView;
    StudentAdapter adapter;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.viewStudentRecycler);
        progressBar.setVisibility(View.VISIBLE);
        login=findViewById(R.id.logbtn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(MainActivity.this,LoginActivity.class));
                startActivity(intent);
            }
        });

        APIService api = RetrofitClient.getAPIService();
        Call<StudentList> call= api.getJSON();

        call.enqueue(new Callback<StudentList>() {
            @Override
            public void onResponse(Call<StudentList> call, Response<StudentList> response) {
                progressBar.setVisibility(View.GONE);

                if(response.isSuccessful()){
                    studentList = response.body().getStudent();
                    adapter = new StudentAdapter(MainActivity.this, studentList);
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(adapter);
                }

            }

            @Override
            public void onFailure(Call<StudentList> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
            }
        });
    }
}

