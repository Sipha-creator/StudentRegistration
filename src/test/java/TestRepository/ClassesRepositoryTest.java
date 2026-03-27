/*
ClassesRepositoryTest.java
Test class for ClassesRepository.
Validates CRUD operations (Create, Read, Update, Delete, GetAll)
for Classes entities using JUnit.

Author: SC Tshijila (231070071)
Date: 27 March 2026
*/

package TestRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.mycput.Entity.*;
import za.ac.mycput.Repository.ClassesRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ClassesRepositoryTest {

    // Repository instance (Singleton)
    private ClassesRepository repo;

    // Test object used across multiple test cases
    private Classes classes;

    // Runs before each test to reset repository state
    @BeforeEach
    void setUp() {
        repo = ClassesRepository.getInstance();
        repo.clear(); // ensure clean state for each test

        // Create supporting objects
        Department dept = new Department(1, "IT");
        Course course = new Course(101, "Software Development", dept);

        Address address = new Address("Street", "City", "0000", "WC");
        ContactDetails contact = new ContactDetails("lect@mail.com", "123");

        // Create lecturers
        Lecturer lecturer1 = new Lecturer(1, "Dr Smith", dept, address, contact, Gender.MALE, Race.WHITE);
        Lecturer lecturer2 = new Lecturer(2, "Ms Jacobs", dept, address, contact, Gender.FEMALE, Race.AFRICAN);

        // Assign lecturers to class
        List<Lecturer> lecturers = Arrays.asList(lecturer1, lecturer2);

        // Create Classes object
        classes = new Classes(201, "Java Programming", course, lecturers);
    }

    // Test CREATE operation
    @Test
    void testCreate() {
        Classes created = repo.create(classes);

        assertNotNull(created); // verify object is created
        assertEquals(1, repo.getAll().size()); // verify repository size
    }

    // Test READ operation
    @Test
    void testRead() {
        repo.create(classes);

        Classes found = repo.read(201);

        assertNotNull(found); // verify object exists
        assertEquals("Java Programming", found.getClassName()); // verify correct data
    }

    // Test UPDATE operation
    @Test
    void testUpdate() {
        repo.create(classes);

        // Create updated version of class
        Classes updated = new Classes(
                201,
                "Advanced Java",
                classes.getCourse(),
                classes.getLecturers()
        );

        repo.update(updated);

        assertEquals("Advanced Java", repo.read(201).getClassName()); // verify update
    }

    // Test DELETE operation
    @Test
    void testDelete() {
        repo.create(classes);

        boolean deleted = repo.delete(201);

        assertTrue(deleted); // verify deletion success
        assertEquals(0, repo.getAll().size()); // verify repository is empty
    }

    // Test GET ALL operation
    @Test
    void testGetAll() {
        repo.create(classes);

        assertFalse(repo.getAll().isEmpty()); // verify list is not empty
    }
}