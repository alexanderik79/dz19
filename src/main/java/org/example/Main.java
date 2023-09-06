package org.example;

import org.example.service.OrderDetailsService;
import org.example.service.ProductService;
import org.example.service.TableFiller;

public class Main {
    public static void main(String[] args) {
        String divLine = "\n__________________________________________________________________________________";
        // заполнение таблиц
        TableFiller tableFiller = new TableFiller();
        tableFiller.usersFill();
        tableFiller.customersFill();
        tableFiller.productsFill();
        tableFiller.ordersFill();
        tableFiller.orderDetailsFill();

        // выборка
        ProductService productService = new ProductService();

        // Отримати всі продукти
        System.out.println(divLine+"\nОтримати всі продукти"+divLine);
        productService.getAllProducts().forEach(p -> System.out.println(p.getNname()+" | " +
                p.getPrice()+" | " + p.getQuantity()));

        //Отримати кількість ордерів у кожного кастомера
        System.out.println(divLine+"\nОтримати кількість ордерів у кожного кастомера"+divLine);
        productService.countOrders();

        //Отримати всі замовлення з деталями, відсортувавши за датою розміщення
        System.out.println(divLine+"\nОтримати всі замовлення з деталями, відсортувавши " +
                "за датою розміщення"+divLine);
        OrderDetailsService orderDetailsService = new OrderDetailsService();
        orderDetailsService.getAll().forEach(od -> System.out.println(od.getId()+" | " +
                od.getTimePlaced()+" | "));

        //Змінити будь-що у замовленні
        System.out.println(divLine+"\nЗмінити будь-що у замовленні. Змінено ціну на продукт по id #2"+divLine);
        productService.updateById(2);

        //Отримати дані по всіх кастомерах та їхніх замовленнях з вказанням кількості продуктів у кожному.
        System.out.println(divLine+"\nОтримати дані по всіх кастомерах та їхніх замовленнях" +
                " \nз вказанням кількості продуктів у кожному."+divLine);
        productService.countExtended();

    }
}