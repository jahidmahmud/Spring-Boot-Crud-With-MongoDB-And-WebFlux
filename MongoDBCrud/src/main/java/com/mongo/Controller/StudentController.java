package com.mongo.Controller;

import com.mongo.Models.Student;
import com.mongo.Services.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {
    Logger log= LoggerFactory.getLogger(StudentController.class);
    @Autowired
    StudentService service;
    @GetMapping("/")
    public ResponseEntity<?> getAllStudents(){
        List<Student> students=new ArrayList<>();
        try {
            students=service.getStudents();
            return ResponseEntity.ok().body(students);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<?>> getStudentById(@PathVariable("id") int id){
        Optional<Student> student=Optional.of(new Student());
        try {
            student=service.getStudent(id);
            return ResponseEntity.ok().body(student);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/")
    public ResponseEntity<?> addStudents(@RequestBody Student student){
        Student student1=new Student();
        try {
            student1=service.addStudent(student);
            return ResponseEntity.status(HttpStatus.CREATED).body(student1);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/")
    public ResponseEntity<?> editStudents(@RequestBody Student student){
        Student student1=new Student();
        try {
            student1=service.editStudent(student);
            return ResponseEntity.status(HttpStatus.OK).body(student1);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(int id){
        boolean status;
        try {
            status= service.deleteStudent(id);
            if (status){
                return ResponseEntity.ok().build();
            }
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
