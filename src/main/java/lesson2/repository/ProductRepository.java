package lesson2.repository;

import lesson2.model.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init(){
        this.products = new ArrayList<>();
        this.products.add(new Product(1L,"Milk"));
        this.products.add(new Product(2L,"Bread"));
        this.products.add(new Product(3L,"Eggs"));
        this.products.add(new Product(4L,"Cheese"));
    }

    public List<Product> findAll(){
        return Collections.unmodifiableList(products);
    }

    public Optional<Product> findById(Long id){
        return products.stream().filter(p->p.getId().equals(id)).findFirst();
    }
}
