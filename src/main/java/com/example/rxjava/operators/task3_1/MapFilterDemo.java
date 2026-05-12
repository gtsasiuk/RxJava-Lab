package com.example.rxjava.operators.task3_1;

import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;
import java.util.List;

public class MapFilterDemo {
    public static void demonstrate() {
        System.out.println("------------- Task 3.1 begin -------------");

        List<Product> products = Arrays.asList(
                new Product("Навушники Sony", 49.99),
                new Product("Клавіатура Logitech", 129.00),
                new Product("Монітор LG 27\"", 399.00),
                new Product("USB-хаб Anker", 35.00),
                new Product("Веб-камера Logitech", 149.00),
                new Product("Килимок для миші", 18.00),
                new Product("SSD Samsung 1TB", 110.00)
        );

        final double USD_TO_UAH = 41.5;

        Observable.fromIterable(products)
                .filter(product -> product.priceUsd() > 100)
                .map(product -> {
                    double priceUah = product.priceUsd() * USD_TO_UAH;

                    return String.format("%s -- %.2f грн (є в наявності)",
                            product.name(), priceUah);
                })
                .subscribe(System.out::println);

        System.out.println("------------- Task 3.1 end -------------");
        System.out.println();
    }
}
