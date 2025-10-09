package com.Project.CourseManagement.controllers;

import com.Project.CourseManagement.dto.CourseEnrollmentDto;
import com.Project.CourseManagement.services.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @PostMapping("courses/enrollment")
    public void enrollStudent(@RequestBody CourseEnrollmentDto courseEnrollmentDto){
        enrollmentService.enrollStudentById(courseEnrollmentDto);

    }
}
