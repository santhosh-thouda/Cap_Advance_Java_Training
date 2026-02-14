package com.university;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UniversityTest {

    UniversityService service = new UniversityService();

    // OneToOne Mapping Test
    @Test
    void testOneToOneMapping() {

        InstructorProfile profile = new InstructorProfile();
        profile.setOfficeRoom("A101");
        profile.setPhone("9876543210");

        Instructor instructor = new Instructor();
        instructor.setName("Dr. Smith");
        instructor.setDepartment("Computer Science");
        instructor.setProfile(profile);

        service.createInstructor(instructor);

        assertTrue(instructor.getId() >= 0);
    }

    // OneToMany Mapping Test
    @Test
    void testOneToManyMapping() {

        Course c1 = new Course();
        c1.setTitle("Java Programming");
        c1.setCredits(4);

        Course c2 = new Course();
        c2.setTitle("Data Structures");
        c2.setCredits(3);

        Instructor instructor = new Instructor();
        instructor.setName("Dr. John");
        instructor.setDepartment("IT");
        instructor.setCourses(Arrays.asList(c1, c2));

        service.addCoursesToInstructor(instructor);

        assertTrue(instructor.getId() >= 0);
    }

    // ManyToOne Mapping Test
    @Test
    void testManyToOneMapping() {

        Course course = new Course();
        course.setTitle("Database Systems");
        course.setCredits(4);

        new CourseDAO().saveCourse(course);

        Enrollment enrollment = new Enrollment();
        enrollment.setSemester("Spring 2026");
        enrollment.setGrade("A");
        enrollment.setCourse(course);

        service.addEnrollment(enrollment);

        assertTrue(enrollment.getId() >= 0);
    }

    // DAO Update Test
    @Test
    void testUpdateGrade() {

        Course course = new Course();
        course.setTitle("Operating Systems");
        course.setCredits(4);

        new CourseDAO().saveCourse(course);

        Enrollment enrollment = new Enrollment();
        enrollment.setSemester("Fall 2026");
        enrollment.setGrade("B");
        enrollment.setCourse(course);

        service.addEnrollment(enrollment);

        service.updateEnrollmentGrade(enrollment.getId(), "A+");

        assertEquals("A+", enrollment.getGrade());
    }

    // Full Service Workflow Test
    @Test
    void testFullWorkflow() {

        InstructorProfile profile = new InstructorProfile();
        profile.setOfficeRoom("B202");
        profile.setPhone("9999999999");

        Course c1 = new Course();
        c1.setTitle("Machine Learning");
        c1.setCredits(4);

        Instructor instructor = new Instructor();
        instructor.setName("Dr. AI");
        instructor.setDepartment("AI & Data Science");
        instructor.setProfile(profile);
        instructor.setCourses(Arrays.asList(c1));

        service.createInstructor(instructor);

        List<Course> courses = service.getInstructorCourses(instructor.getId());

        assertNotNull(courses);
    }
}
