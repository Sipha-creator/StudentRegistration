/*
 * Gents im putting this here so that you can add the message in the commit message when you push to GitHub and
 *  delete this comment before you push the code and lastly add your details(Name, surname student number) to
 * the comment below this comment
 *
 * Commit Message : "Add StudentFactory unit test"
 */

/*
StudentFactoryTest.java
Test class for StudentFactory.
Validates the creation of Student objects using the Builder Pattern
and ensures correct assignment of attributes.

Author: Damien Swarts (222868791)
Date: 25 March 2026
*/
package TestFactory;

import org.junit.jupiter.api.Test;
import za.ac.mycput.Entity.*;
import za.ac.mycput.Factory.*;

import static org.junit.jupiter.api.Assertions.*;

public class StudentFactoryTest {

    // Test to verify that a Student object is correctly created using the factory
    @Test
    public void testCreateStudent() {

        // Create Department and Course
        Department dept = new Department(1, "IT");
        Course course = new Course(101, "Software Dev", dept);

        // Create Address and ContactDetails (inherited from Person)
        Address address = new Address("12 Main St", "Cape Town", "8000", "WC");
        ContactDetails contact = new ContactDetails("test@mail.com", "1234567890");

        // Use factory (which uses Builder Pattern internally) to create Student
        Student student = StudentFactory.createStudent(
                1, "John", "Doe",
                course, address, contact,
                Gender.MALE, Race.AFRICAN
        );

        // Assertions to verify correct object creation
        assertNotNull(student); // ensure object is created
        assertEquals("John Doe", student.getFullName()); // verify full name logic
        assertEquals(course, student.getCourse()); // verify course assignment
    }
}