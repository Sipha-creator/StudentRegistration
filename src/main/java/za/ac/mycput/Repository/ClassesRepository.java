/*
ClassesRepository.java
Repository class for managing Classes objects in the Student Course Management System.
Implements the Singleton pattern and provides CRUD operations.

Author: SC Tshijila (231070071)
Date: 27 March 2026
*/

package za.ac.mycput.Repository;

import za.ac.mycput.Entity.Classes;

import java.util.ArrayList;
import java.util.List;

public class ClassesRepository implements IClassesRepository {

    // Singleton instance of the repository
    private static ClassesRepository repository = null;

    // Internal list used to store Classes objects (acts as in-memory database)
    private List<Classes> classesList;

    // Private constructor prevents direct instantiation (Singleton pattern)
    private ClassesRepository() {
        classesList = new ArrayList<>();
    }

    // Provides global access to the single instance of the repository
    public static ClassesRepository getInstance() {
        if (repository == null) {
            repository = new ClassesRepository();
        }
        return repository;
    }

    // CREATE: Adds a new Classes object to the repository
    @Override
    public Classes create(Classes classes) {
        classesList.add(classes);
        return classes;
    }

    // READ: Retrieves a Classes object by its ID
    @Override
    public Classes read(int id) {
        return classesList.stream()
                .filter(c -> c.getClassId() == id) // find matching class
                .findFirst()
                .orElse(null); // return null if not found
    }

    // UPDATE: Replaces an existing Classes object with updated data
    @Override
    public Classes update(Classes classes) {
        Classes existing = read(classes.getClassId());
        if (existing != null) {
            classesList.remove(existing); // remove old version
            classesList.add(classes);     // add updated version
            return classes;
        }
        return null; // return null if class not found
    }

    // DELETE: Removes a Classes object by its ID
    @Override
    public boolean delete(int id) {
        Classes classes = read(id);
        if (classes != null) {
            classesList.remove(classes);
            return true;
        }
        return false;
    }

    // GET ALL: Returns all Classes objects in the repository
    @Override
    public List<Classes> getAll() {
        return classesList;
    }

    // Utility method used in testing to clear the repository (reset state)
    public void clear() {
        classesList.clear();
    }
}