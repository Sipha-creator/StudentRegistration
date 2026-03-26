/*
Lecturer.java
Lecturer entity representing a lecturer who teaches classes within a department
in the Student Course Management System. Inherits common attributes from Person.

Author: SC Tshijila (231070071)
Date: 25 March 2026
*/


package za.ac.mycput.Entity;

public class Lecturer extends Person {

    // Unique identifier for the lecturer
    private int lecturerId;

    // Name of the lecturer
    private String name;

    // Department the lecturer belongs to
    private Department department;

    // Constructor initializes Lecturer and calls parent (Person) constructor
    public Lecturer(int lecturerId, String name, Department department,
                    Address address, ContactDetails contactDetails,
                    Gender gender, Race race) {

        // Call to superclass constructor (Person)
        super(address, contactDetails, gender, race);

        this.lecturerId = lecturerId;
        this.name = name;
        this.department = department;
    }

    // Getter for lecturer ID
    public int getLecturerId() {
        return lecturerId;
    }

    // Getter for lecturer name
    public String getName() {
        return name;
    }

    // Getter for the department the lecturer belongs to
    public Department getDepartment() {
        return department;
    }

    // Overrides equals method to compare Lecturer objects based on lecturerId
    // Important for correctly identifying lecturers in collections (e.g., lists)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // same reference
        if (obj == null || getClass() != obj.getClass()) return false; // null or different class
        Lecturer lecturer = (Lecturer) obj;
        return lecturerId == lecturer.lecturerId; // compare unique IDs
    }

    // Overrides hashCode method to be consistent with equals
    // Ensures proper behavior in collections like HashSet or List.contains()
    @Override
    public int hashCode() {
        return Integer.hashCode(lecturerId);
    }
}