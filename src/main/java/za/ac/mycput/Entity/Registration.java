/*
Registration.java
Registration entity linking a student to selected classes
in the Student Course Management System.

Author: Damien Swarts (222868791)
Date: 26 March 2026
*/
package za.ac.mycput.Entity;

public class Registration {

    // Reference to the student being registered
    private Student student;

    // Reference to the class the student is registered for
    private Classes classes;

    // Constructor used to create a Registration object
    public Registration(Student student, Classes classes) {
        this.student = student;
        this.classes = classes;
    }

    // Getter for student
    public Student getStudent() {
        return student;
    }

    // Getter for class
    public Classes getClasses() {
        return classes;
    }

    // Returns a formatted string containing registration details
    // Used for displaying student registration information
    public String getInfo() {
        return "Student ID: " + student.getStudentId() +
                "\nName: " + student.getFullName() +
                "\nCourse: " + student.getCourse().getCourseName() +
                "\nClass: " + classes.getClassName();
    }
}
