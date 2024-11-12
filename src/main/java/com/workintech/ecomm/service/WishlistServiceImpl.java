package com.workintech.ecomm.service;

import com.workintech.ecomm.dto.ProductDTO;
import com.workintech.ecomm.dto.WishlistDTO;
import com.workintech.ecomm.entity.Product;
import com.workintech.ecomm.entity.User;
import com.workintech.ecomm.entity.Wishlist;
import com.workintech.ecomm.exceptions.EcommException;
import com.workintech.ecomm.mapper.ProductMapper;
import com.workintech.ecomm.mapper.WishlistMapper;
import com.workintech.ecomm.repository.WishlistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WishlistServiceImpl implements WishlistService{

    private final WishlistRepository wishlistRepository;
    private final UserService userService;
    private final ProductService productService;
    private final ProductMapper productMapper;

    @Override
    public List<ProductDTO> getWishlistProductsByUserId(long userId) {
        List<Wishlist> wishlists = wishlistRepository.findByUserId(userId);
        return wishlists.stream()
                .map(wishlist -> {
                    Product product = wishlist.getProduct();
                    return productMapper.productToProductDTO(product);
                })
                .collect(Collectors.toList());
    }

    @Override
    public void addProductToWishlist(WishlistDTO wishlistDTO) {
        User user = userService.getEntityById(wishlistDTO.getUserId());
        Product product = productService.getEntityById(wishlistDTO.getProductId());
        Wishlist wish = new Wishlist();
        wish.setProduct(product);
        wish.setUser(user);
        wishlistRepository.save(wish);
    }

    @Override
    public Wishlist removeProductFromWishlist(WishlistDTO wishlistDTO) {
        Wishlist wish =wishlistRepository.deleteByUserIdAndProductId(wishlistDTO.getUserId(), wishlistDTO.getProductId())
                .orElseThrow(() -> new EcommException("wishlist not found." + "user id: " + wishlistDTO.getUserId() + " ,product id: " +wishlistDTO.getProductId(), HttpStatus.NOT_FOUND));
        return wish;
    }

}
