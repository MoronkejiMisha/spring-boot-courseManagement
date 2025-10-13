package com.Project.CourseManagement.controllers;

import com.Project.CourseManagement.dto.CourseDto;
import com.Project.CourseManagement.dto.CourseResponseDto;
import com.Project.CourseManagement.dto.CourseUpdateDto;
import com.Project.CourseManagement.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CourseController{
    private final CourseService courseService;

    @GetMapping("/courses")
    public List<CourseResponseDto> getCourses(){
        return this.courseService.findAllCourses();
    }
    @GetMapping("/courses/{courses-id}")
    public CourseResponseDto getCoursesById(@PathVariable("courses-id") Integer id){
        return courseService.findCourseById(id);
    }
    @GetMapping("/courses/title/{course-title}")
    public CourseResponseDto getCourseByName(@PathVariable("course-title") String title){
        return courseService.findCourseByTitle(title);
    }
    @GetMapping("/courses/firstname/{creator-firstName}")
    public List<CourseResponseDto> getCoursesByCreatorsFirstName(@PathVariable("creator-firstName") String firstName){
        return courseService.findCourseByCreatorsFirstName(firstName);
    }
    @GetMapping("/courses/lastname/{creator-lastName}")
    public List<CourseResponseDto> getCoursesByCreatorsLastName(@PathVariable("creator-lastName") String lastName){
        return courseService.findCourseByCreatorsLastName(lastName);
    }


    @PostMapping("/courses")
    public CourseResponseDto saveCourse(@RequestBody CourseDto courseDto){
        return courseService.saveCourse(courseDto);
    }

    @DeleteMapping("/courses/{creator-id}/{course-id}/delete")
    public void deleteCourseById(@PathVariable("creator-id") Integer creatorId,@PathVariable("course-id") Integer courseId){
        courseService.deleteCourse(creatorId,courseId);
    }

    @PatchMapping("/{creator-id}/courses/{course-id}")
    public void updateCourse(@PathVariable("creator-id") Integer creatorId, @PathVariable("course-id") Integer courseId, @RequestBody CourseUpdateDto courseUpdateDto){
        courseService.updateCourse(creatorId,courseId,courseUpdateDto);

    }
}
