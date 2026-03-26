/*
Course.java
Course entity representing a course offered within a department
in the Student Course Management System.

Author: SC Tshijila (231070071)
Date: 26 March 2026
*/

package za.ac.mycput.Entity;

public class Course {

    // Unique identifier for the course
    private int courseId;

    // Name of the course (e.g., Software Development)
    private String courseName;

    // Reference to the department this course belongs to
    private Department department;

    // Constructor used to initialize Course object
    public Course(int courseId, String courseName, Department department) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.department = department;
    }

    // Getter for course ID
    public int getCourseId() {
        return courseId;
    }

    // Getter for course name
    public String getCourseName() {
        return courseName;
    }

    // Getter for department associated with this course
    public Department getDepartment() {
        return department;
    }
}