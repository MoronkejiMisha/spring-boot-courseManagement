package com.Project.CourseManagement.controllers;

import com.Project.CourseManagement.dto.StudentDto;
import com.Project.CourseManagement.services.Implementations.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class StudentController {
    private final StudentServiceImpl studentService;
    @PostMapping("/students")
    public void saveStudent(@RequestBody StudentDto studentDto){
        studentService.saveStudent(studentDto);
    }

    @GetMapping("/students")
    public List<StudentDto> listAllStudents(){
        return studentService.findAllStudents();
    }

    @GetMapping("/students/{student-id}")
    public StudentDto listStudentById(@PathVariable("student-id") Integer id) {
        return studentService.findStudentById(id);
    }

    @DeleteMapping("/students/{student-id}")
    public void deleteCourse(@PathVariable("student-id") Integer id){
        studentService.deleteCourseById(id);
    }

}
