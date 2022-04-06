package com.example.finalProject_backendI.service;

import com.example.finalProject_backendI.DTO.PatientDTO;

import java.util.Collection;
import java.util.Set;

public interface IPatientService {
    public void createPatient(PatientDTO patientDTO);

    public PatientDTO findOnePatient(Integer id);

    public void updatePatient(PatientDTO patientDTO);

    public void deletePatient(Integer id);

    public Collection<PatientDTO> findAllPatients();

    Set<PatientDTO> findOnePatientByEmail(String email);
}
