package com.example.finalProject_backendI.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {
    private Integer id;
    private String street;
    private String locality;
    private int number;
    private String province;
}
