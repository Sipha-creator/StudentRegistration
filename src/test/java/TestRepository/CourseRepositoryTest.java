
/*
CourseRepositoryTest.java
Test class for CourseRepository.
Validates CRUD operations (Create, Read, Update, Delete, GetAll)
for Course entities using JUnit.

Author: SC Tshijila (231070071)
Date: 27 March 2026
*/
package TestRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.mycput.Entity.Course;
import za.ac.mycput.Entity.Department;
import za.ac.mycput.Repository.CourseRepository;

import static org.junit.jupiter.api.Assertions.*;

public class CourseRepositoryTest {

    // Repository instance (Singleton)
    private CourseRepository repo;

    // Test object used across multiple test cases
    private Course course;

    // Runs before each test to reset repository state
    @BeforeEach
    void setUp() {
        repo = CourseRepository.getInstance();
        repo.clear(); // ensure clean state before each test

        // Create Department and Course
        Department dept = new Department(1, "IT");
        course = new Course(101, "Software Dev", dept);
    }

    // Test CREATE operation
    @Test
    void testCreate() {
        Course created = repo.create(course);

        assertNotNull(created); // verify object is created
        assertEquals(1, repo.getAll().size()); // verify repository size
    }

    // Test READ operation
    @Test
    void testRead() {
        repo.create(course);

        Course found = repo.read(101);

        assertNotNull(found); // verify object exists
        assertEquals("Software Dev", found.getCourseName()); // verify correct data
    }

    // Test UPDATE operation
    @Test
    void testUpdate() {
        repo.create(course);

        // Create updated version of course
        Course updated = new Course(101, "Application Development", course.getDepartment());

        repo.update(updated);

        assertEquals("Application Development", repo.read(101).getCourseName()); // verify update
    }

    // Test DELETE operation
    @Test
    void testDelete() {
        repo.create(course);

        boolean deleted = repo.delete(101);

        assertTrue(deleted); // verify deletion success
        assertEquals(0, repo.getAll().size()); // verify repository is empty
    }

    // Test GET ALL operation
    @Test
    void testGetAll() {
        repo.create(course);

        assertFalse(repo.getAll().isEmpty()); // verify list is not empty
    }
}