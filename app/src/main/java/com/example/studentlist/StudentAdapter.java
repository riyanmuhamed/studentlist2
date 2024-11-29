package com.example.studentlist;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;


public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    private ArrayList<Student> students;

    public StudentAdapter(ArrayList<Student> students) {
        this.students = students;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item layout for each student
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        // Get the student for the current position
        Student student = students.get(position);
        // Bind student data to the ViewHolder
        holder.bind(student);
    }

    @Override
    public int getItemCount() {
        // Return the total number of students
        return students.size();
    }

    // ViewHolder class for each student item
    static class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, ageTextView, gradeTextView, majorTextView;

        // Constructor to initialize the views
        StudentViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.name_text_view);
            ageTextView = itemView.findViewById(R.id.age_text_view);
            gradeTextView = itemView.findViewById(R.id.grade_text_view);
            majorTextView = itemView.findViewById(R.id.major_text_view);
        }

        // Method to bind student data to the views
        @SuppressLint("SetTextI18n")
        void bind(Student student) {
            nameTextView.setText("Name: " + student.getName());
            ageTextView.setText("Age: " + student.getAge());
            gradeTextView.setText("Grade: " + student.getGrade());
            majorTextView.setText(student.getMajor().isEmpty() ? "Major: N/A" : "Major: " + student.getMajor());
        }
    }
}
