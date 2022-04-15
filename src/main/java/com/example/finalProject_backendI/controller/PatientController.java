package com.example.finalProject_backendI.controller;

import com.example.finalProject_backendI.DTO.PatientDTO;
import com.example.finalProject_backendI.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    IPatientService iPatientService;

    @CrossOrigin(origins="*")
    @PostMapping("/register")
    public ResponseEntity<?> addPatient(@RequestBody PatientDTO patientDTO) {
        iPatientService.create(patientDTO);
        return new ResponseEntity<>("Se creó el paciente: " + patientDTO.getFirstName() + " " + patientDTO.getLastName(), HttpStatus.OK);
    }

    @CrossOrigin(origins="*")
    @GetMapping("/id/{id}")
    public ResponseEntity<?> findPatient(@PathVariable Integer id) {
        return ResponseEntity.ok(iPatientService.findOne(id));
    }

    @CrossOrigin(origins="*")
    @GetMapping()
    public Collection<PatientDTO> findAllPatients() {
        return iPatientService.findAll();
    }

    @CrossOrigin(origins="*")
    @PutMapping()
    public ResponseEntity<?> updatePatient(@RequestBody PatientDTO patientDTO) {
        ResponseEntity<String> res = null;
        if (iPatientService.findOne(patientDTO.getId()) == null){
            res = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            iPatientService.update(patientDTO);
            res = new ResponseEntity<>("Se modificó el paciente con id: " + patientDTO.getId(), HttpStatus.OK);
        }
        return res;
    }

    @CrossOrigin(origins="*")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Integer id) {
        ResponseEntity<String> res = null;
        if (iPatientService.findOne(id) == null){
            res = new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        } else {
            iPatientService.delete(id);
            res = new ResponseEntity<>("Paciente eliminado con id: " + id, HttpStatus.OK);
        }
        return res;
    }

    @CrossOrigin(origins="*")
    @GetMapping("/email/{email}")
    public ResponseEntity<?> findPatientByEmail(@PathVariable String email) {
        return ResponseEntity.ok(iPatientService.findOnePatientByEmail(email));
    }
}
