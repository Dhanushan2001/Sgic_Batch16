package com.sgic16.sgic.entities;


import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String st_index;


    @OneToOne
    @JoinColumn(name = "Student_id")
    private Student student;


}
