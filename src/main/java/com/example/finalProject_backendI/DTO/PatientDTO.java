package com.example.finalProject_backendI.DTO;

import com.example.finalProject_backendI.entity.Address;
import com.example.finalProject_backendI.entity.DentistShift;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class PatientDTO {
    private Integer id;
    private String lastName;
    private String firstName;
    private String email;
    private String dni;
    private LocalDate admissionDate;
    private Address address;
    private Set<DentistShift> dentistShifts;
}
