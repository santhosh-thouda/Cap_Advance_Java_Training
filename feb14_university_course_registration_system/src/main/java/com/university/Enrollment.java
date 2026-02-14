package com.university;

import javax.persistence.*;

@Entity
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String semester;
    private String grade;

    @ManyToOne
    private Course course;

    public int getId() { return id; }

    public String getSemester() { return semester; }
    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }

    public Course getCourse() { return course; }
    public void setCourse(Course course) {
        this.course = course;
    }
}
