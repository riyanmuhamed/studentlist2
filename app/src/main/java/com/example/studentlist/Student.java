package com.example.studentlist;

public class Student {

    // Initializing variables for the Student class
    private final String name;  // Name of the student
    private final String age;   // Age of the student
    private final String grade; // Grade of the student
    private final String major;  // Major of the student

    // Constructor to initialize the Student object with provided values
    public Student(String name, String age, String grade, String major) {
        this.name = name;   // Set the name variable
        this.age = age;     // Set the age variable
        this.grade = grade; // Set the grade variable
        this.major = major; // Set the major variable
    }

    // Getter method for name
    public String getName() {
        return name; // Return the student's name
    }

    // Getter method for age
    public String getAge() {
        return age; // Return the student's age
    }

    // Getter method for grade
    public String getGrade() {
        return grade; // Return the student's grade
    }

    // Getter method for major
    public String getMajor() {
        return major; // Return the student's major
    }
}

