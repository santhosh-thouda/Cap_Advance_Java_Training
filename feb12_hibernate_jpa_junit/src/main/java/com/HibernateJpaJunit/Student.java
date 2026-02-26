package com.HibernateJpaJunit;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private int marks;

    public Student() {
    }

    public Student(String name, String email, int marks) {
        this.name = name;
        this.email = email;
        this.marks = marks;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public int getMarks() {
        return marks;
    }

    public String getEmail() {
        return email;
    }
}