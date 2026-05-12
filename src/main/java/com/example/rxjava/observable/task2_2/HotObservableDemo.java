package com.example.rxjava.observable.task2_2;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

public class HotObservableDemo {
    public static void demonstrate() throws InterruptedException {

        System.out.println("------------- Task 2.2 - Hot Observable begin -------------");

        ConnectableObservable<String> hotMatches =
                Observable.just(
                                "Динамо 2:1 Шахтар",
                                "Шахтар 3:0 Металіст",
                                "Дніпро 1:1 Карпати",
                                "Зоря 0:2 Динамо",
                                "Металіст 4:2 Чорноморець"
                        )
                        .zipWith(
                                Observable.interval(1, TimeUnit.SECONDS),
                                (match, time) -> match
                        )
                        .publish();

        System.out.println("=== Перший підписник ===");

        hotMatches.subscribe(match ->
                System.out.println("[1] " + match)
        );

        hotMatches.connect();

        Thread.sleep(2000);

        System.out.println("\n=== Другий підписник ===");

        hotMatches.subscribe(match ->
                System.out.println("[2] " + match)
        );

        Thread.sleep(7000);

        System.out.println("------------- Task 2.2 - Hot Observable end -------------");
        System.out.println();
    }
}
