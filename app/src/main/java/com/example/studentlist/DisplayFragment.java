package com.example.studentlist;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

public class DisplayFragment extends Fragment {
    private RecyclerView recyclerView; // RecyclerView to display the list of students
    private StudentAdapter studentAdapter; // Adapter for managing the student data in RecyclerView
    private ArrayList<Student> studentList; // List to hold Student objects
    private TextView noDataTextView; // TextView to show a message when there are no students

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_display, container, false);

        // Initialize RecyclerView and TextView from the inflated layout
        recyclerView = view.findViewById(R.id.recyclerView);
        noDataTextView = view.findViewById(R.id.no_data_text_view); // Initialize the TextView for no data message

        // Create an empty ArrayList to hold student data
        studentList = new ArrayList<>();
        // Initialize the StudentAdapter with the studentList
        studentAdapter = new StudentAdapter(studentList);

        // Set the layout manager for the RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        // Set the adapter to the RecyclerView to display the student data
        recyclerView.setAdapter(studentAdapter);

        return view; // Return the inflated view
    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateStudentList(ArrayList<Student> students) {
        // Clear the existing student list
        studentList.clear();
        // Add all new students to the studentList
        studentList.addAll(students);
        // Notify the adapter that the data has changed
        studentAdapter.notifyDataSetChanged();

        // Check if the student list is empty and update the TextView visibility accordingly
        if (studentList.isEmpty()) {
            noDataTextView.setVisibility(View.VISIBLE); // Show the "no data" message
            recyclerView.setVisibility(View.GONE); // Hide the RecyclerView
        } else {
            noDataTextView.setVisibility(View.GONE); // Hide the "no data" message
            recyclerView.setVisibility(View.VISIBLE); // Show the RecyclerView
        }
    }
}