package com.mongo.Services;

import com.mongo.Models.Student;
import com.mongo.Repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    Logger logger= LoggerFactory.getLogger(StudentServiceImpl.class);
    @Autowired
    public StudentRepository studentRepository;
    @Override
    public List<Student> getStudents() {
        List<Student> students=new ArrayList<>();
        try{
            students=studentRepository.findAll();
        } catch (Exception e){
            logger.error(e.getMessage());
        }
        return students;
    }

    @Override
    public Optional<Student> getStudent(int id) {
        Optional<Student> student= Optional.of(new Student());
        try{
            student=studentRepository.findById(id);
        } catch (Exception e){
            logger.error(e.getMessage());
        }
        return student;
    }

    @Override
    public Student addStudent(Student student) {
        Student studentResult=new Student();
        try{
            studentResult=studentRepository.save(student);
        } catch (Exception e){
            logger.error(e.getMessage());
        }
        return studentResult;
    }

    @Override
    public Student editStudent(Student student) {
        Student student1=new Student();
        try{
            student1=studentRepository.save(student);
        } catch (Exception e){
            logger.error(e.getMessage());
        }
        return student1;
    }

    @Override
    public boolean deleteStudent(int id) {
        try{
            studentRepository.deleteById(id);
            return true;
        } catch (Exception e){
            logger.error(e.getMessage());
        }
        return false;
    }
}
