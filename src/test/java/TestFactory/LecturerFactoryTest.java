/*
LecturerFactoryTest.java
Test class for LecturerFactory.
Validates the creation of Lecturer objects and ensures correct assignment
of department and inherited attributes from Person.

Author: Damien Swarts (222868791)
Date: 27 March 2026
*/
package TestFactory;

import org.junit.jupiter.api.Test;
import za.ac.mycput.Entity.*;
import za.ac.mycput.Factory.*;

import static org.junit.jupiter.api.Assertions.*;

public class LecturerFactoryTest {

    // Test to verify that a Lecturer object is correctly created using the factory
    @Test
    public void testCreateLecturer() {

        // Create Department object
        Department dept = new Department(1, "IT");

        // Create Address and ContactDetails (inherited from Person)
        Address address = new Address("Street", "City", "0000", "WC");
        ContactDetails contact = new ContactDetails("lect@mail.com", "987654321");

        // Use factory to create Lecturer object
        Lecturer lecturer = LecturerFactory.createLecturer(
                1, "Dr Smith", dept,
                address, contact,
                Gender.MALE, Race.WHITE
        );

        // Assertions to verify object creation
        assertNotNull(lecturer); // ensure object is created
        assertEquals("Dr Smith", lecturer.getName()); // verify lecturer name
        assertEquals(dept, lecturer.getDepartment()); // verify department assignment
    }
}