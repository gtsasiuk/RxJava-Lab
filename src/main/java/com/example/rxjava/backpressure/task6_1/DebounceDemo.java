package com.example.rxjava.backpressure.task6_1;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class DebounceDemo {
    public static void demonstrate() throws InterruptedException {
        System.out.println("------------- Task 6.1 begin -------------");
        Observable<String> keystrokes = Observable.create(emitter -> {
            String[] inputs = {"К", "Ки", "Киї", "Київ", "Київ ", "Київ К", "Київ Ки"};

            long[] delays = {50, 80, 120, 100, 400, 60, 350};

            for (int i = 0; i < inputs.length; i++) {
                Thread.sleep(delays[i]);
                System.out.println("[ВВІД] Користувач ввів: " + inputs[i]);
                emitter.onNext(inputs[i]);
            }

            emitter.onComplete();
        });

        keystrokes.debounce(300, TimeUnit.MILLISECONDS)
                .subscribe(query -> System.out.println("[ПОШУК] Запит до API: \"" + query + "\""),
                        error -> System.out.println("(-) Помилка: " + error.getMessage()),
                        () -> System.out.println("(+) Пошук завершено")
                );

        Thread.sleep(3000);

        System.out.println("------------- Task 6.1 end -------------");
        System.out.println();
    }
}
