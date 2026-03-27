/*
CourseRepository.java
Repository class for managing Course objects in the Student Course Management System.
Implements the Singleton pattern and provides CRUD operations.

Author: SC Tshijila (231070071)
Date: 25 March 2026
*/



package za.ac.mycput.Repository;



import za.ac.mycput.Entity.Course;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository implements ICourseRepository {

    // Singleton instance of the repository
    private static CourseRepository repository = null;

    // Internal list used to store Course objects (acts as in-memory database)
    private List<Course> courseList;

    // Private constructor prevents direct instantiation (Singleton pattern)
    private CourseRepository() {
        courseList = new ArrayList<>();
    }

    // Provides global access to the single instance of the repository
    public static CourseRepository getInstance() {
        if (repository == null) {
            repository = new CourseRepository();
        }
        return repository;
    }

    // CREATE: Adds a new Course object to the repository
    @Override
    public Course create(Course course) {
        courseList.add(course);
        return course;
    }

    // READ: Retrieves a Course object by its ID
    @Override
    public Course read(int id) {
        return courseList.stream()
                .filter(c -> c.getCourseId() == id) // find matching course
                .findFirst()
                .orElse(null); // return null if not found
    }

    // UPDATE: Replaces an existing Course object with updated data
    @Override
    public Course update(Course course) {
        Course existing = read(course.getCourseId());
        if (existing != null) {
            courseList.remove(existing); // remove old version
            courseList.add(course);      // add updated version
            return course;
        }
        return null; // return null if course not found
    }

    // DELETE: Removes a Course object by its ID
    @Override
    public boolean delete(int id) {
        Course course = read(id);
        if (course != null) {
            courseList.remove(course);
            return true;
        }
        return false;
    }

    // GET ALL: Returns all Course objects in the repository
    @Override
    public List<Course> getAll() {
        return courseList;
    }

    // Utility method used in testing to clear the repository (reset state)
    public void clear() {
        courseList.clear();
    }
}