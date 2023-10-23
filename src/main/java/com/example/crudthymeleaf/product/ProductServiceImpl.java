package com.example.crudthymeleaf.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public List<ProductModel> getAllProducts() {
        return  this.productRepository.findAll();
    }

    @Override
    public Optional<ProductModel> getProdutcById(Long id) {
        return this.productRepository.findById(id);
    }

    @Override
    public ProductModel addProduct(ProductModel product) {
        return this.productRepository.save(product);
    }

    @Override
    public ProductModel updateProduct(ProductModel product) {
        return this.productRepository.saveAndFlush(product);
    }

    @Override
    public void deleteProduct(Long id) {
       this.productRepository.deleteById(id);
    }
}