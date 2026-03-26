/*
Classes.java
Classes entity representing academic classes within a course.
Supports multiple lecturers assigned to a single class.

Author: SC Tshijila(231070071)
Date: 26 March 2026
*/


package za.ac.mycput.Entity;



import java.util.List;

public class Classes {

    // Unique identifier for the class
    private int classId;

    // Name of the class (e.g., Java Programming)
    private String className;

    // Reference to the course this class belongs to
    private Course course;

    // List of lecturers assigned to teach this class (many-to-many relationship support)
    private List<Lecturer> lecturers;

    // Constructor used to initialize a Classes object
    public Classes(int classId, String className, Course course, List<Lecturer> lecturers) {
        this.classId = classId;
        this.className = className;
        this.course = course;
        this.lecturers = lecturers;
    }

    // Getter for class ID
    public int getClassId() {
        return classId;
    }

    // Getter for class name
    public String getClassName() {
        return className;
    }

    // Getter for course associated with this class
    public Course getCourse() {
        return course;
    }

    // Getter for lecturers teaching this class
    public List<Lecturer> getLecturers() {
        return lecturers;
    }

    // Returns class name when object is printed (useful for display/output)
    @Override
    public String toString() {
        return className;
    }
}