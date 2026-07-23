package com.sgic16.sgic.services;

import com.sgic16.sgic.dto.StudentDto;

import java.util.List;

public interface  StudentService {
    StudentDto createStudent(StudentDto studentDto);
    List<StudentDto> getAllStudents();
    void deleteStudent(Integer id);
   StudentDto updateStudent(Integer id,StudentDto studentDto);

}

