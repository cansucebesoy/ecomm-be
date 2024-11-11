package com.workintech.ecomm.repository;

import com.workintech.ecomm.dto.ProductDTO;
import com.workintech.ecomm.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
  Product deleteById(long id);

  List<Product> getByCategoryId(long categoryId);
}
