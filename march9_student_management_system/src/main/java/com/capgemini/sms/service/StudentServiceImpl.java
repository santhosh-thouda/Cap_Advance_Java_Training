package com.capgemini.sms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.capgemini.sms.entity.Student;
import com.capgemini.sms.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

@Autowired
private StudentRepository repository;

@Override
@PreAuthorize("hasRole('ADMIN')")
public Student createStudent(Student student) {
return repository.save(student);
}

@Override
@Cacheable(value="students",key="#id")
@PreAuthorize("hasAnyRole('ADMIN','USER')")
public Student getStudent(Long id) {

Optional<Student> student = repository.findById(id);

return student.orElseThrow(() ->
new RuntimeException("Student not found"));

}

@Override
@PreAuthorize("hasAnyRole('ADMIN','USER')")
public Page<Student> getAllStudents(int page,int size,String sortBy){

Pageable pageable = PageRequest.of(page,size,Sort.by(sortBy));

return repository.findAll(pageable);

}

@Override
@PreAuthorize("hasRole('ADMIN')")
public Student updateStudent(Long id,Student student){

Student existing = repository.findById(id).orElseThrow();

existing.setName(student.getName());
existing.setEmail(student.getEmail());
existing.setCourse(student.getCourse());
existing.setMarks(student.getMarks());

return repository.save(existing);

}

@Override
@PreAuthorize("hasRole('ADMIN')")
public void deleteStudent(Long id){

repository.deleteById(id);

}

}