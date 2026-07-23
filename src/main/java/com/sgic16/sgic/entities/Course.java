package com.sgic16.sgic.entities;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.grammars.hql.HqlParser;

import java.util.List;

@Entity
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String name;
    private Integer c_redit;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;


}