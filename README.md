# 📚 Book Shop - Learning Project (PoC)

This is an educational, "Absolute Minimum" project designed to demonstrate the core concepts of asynchronous microservices communication. It serves as a Proof of Concept (PoC) for learning how different applications can talk to each other without being directly connected.

---

## 🎯 Educational Goals

The main purpose of this project is to understand:
1. **Asynchronous Decoupling:** How one app can send data and another can receive it later, even if they aren't running at the same time.
2. **Infrastructure as Code:** Using Docker Compose to spin up a professional Message Broker (RabbitMQ) in seconds.
3. **Producer/Consumer Pattern:** Implementing the basic roles of a system that "shouts" information and a system that "listens" to it.

---

## 🏗️ Minimalist Architecture

To keep the learning curve low, this project focuses only on the "Messaging" layer.

1. **`order-api` (The "Speaker"):**
   - Receives a simple HTTP request (from your browser).
   - Forwards that information as a text message to a shared "mailbox" (RabbitMQ).

2. **`inventory-service` (The "Listener"):**
   - Stays silent and waits.
   - When a message appears in the "mailbox", it automatically wakes up and prints the order details to the console.

### 🔄 Minimal Flow
`Browser` ➡️ `Order API` ➡️ `RabbitMQ Queue` ➡️ `Inventory Service`

---

## 🚀 "Starter" Technology Stack
* **Java 21 & Spring Boot 3** (The backbone of modern backend dev)
* **RabbitMQ** (The most popular open-source message broker)
* **Docker** (To avoid installing software directly on your PC)
* **Lombok** (To keep the code clean and short)

---

## 🛠️ Quick Start for Students

### 1. Set up Infrastructure
You don't need to install RabbitMQ. Just run:
docker compose up -d

### 2. Run the apps
- Launch `OrderApiApplication`
- Launch `InventoryServiceApplication`

### 3. Test the "Magic"
Visit: http://localhost:8080/api/orders/test/Harry-Potter
Observe how the `inventory-service` console reacts instantly. Even if you turn off the inventory service, send an order, and turn it back on later – the message will be waiting for you!

---

⚠️ **Note:** This project intentionally skips database persistence, advanced error handling, and security layers to focus exclusively on the messaging logic.