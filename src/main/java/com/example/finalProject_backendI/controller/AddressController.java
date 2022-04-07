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
    private IAddressService iAddressService;

    @PostMapping("/register")
    public ResponseEntity<?> addAddress(@RequestBody AddressDTO addressDTO) {
        iAddressService.createAddress(addressDTO);
        return new ResponseEntity<>("Se creó el domicilio: " + addressDTO.getStreet() + " " + addressDTO.getNumber(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findAddress(@PathVariable Integer id) {
        return ResponseEntity.ok(iAddressService.findOneAddress(id));
    }

    @GetMapping()
    public Collection<AddressDTO> findAllAddresses() {
        return iAddressService.findAllAddresses();
    }

    @PutMapping()
    public ResponseEntity<?> updateAddress(@RequestBody AddressDTO addressDTO) {
        ResponseEntity<String> res = null;
        if (iAddressService.findOneAddress(addressDTO.getId()) == null){
            res = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            iAddressService.updateAddress(addressDTO);
            res = new ResponseEntity<>("Se modificó el domicilio con id: " + addressDTO.getId(), HttpStatus.OK);
        }
        return res;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable Integer id) {
        ResponseEntity<String> res = null;
        if (iAddressService.findOneAddress(id) == null){
            res = new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        } else {
            iAddressService.deleteAddress(id);
            res = new ResponseEntity<>("Domicilio eliminado con id: " + id, HttpStatus.OK);
        }
        return res;
    }
}