package com.example.finalProject_backendI.dto;

import com.example.finalProject_backendI.entity.Address;
import com.example.finalProject_backendI.entity.DentistShift;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
public class PatientDto {
    private Integer id;
    private String lastName;
    private String firstName;
    private String email;
    private String dni;
    private Date admissionDate;
    private Address address;
    private Set<DentistShift> dentistShifts;
}
