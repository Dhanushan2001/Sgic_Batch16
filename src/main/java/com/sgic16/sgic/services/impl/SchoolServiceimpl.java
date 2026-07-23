package com.sgic16.sgic.services.impl;


import com.sgic16.sgic.dto.SchoolDto;
import com.sgic16.sgic.entities.School;
import com.sgic16.sgic.mapper.SchoolMapper;
import com.sgic16.sgic.mapper.StudentMapper;
import com.sgic16.sgic.repositories.SchoolRepository;
import com.sgic16.sgic.repositories.StudentRepository;
import com.sgic16.sgic.services.SchoolService;
import org.springframework.stereotype.Service;

@Service
//@AllArgsConstructor
public class SchoolServiceimpl  implements SchoolService {
    private final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMappert;
    private final StudentMapper studentMapper;
    //private  final StudentRepository studentRepository;

    public SchoolServiceimpl(SchoolRepository schoolRepository, SchoolMapper schoolMappert, StudentRepository studentRepository, StudentMapper studentMapper){
        this.schoolRepository=schoolRepository;
        this.schoolMappert=schoolMappert;
        this.studentMapper = studentMapper;
    }

    @Override
    public SchoolDto createschool(SchoolDto schoolDto) {
        School school=schoolMappert.toEntity(schoolDto);
        School saveSchool=schoolRepository.save(school);
        return schoolMappert.toDto(saveSchool);
    }
}

//
//    @Autowired
//    private final SchoolRepository schoolRepository;
//
//    @Autowired
//    private StudentRepository studentRepository;
//
//    @Override
//    public SchoolDto createschool(SchoolDto schoolDto){
//        School school= SchoolMapper.toEntity(schoolDto);
//        School saveSchool=schoolRepository.save(school);
//        return SchoolMapper.toDto(saveSchool);
//    }
//
//    @Override
//    public void deleteschool(Integer id) {
//        School school = schoolRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
//        schoolRepository.delete(school);
//    }
//}
