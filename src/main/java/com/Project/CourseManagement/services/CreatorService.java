package com.Project.CourseManagement.services;


import com.Project.CourseManagement.dto.CreatorDto;
import com.Project.CourseManagement.dto.CreatorResponseDto;

import java.util.List;

public interface CreatorService {

    void addCreator(CreatorDto creatorDto);
    List<CreatorResponseDto> findAllCreators();
    CreatorDto findCreatorByName(String firstName, String lastName);
    CreatorResponseDto findCreatorById(Integer id);
    List<CreatorResponseDto> findCreatorByFirstName(String firstName);
    List<CreatorResponseDto> findCreatorByLastName(String lastName);
    void deleteCreator(Integer id);
}