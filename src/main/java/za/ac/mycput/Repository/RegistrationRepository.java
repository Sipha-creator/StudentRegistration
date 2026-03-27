/*
RegistrationRepository.java
Repository class for managing Registration objects in the Student Course Management System.
Implements the Singleton pattern and provides basic operations for storing registrations.

Author: Damien Swarts (222868791)
Date: 27 March 2026
*/
package za.ac.mycput.Repository;

import za.ac.mycput.Entity.Registration;
import java.util.ArrayList;
import java.util.List;

public class RegistrationRepository implements IRegistrationRepository {

    // Singleton instance of the repository
    private static RegistrationRepository repository = null;

    // Internal list acting as an in-memory data store for Registration objects
    private List<Registration> registrationList;

    // Private constructor prevents direct instantiation (Singleton pattern)
    private RegistrationRepository() {
        registrationList = new ArrayList<>();
    }

    // Provides global access to the single instance of the repository
    public static RegistrationRepository getInstance() {
        if (repository == null) {
            repository = new RegistrationRepository();
        }
        return repository;
    }

    // CREATE: Adds a new Registration object (links a student to a class)
    @Override
    public Registration create(Registration registration) {
        registrationList.add(registration);
        return registration;
    }

    // GET ALL: Returns all Registration records
    @Override
    public List<Registration> getAll() {
        return registrationList;
    }

    // Utility method used in testing to clear repository data (reset state)
    public void clear() {
        registrationList.clear();
    }
}