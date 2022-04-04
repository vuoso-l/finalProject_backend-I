package com.example.finalProject_backendI.dto;

import com.example.finalProject_backendI.entity.DentistShift;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class DentistDto {
    private Integer id;
    private String registrationNumber;
    private String firstName;
    private String lastName;
    private Set<DentistShift> dentistShifts;
}
