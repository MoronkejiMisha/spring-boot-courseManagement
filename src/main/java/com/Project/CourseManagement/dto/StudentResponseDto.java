package com.Project.CourseManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponseDto{
    private String firstName;
    private String lastName;
    private List<CourseResponseDto> courses_enrolled;
}
