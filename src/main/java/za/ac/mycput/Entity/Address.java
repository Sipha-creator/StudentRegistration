/*
Address.java
Address entity class representing a student's or lecturer's physical address
in the Student Course Management System.

Author: Damien Swarts (222868791)
Date: 25 March 2026
*/


package za.ac.mycput.Entity;

public class Address {

    // Instance variables representing address details
    private String street;
    private String city;
    private String postalCode;
    private String province;

    // Constructor used to initialize Address object
    public Address(String street, String city, String postalCode, String province) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.province = province;
    }

    // Converts Address object into a readable string format
    // Used when displaying address information in output
    @Override
    public String toString() {
        return street + ", " + city + ", " + postalCode + ", " + province;
    }
}