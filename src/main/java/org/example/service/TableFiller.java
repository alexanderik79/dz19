package org.example.service;

import org.example.entity.Customer;
import org.example.entity.Order;
import org.example.entity.Product;
import org.example.entity.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class TableFiller {
    public List<User> users = new ArrayList<>();
    public List<Customer> customers = new ArrayList<>();
    public List<Order> orders = new ArrayList<>();
    public List<Product> products = new ArrayList<>();
    public void usersFill(){
        final UserService userService = new UserService();
        users = List.of(User.builder()
                        .email("a@a.com")
                        .role("user")
                        .username("Alex").build(),
                User.builder()
                        .email("b@b.com")
                        .role("user")
                        .username("Bred").build(),
                User.builder()
                        .email("c@c.com")
                        .role("user")
                        .username("Cris").build());
        users.forEach(userService::save);
    }

    public void customersFill(){
        final CustomerService customerService = new CustomerService();
        Customer customer = new Customer();
        customer.setNname("Alexander");
        customer.setSurnname("Anchor");
        customer.setPhone("+11111");
        customer.setUser(users.get(0));
        customers.add(customer);

        Customer customer2 = new Customer();
        customer2.setNname("Bred");
        customer2.setSurnname("Borland");
        customer2.setPhone("+22222");
        customer2.setUser(users.get(1));
        customers.add(customer2);

        Customer customer3 = new Customer();
        customer3.setNname("Cris");
        customer3.setSurnname("Corn");
        customer3.setPhone("+33333");
        customer3.setUser(users.get(2));
        customers.add(customer3);

        customers.forEach(customerService::save);
    }

    public void productsFill(){
        final ProductService productService = new ProductService();
        Product product = new Product();
        product.setNname("sugar");
        product.setPrice(100.10);
        product.setQuantity(100);
        products.add(product);

        Product product2 = new Product();
        product2.setNname("salt");
        product2.setPrice(50.50);
        product2.setQuantity(50);
        products.add(product2);

        Product product3 = new Product();
        product3.setNname("apple");
        product3.setPrice(80.10);
        product3.setQuantity(200);
        products.add(product3);

        Product product4 = new Product();
        product4.setNname("lemon");
        product4.setPrice(200.20);
        product4.setQuantity(20);
        products.add(product4);

        Product product5 = new Product();
        product5.setNname("water");
        product5.setPrice(10.10);
        product5.setQuantity(120);
        products.add(product5);

        Product product6 = new Product();
        product6.setNname("vodka");
        product6.setPrice(150.10);
        product6.setQuantity(10);
        products.add(product6);

        products.forEach(productService::save);
    }

    public void ordersFill(){
        final OrderService orderService = new OrderService();

        List<Product> cart = new ArrayList<>();
        cart.add(products.get(getRndm()));
        cart.add(products.get(getRndm()));
        cart.add(products.get(getRndm()));
        Order order = new Order();
        order.setNname("order #1");
        order.setTotalSum(1000.01);
        order.setCustomer(customers.get(0));
        order.setProducts(cart);
        orders.add(order);

        List<Product> cart2 = new ArrayList<>();
        cart2.add(products.get(getRndm()));
        cart2.add(products.get(getRndm()));
        cart2.add(products.get(getRndm()));
        Order order2 = new Order();
        order2.setNname("order #2");
        order2.setTotalSum(2000.01);
        order2.setCustomer(customers.get(1));
        order2.setProducts(cart2);
        orders.add(order2);

        List<Product> cart3 = new ArrayList<>();
        cart3.add(products.get(getRndm()));
        cart3.add(products.get(getRndm()));
        Order order3 = new Order();
        order3.setNname("order #3");
        order3.setTotalSum(3000.01);
        order3.setCustomer(customers.get(1));
        order3.setProducts(cart3);
        orders.add(order3);

        List<Product> cart4 = new ArrayList<>();
        cart4.add(products.get(getRndm()));
        cart4.add(products.get(getRndm()));
        cart4.add(products.get(getRndm()));
        Order order4 = new Order();
        order4.setNname("order #4");
        order4.setTotalSum(4000.01);
        order4.setCustomer(customers.get(2));
        order4.setProducts(cart4);
        orders.add(order4);

        List<Product> cart5 = new ArrayList<>();
        cart5.add(products.get(getRndm()));
        Order order5 = new Order();
        order5.setNname("order #5");
        order5.setTotalSum(5000.01);
        order5.setCustomer(customers.get(2));
        order5.setProducts(cart5);
        orders.add(order5);

        List<Product> cart6 = new ArrayList<>();
        cart6.add(products.get(getRndm()));
        cart6.add(products.get(getRndm()));
        cart6.add(products.get(getRndm()));
        cart6.add(products.get(getRndm()));
        cart6.add(products.get(getRndm()));
        Order order6 = new Order();
        order6.setNname("order #6");
        order6.setTotalSum(6000.01);
        order6.setCustomer(customers.get(2));
        order6.setProducts(cart6);
        orders.add(order6);

        orders.forEach(orderService::save);
    }

    public int getRndm(){
        int p = (int) (Math.random()*5);
        return p;
    }
}
