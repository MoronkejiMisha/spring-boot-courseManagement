package com.Project.CourseManagement.services;

import com.Project.CourseManagement.dto.SectionDto;

import java.util.List;

public interface SectionService {
    void addSection(Integer courseId,SectionDto sectionDto);
    void deleteSectionById(Integer courseId,Integer sectionId);
    List<SectionDto> getAllSections();
    SectionDto getSectionsById(Integer sectionId);

}
