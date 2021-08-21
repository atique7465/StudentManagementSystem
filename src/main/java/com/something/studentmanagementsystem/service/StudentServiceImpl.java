package com.something.studentmanagementsystem.service;

import com.something.studentmanagementsystem.mode.Student;
import com.something.studentmanagementsystem.mode.StudentResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    private final Map<String, Student> students = new HashMap<>();
    private Integer lastId = 1;

    @Override
    public StudentResponse getStudent(String id) {
        Student student = students.get(id);
        StudentResponse result = StudentResponse.builder()
                .id(id)
                .name(student.getName())
                .address(student.getAddress())
                .age(student.getAge())
                .bmi(student.getBmi())
                .build();
        return result;
    }

    @Override
    public StudentResponse createStudent(Student student) {
        students.put(lastId.toString(), student);
        lastId++;

        StudentResponse result = StudentResponse.builder()
                .id(lastId.toString())
                .name(student.getName())
                .address(student.getAddress())
                .age(student.getAge())
                .bmi(student.getBmi())
                .build();
        return result;
    }

    @Override
    public StudentResponse updateStudent(String id, Student student) {
        students.put(id, student);

        StudentResponse result = StudentResponse.builder()
                .id(id)
                .name(student.getName())
                .address(student.getAddress())
                .age(student.getAge())
                .bmi(student.getBmi())
                .build();
        return result;
    }

    @Override
    public void deleteStudent(String id) {
        students.remove(id);
    }
}
