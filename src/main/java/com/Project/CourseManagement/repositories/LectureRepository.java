package com.Project.CourseManagement.repositories;

import com.Project.CourseManagement.models.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture,Integer> {
    public Lecture findByNameContaining(String name);
    public Lecture deleteByNameContaining(String name);
}
