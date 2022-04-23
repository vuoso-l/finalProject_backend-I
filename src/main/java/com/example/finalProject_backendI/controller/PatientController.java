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
        PatientDTO patientCreated = iPatientService.create(patientDTO);
        return new ResponseEntity<>(patientCreated, HttpStatus.OK);
    }

    @CrossOrigin(origins="*")
    @GetMapping("/id/{id}")
    public ResponseEntity<?> findPatient(@PathVariable Integer id) {
        PatientDTO patientDTO = iPatientService.findOne(id);
        return ResponseEntity.ok(patientDTO);
    }

    @CrossOrigin(origins="*")
    @GetMapping()
    public ResponseEntity<Collection<PatientDTO>> findAllPatients() {
        return ResponseEntity.ok(iPatientService.findAll());
    }

    @CrossOrigin(origins="*")
    @PutMapping()
    public ResponseEntity<?> updatePatient(@RequestBody PatientDTO patientDTO) {
        ResponseEntity<?> res;
        if (iPatientService.findOne(patientDTO.getId()) == null){
            res = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            PatientDTO patientUpdated = iPatientService.update(patientDTO);
            res = new ResponseEntity<>(patientUpdated, HttpStatus.OK);
        }
        return res;
    }

    @CrossOrigin(origins="*")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Integer id) {
        ResponseEntity<String> res;
        if (iPatientService.findOne(id) == null){
            res = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            iPatientService.delete(id);
            res = new ResponseEntity<>("Paciente eliminado con id: " + id, HttpStatus.OK);
        }
        return res;
    }

    @CrossOrigin(origins="*")
    @GetMapping("/email/{email}")
    public ResponseEntity<?> findPatientByEmail(@PathVariable String email) {
        PatientDTO patientDTO = iPatientService.findOnePatientByEmail(email);
        return ResponseEntity.ok(patientDTO);
    }
}
