package com.udemy.projetospring.config;

import com.udemy.projetospring.entities.Category;
import com.udemy.projetospring.entities.Order;
import com.udemy.projetospring.entities.OrderItem;
import com.udemy.projetospring.entities.Payment;
import com.udemy.projetospring.entities.Product;
import com.udemy.projetospring.entities.User;
import com.udemy.projetospring.entities.enums.OrderStatus;
import com.udemy.projetospring.repositories.CategoryRepository;
import com.udemy.projetospring.repositories.OrderItemRepository;
import com.udemy.projetospring.repositories.OrderRepository;
import com.udemy.projetospring.repositories.ProductRepository;
import com.udemy.projetospring.repositories.UserRepository;
import java.time.Instant;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 *
 * @author carol
 */
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Bolos");
        Category cat2 = new Category(null, "Cookies");
        Category cat3 = new Category(null, "Bebidas");
        Category cat4 = new Category(null, "Massa folhada");

        Product p1 = new Product(null, "Cookie Duplo Chocolate", "Cookie com gotas de chocolate meio amargo", 6.50, "cookie_chocolate.jpg");
        Product p2 = new Product(null, "Croissant", "Croissant folhado tradicional francês", 7.80, "croissant.jpg");
        Product p3 = new Product(null, "Cappuccino", "Cappuccino cremoso com canela", 9.50, "cappuccino.jpg");
        Product p4 = new Product(null, "Cheesecake", "Cheesecake de frutas vermelhas", 22.00, "cheesecake.jpg");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4));

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat4);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat1);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4));

        User u1 = new User(null, "Maria Brown", "988888888");
        User u2 = new User(null, "Alex Green", "977777777");

        userRepository.saveAll(Arrays.asList(u1, u2));

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.WAITING_PAYMENT, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.DELIVERED, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p2, 3, p3.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

        //pagemento de order 3
        Payment pay1 = new Payment(null, Instant.parse("2019-07-23T15:21:22Z"), o3);
        Payment pay2 = new Payment(null, Instant.parse("2019-07-23T15:21:22Z"), o1);

        o3.setPayment(pay1);
        o1.setPayment(pay2);
        
        orderRepository.save(o3);
        orderRepository.save(o1);
    }
}
