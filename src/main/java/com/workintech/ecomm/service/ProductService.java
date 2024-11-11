package com.workintech.ecomm.service;

import com.workintech.ecomm.dto.ProductDTO;
import com.workintech.ecomm.entity.Product;

import java.util.List;

public interface ProductService {
    ProductDTO getById(long id);
    ProductDTO save(ProductDTO productDTO);
    ProductDTO delete(long id);
    ProductDTO update(ProductDTO productDTO);
    Product getEntityById(long id);

    List<ProductDTO> getByCategoryId(long categoryId);


}
