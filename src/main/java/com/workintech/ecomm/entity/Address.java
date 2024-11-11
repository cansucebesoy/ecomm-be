package com.workintech.ecomm.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "address", schema = "ecomm")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    //@NotBlank(message = "Sokak numarasi boş olamaz")
    //@Size(min = 2, max=45, message = "Sokak numarasi 3-45 arasında karakter içermelidir.")
    @Column(name = "street_number")
    private String streetNumber;

    //@NotBlank(message = "Mahalle boş olamaz")
    //@Size(min = 3, max=45, message = "Mahalle 3-45 arasında karakter içermelidir.")
    @Column(name = "neighborhood")
    private String neighborhood;

    //@NotBlank(message = "Apartman numarasi")
    //@Size(min = 1, max=45, message = "Apartman numarasi 3-45 arasında karakter içermelidir.")
    @Column(name = "apartment_number")
    private String apartmentNumber;

    @Column(name = "description")
    private String description;

    //@NotBlank(message = "Sehir")
    //@Size(min = 3, max=45, message = "Sehir 3-45 arasında karakter içermelidir.")
    @Column(name = "city")
    private String city;

    @JsonBackReference
    @ManyToOne(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinColumn(name="user_id")
    private User user;

}
