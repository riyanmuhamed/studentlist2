package com.example.studentlist;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity implements DataEntryFragment.DataEntryListener {
    private DisplayFragment displayFragment;
    private StudentViewModel studentViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentViewModel = new ViewModelProvider(this).get(StudentViewModel.class);


        DataEntryFragment dataEntryFragment = new DataEntryFragment();
        displayFragment = new DisplayFragment();


        studentViewModel.getStudents().observe(this, students -> {

            displayFragment.updateStudentList(students);
        });


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction(); // Begin a fragment transaction


        if (findViewById(R.id.fragment_container_display) != null) {

            transaction.add(R.id.fragment_container, dataEntryFragment);
            transaction.add(R.id.fragment_container_display, displayFragment);
        } else {
            transaction.add(R.id.fragment_container, dataEntryFragment);
            transaction.add(R.id.fragment_container, displayFragment);
        }


        transaction.commit();
    }

    @Override
    public void onDataEntered(String name, String age, String grade, String major) {

        Student student = new Student(name, age, grade, major);

        studentViewModel.addStudent(student);
    }
}



