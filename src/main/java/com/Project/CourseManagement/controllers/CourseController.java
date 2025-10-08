package com.Project.CourseManagement.controllers;

import com.Project.CourseManagement.dto.CourseDto;
import com.Project.CourseManagement.dto.CourseResponseDto;
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
        return this.courseService.findCourseById(id);
    }
    @GetMapping("/courses/title/{course-title}")
    public CourseResponseDto getCourseByName(@PathVariable("course-title") String title){
        return this.courseService.findCourseByTitle(title);
    }
    @GetMapping("/courses/firstname/{creator-firstName}")
    public List<CourseResponseDto> getCoursesByCreatorsFirstName(@PathVariable("creator-firstName") String firstName){
        return this.courseService.findCourseByCreatorsFirstName(firstName);
    }
    @GetMapping("/courses/lastname/{creator-lastName}")
    public List<CourseResponseDto> getCoursesByCreatorsLastName(@PathVariable("creator-lastName") String lastName){
        return this.courseService.findCourseByCreatorsLastName(lastName);
    }


    @PostMapping("/courses")
    public CourseResponseDto saveCourse(@RequestBody CourseDto courseDto){
        return courseService.saveCourse(courseDto);
    }

    @DeleteMapping("/courses/title/{course-title}")
    public void deleteCourseByTitle(@PathVariable("course-title") String title){
        courseService.deleteByTitle(title);
    }

    @DeleteMapping("/courses/{course-id}")
    public void deleteCourseById(@PathVariable("course-id") Integer id){
        this.courseService.deleteById(id);
    }

    @DeleteMapping("/courses/firstname/{creator-firstName}")
    public void deleteCoursesByCreatorFirstName(@PathVariable("creator-firstName") String firstName){
        this.courseService.deleteAllCoursesByCreatorFirstName(firstName);
    }

    @DeleteMapping("/courses/lastname/{creator-lastName}")
    public void deleteCoursesByCreatorLastName(@PathVariable("creator-lastName") String lastName){
        this.courseService.deleteAllCoursesByCreatorLastName(lastName);
    }


}
