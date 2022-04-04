package com.example.finalProject_backendI.DTO;

import com.example.finalProject_backendI.entity.DentistShift;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class DentistDTO {
    private Integer id;
    private String registrationNumber;
    private String firstName;
    private String lastName;
    private Set<DentistShift> dentistShifts;
}
