package com.example.rxjava.errors.task7_2;

import io.reactivex.rxjava3.core.Observable;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class RetryBackoffDemo {
    public static void demonstrate() throws InterruptedException {
        System.out.println("------------- Task 7.2 begin -------------");

        AtomicInteger attemptCount = new AtomicInteger(0);

        Observable<String> unstableApiCall = Observable.create(emitter -> {
            int attempt = attemptCount.incrementAndGet();

            System.out.println("[ПОВТОР] Спроба #" + attempt);

            if (attempt < 4) {
                emitter.onError(new IOException("Connection timeout"));
            } else {
                emitter.onNext("(+) Відповідь API: {status: 'ok', data: [...]}");
                emitter.onComplete();
            }
        });

        unstableApiCall
                .retryWhen(errors ->
                        errors
                            .zipWith(
                                    Observable.range(1, 4),
                                    (error, retryCount) -> retryCount
                            )
                            .flatMap(retryCount -> {
                                long delay = (long) Math.pow(2, retryCount - 1);
                                System.out.println("Очікуємо " + delay + " сек перед повтором...");
                                return Observable.timer(delay, TimeUnit.SECONDS);
                            })
                )
                .subscribe(
                        response -> System.out.println(response),
                        error -> System.out.println("(-) Остаточна помилка: " + error.getMessage())
                );

        Thread.sleep(10000);

        System.out.println("------------- Task 7.2 end -------------");
        System.out.println();
    }
}
