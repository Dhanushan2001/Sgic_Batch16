package com.sgic16.sgic.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class StudentDto {
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String age;

   private  Integer school_id;

}




