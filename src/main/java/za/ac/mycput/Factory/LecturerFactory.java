/*
LecturerFactory.java
Factory class used to create Lecturer objects in the Student Course Management System.
Encapsulates object creation logic for Lecturer entities.

Author: Damien Swarts (222868791)
Date: 27 March 2026
*/
package za.ac.mycput.Factory;

import za.ac.mycput.Entity.*;

public class LecturerFactory {

    /*
     Static factory method used to create a Lecturer object.
     Ensures consistent and readable creation of Lecturer instances,
     including inherited attributes from the Person class.
     */
    public static Lecturer createLecturer(int id, String name,
                                          Department department,
                                          Address address,
                                          ContactDetails contactDetails,
                                          Gender gender, Race race) {

        return new Lecturer(id, name, department, address, contactDetails, gender, race);
    }
}
