package com.example.finalProject_backendI.service;

import com.example.finalProject_backendI.DTO.DentistDTO;
import com.example.finalProject_backendI.DTO.PatientDTO;
import com.example.finalProject_backendI.entity.Dentist;
import com.example.finalProject_backendI.entity.Patient;
import com.example.finalProject_backendI.repository.IPatientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class PatientService implements IPatientService{

    @Autowired
    private IPatientRepository iPatientRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void createPatient(PatientDTO patientDTO) {
        savePatientDTO(patientDTO);
    }

    @Override
    public PatientDTO findOnePatient(Integer id) {
        PatientDTO patientDTO = null;
        Optional<Patient> patientOptional= iPatientRepository.findById(id);
        if (patientOptional.isPresent()){
            patientDTO = mapper.convertValue(patientOptional, PatientDTO.class);
        }
        return patientDTO;
    }

    @Override
    public void updatePatient(PatientDTO patientDTO) {
        savePatientDTO(patientDTO);
    }

    @Override
    public void deletePatient(Integer id) {
        iPatientRepository.deleteById(id);
    }

    @Override
    public Collection<PatientDTO> findAllPatients() {
        List<Patient> patientList= iPatientRepository.findAll();
        Set<PatientDTO> patientDTOS= new HashSet<>();
        for (Patient patient: patientList){
            patientDTOS.add(mapper.convertValue(patient, PatientDTO.class));
        }
        return patientDTOS;
    }

    @Override
    public Set<PatientDTO> findOnePatientByEmail(String email) {
        Set<Patient> patientSet = iPatientRepository.findOnePatientByEmail(email);
        Set<PatientDTO> patientDTOSet = new HashSet<PatientDTO>();
        for(Patient patient: patientSet)
            patientDTOSet.add(mapper.convertValue(patient,PatientDTO.class));

        return patientDTOSet;
    }

    public void savePatientDTO (PatientDTO patientDTO){
        Patient patient = mapper.convertValue(patientDTO, Patient.class);
        iPatientRepository.save(patient);
    }
}
