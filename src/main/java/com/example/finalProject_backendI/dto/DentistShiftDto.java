package com.example.finalProject_backendI.dto;

import com.example.finalProject_backendI.entity.Dentist;
import com.example.finalProject_backendI.entity.Patient;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DentistShiftDto {
    private Integer id;
    private Date date;
    private Patient patient;
    private Dentist dentist;
}
