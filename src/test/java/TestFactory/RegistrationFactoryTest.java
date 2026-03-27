/*
 * Gents im putting this here so that you can add the message in the commit message when you push to GitHub and
 *  delete this comment before you push the code and lastly add your details(Name, surname student number) to
 * the comment below this comment
 *
 * Commit Message : "Add RegistrationFactory unit test"
 */

/*
RegistrationFactoryTest.java
Test class for RegistrationFactory.
Validates the creation of Registration objects and ensures correct linking
between Student and Classes entities.

Author: Damien Swarts (222868791)
Date: 25 March 2026
*/
package TestFactory;

import org.junit.jupiter.api.Test;
import za.ac.mycput.Entity.*;
import za.ac.mycput.Factory.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RegistrationFactoryTest {

    // Test to verify that a Registration object is correctly created
    // and links a Student to a Classes instance
    @Test
    public void testCreateRegistration() {

        // Create Department and Course
        Department dept = new Department(1, "IT");
        Course course = new Course(101, "Software Dev", dept);

        // Create Address and ContactDetails
        Address address = new Address("Street", "City", "0000", "WC");
        ContactDetails contact = new ContactDetails("test@mail.com", "123");

        // Create Student using Builder Pattern
        Student student = new Student.Builder()
                .setStudentId(1)
                .setFirstName("John")
                .setLastName("Doe")
                .setCourse(course)
                .setAddress(address)
                .setContactDetails(contact)
                .setGender(Gender.MALE)
                .setRace(Race.AFRICAN)
                .build();

        // Create Lecturer
        Lecturer lecturer = new Lecturer(1, "Dr Smith", dept,
                address, contact, Gender.MALE, Race.WHITE);

        // Wrap lecturer in a list (Classes supports multiple lecturers)
        List<Lecturer> lecturers = Arrays.asList(lecturer);

        // Create Classes object
        Classes classes = new Classes(201, "Java", course, lecturers);

        // Use factory to create Registration object
        Registration reg = RegistrationFactory.createRegistration(student, classes);

        // Assertions to verify correct linking
        assertNotNull(reg); // ensure object is created
        assertEquals(student, reg.getStudent()); // verify student link
        assertEquals(classes, reg.getClasses()); // verify class link
    }
}