package com.bookshop.inventoryservice.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderListener {

    @RabbitListener(queues = "order.created.queue")
    public void receiveOrder(String message) {
        System.out.println("\n==========================================");
        System.out.println("📦 [INVENTORY-SERVICE] Otrzymano nowe zamówienie!");
        System.out.println("Treść: " + message);
        System.out.println("Magazynier poszedł szukać książki na półce...");
        System.out.println("==========================================\n");
    }
}