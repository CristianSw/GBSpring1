package lesson2.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cart {
    private List<Product> products;

    public Cart(){
        this.products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    public void add(Product product){
        products.add(product);
    }
    public void removeByTitle(final Product product){
        products.removeIf(p -> p.getTitle().equals(product.getTitle()));
    }

    public void clear(){
        products.clear();
    }

    @Override
    public String toString() {
        return "Cart{" +
                "products=" + products +
                '}';
    }
}
