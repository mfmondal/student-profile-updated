package com.mondal.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mondal.springboot.entity.Student;
import com.mondal.springboot.exceptions.ResourceNotFoundException;
import com.mondal.springboot.repository.StudentRepository;
	
//@RestController @CrossOrigin(origins = "http://localhost:4200")
@RestController @CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    // http://localhost:8081/angular-springboot/api/v1/students
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    
    // http://localhost:8081/angular-springboot/api/v1/students/17
    @Primary
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable(value = "id") Long studentId)
        throws ResourceNotFoundException {
        Student student = studentRepository.findById(studentId)
          .orElseThrow(() -> new ResourceNotFoundException("Student not found with this id :: " + studentId));
        return ResponseEntity.ok().body(student);
    }
    
    // http://localhost:8081/angular-springboot/api/v1/students
    @PostMapping("/students")
    public Student createStudent(@Validated @RequestBody Student student) {
        return studentRepository.save(student);
    }

    // http://localhost:8081/angular-springboot/api/v1/students/17
    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") Long studentId,
         @Validated @RequestBody Student studentDetails) throws ResourceNotFoundException {
        Student student = studentRepository.findById(studentId)
        .orElseThrow(() -> new ResourceNotFoundException("Employee not found with this id :: " + studentId));

        student.setFirstName(studentDetails.getFirstName());
        student.setLastName(studentDetails.getLastName());
        student.setEmailId(studentDetails.getEmailId());
        student.setProgramEnrolled(studentDetails.getProgramEnrolled());
        student.setSemesterEnrolled(studentDetails.getSemesterEnrolled());
        student.setAddress(studentDetails.getAddress());
        student.setCity(studentDetails.getCity());
        student.setPostalCode(studentDetails.getPostalCode());
        
        final Student updatedStudent = studentRepository.save(student);
        return ResponseEntity.ok(updatedStudent);
    }
    
    // http://localhost:8081/angular-springboot/api/v1/students/17
    @DeleteMapping("/students/{id}")
//    public Map<String, Boolean> deleteStudent(@PathVariable(value = "id") Long studentId)
//         throws ResourceNotFoundException {
//        Student student = studentRepository.findById(studentId)
//       .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + studentId));
//
//        studentRepository.delete(student);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("Deleted", Boolean.TRUE);
//        return response;
//    }
    
    public String deleteStudent(@PathVariable(value = "id") Long studentId)
    {
    	//Optional<Student> student = studentRepository.findById(studentId);
    	studentRepository.deleteById(studentId);
        return "Student Deleted Successfully";
    }
}
