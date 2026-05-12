package com.example.rxjava.observable.task2_1;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observers.DisposableObserver;

public class FirstObservableDemo {
    public static void demonstrate() {
        System.out.println("------------- Task 2.1 begin -------------");

        Observable<String> atmObservable = Observable.just(
                "Вставте картку",
                "Введіть PIN-код",
                "Оберіть суму: 500 грн",
                "Видача готівки...",
                "Дякуємо! Заберіть картку"
        );

        atmObservable.subscribeWith(new DisposableObserver<String>() {

            @Override
            public void onStart() {
                System.out.println("[БАНКОМАТ] Сесію розпочато");
            }

            @Override
            public void onNext(String step) {
                System.out.println(">> " + step);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("[БАНКОМАТ] Помилка: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("[БАНКОМАТ] Сесію завершено");
            }
        });
        System.out.println("------------- Task 2.1 end -------------");
        System.out.println();
    }
}
