package com.Project.CourseManagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatorDto{
        @NotBlank(message = "firstname must not be empty")
        String firstName;

        @NotBlank(message = "lastname must not be empty")
        String lastName;

        @Email(message = "invalid email format")
        String email;

        @NotBlank(message = "password must not be empty")
        String password;


}
