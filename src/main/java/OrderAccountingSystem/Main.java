package OrderAccountingSystem;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nВсе товары: \n");
        ProductRepository productRepository = new ProductRepository();
        productRepository.printAllProducts();

        System.out.println("\nЗаказ №3: \n");
        OrderRepository orderRepository = new OrderRepository();
        orderRepository.printOrderProductNames(3);

        // Новый заказ
        OrderService orderService = new OrderService();
        List<OrderItem> items = List.of(
                new OrderItem(0, "3251615", 8000, 1),
                new OrderItem(0, "3251617", 4000, 4)
        );
        orderService.registerOrder("Иван Иванов", "(911)123-45-67", "ivanov@mail.ru", "ул. Примерная, 1", items);
    }
}

