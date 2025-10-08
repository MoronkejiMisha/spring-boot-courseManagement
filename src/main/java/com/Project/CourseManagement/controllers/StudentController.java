package com.Project.CourseManagement.controllers;

import com.Project.CourseManagement.dto.StudentDto;
import com.Project.CourseManagement.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class StudentController {
    private final StudentService studentService;
    @PostMapping("/students")
    public void saveStudent(StudentDto studentDto){
        studentService.saveStudent(studentDto);
    }

    @PostMapping("/students")
    public List<StudentDto> listAllStudents(){
        return studentService.findAllStudents();
    }

    @GetMapping("/students/{student-id}")
    public StudentDto listStudentById(@PathVariable("student-id") Integer id){
        return studentService.findStudentById(id);
    }

    @DeleteMapping("/students/{student-id}")
    public void deleteCourse(@PathVariable("student-id") Integer id){
        studentService.deleteCourseById(id);
    }

}
