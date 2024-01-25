package it.epicode;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class Order {
    private long id;
    private String status;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private List<Product> products;
    private Customers customers;

    public Order(String status, List<Product> products, Customers customers, LocalDate date) {
        Random rdnm = new Random();
        this.id = rdnm.nextLong(100000, 999999);
        this.status = status;
        this.orderDate = date;
        this.deliveryDate = date.plusDays(7);
        this.products = products;
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", products=" + products +
                ", customers=" + customers +
                '}';
    }

    public long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Customers getCustomers() {
        return customers;
    }
}