package com.workintech.ecomm.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

    long id;
    String streetNumber;
    String neighborhood;
    String apartmentNumber;
    String description;
    String city;
}