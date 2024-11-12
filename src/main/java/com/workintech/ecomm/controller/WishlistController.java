package com.workintech.ecomm.controller;

import com.workintech.ecomm.dto.ProductDTO;
import com.workintech.ecomm.dto.WishlistDTO;
import com.workintech.ecomm.service.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wishlist")
@RequiredArgsConstructor
public class WishlistController {
    private final WishlistService wishlistService;

    @GetMapping("{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDTO> getWishlistProductsByUserId(@PathVariable long userId){
        return wishlistService.getWishlistProductsByUserId(userId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addProductToWishList(@RequestBody WishlistDTO wishlistDTO){
        wishlistService.addProductToWishlist(wishlistDTO);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void removeProductFromWishlist(@RequestBody WishlistDTO wishlistDTO){
        wishlistService.removeProductFromWishlist(wishlistDTO);
    }
}
