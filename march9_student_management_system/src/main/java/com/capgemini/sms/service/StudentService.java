package com.capgemini.sms.service;

import org.springframework.data.domain.Page;
import com.capgemini.sms.entity.Student;

public interface StudentService {

Student createStudent(Student student);

Student getStudent(Long id);

Page<Student> getAllStudents(int page,int size,String sortBy);

Student updateStudent(Long id,Student student);

void deleteStudent(Long id);

}