package com.workintech.ecomm.mapper;

import com.workintech.ecomm.dto.ProductDTO;
import com.workintech.ecomm.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTO productToProductDTO(Product product);

    List<ProductDTO> productListToProductDTOList(List<Product> productList);

    Product productDTOToProduct(ProductDTO productDTO);

    List<Product> productDTOListToProductList(List<ProductDTO> productDTOList);
}
