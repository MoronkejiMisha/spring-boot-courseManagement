package com.Project.CourseManagement.services;

import com.Project.CourseManagement.dto.ResourceDto;

import java.util.List;

public interface ResourceService {

        public void addResource(Integer lectureId,ResourceDto resourceDto);
        public ResourceDto getResourceById(Integer resourceId);
        public void deleteResource(Integer courseId,Integer sectionId,Integer lectureId,Integer resourceId);
        public List<ResourceDto> getAllResources();
}
