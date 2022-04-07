package com.example.finalProject_backendI.DTO;

import com.example.finalProject_backendI.entity.Dentist;
import com.example.finalProject_backendI.entity.Patient;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DentistShiftDTO {
    private Integer id;
    private LocalDate date;
    private Patient patient;
    private Dentist dentist;
}
