/*
ILecturerRepository.java
Interface defining CRUD operations for Lecturer entities
in the Student Course Management System.
Provides abstraction between the repository implementation and usage.

Author: Damien Swarts (222868791)
Date: 27 March 2026
*/
package za.ac.mycput.Repository;

import za.ac.mycput.Entity.Lecturer;
import java.util.List;

public interface ILecturerRepository {

    // CREATE: Adds a new Lecturer object
    Lecturer create(Lecturer lecturer);

    // READ: Retrieves a Lecturer object by its ID
    Lecturer read(int id);

    // UPDATE: Updates an existing Lecturer object
    Lecturer update(Lecturer lecturer);

    // DELETE: Removes a Lecturer object by its ID
    boolean delete(int id);

    // GET ALL: Returns all Lecturer objects
    List<Lecturer> getAll();
}