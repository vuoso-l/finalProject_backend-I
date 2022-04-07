package com.example.finalProject_backendI.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "dentists")
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String registrationNumber;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "dentist")
    @JsonIgnore
    private Set<DentistShift> dentistShifts;
}
