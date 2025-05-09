package com.project.shopapp.services;


import com.project.shopapp.dtos.ProductDTO;
import com.project.shopapp.dtos.ProductImageDTO;
import com.project.shopapp.exceptions.DataNotFoundException;
import com.project.shopapp.models.Product;
import com.project.shopapp.models.ProductImage;
import com.project.shopapp.responses.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IProductService {
    public Product createProduct(ProductDTO productDTO) throws DataNotFoundException;
    public Product getProductById(Long id) throws DataNotFoundException;
    public void deleteProduct(Long id);
    public Product updateProduct(Long productId, ProductDTO productDTO) throws DataNotFoundException;
    public Page<ProductResponse> getAllProducts(PageRequest pageRequest);
    public boolean existsByName(String name);
    public ProductImage createProductImage(Long productId, ProductImageDTO productImageDTO) throws DataNotFoundException, Exception;
}
