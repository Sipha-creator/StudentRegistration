
/*
Department.java
Department entity representing an academic department that contains courses
in the Student Course Management System.

Author: SC Tshijila (231070071)
Date: 26 March 2026
*/


package za.ac.mycput.Entity;

public class Department {

    // Unique identifier for the department
    private int departmentId;

    // Name of the department (e.g., IT)
    private String departmentName;

    // Constructor used to initialize Department object
    public Department(int departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    // Getter for department ID
    public int getDepartmentId() {
        return departmentId;
    }

    // Getter for department name
    public String getDepartmentName() {
        return departmentName;
    }
}