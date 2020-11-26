package com.example.studentapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private Context context;
    private List<Student> studentList;

    public StudentAdapter(Context context, List<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentAdapter.StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StudentViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.student_layout_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.StudentViewHolder holder, int position) {

        Student student = studentList.get(position);
        holder.studentName.setText(student.getName());
        holder.email.setText(student.getEmail());
        holder.dob.setText(student.getDob());
        holder.hobby.setText(student.getHobby());
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {
        public ImageView src;
        public TextView studentName, email, dob, hobby;

        public StudentViewHolder(View itemView) {
            super(itemView);

            src = itemView.findViewById(R.id.src);
            studentName = itemView.findViewById(R.id.StudentName);
            email = itemView.findViewById(R.id.email);
            dob = itemView.findViewById(R.id.dob);
            hobby = itemView.findViewById(R.id.hobby);
        }
    }
}
