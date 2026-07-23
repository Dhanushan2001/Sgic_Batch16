package com.sgic16.sgic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class SchoolDto {
    private Integer id;
    private String name;
    private String location;
}
