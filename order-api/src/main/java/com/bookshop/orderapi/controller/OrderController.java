package com.bookshop.orderapi.controller;

import com.bookshop.orderapi.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final RabbitTemplate rabbitTemplate;

    public OrderController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping("/test/{bookName}")
    public String testOrder(@PathVariable String bookName) {
        String message = "Klient wlasnie kupil ksiazke: " + bookName;

        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, message);

        return "Sukces! Wiadomosc wyslana do RabbitMQ: " + message;
    }
}