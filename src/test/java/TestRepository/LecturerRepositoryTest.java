/*
LecturerRepositoryTest.java
Test class for LecturerRepository.
Validates CRUD operations (Create, Read, Update, Delete, GetAll)
for Lecturer entities using JUnit.

Author: SC Tshijila
Date: 27 March 2026
*/
package TestRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.mycput.Entity.*;
import za.ac.mycput.Repository.LecturerRepository;

import static org.junit.jupiter.api.Assertions.*;

public class LecturerRepositoryTest {

    // Repository instance (Singleton)
    private LecturerRepository repo;

    // Test object used across multiple test cases
    private Lecturer lecturer;

    // Runs before each test to reset repository state
    @BeforeEach
    void setUp() {
        repo = LecturerRepository.getInstance();
        repo.clear(); // ensure clean state before each test

        // Create supporting objects
        Department dept = new Department(1, "IT");
        Address address = new Address("45 Long St", "Cape Town", "8001", "WC");
        ContactDetails contact = new ContactDetails("smith@email.com", "0821234567");

        // Create Lecturer object
        lecturer = new Lecturer(
                1,
                "Dr Smith",
                dept,
                address,
                contact,
                Gender.MALE,
                Race.WHITE
        );
    }

    // Test CREATE operation
    @Test
    void testCreate() {
        Lecturer created = repo.create(lecturer);

        assertNotNull(created); // verify object is created
        assertEquals(1, repo.getAll().size()); // verify repository size
    }

    // Test READ operation
    @Test
    void testRead() {
        repo.create(lecturer);

        Lecturer found = repo.read(1);

        assertNotNull(found); // verify object exists
        assertEquals("Dr Smith", found.getName()); // verify correct data
    }

    // Test UPDATE operation
    @Test
    void testUpdate() {
        repo.create(lecturer);

        // Create updated version of lecturer
        Lecturer updated = new Lecturer(
                1,
                "Prof Smith",
                lecturer.getDepartment(),
                lecturer.getAddress(),
                lecturer.getContactDetails(),
                lecturer.getGender(),
                lecturer.getRace()
        );

        repo.update(updated);

        assertEquals("Prof Smith", repo.read(1).getName()); // verify update
    }

    // Test DELETE operation
    @Test
    void testDelete() {
        repo.create(lecturer);

        boolean deleted = repo.delete(1);

        assertTrue(deleted); // verify deletion success
        assertEquals(0, repo.getAll().size()); // verify repository is empty
    }

    // Test GET ALL operation
    @Test
    void testGetAll() {
        repo.create(lecturer);

        assertFalse(repo.getAll().isEmpty()); // verify list is not empty
    }
}