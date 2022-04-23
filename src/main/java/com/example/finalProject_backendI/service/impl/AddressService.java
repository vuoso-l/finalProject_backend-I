package com.example.finalProject_backendI.service.impl;

import com.example.finalProject_backendI.DTO.AddressDTO;
import com.example.finalProject_backendI.entity.Address;
import com.example.finalProject_backendI.repository.IAddressRepository;
import com.example.finalProject_backendI.service.IAddressService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AddressService implements IAddressService {

    @Autowired
    IAddressRepository iAddressRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public AddressDTO create(AddressDTO addressDTO) {
        Address address = mapEntity(addressDTO);
        return mapDTO(iAddressRepository.save(address));
    }

    @Override
    public AddressDTO findOne(Integer id) {
        AddressDTO addressDTO = null;
        Optional<Address> addressOptional= iAddressRepository.findById(id);
        if (addressOptional.isPresent()){
            addressDTO = mapper.convertValue(addressOptional, AddressDTO.class);
        }
        return addressDTO;
    }

    @Override
    public AddressDTO update(AddressDTO addressDTO) {
        Address address = mapEntity(addressDTO);
        return mapDTO(iAddressRepository.save(address));
    }

    @Override
    public void delete(Integer id) {
        iAddressRepository.deleteById(id);
    }

    @Override
    public Collection<AddressDTO> findAll() {
        List<Address> addressList= iAddressRepository.findAll();
        Set<AddressDTO> addressesDTO= new HashSet<>();
        for (Address address: addressList){
            addressesDTO.add(mapper.convertValue(address, AddressDTO.class));
        }
        return addressesDTO;
    }

    private AddressDTO mapDTO(Address address){
        return mapper.convertValue(address, AddressDTO.class);
    }

    public Address mapEntity(AddressDTO addressDTO){
        return mapper.convertValue(addressDTO, Address.class);
    }
}
