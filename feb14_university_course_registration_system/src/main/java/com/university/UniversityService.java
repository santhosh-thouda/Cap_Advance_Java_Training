package com.university;

import java.util.List;

public class UniversityService {

    InstructorDAO instructorDAO = new InstructorDAO();
    CourseDAO courseDAO = new CourseDAO();
    EnrollmentDAO enrollmentDAO = new EnrollmentDAO();

    public void createInstructor(Instructor instructor) {
        instructorDAO.saveInstructor(instructor);
    }

    public void addCoursesToInstructor(Instructor instructor) {
        instructorDAO.saveInstructor(instructor);
    }

    public void addEnrollment(Enrollment enrollment) {
        enrollmentDAO.saveEnrollment(enrollment);
    }

    public void updateEnrollmentGrade(int id, String grade) {
        enrollmentDAO.updateGrade(id, grade);
    }

    public List<Course> getInstructorCourses(int id) {
        return courseDAO.findByInstructor(id);
    }
}
