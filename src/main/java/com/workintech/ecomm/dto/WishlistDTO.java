package com.workintech.ecomm.dto;

import com.workintech.ecomm.entity.Product;
import com.workintech.ecomm.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WishlistDTO {
    private long userId;
    private long productId;
}
