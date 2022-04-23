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

    @CrossOrigin(origins="*")
    @PostMapping("/register")
    public ResponseEntity<?> addDentistShift(@RequestBody DentistShiftDTO dentistShiftDTO) {
        DentistShiftDTO dentistShiftCreated = iDentistShiftService.create(dentistShiftDTO);
        return new ResponseEntity<>(dentistShiftCreated, HttpStatus.OK);
    }

    @CrossOrigin(origins="*")
    @GetMapping("/{id}")
    public ResponseEntity<?> findDentistShift(@PathVariable Integer id) {
        DentistShiftDTO dentistShiftDTO = iDentistShiftService.findOne(id);
        return new ResponseEntity<>(dentistShiftDTO, HttpStatus.OK);
    }

    @CrossOrigin(origins="*")
    @GetMapping()
    public ResponseEntity<Collection<DentistShiftDTO>> findAllDentistShifts() {
        return ResponseEntity.ok(iDentistShiftService.findAll());
    }

    @CrossOrigin(origins="*")
    @PutMapping()
    public ResponseEntity<?> updateDentistShift(@RequestBody DentistShiftDTO dentistShiftDTO) {
        ResponseEntity<?> res;
        if (iDentistShiftService.findOne(dentistShiftDTO.getId()) == null) {
            res = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            DentistShiftDTO dentistShiftUpdated = iDentistShiftService.update(dentistShiftDTO);
            res = new ResponseEntity<>(dentistShiftUpdated, HttpStatus.OK);
        }
        return res;
    }

    @CrossOrigin(origins="*")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDentistShift(@PathVariable Integer id) {
        ResponseEntity<String> res;
        if (iDentistShiftService.findOne(id) == null) {
            res = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            iDentistShiftService.delete(id);
            res = new ResponseEntity<>("Turno eliminado con id: " + id, HttpStatus.OK);
        }
        return res;
    }
}
