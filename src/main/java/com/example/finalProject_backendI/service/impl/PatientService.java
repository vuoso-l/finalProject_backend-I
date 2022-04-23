package com.example.finalProject_backendI.service.impl;

import com.example.finalProject_backendI.DTO.PatientDTO;
import com.example.finalProject_backendI.entity.Patient;
import com.example.finalProject_backendI.repository.IPatientRepository;
import com.example.finalProject_backendI.service.IPatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PatientService implements IPatientService {

    @Autowired
    IPatientRepository iPatientRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public PatientDTO create(PatientDTO patientDTO) {
        Patient patient = mapEntity(patientDTO);
        return mapDTO(iPatientRepository.save(patient));
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
    public PatientDTO update(PatientDTO patientDTO) {
        Patient patient = mapEntity(patientDTO);
        return mapDTO(iPatientRepository.save(patient));
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

    private PatientDTO mapDTO(Patient patient){
        return mapper.convertValue(patient, PatientDTO.class);
    }

    public Patient mapEntity(PatientDTO patientDTO){
        return mapper.convertValue(patientDTO, Patient.class);
    }
}
