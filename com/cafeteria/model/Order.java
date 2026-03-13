package com.cafeteria.model;

import com.cafeteria.strategy.PaymentStrategy;
import com.cafeteria.observer.OrderObserver;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int idCounter = 1;
    
    private int id;
    private String client;
    private List<Product> products;
    private OrderStatus status;
    private PaymentStrategy paymentStrategy;
    private List<OrderObserver> observers;
    private double discount;

    public Order(String client) {
        this.id = idCounter++;
        this.client = client;
        this.products = new ArrayList<>();
        this.status = OrderStatus.CREATED;
        this.observers = new ArrayList<>();
        this.discount = 0;
    }

    public int getId() {
        return id;
    }

    public String getClient() {
        return client;
    }

    public List<Product> getProducts() {
        return products;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
        notifyObservers();
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public double getSubtotal() {
        double subtotal = 0;
        for (Product product : products) {
            subtotal += product.getPrice();
        }
        return subtotal;
    }

    public double getTotal() {
        return getSubtotal() - discount;
    }

    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(OrderObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.update(this);
        }
    }

    public String getDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Pedido #").append(id).append(" ===\n");
        sb.append("Cliente: ").append(client).append("\n");
        sb.append("Estado: ").append(status.getDescription()).append("\n");
        sb.append("Productos:\n");
        for (Product product : products) {
            sb.append("  - ").append(product.getName())
              .append(" ($").append(product.getPrice()).append(")\n");
        }
        sb.append("Subtotal: $").append(getSubtotal()).append("\n");
        if (discount > 0) {
            sb.append("Descuento: -$").append(discount).append("\n");
        }
        sb.append("Total: $").append(getTotal()).append("\n");
        if (paymentStrategy != null) {
            sb.append("Método de pago: ").append(paymentStrategy.getName()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Pedido #" + id + " - Cliente: " + client + " - Estado: " + status.getDescription();
    }
}
