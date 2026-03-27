/*
ContactDetails.java
ContactDetails entity class representing contact information
(email and phone number) for a person in the Student Course Management System.

Author: SC Tshijila (231070071)
Date: 26 March 2026
*/


package za.ac.mycput.Entity;

public class ContactDetails {

    // Email address of the person
    private String email;

    // Phone number of the person
    private String phone;

    // Constructor used to initialize ContactDetails object
    public ContactDetails(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }

    // Converts contact details into a readable string format
    // Used when displaying contact information in output
    @Override
    public String toString() {
        return "Email: " + email + ", Phone: " + phone;
    }
}