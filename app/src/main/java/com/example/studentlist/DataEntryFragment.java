package com.example.studentlist;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class DataEntryFragment extends Fragment {
    private DataEntryListener callback; // Listener to communicate with the hosting activity

    // Interface to define a method for data entry callback
    public interface DataEntryListener {
        void onDataEntered(String name, String age, String grade, String major);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        // Ensure that the hosting activity implements the DataEntryListener interface
        if (context instanceof DataEntryListener) {
            callback = (DataEntryListener) context; // Cast the context to DataEntryListener
        } else {
            throw new ClassCastException(context.toString() + " must implement DataEntryListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_data_entry, container, false);

        // Initialize EditText fields and Button
        EditText nameEditText = view.findViewById(R.id.nameEditText);
        EditText ageEditText = view.findViewById(R.id.ageEditText);
        EditText gradeEditText = view.findViewById(R.id.gradeEditText);
        EditText majorEditText = view.findViewById(R.id.majorEditText);
        Button submitButton = view.findViewById(R.id.submitButton);

        // Set an OnClickListener on the submit button
        submitButton.setOnClickListener(v -> {
            // Get the input values from EditText fields
            String name = nameEditText.getText().toString();
            String age = ageEditText.getText().toString();
            String grade = gradeEditText.getText().toString();
            String major = majorEditText.getText().toString();

            // Validate input fields before proceeding
            if (validateInput(name, age, grade)) {
                // Notify the listener with the entered data
                callback.onDataEntered(name, age, grade, major);

                // Clear input fields after submission
                clearInputFields(nameEditText, ageEditText, gradeEditText, majorEditText);
            }
        });

        return view; // Return the inflated view
    }

    // Method to validate input fields
    private boolean validateInput(String name, String age, String grade) {
        // Add validation logic (e.g., check if empty, valid integers, etc.)
        // Return true if valid; otherwise, show error messages (implementation needed)
        return true; // Placeholder, replace with actual validation logic
    }

    // Method to clear input fields
    private void clearInputFields(EditText... editTexts) {
        for (EditText editText : editTexts) {
            editText.setText(""); // Set each EditText's text to empty
        }
    }
}

