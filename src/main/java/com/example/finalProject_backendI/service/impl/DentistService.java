package com.example.finalProject_backendI.service.impl;

import com.example.finalProject_backendI.DTO.DentistDTO;
import com.example.finalProject_backendI.entity.Dentist;
import com.example.finalProject_backendI.repository.IDentistRepository;
import com.example.finalProject_backendI.service.IDentistService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DentistService implements IDentistService {

    @Autowired
    IDentistRepository iDentistRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public DentistDTO create(DentistDTO dentistDTO) {
        Dentist dent = mapEntity(dentistDTO);
        return mapDTO(iDentistRepository.save(dent));
    }

    @Override
    public DentistDTO findOne(Integer id) {
        DentistDTO dentistDTO = null;
        Optional<Dentist> dentistOptional= iDentistRepository.findById(id);
        if (dentistOptional.isPresent()){
            dentistDTO = mapper.convertValue(dentistOptional, DentistDTO.class);
        }
        return dentistDTO;
    }

    @Override
    public DentistDTO update(DentistDTO dentistDTO) {
        Dentist dent = mapEntity(dentistDTO);
        return mapDTO(iDentistRepository.save(dent));
    }

    @Override
    public void delete(Integer id) {
        iDentistRepository.deleteById(id);
    }

    @Override
    public Collection<DentistDTO> findAll() {
        List<Dentist> dentistList= iDentistRepository.findAll();
        Set<DentistDTO> dentistsDTO= new HashSet<>();
        for (Dentist dentist: dentistList){
            dentistsDTO.add(mapper.convertValue(dentist, DentistDTO.class));
        }
        return dentistsDTO;
    }

    private DentistDTO mapDTO(Dentist dentist){
        return mapper.convertValue(dentist, DentistDTO.class);
    }

    public Dentist mapEntity(DentistDTO dentistDTO){
        return mapper.convertValue(dentistDTO, Dentist.class);
    }
}
