package com.sgic16.sgic.controllers;

import com.sgic16.sgic.dto.SchoolDto;
import com.sgic16.sgic.services.SchoolService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/api/school")
public class SchoolController {
    private final SchoolService schoolService;

    @PostMapping()
    public SchoolDto saveSchool(@RequestBody SchoolDto schoolDto){
        return schoolService.createschool(schoolDto);
    }

//    @DeleteMapping("/{id}")
//    public String deletechool(@PathVariable Integer id){
//        schoolService.deleteschool(id);
//        return "School id is "+id+ " Delete successfully";
//    }


}
