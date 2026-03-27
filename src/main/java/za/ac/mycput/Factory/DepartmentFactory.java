/*
DepartmentFactory.java
Factory class used to create Department objects in the Student Course Management System.
Encapsulates object creation logic for Department entities.

Author: Damien Swarts (222868791)
Date: 27 March 2026
*/
package za.ac.mycput.Factory;

import za.ac.mycput.Entity.*;

public class DepartmentFactory {

    /*
     Static factory method used to create a Department object.
     Provides a clean and consistent way to instantiate Department entities.
     */
    public static Department createDepartment(int id, String name) {
        return new Department(id, name);
    }
}