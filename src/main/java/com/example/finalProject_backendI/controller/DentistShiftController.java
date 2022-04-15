package com.example.finalProject_backendI.controller;

import com.example.finalProject_backendI.DTO.DentistShiftDTO;
import com.example.finalProject_backendI.service.IDentistShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/dentistShift")
public class DentistShiftController {

    @Autowired
    IDentistShiftService iDentistShiftService;

    @PostMapping("/register")
    public ResponseEntity<?> addDentistShift(@RequestBody DentistShiftDTO dentistShiftDTO) {
        iDentistShiftService.create(dentistShiftDTO);
        return new ResponseEntity<>("Se creó el turno para el paciente con id : " + dentistShiftDTO.getPatient().getId(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findDentistShift(@PathVariable Integer id) {
        return ResponseEntity.ok(iDentistShiftService.findOne(id));
    }

    @GetMapping()
    public Collection<DentistShiftDTO> findAllDentistShifts() {
        return iDentistShiftService.findAll();
    }

    @PutMapping()
    public ResponseEntity<?> updateDentistShift(@RequestBody DentistShiftDTO dentistShiftDTO) {
        ResponseEntity<String> res = null;
        if (iDentistShiftService.findOne(dentistShiftDTO.getId()) == null) {
            res = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            iDentistShiftService.update(dentistShiftDTO);
            res = new ResponseEntity<>("Se modificó el turno con id: " + dentistShiftDTO.getId(), HttpStatus.OK);
        }
        return res;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDentistShift(@PathVariable Integer id) {
        ResponseEntity<String> res = null;
        if (iDentistShiftService.findOne(id) == null) {
            res = new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        } else {
            iDentistShiftService.delete(id);
            res = new ResponseEntity<>("Turno eliminado con id: " + id, HttpStatus.OK);
        }
        return res;
    }
}
