package com.HibernateJpaJunitTest;

import org.junit.jupiter.api.*;
import com.HibernateJpaJunit.Student;
import com.HibernateJpaJunit.StudentDAO;


import javax.persistence.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentDAOTest {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private StudentDAO dao;

    @BeforeAll
    static void setupFactory() {
        emf = Persistence.createEntityManagerFactory("postgres");
    }

    @AfterAll
    static void closeFactory() {
        emf.close();
    }

    @BeforeEach
    void setup() {
        em = emf.createEntityManager();
        dao = new StudentDAO(em);
    }

    @AfterEach
    void tearDown() {
        em.close();
    }

    @Test
    @Order(1)
    void testSaveStudent() {
        Student s = new Student("santhosh", "santhosh@gmail.com", 85);
        dao.saveStudent(s);
        assertNotNull(s.getId());
    }

    @Test
    @Order(2)
    void testFindStudentById() {
        Student s = new Student("uthkarsh", "uthkarsh@gmail.com", 90);
        dao.saveStudent(s);

        Student found = dao.findStudentById(s.getId());
        assertEquals("Alice", found.getName());
    }

    @Test
    @Order(3)
    void testFindAllStudents() {
        List<Student> list = dao.findAllStudents();
        assertTrue(list.size() >= 0);
    }

    @Test
    @Order(4)
    void testUpdateStudent() {
        Student s = new Student("Shashwat", "shashwat@gmail.com.com", 70);
        dao.saveStudent(s);

        s.setMarks(95);
        dao.updateStudent(s);

        Student updated = dao.findStudentById(s.getId());
        assertEquals(95, updated.getMarks());
    }

    @Test
    @Order(5)
    void testDeleteStudent() {
        Student s = new Student("Mark", "mark@example.com", 60);
        dao.saveStudent(s);

        dao.deleteStudent(s.getId());
        assertNull(dao.findStudentById(s.getId()));
    }

    @Test
    @Order(6)
    void testStudentCount() {
        long count = dao.countStudents();
        assertTrue(count >= 0);
    }
}