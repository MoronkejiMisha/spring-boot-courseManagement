package com.Project.CourseManagement.repositories;

import com.Project.CourseManagement.models.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section,Integer> {
    Section findByIdAndCourses_Id(Integer sectionId,Integer courseId);
}
