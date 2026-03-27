/*
 * Gents im putting this here so that you can add the message in the commit message when you push to GitHub and
 *  delete this comment before you push the code and lastly add your details(Name, surname student number) to
 * the comment below this comment
 *
 * Commit Message : "Add CourseFactory unit test"
 */

/*
CourseFactoryTest.java
Test class for CourseFactory.
Validates the creation of Course objects and ensures correct assignment to a department.

Author: Damien Swarts (222868791)
Date: 25 March 2026
*/
package TestFactory;

import org.junit.jupiter.api.Test;
import za.ac.mycput.Entity.*;
import za.ac.mycput.Factory.*;

import static org.junit.jupiter.api.Assertions.*;

public class CourseFactoryTest {

    // Test to verify that a Course object is correctly created using the factory
    @Test
    public void testCreateCourse() {

        // Create a Department object
        Department dept = new Department(1, "IT");

        // Use factory to create a Course object
        Course course = CourseFactory.createCourse(101, "Software Dev", dept);

        // Assertions to verify correct object creation
        assertNotNull(course); // ensure object is created
        assertEquals("Software Dev", course.getCourseName()); // verify course name
        assertEquals(dept, course.getDepartment()); // verify correct department assignment
    }
}