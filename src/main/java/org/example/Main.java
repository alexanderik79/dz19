package org.example;

import org.example.service.TableFiller;

public class Main {
    public static void main(String[] args) {
 //       ProductService productService = new ProductService();
        TableFiller tableFiller = new TableFiller();
        tableFiller.usersFill();
        tableFiller.customersFill();
        tableFiller.productsFill();
        tableFiller.ordersFill();
        tableFiller.orderDetailsFill();


//        List<Customer> customers = List.of(Customer.builder()
//                        .nname("Alexander")
//                        .phone("+11111")
//                        .surnname("Anchor")
//                        .user(users.get(0)),
//                Customer.builder()
//                        .nname("Alexander")
//                        .phone("+11111")
//                        .surnname("Anchor")
//                        .user(users.get(1)),
//                Customer.builder()
//                        .nname("Alexander")
//                        .phone("+11111")
//                        .surnname("Anchor")
//                        .user(users.get(2)).build());
//        users.forEach(userService::save);



//        productService.updateById(6);
//        //  productService.countOrders();
//        productService.getAllProducts().forEach(p -> System.out.println(p.getNname()+" | " +
//                p.getPrice()+" | " + p.getQuantity()));
//
//        OrderDetailsService orderDetailsService = new OrderDetailsService();
//        orderDetailsService.getAllProducts().forEach(od -> System.out.println(od.toString()));


    }
}