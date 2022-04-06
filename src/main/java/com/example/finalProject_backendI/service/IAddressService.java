package com.example.finalProject_backendI.service;


import com.example.finalProject_backendI.DTO.AddressDTO;

import java.util.Collection;

public interface IAddressService {

    public void createAddress(AddressDTO addressDTO);

    public AddressDTO findOneAddress(Integer id);

    public void updateAddress(AddressDTO addressDTO);

    public void deleteAddress(Integer id);

    public Collection<AddressDTO> findAllAddresses();
}
