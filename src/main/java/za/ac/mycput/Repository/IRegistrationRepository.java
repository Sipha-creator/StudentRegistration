/*
IRegistrationRepository.java
Interface defining operations for Registration entities
in the Student Course Management System.
Handles linking between Student and Classes through registration.

Author: Damien Swarts (222868791)
Date: 27 March 2026
*/
package za.ac.mycput.Repository;

import za.ac.mycput.Entity.Registration;
import java.util.List;

public interface IRegistrationRepository {

    // CREATE: Adds a new Registration object linking a student to a class
    Registration create(Registration registration);

    // GET ALL: Returns all Registration records
    List<Registration> getAll();
}