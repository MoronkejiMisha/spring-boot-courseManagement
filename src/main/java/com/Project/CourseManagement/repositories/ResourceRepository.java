package com.Project.CourseManagement.repositories;

import com.Project.CourseManagement.models.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource,Integer> {
}
