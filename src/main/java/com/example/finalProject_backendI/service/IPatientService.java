package com.example.finalProject_backendI.service;

import com.example.finalProject_backendI.DTO.PatientDTO;

public interface IPatientService extends IBasicCrudService<PatientDTO>{

    PatientDTO findOnePatientByEmail(String email);
}
