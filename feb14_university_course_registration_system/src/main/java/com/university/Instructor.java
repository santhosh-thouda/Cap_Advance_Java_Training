package com.university;

import javax.persistence.*;
import java.util.List;

@Entity
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String department;

    @OneToOne(cascade = CascadeType.ALL)
    private InstructorProfile profile;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Course> courses;

    public int getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) {
        this.department = department;
    }

    public InstructorProfile getProfile() { return profile; }
    public void setProfile(InstructorProfile profile) {
        this.profile = profile;
    }

    public List<Course> getCourses() { return courses; }
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
