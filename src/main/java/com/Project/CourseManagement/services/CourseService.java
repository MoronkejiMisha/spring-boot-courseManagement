package com.Project.CourseManagement.services;

import com.Project.CourseManagement.dto.CourseDto;
import com.Project.CourseManagement.dto.CourseResponseDto;
import com.Project.CourseManagement.dto.CourseUpdateDto;

import java.util.List;

public interface CourseService {
    CourseResponseDto saveCourse(CourseDto courseDto);
    CourseResponseDto findCourseById(Integer id);
    CourseResponseDto findCourseByTitle(String title);
    List<CourseResponseDto> findCourseByCreatorsFirstName(String firstName);
    List<CourseResponseDto> findCourseByCreatorsLastName(String lastName);
    List<CourseResponseDto> findAllCourses();
    void deleteCourse(Integer creatorId, Integer courseId);
    void updateCourse(Integer creatorId, Integer courseId, CourseUpdateDto courseUpdateDto);
}