package com.Project.CourseManagement.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {

    @NotBlank(message = "Title must nt be empty")
    private String title;

    private String description;

    private Integer creatorId;
}
