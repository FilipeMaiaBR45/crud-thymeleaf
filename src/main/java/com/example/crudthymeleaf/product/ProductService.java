package com.example.crudthymeleaf.product;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {

    List<ProductModel> getAllProducts();

    Optional<ProductModel> getProdutcById(Long id);

    ProductModel addProduct(ProductModel product);

    ProductModel updateProduct(ProductModel product);

    void deleteProduct(Long id);

}
