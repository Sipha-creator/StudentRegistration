/*
ClassesFactoryTest.java
Test class for ClassesFactory.
Validates the creation of Classes objects and ensures correct assignment of lecturers.

Author: Damien Swarts (222868791)
Date: 27 March 2026
*/
package TestFactory;

import org.junit.jupiter.api.Test;
import za.ac.mycput.Entity.*;
import za.ac.mycput.Factory.ClassesFactory;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ClassesFactoryTest {

    // Test to verify that a Classes object is correctly created using the factory
    @Test
    void testCreateClasses() {

        // Create supporting objects (Department and Course)
        Department dept = new Department(1, "IT");
        Course course = new Course(101, "Software Development", dept);

        // Create shared address and contact details for lecturers
        Address address = new Address("Street", "City", "0000", "WC");
        ContactDetails contact = new ContactDetails("lect@mail.com", "123");

        // Create lecturer objects
        Lecturer lecturer1 = new Lecturer(1, "Dr Smith", dept, address, contact, Gender.MALE, Race.WHITE);
        Lecturer lecturer2 = new Lecturer(2, "Ms Jacobs", dept, address, contact, Gender.FEMALE, Race.AFRICAN);

        // Store lecturers in a list (since Classes supports multiple lecturers)
        List<Lecturer> lecturers = Arrays.asList(lecturer1, lecturer2);

        // Use factory to create Classes object
        Classes classes = ClassesFactory.createClasses(201, "Java Programming", course, lecturers);

        // Assertions to verify object creation
        assertNotNull(classes); // ensure object is created
        assertEquals("Java Programming", classes.getClassName()); // verify class name
        assertEquals(2, classes.getLecturers().size()); // verify lecturers assigned
    }
}