package com.something.studentmanagementsystem.service;

import com.something.studentmanagementsystem.mode.Student;
import com.something.studentmanagementsystem.mode.StudentResponse;

public interface StudentService {
    StudentResponse getStudent(String id);

    StudentResponse createStudent(Student student);

    StudentResponse updateStudent(String id, Student student);

    void deleteStudent(String id);
}
