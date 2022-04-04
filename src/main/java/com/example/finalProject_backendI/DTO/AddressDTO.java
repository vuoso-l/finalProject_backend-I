package com.example.finalProject_backendI.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {
    private Integer id;
    private String street;
    private String locality;
    private int number;
    private String province;
}
