package com.example.rxjava.schedulers.task5_2;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.Arrays;
import java.util.List;

public class ParallelServiceDemo {
    public static void demonstrate() throws InterruptedException {
        List<ServiceCall> services = Arrays.asList(
                new ServiceCall("UserService", 800),
                new ServiceCall("OrderService", 1200),
                new ServiceCall("RecommendationService", 600)
        );

        System.out.println("------------- Task 5.2 PART A begin -------------");
        long startSequential = System.currentTimeMillis();
        Observable.fromIterable(services)
                .concatMap(service -> callService(service).subscribeOn(Schedulers.io()))
                .blockingSubscribe(result -> {},
                        error -> System.out.println("(-) Помилка: " + error.getMessage())
                );

        long endSequential = System.currentTimeMillis();

        System.out.println("Загальний час (послідовно): " + (endSequential - startSequential) + " мс");

        System.out.println("\n------------- Task 5.2 PART B begin -------------");

        long startParallel = System.currentTimeMillis();

        Observable.fromIterable(services)
                .flatMap(service -> callService(service).subscribeOn(Schedulers.io()))
                .blockingSubscribe(result -> {},
                        error -> System.out.println("(-) Помилка: " + error.getMessage())
                );

        long endParallel = System.currentTimeMillis();

        System.out.println("Загальний час (паралельно): " + (endParallel - startParallel) + " мс");

        System.out.println("------------- Task 5.2 end -------------");
        System.out.println();
    }

    private static Observable<String> callService(ServiceCall service) {
        return Observable.fromCallable(() -> {
            Thread.sleep(service.delayMs());
            String result = "[" + Thread.currentThread().getName() + "] " + "(+) " + service.serviceName() +
                            " відповів за " + service.delayMs() + " мс";
            System.out.println(result);

            return result;
        });
    }
}
