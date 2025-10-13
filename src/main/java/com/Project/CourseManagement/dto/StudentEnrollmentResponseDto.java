package com.Project.CourseManagement.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentEnrollmentResponseDto {
    @NotBlank(message = "firstname must not be empty")
    private String firstName;

    @NotBlank(message = "lastname must not be empty")
    private String lastName;
}

