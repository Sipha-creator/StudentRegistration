/*
IStudentRepository.java
Interface defining CRUD operations for Student entities
in the Student Course Management System.
Provides abstraction between the repository implementation and usage.

Author: Damien Swarts (222868791)
Date: 27 March 2026
*/
package za.ac.mycput.Repository;

import za.ac.mycput.Entity.Student;
import java.util.List;

public interface IStudentRepository {

    // CREATE: Adds a new Student object
    Student create(Student student);

    // READ: Retrieves a Student object by its ID
    Student read(int id);

    // UPDATE: Updates an existing Student object
    Student update(Student student);

    // DELETE: Removes a Student object by its ID
    boolean delete(int id);

    // GET ALL: Returns all Student objects
    List<Student> getAll();
}