/*
IClassesRepository.java
Interface defining CRUD operations for Classes entities
in the Student Course Management System.
Provides abstraction between the repository implementation and usage.

Author: Damien Swarts (222868791)
Date: 27 March 2026
*/
package za.ac.mycput.Repository;

import za.ac.mycput.Entity.Classes;
import java.util.List;

public interface IClassesRepository {

    // CREATE: Adds a new Classes object
    Classes create(Classes classes);

    // READ: Retrieves a Classes object by its ID
    Classes read(int id);

    // UPDATE: Updates an existing Classes object
    Classes update(Classes classes);

    // DELETE: Removes a Classes object by its ID
    boolean delete(int id);

    // GET ALL: Returns all Classes objects
    List<Classes> getAll();
}