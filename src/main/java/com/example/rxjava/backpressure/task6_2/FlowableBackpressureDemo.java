package com.example.rxjava.backpressure.task6_2;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.atomic.AtomicInteger;

public class FlowableBackpressureDemo {
    public static void demonstrate() throws InterruptedException {
        System.out.println("------------- Task 6.2 PART B begin -------------");
        AtomicInteger processed = new AtomicInteger();
        AtomicInteger dropped = new AtomicInteger();
        Flowable<Integer> fastProducer = Flowable.create(emitter -> {
            for (int i = 1; i <= 1000; i++) {
                if (emitter.requested() > 0) {
                    emitter.onNext(i);
                } else {
                    dropped.incrementAndGet();
                }
            }
            emitter.onComplete();
        }, BackpressureStrategy.DROP);

        fastProducer
                .observeOn(Schedulers.computation())
                .subscribe(item -> {
                            Thread.sleep(10);
                            processed.incrementAndGet();
                        },
                        error -> System.out.println("(-) Помилка: " + error.getMessage()),

                        () -> {
                            System.out.println("[ЗВІТ] Оброблено: " + processed.get());
                            System.out.println("[ЗВІТ] Відкинуто: " + dropped.get());
                            System.out.println("(!) Стратегія DROP: частину елементів втрачено");
                        }
                );

        Thread.sleep(5000);

        System.out.println("------------- Task 6.2 PART B end -------------");
        System.out.println();
    }
}
