package com.workintech.ecomm.mapper;

import com.workintech.ecomm.dto.WishlistDTO;
import com.workintech.ecomm.entity.Wishlist;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WishlistMapper {
    WishlistMapper INSTANCE = Mappers.getMapper(WishlistMapper.class);

    WishlistDTO wishlistToWishlistDTO(Wishlist wishlist);

    List<WishlistDTO> wishlistsDTOToWishlistDTOS(List<Wishlist> wishlists);

    Wishlist wishlistDTOToWishlist(WishlistDTO wishlistDTO);

    List<Wishlist> wishlistDTOSToWishlists(List<WishlistDTO> wishlistDTOS);
}
