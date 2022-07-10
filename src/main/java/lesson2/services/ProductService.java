package lesson2.services;

import lesson2.model.Product;
import lesson2.repository.ProductRepository;
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

    public boolean isProductIdExist(Long id){
        return productRepository.findAll().stream().anyMatch(p -> p.getId().equals(id));
    }
}
