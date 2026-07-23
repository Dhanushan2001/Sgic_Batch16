package com.sgic16.sgic.mapper;

import com.sgic16.sgic.dto.SchoolDto;
import com.sgic16.sgic.entities.School;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface SchoolMapper {
   @Mapping(source = "id",target = "id")
   @Mapping(source = "name",target="name")
   @Mapping(source="location",target="location")
   SchoolDto toDto(School school);

   @Mapping(source="id",target="id")
   @Mapping(source="name",target = "name")
   @Mapping(source="location",target="location")
   School toEntity(SchoolDto schoolDto);

}


//    public static SchoolDto toDto(School school){
//        return  new SchoolDto(
//                school.getId(),
//                school.getName(),
//                school.getLocation()
//        );
//    }
//
//    public static  School toEntity(SchoolDto schoolDto){
//            School school=new School();
//            school.setId(schoolDto.getId());
//            school.setName(schoolDto.getName());
//            school.setLocation(schoolDto.getLocation());
//            return school;
//  }

