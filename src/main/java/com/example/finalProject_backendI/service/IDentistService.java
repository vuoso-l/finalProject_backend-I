package com.example.finalProject_backendI.service;

import com.example.finalProject_backendI.DTO.DentistDTO;
import com.example.finalProject_backendI.entity.Dentist;

import java.util.Set;

public interface IDentistService {
    public void createDentist(Dentist dentistDTO);

    public DentistDTO readDentist(Integer id);

    public void updateDentist(DentistDTO dentistDTO);

    public void deleteDentist(Integer id);

    public Set<DentistDTO> getAll();
}
