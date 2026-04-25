package com.sms.studentmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponseDto {
    
    private int id;
    private String rollNumber;
    private String firstName;
    private String branch;
    private String section;

}
