package com.capgemini.sms.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.capgemini.sms.entity.Student;
import com.capgemini.sms.repository.StudentRepository;
import com.capgemini.sms.service.StudentService;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins="*")
public class StudentController {

@Autowired
private StudentService service;

@Autowired
private StudentRepository repository;

@PostMapping
public Student createStudent(@RequestBody Student student){
return service.createStudent(student);
}

@GetMapping("/{id}")
public Student getStudent(@PathVariable Long id){
return service.getStudent(id);
}

@GetMapping
public Page<Student> getAllStudents(
@RequestParam(defaultValue="0") int page,
@RequestParam(defaultValue="5") int size,
@RequestParam(defaultValue="id") String sortBy){

return service.getAllStudents(page,size,sortBy);
}

@PutMapping("/{id}")
public Student updateStudent(@PathVariable Long id,
@RequestBody Student student){
return service.updateStudent(id,student);
}

@DeleteMapping("/{id}")
public void deleteStudent(@PathVariable Long id){
service.deleteStudent(id);
}

@PostMapping("/{id}/upload/profile")
public String uploadProfileImage(
@PathVariable Long id,
@RequestParam("file") MultipartFile file) throws IOException {

Student student = repository.findById(id).orElseThrow();

student.setProfileImage(file.getBytes());

repository.save(student);

return "Profile image uploaded";
}

@PostMapping("/{id}/upload/assignment")
public String uploadAssignment(
@PathVariable Long id,
@RequestParam("file") MultipartFile file) throws IOException {

Student student = repository.findById(id).orElseThrow();

student.setAssignmentFile(file.getBytes());

repository.save(student);

return "Assignment uploaded";
}

@GetMapping("/{id}/profile")
public ResponseEntity<byte[]> downloadProfile(@PathVariable Long id){

Student student = repository.findById(id).orElseThrow();

return ResponseEntity.ok()
.contentType(MediaType.IMAGE_JPEG)
.body(student.getProfileImage());

}

@GetMapping("/{id}/assignment")
public ResponseEntity<byte[]> downloadAssignment(@PathVariable Long id){

Student student = repository.findById(id).orElseThrow();

return ResponseEntity.ok()
.contentType(MediaType.APPLICATION_OCTET_STREAM)
.body(student.getAssignmentFile());

}

}