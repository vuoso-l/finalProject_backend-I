package com.example.finalProject_backendI.service;

import com.example.finalProject_backendI.DTO.PatientDTO;
import com.example.finalProject_backendI.entity.Patient;
import com.example.finalProject_backendI.repository.IPatientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PatientService implements IPatientService{

    @Autowired
    private IPatientRepository iPatientRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void create(PatientDTO patientDTO) {
        savePatientDTO(patientDTO);
    }

    @Override
    public PatientDTO findOne(Integer id) {
        PatientDTO patientDTO = null;
        Optional<Patient> patientOptional= iPatientRepository.findById(id);
        if (patientOptional.isPresent()){
            patientDTO = mapper.convertValue(patientOptional, PatientDTO.class);
        }
        return patientDTO;
    }

    @Override
    public void update(PatientDTO patientDTO) {
        savePatientDTO(patientDTO);
    }

    @Override
    public void delete(Integer id) {
        iPatientRepository.deleteById(id);
    }

    @Override
    public Collection<PatientDTO> findAll() {
        List<Patient> patientList= iPatientRepository.findAll();
        Set<PatientDTO> patientDTOS= new HashSet<>();
        for (Patient patient: patientList){
            patientDTOS.add(mapper.convertValue(patient, PatientDTO.class));
        }
        return patientDTOS;
    }

    @Override
    public PatientDTO findOnePatientByEmail(String email) {
        PatientDTO patientDTO = null;
        Optional<Patient> patientOptional= iPatientRepository.findOnePatientByEmail(email);
        if (patientOptional.isPresent()){
            patientDTO = mapper.convertValue(patientOptional, PatientDTO.class);
        }
        return patientDTO;
    }

    public void savePatientDTO (PatientDTO patientDTO){
        Patient patient = mapper.convertValue(patientDTO, Patient.class);
        iPatientRepository.save(patient);
    }

    public Patient mapDto (PatientDTO patientDTO){
        Patient patient = mapper.convertValue(patientDTO, Patient.class);
        return patient;
    }
}
