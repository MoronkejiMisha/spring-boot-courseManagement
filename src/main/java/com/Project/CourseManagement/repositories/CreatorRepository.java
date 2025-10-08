package com.Project.CourseManagement.repositories;

import com.Project.CourseManagement.models.Course;
import com.Project.CourseManagement.models.Creator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreatorRepository extends JpaRepository<Creator,Integer> {
    public List<Creator> findByFirstNameIgnoreCaseContaining(String firstName);
    public List<Creator> findByLastNameIgnoreCaseContaining(String lastName);
    public Creator findByFirstNameAndLastNameIgnoreCaseContaining(String firstName,String LastName);

    //how to find via both first and lastnames
}
