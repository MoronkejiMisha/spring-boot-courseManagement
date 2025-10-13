package com.Project.CourseManagement.repositories;

import com.Project.CourseManagement.models.Course;
import com.Project.CourseManagement.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Integer> {
    Course findByTitleIgnoreCaseContaining(String title);

    Course deleteByTitleIgnoreCaseContaining(String title);

    void deleteAllByCreators_FirstNameIgnoreCaseContaining(String creator);

    void deleteAllByCreators_LastNameIgnoreCaseContaining(String creator);

    void deleteByCreators_FirstNameIgnoreCaseContaining(String firstName);

    void deleteByCreators_LastNameIgnoreCaseContaining(String lastName);

    Course findByCreators_IdAndId(Integer creatorId, Integer courseId);

    List<Course> findByCreators_FirstNameIgnoreCaseContaining(String firstName);

    List<Course> findByCreators_LastNameIgnoreCaseContaining(String lastName);

}
