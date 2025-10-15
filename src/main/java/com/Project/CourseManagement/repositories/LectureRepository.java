package com.Project.CourseManagement.repositories;

import com.Project.CourseManagement.models.Lecture;
import com.Project.CourseManagement.models.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture,Integer> {
    Lecture findByIdAndSections_IdAndSections_Courses_Id(Integer lectureId, Integer sectionId, Integer courseId);
}
