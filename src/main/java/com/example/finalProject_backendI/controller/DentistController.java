package com.example.finalProject_backendI.controller;

import com.example.finalProject_backendI.DTO.DentistDTO;
import com.example.finalProject_backendI.service.IDentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/dentist")
public class DentistController {

    @Autowired
    IDentistService iDentistService;

    @CrossOrigin(origins="*")
    @PostMapping("/register")
    public ResponseEntity<?> addDentist(@RequestBody DentistDTO dentistDTO) {
        DentistDTO dentistCreated = iDentistService.create(dentistDTO);
        return new ResponseEntity<>(dentistCreated, HttpStatus.OK);
    }

    @CrossOrigin(origins="*")
    @GetMapping("/{id}")
    public ResponseEntity<?> findDentist(@PathVariable Integer id) {
        DentistDTO dentistDTO = iDentistService.findOne(id);
        return new ResponseEntity<>(dentistDTO, HttpStatus.OK);
    }

    @CrossOrigin(origins="*")
    @GetMapping()
    public ResponseEntity<Collection<DentistDTO>> findAllDentists() {
        return ResponseEntity.ok(iDentistService.findAll());
    }

    @CrossOrigin(origins="*")
    @PutMapping()
    public ResponseEntity<?> updateDentist(@RequestBody DentistDTO dentistDTO) {
        ResponseEntity<?> res;
        if (iDentistService.findOne(dentistDTO.getId()) == null){
            res = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            DentistDTO dentistUpdated = iDentistService.update(dentistDTO);
            res = new ResponseEntity<>(dentistUpdated, HttpStatus.OK);
        }
        return res;
    }

    @CrossOrigin(origins="*")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDentist(@PathVariable Integer id) {
        ResponseEntity<String> res;
        if (iDentistService.findOne(id) == null){
            res = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            iDentistService.delete(id);
            res = new ResponseEntity<>("Odontólogo eliminado con id: " + id, HttpStatus.OK);
        }
        return res;
    }
}
