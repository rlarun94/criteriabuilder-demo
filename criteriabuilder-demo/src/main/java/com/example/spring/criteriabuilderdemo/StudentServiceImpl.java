package com.example.spring.criteriabuilderdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private CustomStudentRepository customStudentRepository;

    @Override
    public List<Student> listAllStudents(Student student) {
        return customStudentRepository.listAllStudents(student);
    }
}
