package com.example.finalProject_backendI.controller;

import com.example.finalProject_backendI.DTO.DentistDTO;
import com.example.finalProject_backendI.DTO.PatientDTO;
import com.example.finalProject_backendI.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    IPatientService iPatientService;

    @PostMapping("/register")
    public ResponseEntity<?> addPatient(@RequestBody PatientDTO patientDTO) {
        iPatientService.createPatient(patientDTO);
        return new ResponseEntity<>("Se creó el paciente: " + patientDTO.getFirstName() + " " + patientDTO.getLastName(), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> findPatient(@PathVariable Integer id) {
        return ResponseEntity.ok(iPatientService.findOnePatient(id));
    }

    @GetMapping()
    public Collection<PatientDTO> findAllPatients() {
        return iPatientService.findAllPatients();
    }

    @PutMapping()
    public ResponseEntity<?> updatePatient(@RequestBody PatientDTO patientDTO) {
        ResponseEntity<String> res = null;
        if (iPatientService.findOnePatient(patientDTO.getId()) == null){
            res = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            iPatientService.updatePatient(patientDTO);
            res = new ResponseEntity<>("Se modificó el paciente con id: " + patientDTO.getId(), HttpStatus.OK);
        }
        return res;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Integer id) {
        ResponseEntity<String> res = null;
        if (iPatientService.findOnePatient(id) == null){
            res = new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        } else {
            iPatientService.deletePatient(id);
            res = new ResponseEntity<>("Paciente eliminado con id: " + id, HttpStatus.OK);
        }
        return res;
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<?> findPatientByEmail(@PathVariable String email) {
        return ResponseEntity.ok(iPatientService.findOnePatientByEmail(email));
    }
}
