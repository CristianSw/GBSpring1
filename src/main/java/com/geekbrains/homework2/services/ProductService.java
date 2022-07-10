package com.geekbrains.homework2.services;

import com.geekbrains.homework2.repository.ProductRepository;
import com.geekbrains.homework2.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> findById(Long id){
        return  productRepository.findById(id);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

}
