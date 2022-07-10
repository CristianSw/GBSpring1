package lesson2.services;

import lesson2.model.Cart;
import lesson2.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class CartService {
    private ProductService productService;
    private Cart cart;

    @Autowired
    public CartService(ProductService productService) {
        this.productService = productService;
    }

    @PostConstruct
    public void init(){
        this.cart =  new Cart();
    }

    public Cart getCurrentCart(){
        return cart;
    }

    public void addToCartByProductId(Long productID){
        Product product = productService.findById(productID).get();
        cart.add(product);
    }
    public void removeFromCart(Product product){
        cart.removeByTitle(product);
    }
    public void clearCurrentCart(){
        cart.clear();
    }


}
