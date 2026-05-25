package com.sms.studentmanagement.services;

import com.sms.studentmanagement.dto.StudentResponseDto;
import com.sms.studentmanagement.dto.StudentRequestDto;
import java.util.List;

public interface StudentService {

    StudentResponseDto addStudent(StudentRequestDto dto);
    List<StudentResponseDto> getAllStudents();
    StudentResponseDto getStudentById(int id);
    public StudentResponseDto updateStudent(int id, StudentRequestDto dto);
    void deleteStudent(int id);
    StudentResponseDto updatePartialStudent(int id, StudentRequestDto dto);

}
