package com.workintech.ecomm.service;

import com.workintech.ecomm.dto.ProductDTO;
import com.workintech.ecomm.dto.WishlistDTO;
import com.workintech.ecomm.entity.Product;
import com.workintech.ecomm.entity.Wishlist;

import java.util.List;
import java.util.Optional;

public interface WishlistService {

    List<ProductDTO> getWishlistProductsByUserId(long userId);

    void addProductToWishlist(WishlistDTO wishlistDTO);

    Wishlist removeProductFromWishlist(WishlistDTO wishlistDTO);

}
