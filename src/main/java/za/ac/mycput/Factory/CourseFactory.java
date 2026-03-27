/*
CourseFactory.java
Factory class used to create Course objects in the Student Course Management System.
Encapsulates object creation logic for Course entities.

Author: Damien Swarts (222868791)
Date: 27 March 2026
*/
package za.ac.mycput.Factory;

import za.ac.mycput.Entity.*;

public class CourseFactory {

    /*
     Static factory method used to create a Course object.
     Ensures consistent and controlled creation of Course instances.
     */
    public static Course createCourse(int id, String name, Department department) {
        return new Course(id, name, department);
    }
}
