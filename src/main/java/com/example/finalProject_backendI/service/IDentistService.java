package com.example.finalProject_backendI.service;

import com.example.finalProject_backendI.DTO.DentistDTO;

import java.util.Collection;

public interface IDentistService {
    public void createDentist(DentistDTO dentistDTO);

    public DentistDTO findOneDentist(Integer id);

    public void updateDentist(DentistDTO dentistDTO);

    public void deleteDentist(Integer id);

    public Collection<DentistDTO> findAllDentists();
}
