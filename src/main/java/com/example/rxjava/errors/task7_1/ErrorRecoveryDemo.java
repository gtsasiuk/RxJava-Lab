package com.example.rxjava.errors.task7_1;

import io.reactivex.rxjava3.core.Observable;

public class ErrorRecoveryDemo {
    public static void demonstrate() {
        System.out.println("------------- Task 7.1 SCENARIO A begin -------------");
        Observable<String> currencyServiceA = Observable.create(emitter -> {
            emitter.onNext("USD -> UAH: 41.50");
            emitter.onNext("EUR -> UAH: 44.20");
            emitter.onError(new RuntimeException("Сервіс тимчасово недоступний"));
            emitter.onNext("GBP -> UAH: 52.10");
        });

        currencyServiceA
                .onErrorReturn(error -> "Використовується кешований курс: USD -> UAH: 41.00")
                .subscribe(value -> System.out.println(value),
                        error -> System.out.println("(-) Помилка: " + error.getMessage()));

        System.out.println("\n------------- Task 7.1 SCENARIO B begin -------------");

        Observable<String> currencyServiceB = Observable.create(emitter -> {
            emitter.onNext("USD -> UAH: 41.50");
            emitter.onNext("EUR -> UAH: 44.20");
            emitter.onError(new RuntimeException("Сервіс тимчасово недоступний"));
            emitter.onNext("GBP -> UAH: 52.10");
        });

        currencyServiceB
                .onErrorResumeNext(error ->
                        Observable.just("JPY -> UAH: 0.27", "PLN -> UAH: 10.30"))
                .subscribe(value -> System.out.println(value),
                        error -> System.out.println("(-) Помилка: " + error.getMessage()));

        System.out.println("------------- Task 7.1 end -------------");
        System.out.println();
    }
}
