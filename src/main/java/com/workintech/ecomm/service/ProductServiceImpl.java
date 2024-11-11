package com.workintech.ecomm.service;

import com.workintech.ecomm.dto.ProductDTO;
import com.workintech.ecomm.entity.Product;
import com.workintech.ecomm.exceptions.EcommException;
import com.workintech.ecomm.mapper.ProductMapper;
import com.workintech.ecomm.repository.ProductRepository;
import com.workintech.ecomm.util.GenericUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        return GenericUtil.saveEntity(productDTO, productMapper::productDTOToProduct, productMapper::productToProductDTO, productRepository);
    }

    @Override
    public ProductDTO getById(long id) {
        Product product = getEntityById(id);
        return productMapper.productToProductDTO(product);
    }

    @Override
    public ProductDTO delete(long id) {
        Product product = productRepository.deleteById(id);
        return productMapper.productToProductDTO(product);
    }

    @Override
    public ProductDTO update(ProductDTO productDTO) {
        return GenericUtil.saveEntity(productDTO, productMapper::productDTOToProduct, productMapper::productToProductDTO, productRepository);
    }

    @Override
    public Product getEntityById(long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new EcommException("Product with given id does not exist: " + id, HttpStatus.NOT_FOUND));
    }

    @Override
    public List<ProductDTO> getByCategoryId(long categoryId) {
        List<Product> productList = productRepository.getByCategoryId(categoryId);
        return productMapper.productListToProductDTOList(productList);
    }
}
