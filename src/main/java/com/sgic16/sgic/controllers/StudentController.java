package com.sgic16.sgic.controllers;

import com.sgic16.sgic.dto.StudentDto;
import com.sgic16.sgic.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/V2")
public class StudentController {

    private final StudentService studentService;

    @PostMapping("saveStudent")
    public StudentDto createStudent(@RequestBody StudentDto studentDto) {
        return studentService.createStudent(studentDto);
    }

    @GetMapping("getStudent")
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        List<StudentDto> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @PutMapping("update/{id}")
    public StudentDto updateStudent(@PathVariable Integer id, @RequestBody StudentDto studentDto) {
        return studentService.updateStudent(id, studentDto);
    }

    @DeleteMapping("deletestudent/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return "Student with id " + id + " deleted successfully.";
    }
}



