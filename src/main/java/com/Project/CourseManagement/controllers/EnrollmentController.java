package com.Project.CourseManagement.controllers;

import com.Project.CourseManagement.dto.CourseEnrollmentDto;
import com.Project.CourseManagement.dto.StudentEnrollmentResponseDto;
import com.Project.CourseManagement.models.Course;
import com.Project.CourseManagement.services.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @PostMapping("/enroll")
    public void enrollStudent(@RequestBody CourseEnrollmentDto courseEnrollmentDto){
        enrollmentService.enrollStudentById(courseEnrollmentDto);

    }
    @DeleteMapping("/{student-id}/delete/{course-id}")
    public void deleteEnrollment(@PathVariable("student-id") Integer studentId,@PathVariable("course-id") Integer courseId){
        enrollmentService.deleteEnrollment(studentId,courseId);
    }
    @GetMapping("/{student-id}/enrolled/courses")
    public List<Course> coursesEnrolled(@PathVariable("student-id") Integer id){
        return enrollmentService.getCoursesEnrolled(id);
    }

    @GetMapping("/{course-id}/enrolled/students")
    public List<StudentEnrollmentResponseDto> studentsEnrolled(@PathVariable("course-id") Integer id){
        return enrollmentService.getStudentsEnrolled(id);
    }

}
