package com.Project.CourseManagement.controllers;

import com.Project.CourseManagement.dto.ResourceDto;
import com.Project.CourseManagement.services.ResourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ResourceController {
    private final ResourceService resourceService;

    @PostMapping("/courses/{courseId}/sections/{sectionId}/lectures/{lectureId}/resources")
    public void addResource(@PathVariable("courseId") Integer courseId,@PathVariable("sectionId") Integer sectionId,@PathVariable("lectureId") Integer lectureId,@RequestBody ResourceDto resourceDto){
        resourceService.addResource(lectureId,resourceDto);
    }

    @GetMapping("/courses/{courseId}/sections/{sectionId}/lectures/{lectureId}/resources/{resourceId}")
    public ResourceDto getResourceById(@PathVariable("resourceId") Integer resourceId){
        return resourceService.getResourceById(resourceId);
    }

    @GetMapping("/courses/{courseId}/sections/{sectionId}/lectures/{lectureId}/resources")
    public List<ResourceDto> getAllResources(){
        return resourceService.getAllResources();
    }

    @DeleteMapping("/courses/{courseId}/sections/{sectionId}/lectures/{lectureId}/resources/{resourceId}")
    public void deleteById(@PathVariable("courseId") Integer courseId,@PathVariable("sectionId") Integer sectionId,@PathVariable("lectureId") Integer lectureId,@PathVariable("resourceId") Integer resourceId){
        resourceService.deleteResource(courseId,sectionId,lectureId,resourceId);

    }
}
