package com.Project.CourseManagement.controllers;

import com.Project.CourseManagement.dto.LectureDto;
import com.Project.CourseManagement.services.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class LectureController {
    private final LectureService lectureService;

    @PostMapping("/courses/{courseId}/sections/{sectionId}/lectures")
    public void addLecture(@PathVariable("sectionId") Integer sectionId,@RequestBody LectureDto lectureDto){
        lectureService.saveLecture(sectionId,lectureDto);
    }
    @GetMapping("/courses/{courseId}/sections/{sectionId}/lectures/{lectureId}")
    public LectureDto getLectureById(@PathVariable("lectureId") Integer lectureId){
        return lectureService.getLectureById(lectureId);
    }

    @GetMapping("/courses/{courseId}/sections/{sectionId}/lectures")
    public List<LectureDto> getAllLectures(){
        return lectureService.getAllLectures();
    }

    @DeleteMapping("/courses/{courseId}/sections/{sectionId}/lectures/{lectureId}")
    public void deleteById(@PathVariable("courseId") Integer courseId,@PathVariable("sectionId") Integer sectionId,@PathVariable("lectureId") Integer lectureId){
        lectureService.deleteLectureById(courseId,sectionId,lectureId);

    }
}
