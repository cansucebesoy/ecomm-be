package com.workintech.ecomm.repository;

import com.workintech.ecomm.dto.WishlistDTO;
import com.workintech.ecomm.entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {

    List<Wishlist> findByUserId(long userId);;
    Optional<Wishlist> deleteByUserIdAndProductId(long userId, long productId);


}
