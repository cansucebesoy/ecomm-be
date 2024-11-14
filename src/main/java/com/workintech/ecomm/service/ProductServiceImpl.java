package com.workintech.ecomm.service;

import com.workintech.ecomm.dto.ProductDTO;
import com.workintech.ecomm.entity.Category;
import com.workintech.ecomm.entity.Product;
import com.workintech.ecomm.exceptions.EcommException;
import com.workintech.ecomm.mapper.ProductMapper;
import com.workintech.ecomm.repository.CategoryRepository;
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
    private final CategoryRepository categoryRepository;

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        Category productCategory = categoryRepository.getReferenceById(productDTO.getCategoryId());
        Product product = new Product();
        product.setTitle(productDTO.getTitle());
        product.setRating(productDTO.getRating());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setCategory(productCategory);

        product = productRepository.save(product);
        return productMapper.productToProductDTO(product);
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
        Product product = productRepository.findById(productDTO.getId())
                .orElseThrow(() -> new EcommException("Product with given id does not exist", HttpStatus.NOT_FOUND));
        product.setTitle(productDTO.getTitle() == null ? product.getTitle() : productDTO.getTitle());
        product.setRating(productDTO.getRating() == null ? product.getRating() : productDTO.getRating());
        product.setPrice(productDTO.getPrice() == null ? product.getPrice() : productDTO.getPrice());
        product.setDescription(productDTO.getDescription() == null ? product.getDescription() : productDTO.getDescription());
        if(productDTO.getCategoryId() != null) {
            Category productCategory = categoryRepository.getReferenceById(productDTO.getCategoryId());
            product.setCategory(productCategory);
        }

        product = productRepository.save(product);
        return productMapper.productToProductDTO(product);    }

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
