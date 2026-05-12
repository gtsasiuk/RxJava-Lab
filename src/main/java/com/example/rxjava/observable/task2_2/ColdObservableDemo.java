package com.example.rxjava.observable.task2_2;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class ColdObservableDemo {
    public static void demonstrate() throws InterruptedException {

        System.out.println("------------- Task 2.2 - Cold Observable begin -------------");

        Observable<String> matches = Observable.just(
                        "Динамо 2:1 Шахтар",
                        "Шахтар 3:0 Металіст",
                        "Дніпро 1:1 Карпати",
                        "Зоря 0:2 Динамо",
                        "Металіст 4:2 Чорноморець"
                )
                .zipWith(
                        Observable.interval(1, TimeUnit.SECONDS),
                        (match, time) -> match
                );

        System.out.println("=== Перший підписник ===");

        matches.subscribe(match ->
                System.out.println("[1] " + match)
        );

        Thread.sleep(7000);

        System.out.println("\n=== Другий підписник ===");

        matches.subscribe(match ->
                System.out.println("[2] " + match)
        );

        Thread.sleep(7000);

        System.out.println("------------- Task 2.2 - Cold Observable end -------------");
        System.out.println();
    }
}
