package com.mongo.Services;

import com.mongo.Models.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public List<Student> getStudents();
    public Optional<Student> getStudent(int id);
    public Student addStudent(Student student);
    public Student editStudent(Student student);
    public boolean deleteStudent(int id);
}
