package com.Project.CourseManagement.repositories;

import com.Project.CourseManagement.models.Course;
import com.Project.CourseManagement.models.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource,Integer> {

    Resource findByIdAndLectures_IdAndLectures_Sections_IdAndLectures_Sections_Courses_Id(Integer resourceId,Integer lectureId,Integer SectionId,Integer CourseId);
}
