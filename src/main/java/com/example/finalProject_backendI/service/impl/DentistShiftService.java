package com.example.finalProject_backendI.service.impl;

import com.example.finalProject_backendI.DTO.DentistDTO;
import com.example.finalProject_backendI.DTO.DentistShiftDTO;
import com.example.finalProject_backendI.entity.Address;
import com.example.finalProject_backendI.entity.Dentist;
import com.example.finalProject_backendI.entity.DentistShift;
import com.example.finalProject_backendI.repository.IDentistShiftRepository;
import com.example.finalProject_backendI.service.IDentistShiftService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DentistShiftService implements IDentistShiftService {

    @Autowired
    IDentistShiftRepository iDentistShiftRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public DentistShiftDTO create(DentistShiftDTO dentistShiftDTO) {
        DentistShift dentistShift = mapEntity(dentistShiftDTO);
        return mapDTO(iDentistShiftRepository.save(dentistShift));
    }

    @Override
    public DentistShiftDTO findOne(Integer id) {
        DentistShiftDTO dentistShiftDTO = null;
        Optional<DentistShift> dentistShiftOptional= iDentistShiftRepository.findById(id);
        if (dentistShiftOptional.isPresent()){
            dentistShiftDTO = mapper.convertValue(dentistShiftOptional, DentistShiftDTO.class);
        }
        return dentistShiftDTO;
    }

    @Override
    public Collection<DentistShiftDTO> findAll() {
        List<DentistShift> dentistShiftList= iDentistShiftRepository.findAll();
        Set<DentistShiftDTO> dentistShiftDTOS= new HashSet<>();
        for (DentistShift dentistShift: dentistShiftList){
            dentistShiftDTOS.add(mapper.convertValue(dentistShift, DentistShiftDTO.class));
        }
        return dentistShiftDTOS;
    }

    @Override
    public DentistShiftDTO update(DentistShiftDTO dentistShiftDTO) {
        DentistShift dentistShift = mapEntity(dentistShiftDTO);
        return mapDTO(iDentistShiftRepository.save(dentistShift));
    }

    @Override
    public void delete(Integer id) {
        iDentistShiftRepository.deleteById(id);
    }

    private DentistShiftDTO mapDTO(DentistShift dentistShift){
        DentistShiftDTO dentistShiftDTO = mapper.convertValue(dentistShift, DentistShiftDTO.class);
        return dentistShiftDTO;
    }

    public DentistShift mapEntity(DentistShiftDTO dentistShiftDTO){
        DentistShift dentistShift = mapper.convertValue(dentistShiftDTO, DentistShift.class);
        return dentistShift;
    }
}
