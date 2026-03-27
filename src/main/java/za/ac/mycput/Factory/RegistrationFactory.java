/*
RegistrationFactory.java
Factory class used to create Registration objects in the Student Course Management System.
Encapsulates object creation logic for Registration entities.

Author: SC Tshijila (231070071
Date: 27 March 2026
*/

package za.ac.mycput.Factory;

import za.ac.mycput.Entity.*;

public class RegistrationFactory {

    /*
     Static factory method used to create a Registration object.
     Links a Student to a specific Classes instance.
     */
    public static Registration createRegistration(Student student, Classes classes) {
        return new Registration(student, classes);
    }
}