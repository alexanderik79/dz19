package org.example;

import org.example.service.OrderDetailsService;
import org.example.service.ProductService;
import org.example.service.TableFiller;

public class Main {
    public static void main(String[] args) {

        TableFiller tableFiller = new TableFiller();
        tableFiller.usersFill();
        tableFiller.customersFill();
        tableFiller.productsFill();
        tableFiller.ordersFill();
        tableFiller.orderDetailsFill();

        ProductService productService = new ProductService();
        productService.updateById(1);
        productService.countOrders();
        productService.countExtended();

        productService.getAllProducts().forEach(p -> System.out.println(p.getNname()+" | " +
                p.getPrice()+" | " + p.getQuantity()));

        OrderDetailsService orderDetailsService = new OrderDetailsService();
        orderDetailsService.getAll().forEach(od -> System.out.println(od.getId()+" | " +
                od.getTimePlaced()+" | " +od.getTimeUpdated()));
    }
}