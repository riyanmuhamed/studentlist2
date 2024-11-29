package com.example.studentlist;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData; // Import MutableLiveData for mutable data
import androidx.lifecycle.ViewModel; // Import ViewModel class for the MVVM architecture
import java.util.ArrayList; // Import ArrayList class for dynamic array functionality

public class StudentViewModel extends ViewModel {

    private final MutableLiveData<ArrayList<Student>> students = new MutableLiveData<>(new ArrayList<>());

    // Method to get the LiveData of students
    public LiveData<ArrayList<Student>> getStudents() {
        return students; // Return the LiveData object so it can be observed by the UI
    }

    // Method to add a new Student to the list
    public void addStudent(Student student) {
        // Get the current list of students
        ArrayList<Student> currentStudents = students.getValue();
        // Check if the currentStudents list is not null
        if (currentStudents != null) {
            currentStudents.add(student); // Add the new student to the list
            students.setValue(currentStudents); // Update the MutableLiveData with the new list
        }
    }
}


