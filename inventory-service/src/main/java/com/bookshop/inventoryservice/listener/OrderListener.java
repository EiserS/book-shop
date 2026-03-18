package com.bookshop.inventoryservice.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderListener {

    @RabbitListener(queues = "order.created.queue")
    public void receiveOrder(String message) {
        System.out.println("\n==========================================");
        System.out.println("📦 [INVENTORY-SERVICE] New order received!");
        System.out.println("Message content: " + message);
        System.out.println("Warehouse worker is looking for the book on the shelf...");
        System.out.println("==========================================\n");
    }
}