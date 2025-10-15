package com.Project.CourseManagement.controllers;

import com.Project.CourseManagement.dto.LectureDto;
import com.Project.CourseManagement.dto.SectionDto;
import com.Project.CourseManagement.services.SectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class SectionController {
    private final SectionService sectionService;

    @PostMapping("/courses/{courseId}/sections")
    public void addSection(@PathVariable("courseId") Integer courseId, @RequestBody SectionDto sectionDto){
        sectionService.addSection(courseId,sectionDto);
    }
    @GetMapping("/courses/{courseId}/sections/{sectionId}")
    public SectionDto getSectionById(@PathVariable("sectionId") Integer sectionId){
        return sectionService.getSectionsById(sectionId);
    }

    @GetMapping("/courses/{courseId}/sections")
    public List<SectionDto> getAllSections(){
        return sectionService.getAllSections();
    }
    @DeleteMapping("/courses/{courseId}/sections/{sectionId}")
    public void deleteById(@PathVariable("courseId") Integer courseId,@PathVariable("sectionId") Integer sectionId){
       sectionService.deleteSectionById(courseId,sectionId);

    }

}
