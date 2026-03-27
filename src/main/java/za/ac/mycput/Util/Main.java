/*
Main.java
Main driver class demonstrating the Student Course Management System.
Shows creation of entities, relationships, repository usage, and formatted output.

Author: Damien Swarts (222868791)
Date: 27 March 2026
*/
package za.ac.mycput.Util;

import za.ac.mycput.Entity.*;
import za.ac.mycput.Factory.*;
import za.ac.mycput.Repository.*;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        // Create department
        Department dept = DepartmentFactory.createDepartment(1, "IT");

        // Create courses within the department
        Course course1 = CourseFactory.createCourse(101, "Software Development", dept);
        Course course2 = CourseFactory.createCourse(102, "Application Development", dept);

        // Create lecturer addresses and contact details
        //Guys please note there are 4 lecturers but you can always change it
        Address a1 = new Address("12 College Road", "Cape Town", "8000", "WC");
        ContactDetails c1 = new ContactDetails("drsmith@cput.ac.za", "0215551001");

        Address a2 = new Address("45 Main Street", "Bellville", "7530", "WC");
        ContactDetails c2 = new ContactDetails("mjacobs@cput.ac.za", "0215551002");

        Address a3 = new Address("78 Voortrekker Road", "Parow", "7500", "WC");
        ContactDetails c3 = new ContactDetails("mnaidoo@cput.ac.za", "0215551003");

        Address a4 = new Address("99 Strand Street", "Cape Town", "8001", "WC");
        ContactDetails c4 = new ContactDetails("padams@cput.ac.za", "0215551004");

        // Create lecturer objects
        Lecturer lecturer1 = LecturerFactory.createLecturer(1, "Dr Smith", dept, a1, c1, Gender.MALE, Race.WHITE);
        Lecturer lecturer2 = LecturerFactory.createLecturer(2, "Ms Jacobs", dept, a2, c2, Gender.FEMALE, Race.AFRICAN);
        Lecturer lecturer3 = LecturerFactory.createLecturer(3, "Mr Naidoo", dept, a3, c3, Gender.MALE, Race.INDIAN);
        Lecturer lecturer4 = LecturerFactory.createLecturer(4, "Prof Adams", dept, a4, c4, Gender.MALE, Race.WHITE);

        // Create classes and assign one or more lecturers to each class
        Classes class1 = ClassesFactory.createClasses(201, "Programming Fundamentals", course1, Arrays.asList(lecturer1, lecturer4));
        Classes class2 = ClassesFactory.createClasses(202, "Systems Analysis", course1, Arrays.asList(lecturer2, lecturer3));
        Classes class3 = ClassesFactory.createClasses(203, "Web Development", course2, Arrays.asList(lecturer3));
        Classes class4 = ClassesFactory.createClasses(204, "Database Programming", course2, Arrays.asList(lecturer1, lecturer3, lecturer4));

        // Create a student and assign the student to one course
        Student student = StudentFactory.createStudent(
                1,
                "John",
                "Doe",
                course1,
                new Address("12 Main St", "Cape Town", "8000", "WC"),
                new ContactDetails("johndoe@student.cput.ac.za", "0812345678"),
                Gender.MALE,
                Race.AFRICAN
        );

        // Save entities to their respective repositories
        StudentRepository.getInstance().create(student);
        CourseRepository.getInstance().create(course1);
        CourseRepository.getInstance().create(course2);
        LecturerRepository.getInstance().create(lecturer1);
        LecturerRepository.getInstance().create(lecturer2);
        LecturerRepository.getInstance().create(lecturer3);
        LecturerRepository.getInstance().create(lecturer4);
        ClassesRepository.getInstance().create(class1);
        ClassesRepository.getInstance().create(class2);
        ClassesRepository.getInstance().create(class3);
        ClassesRepository.getInstance().create(class4);

        // Register the student for all classes in course 1
        RegistrationRepository.getInstance().create(RegistrationFactory.createRegistration(student, class1));
        RegistrationRepository.getInstance().create(RegistrationFactory.createRegistration(student, class2));

        // Lists used for easier output display
        List<Course> courses = Arrays.asList(course1, course2);
        List<Classes> allClasses = Arrays.asList(class1, class2, class3, class4);
        List<Lecturer> allLecturers = Arrays.asList(lecturer1, lecturer2, lecturer3, lecturer4);

        /*
         ==============================
         DEPARTMENT OVERVIEW SECTION
         ==============================
         Displays department details, its courses,
         and the classes offered within each course
         including assigned lecturers.
         */
        System.out.println("==============================");
        System.out.println("DEPARTMENT OVERVIEW");
        System.out.println("==============================\n");

        System.out.println("Department ID: " + dept.getDepartmentId());
        System.out.println("Department Name: " + dept.getDepartmentName());
        System.out.println("\nCourses in Department:");

        for (Course course : courses) {
            System.out.println("--------------------------------------------------");
            System.out.println("Course ID: " + course.getCourseId());
            System.out.println("Course Name: " + course.getCourseName());
            System.out.println("\nClasses in this Course:");

            for (Classes classes : allClasses) {
                if (classes.getCourse().getCourseId() == course.getCourseId()) {
                    System.out.println("  Class ID: " + classes.getClassId());
                    System.out.println("  Class Name: " + classes.getClassName());
                    System.out.println("  Lecturers Assigned:");
                    for (Lecturer lecturer : classes.getLecturers()) {
                        System.out.println("    - Lecturer " + lecturer.getLecturerId() + ": " + lecturer.getName());
                    }
                    System.out.println();
                }
            }
        }

        /*
         ==============================
         LECTURER INFORMATION SECTION
         ==============================
         Displays lecturer details such as ID, name,
         department, address, contact details,
         and classes taught by each lecturer.
         */
        System.out.println("==============================");
        System.out.println("LECTURER INFORMATION");
        System.out.println("==============================\n");

        for (Lecturer lecturer : allLecturers) {
            System.out.println("Lecturer ID: " + lecturer.getLecturerId());
            System.out.println("Name: " + lecturer.getName());
            System.out.println("Department: " + lecturer.getDepartment().getDepartmentName());
            System.out.println("Address: " + lecturer.getAddress());
            System.out.println("Contact: " + lecturer.getContactDetails());
            System.out.println("Classes Teaching:");

            for (Classes classes : allClasses) {
                if (classes.getLecturers().contains(lecturer)) {
                    System.out.println("  - " + classes.getClassName() + " (Course: " + classes.getCourse().getCourseName() + ")");
                }
            }
            System.out.println("\n--------------------------------------------------\n");
        }

        /*
         ==============================
         STUDENT REGISTRATION SECTION
         ==============================
         Displays student registration details,
         including course information and all classes
         the student is registered for.
         */
        System.out.println("==============================");
        System.out.println("STUDENT REGISTRATION DETAILS");
        System.out.println("==============================\n");

        System.out.println("Student ID: " + student.getStudentId());
        System.out.println("Name: " + student.getFullName());
        System.out.println("Department: " + student.getCourse().getDepartment().getDepartmentName());
        System.out.println("Registered Course: " + student.getCourse().getCourseName());
        System.out.println("Address: " + student.getAddress());
        System.out.println("Contact: " + student.getContactDetails());

        System.out.println("\nRegistered Classes:");
        int count = 1;
        for (Registration registration : RegistrationRepository.getInstance().getAll()) {
            if (registration.getStudent().getStudentId() == student.getStudentId()) {
                System.out.println("  " + count + ". " + registration.getClasses().getClassName());
                System.out.println("     Lecturers:");
                for (Lecturer lecturer : registration.getClasses().getLecturers()) {
                    System.out.println("       - " + lecturer.getName());
                }
                System.out.println();
                count++;
            }
        }
    }
}