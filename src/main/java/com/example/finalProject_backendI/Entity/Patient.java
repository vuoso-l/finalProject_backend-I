package com.example.finalProject_backendI.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lastName;
    private String firstName;
    private String email;
    private String dni;
    private Date admissionDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_address", referencedColumnName = "id")
    private Address address;

    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private Set<DentistShift> dentistShifts;
}
