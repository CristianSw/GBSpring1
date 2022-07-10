package lesson2.services;

import lesson2.model.Cart;
import lesson2.model.Order;
import lesson2.model.Product;
import lesson2.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class OrderService {
    private UserService userService;
    private CartService cartService;
    private ProductService productService;

    public OrderService(UserService userService, CartService cartService, ProductService productService) {
        this.userService = userService;
        this.cartService = cartService;
        this.productService = productService;
    }

    public Order createNewOrder(){
        Order order = new Order();
        User currentUser = userService.getCurrentUser();

        order.setId(UUID.randomUUID().toString());
        order.setUser(currentUser);

        Cart currentCart = cartService.getCurrentCart();
        for (Product p : currentCart.getProducts()){
            if (!productService.isProductIdExist(p.getId())){
                throw new RuntimeException("ID dont exists");
            }
        }

        order.setProducts(new ArrayList<>(currentCart.getProducts()));
        cartService.clearCurrentCart();





        return order;
    }
}
