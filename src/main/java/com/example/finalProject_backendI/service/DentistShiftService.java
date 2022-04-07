package com.example.finalProject_backendI.service;

import com.example.finalProject_backendI.DTO.DentistShiftDTO;
import com.example.finalProject_backendI.entity.DentistShift;
import com.example.finalProject_backendI.repository.IDentistShiftRepository;
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
    public void create(DentistShiftDTO dentistShiftDTO) {
        saveDentistShiftDTO(dentistShiftDTO);
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
    public void update(DentistShiftDTO dentistShiftDTO) {
        saveDentistShiftDTO(dentistShiftDTO);
    }

    @Override
    public void delete(Integer id) {
        iDentistShiftRepository.deleteById(id);
    }

    public void saveDentistShiftDTO (DentistShiftDTO dentistShiftDTO){
        DentistShift dentistShift = mapper.convertValue(dentistShiftDTO, DentistShift.class);
        iDentistShiftRepository.save(dentistShift);
    }
}
