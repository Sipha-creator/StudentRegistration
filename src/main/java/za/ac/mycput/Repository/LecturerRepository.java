/*
LecturerRepository.java
Repository class for managing Lecturer objects in the Student Course Management System.
Implements the Singleton pattern and provides CRUD operations.

Author: SC TShijila (231070071)
Date: 27 March 2026
*/
package za.ac.mycput.Repository;

import za.ac.mycput.Entity.Lecturer;

import java.util.ArrayList;
import java.util.List;

public class LecturerRepository implements ILecturerRepository {

    // Singleton instance of the repository
    private static LecturerRepository repository = null;

    // Internal list acting as an in-memory data store for Lecturer objects
    private List<Lecturer> lecturerList;

    // Private constructor prevents direct instantiation (Singleton pattern)
    private LecturerRepository() {
        lecturerList = new ArrayList<>();
    }

    // Provides global access to the single instance of the repository
    public static LecturerRepository getInstance() {
        if (repository == null) {
            repository = new LecturerRepository();
        }
        return repository;
    }

    // CREATE: Adds a new Lecturer object to the repository
    @Override
    public Lecturer create(Lecturer lecturer) {
        lecturerList.add(lecturer);
        return lecturer;
    }

    // READ: Retrieves a Lecturer object by its ID
    @Override
    public Lecturer read(int id) {
        return lecturerList.stream()
                .filter(l -> l.getLecturerId() == id) // find matching lecturer
                .findFirst()
                .orElse(null); // return null if not found
    }

    // UPDATE: Replaces an existing Lecturer object with updated data
    @Override
    public Lecturer update(Lecturer lecturer) {
        Lecturer existing = read(lecturer.getLecturerId());
        if (existing != null) {
            lecturerList.remove(existing); // remove old version
            lecturerList.add(lecturer);    // add updated version
            return lecturer;
        }
        return null; // return null if lecturer not found
    }

    // DELETE: Removes a Lecturer object by its ID
    @Override
    public boolean delete(int id) {
        Lecturer lecturer = read(id);
        if (lecturer != null) {
            lecturerList.remove(lecturer);
            return true;
        }
        return false;
    }

    // GET ALL: Returns all Lecturer objects in the repository
    @Override
    public List<Lecturer> getAll() {
        return lecturerList;
    }

    // Utility method used in testing to clear repository data (reset state)
    public void clear() {
        lecturerList.clear();
    }
}