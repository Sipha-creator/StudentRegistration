/*
Student.java
Student entity representing a student in the Student Course Management System.
Uses the Builder Pattern for flexible and controlled object creation.
Inherits common attributes from the Person class.

Author: SC Tshijila (231070071)
Date: 26 March 2026
*/

package za.ac.mycput.Entity;



public class Student extends Person {

    // Unique identifier for the student
    private int studentId;

    // Student's first name
    private String firstName;

    // Student's last name
    private String lastName;

    // Course the student is registered for
    private Course course;

    // Private constructor used by Builder to create Student object
    private Student(Builder builder) {
        // Call to superclass (Person) constructor
        super(builder.address, builder.contactDetails, builder.gender, builder.race);

        this.studentId = builder.studentId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.course = builder.course;
    }

    /*
     Builder class used to construct Student objects step-by-step.
     This pattern improves readability and avoids complex constructors.
     */
    public static class Builder {

        private int studentId;
        private String firstName;
        private String lastName;
        private Course course;
        private Address address;
        private ContactDetails contactDetails;
        private Gender gender;
        private Race race;

        // Sets student ID
        public Builder setStudentId(int studentId) {
            this.studentId = studentId;
            return this;
        }

        // Sets first name
        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        // Sets last name
        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        // Sets course
        public Builder setCourse(Course course) {
            this.course = course;
            return this;
        }

        // Sets address
        public Builder setAddress(Address address) {
            this.address = address;
            return this;
        }

        // Sets contact details
        public Builder setContactDetails(ContactDetails contactDetails) {
            this.contactDetails = contactDetails;
            return this;
        }

        // Sets gender
        public Builder setGender(Gender gender) {
            this.gender = gender;
            return this;
        }

        // Sets race
        public Builder setRace(Race race) {
            this.race = race;
            return this;
        }

        // Builds and returns a Student object
        public Student build() {
            return new Student(this);
        }
    }

    // Getter for student ID
    public int getStudentId() {
        return studentId;
    }

    // Returns full name of student (used for display/output)
    public String getFullName() {
        return firstName + " " + lastName;
    }

    // Getter for course the student is enrolled in
    public Course getCourse() {
        return course;
    }
}