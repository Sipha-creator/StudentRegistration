/*
StudentRepositoryTest.java
Test class for StudentRepository.
Validates CRUD operations (Create, Read, Update, Delete, GetAll)
for Student entities using JUnit.

Author: SC Tshijila (231070071)
Date: 27 March 2026
*/
package TestRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.mycput.Entity.*;
import za.ac.mycput.Repository.StudentRepository;

import static org.junit.jupiter.api.Assertions.*;

public class StudentRepositoryTest {

    // Repository instance (Singleton)
    private StudentRepository repo;

    // Test object used across multiple test cases
    private Student student;

    // Runs before each test to reset repository state
    @BeforeEach
    void setUp() {
        repo = StudentRepository.getInstance();
        repo.clear(); // ensure clean state before each test

        // Create supporting objects
        Department dept = new Department(1, "IT");
        Course course = new Course(101, "Software Dev", dept);
        Address address = new Address("12 Main St", "Cape Town", "8000", "WC");
        ContactDetails contact = new ContactDetails("john@email.com", "0812345678");

        // Create Student using Builder Pattern
        student = new Student.Builder()
                .setStudentId(1)
                .setFirstName("John")
                .setLastName("Doe")
                .setCourse(course)
                .setAddress(address)
                .setContactDetails(contact)
                .setGender(Gender.MALE)
                .setRace(Race.AFRICAN)
                .build();
    }

    // Test CREATE operation
    @Test
    void testCreate() {
        Student created = repo.create(student);

        assertNotNull(created); // verify object is created
        assertEquals(1, repo.getAll().size()); // verify repository size
    }

    // Test READ operation
    @Test
    void testRead() {
        repo.create(student);

        Student found = repo.read(1);

        assertNotNull(found); // verify object exists
        assertEquals("John Doe", found.getFullName()); // verify correct data
    }

    // Test UPDATE operation
    @Test
    void testUpdate() {
        repo.create(student);

        // Create updated version of student using Builder Pattern
        Student updated = new Student.Builder()
                .setStudentId(1)
                .setFirstName("Johnny")
                .setLastName("Doe")
                .setCourse(student.getCourse())
                .setAddress(student.getAddress())
                .setContactDetails(student.getContactDetails())
                .setGender(student.getGender())
                .setRace(student.getRace())
                .build();

        repo.update(updated);

        assertEquals("Johnny Doe", repo.read(1).getFullName()); // verify update
    }

    // Test DELETE operation
    @Test
    void testDelete() {
        repo.create(student);

        boolean deleted = repo.delete(1);

        assertTrue(deleted); // verify deletion success
        assertEquals(0, repo.getAll().size()); // verify repository is empty
    }

    // Test GET ALL operation
    @Test
    void testGetAll() {
        repo.create(student);

        assertFalse(repo.getAll().isEmpty()); // verify list is not empty
    }
}