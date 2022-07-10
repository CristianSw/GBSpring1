package lesson2;

import lesson2.model.Order;
import lesson2.services.CartService;
import lesson2.services.OrderService;
import lesson2.services.ProductService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        CartService cartService = context.getBean(CartService.class);
        System.out.println(cartService.getCurrentCart());
        cartService.addToCartByProductId(1L);
        cartService.addToCartByProductId(2L);
        System.out.println(cartService.getCurrentCart());

//        ProductService productService = context.getBean(ProductService.class);
//        System.out.println(productService.findAll());
//        System.out.println(productService.findById(1L));
//        System.out.println(productService.findById(2L));
//        System.out.println(productService.findById(3L));
        OrderService orderService = context.getBean(OrderService.class);
        Order order = orderService.createNewOrder();
        System.out.println(order);

        System.out.println(cartService.getCurrentCart());

        context.close();
    }
}
