/*
ClassesFactory.java
Factory class used to create Classes objects in the Student Course Management System.
Encapsulates object creation logic for Classes entities.

Author: SC Tshijila (231070071)
Date: 27 March 2026
*/



package za.ac.mycput.Factory;

import za.ac.mycput.Entity.Classes;
import za.ac.mycput.Entity.Course;
import za.ac.mycput.Entity.Lecturer;

import java.util.List;

public class ClassesFactory {

    /*
     Static factory method used to create a Classes object.
     This method ensures consistent object creation and improves readability.
     */
    public static Classes createClasses(int id, String name, Course course, List<Lecturer> lecturers) {
        return new Classes(id, name, course, lecturers);
    }
}