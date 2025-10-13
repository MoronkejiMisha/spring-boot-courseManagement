package com.Project.CourseManagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto{
    @NotBlank(message="firstname must not be empty")
    private String firstName;

    @NotBlank(message="lastname must not be empty")
    private String lastName;

    @Email(message = "invalid email format")
    private String email;

    @NotBlank(message = "password must not be empty")
    private String password;
}
