package com.workintech.ecomm.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product", schema = "ecomm")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    @NotBlank(message = "title boş olamaz")
    @Size(min = 3, max=255, message = "title 2 - 255 arasında karakter içermelidir.")
    private String title;

    @Column(name = "description")
    @NotBlank(message = "description boş olamaz")
    @Size(min = 3, max=255, message = "description 2 - 255 arasında karakter içermelidir.")
    private String description;

    @Column(name = "price")
    @NotNull(message = "price boş olamaz")
    @DecimalMin(value = "0.0", inclusive = false, message = "price 0'dan büyük olmalıdır.")
    private Double price;

    @Column(name = "rating")
    @NotNull(message = "rating boş olamaz")
    @DecimalMin(value = "0.0", message = "rating 0 veya daha büyük olmalıdır.")
    @DecimalMax(value = "5.0", message = "rating 5 veya daha küçük olmalıdır.")
    private Double rating;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy= "product")
    private List<Wishlist> wishlist;

    @JsonBackReference
    @ManyToOne(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinColumn(name="category_id")
    private Category category;

}
