package com.sms.studentmanagement.services;

import com.sms.studentmanagement.dto.StudentResponseDto;
import com.sms.studentmanagement.entity.Student;
import com.sms.studentmanagement.repository.StudentRepository;
import com.sms.studentmanagement.exception.StudentNotFoundException;
import com.sms.studentmanagement.dto.StudentRequestDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentResponseDto addStudent(StudentRequestDto dto) {

        Student student = new Student();

        student.setRollNumber(dto.getRollNumber());
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setEmail(dto.getEmail());
        student.setPhone(dto.getPhone());
        student.setBranch(dto.getBranch());
        student.setSection(dto.getSection());
        student.setAcademicYear(dto.getAcademicYear());
        student.setDateOfBirth(dto.getDateOfBirth());
        student.setGender(dto.getGender());
        student.setAddress(dto.getAddress());

        Student saved = studentRepository.save(student);

        return new StudentResponseDto(
            saved.getId(),
            saved.getRollNumber(),
            saved.getFirstName(),
            saved.getBranch(),
            saved.getSection()
        );
         
    }

    @Override
    public List<StudentResponseDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();  
        List<StudentResponseDto> responceList = new ArrayList<>();

        for(Student student : students){

            StudentResponseDto dto = new StudentResponseDto(
                student.getId(),
                student.getRollNumber(),
                student.getFirstName(),
                student.getBranch(),
                student.getSection()
            );
            responceList.add(dto);
        }

        return responceList;

    }

    @Override
    public StudentResponseDto getStudentById(int id){

        Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found with id " +id));
        return new StudentResponseDto(student.getId(), student.getRollNumber(), student.getFirstName(), student.getBranch(), student.getSection());

    }

    @Override
    public StudentResponseDto updateStudent(int id, StudentRequestDto dto){
        Student existing = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id " + id));

        existing.setRollNumber(dto.getRollNumber());
        existing.setFirstName(dto.getFirstName());
        existing.setLastName(dto.getLastName());
        existing.setEmail(dto.getEmail());
        existing.setPhone(dto.getPhone());
        existing.setBranch(dto.getBranch().toUpperCase());
        existing.setSection(dto.getSection().toUpperCase());
        existing.setAcademicYear(dto.getAcademicYear());
        existing.setDateOfBirth(dto.getDateOfBirth());
        existing.setGender(dto.getGender());
        existing.setAddress(dto.getAddress());

       Student saved = studentRepository.save(existing);

       return new StudentResponseDto(
            saved.getId(),
            saved.getRollNumber(),
            saved.getFirstName(),
            saved.getBranch(),
            saved.getSection()
       );
    }

    @Override
    public void deleteStudent(int id){
        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException("Student not found with id " + id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentResponseDto updatePartialStudent(int id, StudentRequestDto dto) {

        Student existing = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id " + id));

        if (dto.getFirstName() != null && !dto.getFirstName().isBlank())
            existing.setFirstName(dto.getFirstName().trim());

        if (dto.getLastName() != null && !dto.getLastName().isBlank())
            existing.setLastName(dto.getLastName().trim());

        if (dto.getEmail() != null && !dto.getEmail().isBlank())
            existing.setEmail(dto.getEmail().trim());

        if (dto.getPhone() != null && !dto.getPhone().isBlank())
            existing.setPhone(dto.getPhone().trim());

        if (dto.getBranch() != null && !dto.getBranch().isBlank())
            existing.setBranch(dto.getBranch().trim().toUpperCase());

        if (dto.getSection() != null && !dto.getSection().isBlank())
            existing.setSection(dto.getSection().trim().toUpperCase());

        if (dto.getAcademicYear() != 0)
            existing.setAcademicYear(dto.getAcademicYear());

        if (dto.getGender() != null && !dto.getGender().isBlank())
            existing.setGender(dto.getGender().trim());

        if (dto.getAddress() != null && !dto.getAddress().isBlank())
            existing.setAddress(dto.getAddress().trim());

        if (dto.getDateOfBirth() != null)
            existing.setDateOfBirth(dto.getDateOfBirth());

        Student saved = studentRepository.save(existing);

        return new StudentResponseDto(
                saved.getId(),
                saved.getRollNumber(),
                saved.getFirstName(),
                saved.getBranch(),
                saved.getSection()
        );
    }
}