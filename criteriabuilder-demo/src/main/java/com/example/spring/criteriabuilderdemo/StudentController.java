package com.example.spring.criteriabuilderdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hi";
    }

    @PostMapping("/listAll")
    public List<Student> listAll(@RequestBody Student student){
        return studentService.listAllStudents(student);
    }

}
