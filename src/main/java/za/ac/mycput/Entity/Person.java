/*
Person.java
Abstract base class representing a generic person in the Student Course Management System.
Provides common attributes shared by Student and Lecturer entities.

Author: Damien Swarts (222868791)
Date: 26 March 2026
*/
package za.ac.mycput.Entity;

public abstract class Person {

    // Address of the person (composition relationship)
    protected Address address;

    // Contact details of the person (composition relationship)
    protected ContactDetails contactDetails;

    // Gender of the person (enum type)
    protected Gender gender;

    // Race of the person (enum type)
    protected Race race;

    // Constructor used by subclasses (Student and Lecturer)
    public Person(Address address, ContactDetails contactDetails, Gender gender, Race race) {
        this.address = address;
        this.contactDetails = contactDetails;
        this.gender = gender;
        this.race = race;
    }

    // Getter for address
    public Address getAddress() {
        return address;
    }

    // Getter for contact details
    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    // Getter for gender
    public Gender getGender() {
        return gender;
    }

    // Getter for race
    public Race getRace() {
        return race;
    }
}