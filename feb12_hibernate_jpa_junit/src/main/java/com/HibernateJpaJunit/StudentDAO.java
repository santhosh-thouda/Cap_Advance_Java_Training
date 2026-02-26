package com.HibernateJpaJunit;

import javax.persistence.*;
import java.util.List;

public class StudentDAO {

    private EntityManager em;

    public StudentDAO(EntityManager em) {
        this.em = em;
    }

    public void saveStudent(Student student) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(student);
        tx.commit();
    }

    public Student findStudentById(Long id) {
        return em.find(Student.class, id);
    }

    public List<Student> findAllStudents() {
        return em.createQuery("SELECT s FROM Student s", Student.class)
                .getResultList();
    }

    public void updateStudent(Student student) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(student);
        tx.commit();
    }

    public void deleteStudent(Long id) {
        EntityTransaction tx = em.getTransaction();
        Student student = em.find(Student.class, id);
        if (student != null) {
            tx.begin();
            em.remove(student);
            tx.commit();
        }
    }

    public long countStudents() {
        return em.createQuery("SELECT COUNT(s) FROM Student s", Long.class)
                .getSingleResult();
    }
}