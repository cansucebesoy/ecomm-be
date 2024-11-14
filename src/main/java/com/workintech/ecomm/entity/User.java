package com.workintech.ecomm.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user", schema = "ecomm")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "first_name")
    @NotBlank(message = "İlk isim boş olamaz")
    @Size(min = 3, max=45, message = "İlk isim 3-45 arasında karakter içermelidir.")
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "Soyisim boş olamaz")
    @Size(min = 2, max=45, message = "Soyisim 2-45 arasında karakter içermelidir.")
    private String lastName;

    @Column(name = "email")
    @NotBlank(message = "email boş olamaz")
    @Size(min = 10, max=80, message = "email 10-80 arasında karakter içermelidir.")
    @Email(message = "Mail formatı bozuk.")
    private String email;

    @Column(name = "password")
    @NotBlank(message = "password boş olamaz")
    @Size(min = 3, max=255, message = "password 2 - 255 arasında karakter içermelidir.")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="user_role", schema="ecomm",
    joinColumns = @JoinColumn(name="user_id"),
    inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<Role> authorities = new HashSet<>();

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

