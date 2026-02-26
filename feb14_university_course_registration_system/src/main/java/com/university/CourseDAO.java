package com.university;

import javax.persistence.*;
import java.util.List;

public class CourseDAO {

    public void saveCourse(Course course) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(course);
        tx.commit();
        em.close();
    }

    public Course findCourse(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        Course c = em.find(Course.class, id);
        em.close();
        return c;
    }

    public List<Course> findByInstructor(int instructorId) {
        EntityManager em = JPAUtil.getEntityManager();
        Query q = em.createQuery(
                "SELECT i.courses FROM Instructor i WHERE i.id = :id");
        q.setParameter("id", instructorId);
        List<Course> list = q.getResultList();
        em.close();
        return list;
    }
}
