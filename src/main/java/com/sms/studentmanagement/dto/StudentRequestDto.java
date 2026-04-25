package com.sms.studentmanagement.dto;

import java.time.LocalDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRequestDto {
    
    @NotBlank(message = "Roll number is required")
    private String rollNumber;

    @NotBlank(message = "First name id required")
    private String firstName;
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Invalid Phone number")
    private String phone;

    @NotBlank(message = "Branch is required")
    private String branch;

    @NotBlank(message = "Section is required")
    private String section;

    @Min(value = 1, message = "Academic year must be at least 1")
    @Max(value = 4, message = "Academic year must be at most 4")
    private int academicYear;
    private LocalDate dateOfBirth;
    private String gender;
    private String address;

}
