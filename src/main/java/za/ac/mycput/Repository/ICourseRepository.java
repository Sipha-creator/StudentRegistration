/*
ICourseRepository.java
Interface defining CRUD operations for Course entities
in the Student Course Management System.
Provides abstraction between the repository implementation and usage.

Author: Damien Swarts (222868791)
Date: 27 March 2026
*/
package za.ac.mycput.Repository;

import za.ac.mycput.Entity.*;
import java.util.List;

public interface ICourseRepository {

    // CREATE: Adds a new Course object
    Course create(Course course);

    // READ: Retrieves a Course object by its ID
    Course read(int id);

    // UPDATE: Updates an existing Course object
    Course update(Course course);

    // DELETE: Removes a Course object by its ID
    boolean delete(int id);

    // GET ALL: Returns all Course objects
    List<Course> getAll();
}
