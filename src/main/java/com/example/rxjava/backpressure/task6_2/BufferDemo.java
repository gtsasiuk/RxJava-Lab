package com.example.rxjava.backpressure.task6_2;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.atomic.AtomicInteger;

public class BufferDemo {
    public static void demonstrate() {
        System.out.println("------------- Task 6.2 PART A begin -------------");

        Observable<String> events = Observable.fromArray(
                "LOGIN:user1",
                "CLICK:btn_buy",
                "VIEW:product_42",
                "LOGIN:user2",
                "LOGOUT:user1",

                "CLICK:btn_cart",
                "VIEW:product_7",
                "LOGIN:user3",
                "CLICK:btn_pay",
                "LOGOUT:user2",

                "LOGIN:user4",
                "VIEW:product_1"
        );

        AtomicInteger batchCounter = new AtomicInteger(1);
        AtomicInteger totalEvents = new AtomicInteger();

        events.buffer(5)
                .subscribe(batch -> {
                            totalEvents.addAndGet(batch.size());
                            System.out.println("[DB] Batch INSERT #" + batchCounter.getAndIncrement() + ": " + batch);
                        },
                        error -> System.out.println("(-) Помилка: " + error.getMessage()),
                        () -> System.out.println("(+) Збережено подій: " + totalEvents.get())
                );

        System.out.println("------------- Task 6.2 PART A end -------------");
        System.out.println();
    }
}
