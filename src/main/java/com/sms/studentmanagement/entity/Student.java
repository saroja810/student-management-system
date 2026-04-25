package com.sms.studentmanagement.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity   
public class Student {
    
    @Id   //  Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto ID
    private int id;

    @Column(unique = true, nullable = false)  // unique student id  provided by admin 
    private String rollNumber;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String branch;
    private int academicYear;
    private String section;
    private LocalDate dateOfBirth;
    private String gender;
    private String address;

    // Constructor 
        public Student(String rollNumber, String firstName, String lastName, String email, String phone, String branch, int academicYear, String section, LocalDate dateOfBirth, String gender, String address){
       
        this.rollNumber = rollNumber;
        this.firstName =firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.branch = branch;
        this.academicYear = academicYear;
        this.section = section;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;

    }
    
}