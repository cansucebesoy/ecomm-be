package com.workintech.ecomm.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user", schema = "ecomm")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "first_name")
    //@NotBlank(message = "İlk isim boş olamaz")
    //@Size(min = 3, max=45, message = "İlk isim 3-45 arasında karakter içermelidir.")
    private String firstName;

    @Column(name = "last_name")
    //@NotBlank(message = "Soyisim boş olamaz")
    //@Size(min = 2, max=45, message = "Soyisim 2-45 arasında karakter içermelidir.")
    private String lastName;

    @Column(name = "email")
    //@NotBlank(message = "email boş olamaz")
    //@Size(min = 10, max=80, message = "email 10-80 arasında karakter içermelidir.")
    //@Email(message = "Mail formatı bozuk.")
    private String email;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy= "user")
    private List<Address> addressList;

    public void addAddress(Address address){
        if(addressList == null){
            addressList = new ArrayList<>();
        }
        addressList.add(address);
    }

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy= "user")
    private List<Wishlist> wishlist;

}

