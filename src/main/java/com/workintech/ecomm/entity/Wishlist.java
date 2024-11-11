package com.workintech.ecomm.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    @Table(name = "wishlist", schema = "ecomm")
    public class Wishlist {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @JsonBackReference
        @ManyToOne(cascade = {
                CascadeType.DETACH, CascadeType.MERGE,
                CascadeType.PERSIST, CascadeType.REFRESH
        })
        @JoinColumn(name="user_id")
        private User user;

        @JsonBackReference
        @ManyToOne(cascade = {
                CascadeType.DETACH, CascadeType.MERGE,
                CascadeType.PERSIST, CascadeType.REFRESH
        })
        @JoinColumn(name="product_id")
        private Product product;
    }

