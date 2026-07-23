
//package com.sgic16.sgic.services.impl;
//
//import com.sgic16.sgic.dto.StudentDto;
//import com.sgic16.sgic.entities.School;
//import com.sgic16.sgic.entities.Student;
//import com.sgic16.sgic.repositories.SchoolRepository;
//import com.sgic16.sgic.repositories.StudentRepository;
//import com.sgic16.sgic.services.StudentService;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@AllArgsConstructor
//public class StudentServiceImpl implements StudentService {
//
//    private final StudentRepository studentRepository;
//    private final SchoolRepository schoolRepository;
//
//    @Override
//    public StudentDto createStudent(StudentDto studentDto) {
//        School school = schoolRepository.findById(studentDto.getSchoolid())
//                .orElseThrow(() -> new RuntimeException("School not found"));
//
//        Student student = new Student();
//        student.setFirstname(studentDto.getFirstname());
//        student.setLastname(studentDto.getLastname());
//        student.setEmail(student.getEmail());
//        student.setAge(student.getAge());
//        student.setSchool(school);
//
//        Student saved = studentRepository.save(student);
//
//        return new StudentDto(saved.getId(), saved.getFirstname(),saved.getLastname(),saved.getEmail(),saved.getAge(), saved.getSchool().getId());
//    }
//
//    @Override
//    public List<StudentDto> getAllStudents() {
//        return studentRepository.findAll()
//                .stream()
//                .map(s -> new StudentDto(s.getId(), s.getFirstname(),s.getLastname(),s.getEmail(),s.getAge(), s.getSchool().getId()))
//                .collect(Collectors.toList());
//    }
//}

package com.sgic16.sgic.services.impl;
import com.sgic16.sgic.dto.StudentDto;
import com.sgic16.sgic.entities.School;
import com.sgic16.sgic.entities.Student;
import com.sgic16.sgic.mapper.StudentMapper;
import com.sgic16.sgic.repositories.SchoolRepository;
import com.sgic16.sgic.repositories.StudentRepository;
import com.sgic16.sgic.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
//@AllArgsConstructor
public  class StudentServiceimpl implements StudentService {
    @Autowired
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final SchoolRepository schoolRepository;

    public StudentServiceimpl(StudentRepository studentRepository, StudentMapper studentMapper, SchoolRepository schoolRepository) {
        this.studentMapper = studentMapper;
        this.studentRepository = studentRepository;
        this.schoolRepository = schoolRepository;
    }

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        // Convert DTO to entity
        Student student = studentMapper.toEntity(studentDto);

        // Fetch the School entity using school_id from DTO
        if (studentDto.getSchool_id() != null) {
            School school = schoolRepository.findById(studentDto.getSchool_id())
                    .orElseThrow(() -> new RuntimeException("School not found with id: " + studentDto.getSchool_id()));
            student.setSchool(school);
        }
        // Save student
        Student savedStudent = studentRepository.save(student);

        // Convert back to DTO
        return studentMapper.toDto(savedStudent);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        // Fetch all students from repository
        List<Student> students = studentRepository.findAll();

        // Convert entities to DTOs
        return students.stream()
                .map(studentMapper::toDto)
                .collect(Collectors.toList());
    }


//
//    @Override
//    public StudentDto updateStudent(Integer id, StudentDto studentDto) {
//        Student student = studentRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
//
//        student.setFirstname(studentDto.getFirstname());
//        student.setLastname(studentDto.getLastname());
//        student.setEmail(studentDto.getEmail());
//        student.setAge(studentDto.getAge());
//
//        Student updatedStudent = studentRepository.save(student);
//        return StudentMapper.toDto(updatedStudent);
//    }
//
    @Override
    public void deleteStudent(Integer id) {
        //find the student id and return to student
        Student student = studentRepository.findById(id)
                //if student isn't exist throw an exception
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        //if student is exist delete the student from DB
        studentRepository.delete(student);
    }



    @Override
    public StudentDto updateStudent(Integer id, StudentDto studentDto) {
        // Find existing student
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        // Update fields from DTO
        existingStudent.setFirstname(studentDto.getFirstname());
        existingStudent.setLastname(studentDto.getLastname());
        existingStudent.setEmail(studentDto.getEmail());
        existingStudent.setAge(studentDto.getAge());

        // Handle school relationship if provided
        if (studentDto.getSchool_id() != null) {
            School school = schoolRepository.findById(studentDto.getSchool_id())
                    .orElseThrow(() -> new RuntimeException("School not found with id: " + studentDto.getSchool_id()));
            existingStudent.setSchool(school);
        }

        // Save updated student
        Student updatedStudent = studentRepository.save(existingStudent);

        // Convert back to DTO
        return studentMapper.toDto(updatedStudent);
    }
}




