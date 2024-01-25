package it.epicode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Product> productList = new ArrayList<>();
        Product ioNonHoPaura = new Product("Io non ho paura", "Books", 17.50);
        Product harryPotter = new Product("Harry Potter", "Books", 29.99);
        Product ilPiacere = new Product("Il Piacere", "Books", 15.90);
        Product peluche = new Product("Peluche", "Baby", 19.99);
        Product bavaglino = new Product("bavaglino", "Baby", 8.99);
        Product tShirt = new Product("T-shirt", "Boys", 25.99);
        Product sneakers = new Product("Sneakers", "Boys", 149.99);
        Product calzini = new Product("calzini", "Boys", 9.99);
        productList.add(ioNonHoPaura);
        productList.add(harryPotter);
        productList.add(ilPiacere);
        productList.add(peluche);
        productList.add(bavaglino);
        productList.add(tShirt);
        productList.add(sneakers);
        productList.add(calzini);

        Customers annaRossi = new Customers("Anna Rossi");
        Customers marioBlu = new Customers("Mario Blu");
        Customers lucaVerdi = new Customers("Luca Verdi");
        Customers paoloGialli = new Customers("Paolo Gialli");

        List<Product> orderProductByAnnaR = new ArrayList<>();
        List<Product> orderProductByMarioB = new ArrayList<>();
        List<Product> orderProductByLucaV = new ArrayList<>();
        List<Product> orderProductByPaoloG = new ArrayList<>();

        orderProductByAnnaR.add(bavaglino);
        orderProductByAnnaR.add(ioNonHoPaura);

        orderProductByLucaV.add(peluche);
        orderProductByLucaV.add(ioNonHoPaura);


        orderProductByPaoloG.add(tShirt);
        orderProductByPaoloG.add(harryPotter);


        orderProductByMarioB.add(sneakers);
        orderProductByMarioB.add(ilPiacere);

        LocalDate date1 = LocalDate.of(2024, 1, 21);
        LocalDate date2 = LocalDate.of(2024, 2, 11);
        LocalDate date3 = LocalDate.of(2024, 6, 23);
        LocalDate date4 = LocalDate.of(2024, 9, 4);


        Order order1 = new Order("in progress", orderProductByAnnaR, annaRossi, date1);
        Order order2 = new Order("in progress", orderProductByMarioB, marioBlu, date2);
        Order order3 = new Order("in progress", orderProductByLucaV, lucaVerdi, date3);
        Order order4 = new Order("in progress", orderProductByPaoloG, paoloGialli, date4);


        List<Order> orderList = new ArrayList<>();
        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);
        orderList.add(order4);


        List<Order> orderListCustomersTier2 = new ArrayList<>();
        LocalDate onefeb = LocalDate.of(2021, 2, 1);
        LocalDate oneApr = LocalDate.of(2021, 4, 1);


        //EXERCISE U4-W3-D3

        System.out.println("-------------------EXERCISE 1-------------------");
        productList.stream().filter(product -> product.getCategory().equals("Books")).filter(product -> product.getPrice() > 100).forEach(System.out::println);
        System.out.println("-------------------EXERCISE 2-------------------");
        orderList.forEach(order -> order.getProducts().stream().filter(product -> product.getCategory().equals("Baby")).forEach(System.out::println));
        System.out.println("-------------------EXERCISE 3-------------------");
        productList.stream().filter(product -> product.getCategory().equals("Boys")).forEach(product -> product.setPrice(product.sconto(product.getPrice())));
        productList.stream().filter(product -> product.getCategory().equals("Boys")).forEach(System.out::println);
        System.out.println("-------------------EXERCISE 4-------------------");
        orderList.stream().filter(order -> order.getCustomers().getTier() == 2).forEach(orderListCustomersTier2::add);
        orderListCustomersTier2.stream().filter(order -> order.getOrderDate().isAfter(onefeb)).filter(order -> order.getOrderDate().isBefore(oneApr)).forEach(order -> System.out.println(order.getProducts().toString()));


        //EXERCISE U4-W3-D4

        System.out.println("-------------------EXERCISE 1-------------------");
        orderList.stream().collect(Collectors.groupingBy(Order::getCustomers)).forEach((k, v) -> System.out.println( k + ", Order: " + v ));

        System.out.println("-------------------EXERCISE 2-------------------");
        orderList.stream().collect(Collectors.groupingBy(Order::getCustomers)).forEach((k, orders) -> {
            double finalPrice = 0;
            for(Order order : orders)  {
                double partialSum = order.getProducts().stream().mapToDouble(Product::getPrice).sum();
                finalPrice += partialSum;
            };
            System.out.println(k + ", somma prezzi ordini : " + finalPrice);
        });

        System.out.println("-------------------EXERCISE 3-------------------");
        List<Product> prodottiOrdineDecrescente = productList.stream().sorted(Comparator.comparing(Product::getPrice, Comparator.reverseOrder())).toList();
        prodottiOrdineDecrescente.forEach(System.out::println);

        System.out.println("-------------------EXERCISE 4-------------------");
        double sum = orderList.stream().mapToDouble(order -> order.getProducts().stream().mapToDouble(Product::getPrice).sum()).average().orElse(0.0);
        System.out.println("media dei prezzi dei prodotti di tutti gli ordini : " + sum);

        System.out.println("-------------------EXERCISE 5-------------------");
        Map<String , Double> productPriceSum= productList.stream().collect(Collectors.groupingBy(Product::getCategory, Collectors.summingDouble(Product::getPrice)));
        productPriceSum.forEach((category, priceSum ) -> System.out.println(category + ": " + priceSum));





    }
}
