package com.example.finalProject_backendI.service;

import com.example.finalProject_backendI.DTO.PatientDTO;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;

public interface IPatientService {
    public void createPatient(PatientDTO patientDTO);

    public PatientDTO findOnePatient(Integer id);

    public void updatePatient(PatientDTO patientDTO);

    public void deletePatient(Integer id);

    public Collection<PatientDTO> findAllPatients();

    public PatientDTO findOnePatientByEmail(String email);
}
