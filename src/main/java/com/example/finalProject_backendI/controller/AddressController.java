package com.example.finalProject_backendI.controller;

import com.example.finalProject_backendI.DTO.AddressDTO;
import com.example.finalProject_backendI.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    IAddressService iAddressService;

    @CrossOrigin(origins="*")
    @PostMapping("/register")
    public ResponseEntity<?> addAddress(@RequestBody AddressDTO addressDTO) {
        AddressDTO addressCreated = iAddressService.create(addressDTO);
        return new ResponseEntity<>(addressCreated, HttpStatus.OK);
    }

    @CrossOrigin(origins="*")
    @GetMapping("/{id}")
    public ResponseEntity<?> findAddress(@PathVariable Integer id) {
        AddressDTO addressDTO = iAddressService.findOne(id);
        return new ResponseEntity<>(addressDTO, HttpStatus.OK);
    }

    @CrossOrigin(origins="*")
    @GetMapping()
    public ResponseEntity<Collection<AddressDTO>> findAllAddresses() {
        return ResponseEntity.ok(iAddressService.findAll());
    }

    @CrossOrigin(origins="*")
    @PutMapping()
    public ResponseEntity<?> updateAddress(@RequestBody AddressDTO addressDTO) {
        ResponseEntity<?> res;
        if (iAddressService.findOne(addressDTO.getId()) == null){
            res = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            AddressDTO addressUpdated = iAddressService.update(addressDTO);
            res = new ResponseEntity<>(addressUpdated, HttpStatus.OK);
        }
        return res;
    }

    @CrossOrigin(origins="*")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable Integer id) {
        ResponseEntity<String> res;
        if (iAddressService.findOne(id) == null){
            res = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            iAddressService.delete(id);
            res = new ResponseEntity<>("Domicilio eliminado con id: " + id, HttpStatus.OK);
        }
        return res;
    }
}
