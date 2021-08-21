package com.something.studentmanagementsystem.controller;

import com.something.studentmanagementsystem.mode.Student;
import com.something.studentmanagementsystem.mode.StudentResponse;
import com.something.studentmanagementsystem.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/student")
@Slf4j
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/{id}")
    public StudentResponse getStudent(@PathVariable String id) {
        log.info("Get student with id: {}", id);
        return studentService.getStudent(id);
    }

    @PostMapping(value = "/create")
    public StudentResponse createStudent(@RequestBody Student student) {
        log.info("Student Create request received with student: {}", student);
        return studentService.createStudent(student);
    }

    @PutMapping(value = "/update/{id}")
    public StudentResponse updateStudent(@PathVariable String id, @RequestBody Student student) {
        log.info("Student update request received with id: {}, student: {}", id, student);
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteStudent(@PathVariable String id) {
        log.info("DELETE student with id: {}", id);
        studentService.deleteStudent(id);
    }

}
