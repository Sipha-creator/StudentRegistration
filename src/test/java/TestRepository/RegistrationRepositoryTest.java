/*
RegistrationRepositoryTest.java
Test class for RegistrationRepository.
Validates creation and retrieval of Registration entities
which link Student and Classes in the system.

Author: SC Tshijila (231070071)
Date: 27 March 2026
*/
package TestRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.mycput.Entity.*;
import za.ac.mycput.Repository.RegistrationRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RegistrationRepositoryTest {

    // Repository instance (Singleton)
    private RegistrationRepository repo;

    // Test object used across test cases
    private Registration registration;

    // Runs before each test to reset repository state
    @BeforeEach
    void setUp() {
        repo = RegistrationRepository.getInstance();
        repo.clear(); // ensure clean state before each test

        // Create Department and Course
        Department dept = new Department(1, "IT");
        Course course = new Course(101, "Software Development", dept);

        // Create Student details
        Address studentAddress = new Address("12 Main St", "Cape Town", "8000", "WC");
        ContactDetails studentContact = new ContactDetails("john@email.com", "0812345678");

        // Create Student using Builder Pattern
        Student student = new Student.Builder()
                .setStudentId(1)
                .setFirstName("John")
                .setLastName("Doe")
                .setCourse(course)
                .setAddress(studentAddress)
                .setContactDetails(studentContact)
                .setGender(Gender.MALE)
                .setRace(Race.AFRICAN)
                .build();

        // Create Lecturer details
        Address lecturerAddress = new Address("45 Long St", "Cape Town", "8001", "WC");
        ContactDetails lecturerContact = new ContactDetails("smith@email.com", "0821234567");

        // Create Lecturers
        Lecturer lecturer1 = new Lecturer(1, "Dr Smith", dept, lecturerAddress, lecturerContact, Gender.MALE, Race.WHITE);
        Lecturer lecturer2 = new Lecturer(2, "Ms Jacobs", dept, lecturerAddress, lecturerContact, Gender.FEMALE, Race.AFRICAN);

        // Assign lecturers to class
        List<Lecturer> lecturers = Arrays.asList(lecturer1, lecturer2);

        // Create Classes object
        Classes classes = new Classes(201, "Java Programming", course, lecturers);

        // Create Registration object linking student and class
        registration = new Registration(student, classes);
    }

    // Test CREATE operation
    @Test
    void testCreate() {
        Registration created = repo.create(registration);

        assertNotNull(created); // verify object is created
        assertEquals(1, repo.getAll().size()); // verify repository size
    }

    // Test GET ALL operation
    @Test
    void testGetAll() {
        repo.create(registration);

        assertFalse(repo.getAll().isEmpty()); // verify list is not empty
    }
}