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

    @PostMapping("/register")
    public ResponseEntity<?> addDentist(@RequestBody DentistDTO dentistDTO) {
        iDentistService.createDentist(dentistDTO);
        return new ResponseEntity<>("Se creó el odontólogo: " + dentistDTO.getFirstName() + " " + dentistDTO.getLastName(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findDentist(@PathVariable Integer id) {
        return ResponseEntity.ok(iDentistService.findOneDentist(id));
    }

    @GetMapping()
    public Collection<DentistDTO> findAllDentists() {
        return iDentistService.findAllDentists();
    }

    @PutMapping()
    public ResponseEntity<?> updateDentist(@RequestBody DentistDTO dentistDTO) {
        ResponseEntity<String> res = null;
        if (iDentistService.findOneDentist(dentistDTO.getId()) == null){
            res = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            iDentistService.updateDentist(dentistDTO);
            res = new ResponseEntity<>("Se modificó el odontólogo con id: " + dentistDTO.getId(), HttpStatus.OK);
        }
        return res;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDentist(@PathVariable Integer id) {
        ResponseEntity<String> res = null;
        if (iDentistService.findOneDentist(id) == null){
            res = new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        } else {
            iDentistService.deleteDentist(id);
            res = new ResponseEntity<>("Odontólogo eliminado con id: " + id, HttpStatus.OK);
        }
        return res;
    }
}
