package com.sgic16.sgic.mapper;

import com.sgic16.sgic.dto.StudentDto;
import com.sgic16.sgic.entities.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface StudentMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "firstname", target = "firstname")
    @Mapping(source = "lastname", target = "lastname")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "school.id", target = "school_id")
    StudentDto toDto(Student student);


    @Mapping(source = "id", target = "id")
    @Mapping(source = "firstname", target = "firstname")
    @Mapping(source = "lastname", target = "lastname")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "email", target = "email")
    Student toEntity(StudentDto studentDto);

}





//    public static StudentDto toDto(Student student) {
//        return new StudentDto(
//                student.getId(),
//                student.getFirstname(),
//                student.getLastname(),
//                student.getEmail(),
//                student.getAge()
//        );
//    }
//
//    public static Student toEntity(StudentDto dto) {
//        Student student = new Student();
//        student.setId(dto.getId());
//        student.setFirstname(dto.getFirstname());
//        student.setLastname(dto.getLastname());
//        student.setEmail(dto.getEmail());
//        student.setAge(dto.getAge());
//        return student;
//    }

