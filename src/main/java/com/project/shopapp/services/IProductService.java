package com.project.shopapp.services;


import com.project.shopapp.dtos.ProductDTO;
import com.project.shopapp.exceptions.DataNotFoundException;
import com.project.shopapp.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IProductService {
    public Product createProduct(ProductDTO productDTO) throws DataNotFoundException;
    public Product getProductById(Long id);
    public void deleteProduct(Long id);
    public Product updateProduct(Long productId, ProductDTO productDTO) throws DataNotFoundException;
    public Page<Product> getAllProducts(PageRequest pageRequest);
    public boolean existsByName(String name);
}
