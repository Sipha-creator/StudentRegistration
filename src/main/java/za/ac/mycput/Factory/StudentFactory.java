/*
StudentFactory.java
Factory class used to create Student objects in the Student Course Management System.
Utilizes the Builder Pattern for flexible and readable object creation.

Author: SC Tshijila (231070071)
Date: 27 March 2026
*/




package za.ac.mycput.Factory;

import za.ac.mycput.Entity.*;

public class StudentFactory {

    /*
     Static factory method used to create a Student object.
     Uses the Builder Pattern to construct a Student instance step-by-step,
     ensuring clarity and avoiding complex constructors.
     */
    public static Student createStudent(int id, String firstName, String lastName,
                                        Course course, Address address,
                                        ContactDetails contactDetails,
                                        Gender gender, Race race) {

        return new Student.Builder()
                .setStudentId(id)               // set unique student ID
                .setFirstName(firstName)        // set student's first name
                .setLastName(lastName)          // set student's last name
                .setCourse(course)              // assign course to student
                .setAddress(address)            // set address (from Person)
                .setContactDetails(contactDetails) // set contact details (from Person)
                .setGender(gender)              // set gender
                .setRace(race)                  // set race
                .build();                       // build and return Student object
    }
}