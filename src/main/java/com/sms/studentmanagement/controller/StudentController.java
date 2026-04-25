package com.sms.studentmanagement.controller;

import com.sms.studentmanagement.entity.Student;
import com.sms.studentmanagement.services.StudentService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sms.studentmanagement.dto.StudentRequestDto;
import com.sms.studentmanagement.dto.StudentResponseDto;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentResponseDto> addStudent(
            @Valid @RequestBody StudentRequestDto dto) {

        return ResponseEntity.ok(studentService.addStudent(dto));
    }

    @GetMapping
    public List<StudentResponseDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDto> getStudentById(@PathVariable int id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponseDto> updateStudent(
            @PathVariable int id,
            @Valid @RequestBody StudentRequestDto dto) {

        return ResponseEntity.ok(studentService.updateStudent(id, dto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<StudentResponseDto> updatePartialStudent(
            @PathVariable int id,
            @RequestBody StudentRequestDto dto) {

        return ResponseEntity.ok(studentService.updatePartialStudent(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

}