package com.Project.CourseManagement.dto;

import com.Project.CourseManagement.models.Creator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponseDto {
    private String title;
    private String description;
    private CreatorResponseDto creators;
}
