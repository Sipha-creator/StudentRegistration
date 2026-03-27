/*
StudentRepository.java
Repository class for managing Student objects in the Student Course Management System.
Implements the Singleton pattern and provides CRUD operations.

Author: SC Tshijila (231070071)
Date: 27 March 2026
*/
package za.ac.mycput.Repository;

import za.ac.mycput.Entity.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {

    // Singleton instance of the repository
    private static StudentRepository repository = null;

    // Internal list acting as an in-memory data store for Student objects
    private List<Student> studentList;

    // Private constructor prevents direct instantiation (Singleton pattern)
    private StudentRepository() {
        studentList = new ArrayList<>();
    }

    // Provides global access to the single instance of the repository
    public static StudentRepository getInstance() {
        if (repository == null) {
            repository = new StudentRepository();
        }
        return repository;
    }

    // CREATE: Adds a new Student object to the repository
    @Override
    public Student create(Student student) {
        studentList.add(student);
        return student;
    }

    // READ: Retrieves a Student object by its ID
    @Override
    public Student read(int id) {
        return studentList.stream()
                .filter(s -> s.getStudentId() == id) // find matching student
                .findFirst()
                .orElse(null); // return null if not found
    }

    // UPDATE: Replaces an existing Student object with updated data
    @Override
    public Student update(Student student) {
        Student existing = read(student.getStudentId());
        if (existing != null) {
            studentList.remove(existing); // remove old version
            studentList.add(student);     // add updated version
            return student;
        }
        return null; // return null if student not found
    }

    // DELETE: Removes a Student object by its ID
    @Override
    public boolean delete(int id) {
        Student student = read(id);
        if (student != null) {
            studentList.remove(student);
            return true;
        }
        return false;
    }

    // GET ALL: Returns all Student objects in the repository
    @Override
    public List<Student> getAll() {
        return studentList;
    }

    // Utility method used in testing to clear repository data (reset state)
    public void clear() {
        studentList.clear();
    }
}