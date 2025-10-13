package com.Project.CourseManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseUpdateDto {
    private Integer course_id;
    private String content;
    private String description;
    private String title;
}