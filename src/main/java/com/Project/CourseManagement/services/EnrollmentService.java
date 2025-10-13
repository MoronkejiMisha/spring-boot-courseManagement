package com.Project.CourseManagement.services;

import com.Project.CourseManagement.dto.CourseEnrollmentDto;
import com.Project.CourseManagement.dto.StudentEnrollmentResponseDto;
import com.Project.CourseManagement.models.Course;
import java.util.List;

public interface EnrollmentService {
    public void enrollStudentById(CourseEnrollmentDto courseEnrollmentDto);

    public void deleteEnrollment(Integer studentId,Integer courseId);

    public List<Course> getCoursesEnrolled(Integer id);

    public List<StudentEnrollmentResponseDto> getStudentsEnrolled(Integer id);
}

