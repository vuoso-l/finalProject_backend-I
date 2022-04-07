package com.example.finalProject_backendI.service;

import com.example.finalProject_backendI.DTO.AddressDTO;
import com.example.finalProject_backendI.DTO.DentistDTO;
import com.example.finalProject_backendI.entity.Address;
import com.example.finalProject_backendI.entity.Dentist;
import com.example.finalProject_backendI.repository.IAddressRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AddressService implements IAddressService{

    @Autowired
    private IAddressRepository iAddressRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void createAddress(AddressDTO addressDTO) {
        saveAddressDTO(addressDTO);
    }

    @Override
    public AddressDTO findOneAddress(Integer id) {
        AddressDTO addressDTO = null;
        Optional<Address> addressOptional= iAddressRepository.findById(id);
        if (addressOptional.isPresent()){
            addressDTO = mapper.convertValue(addressOptional, AddressDTO.class);
        }
        return addressDTO;
    }

    @Override
    public void updateAddress(AddressDTO addressDTO) {
        saveAddressDTO(addressDTO);
    }

    @Override
    public void deleteAddress(Integer id) {
        iAddressRepository.deleteById(id);
    }

    @Override
    public Collection<AddressDTO> findAllAddresses() {
        List<Address> addressList= iAddressRepository.findAll();
        Set<AddressDTO> addressesDTO= new HashSet<>();
        for (Address address: addressList){
            addressesDTO.add(mapper.convertValue(address, AddressDTO.class));
        }
        return addressesDTO;
    }

    public void saveAddressDTO (AddressDTO addressDTO){
        Address address = mapper.convertValue(addressDTO, Address.class);
        iAddressRepository.save(address);
    }
}
