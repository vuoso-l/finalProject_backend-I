package com.example.finalProject_backendI.service;

import com.example.finalProject_backendI.DTO.DentistDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DentistServiceTest {

    @Autowired
    IDentistService iDentistService;

    DentistDTO dent1 = new DentistDTO();
    DentistDTO readDentist;
    Collection <DentistDTO> readAll;

    @BeforeEach
    void setUp() {
        dent1.setRegistrationNumber("123456");
        dent1.setFirstName("Lucas");
        dent1.setLastName("Prueba-1");
    }

    @Test
    void create() {
        iDentistService.create(dent1);
        //readDentist = iDentistService.findOne(dent1.getId());
        readDentist = iDentistService.findOne(53);
        assertNotNull(readDentist);
    }

    @Test
    void update() {
        iDentistService.create(dent1);
        DentistDTO updateDentist = new DentistDTO();
        updateDentist.setId(67);
        updateDentist.setRegistrationNumber("159321");
        updateDentist.setFirstName("update");
        updateDentist.setLastName("Prueba-1");
        iDentistService.update(updateDentist);
        assertEquals(iDentistService.findOne(67).getFirstName(), "update");
    }

    @Test
    void delete() {
        /*//iDentistService.delete(dent1.getId());
        iDentistService.delete(46);
        readDentist = iDentistService.findOne(46);
        assertNull(readDentist);*/
    }

    @Test
    void findAll() {
        /*readAll = iDentistService.findAll();
        Set<DentistDTO> dentistsDTO = new HashSet<>(readAll);
        assertFalse(dentistsDTO.isEmpty());*/
    }
}