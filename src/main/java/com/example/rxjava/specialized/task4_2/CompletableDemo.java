package com.example.rxjava.specialized.task4_2;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

public class CompletableDemo {
    public static void demonstrate() throws InterruptedException {
        System.out.println("------------- Task 4.2 - Completable SUCCESS begin -------------");

        validateInput()
                .andThen(saveToDatabase(false))
                .andThen(generateToken())
                .subscribe(token -> {
                            System.out.println("[ТОКЕН] Токен: " + token);
                            System.out.println("(+) Реєстрацію завершено успішно!");
                        },
                        error -> System.out.println("(-) Помилка: " + error.getMessage())
                );

        Thread.sleep(1000);

        System.out.println("\n------------- Task 4.2 - Completable ERROR begin -------------");

        validateInput()
                .andThen(saveToDatabase(true))
                .andThen(generateToken())
                .subscribe(token -> {
                            System.out.println("[ТОКЕН] Токен: " + token);
                            System.out.println("(+) Реєстрацію завершено успішно!");
                        },
                        error -> System.out.println("(-) Помилка: " + error.getMessage())
                );

        Thread.sleep(1000);

        System.out.println("\n------------- Task 4.2 - Completable end -------------");
        System.out.println();
    }

    private static Completable validateInput() {
        return Completable.fromAction(() -> {
            System.out.println("[ПОШУК] Перевірка даних...");
            System.out.println("(+) Дані валідні");
        });
    }

    private static Completable saveToDatabase(boolean shouldFail) {
        return Completable.fromAction(() -> {
            System.out.println("[DB] Збереження в БД...");
            if (shouldFail) {
                throw new RuntimeException("Помилка збереження в БД");
            }

            System.out.println("(+) Збережено");
        });
    }

    private static Single<String> generateToken() {
        return Single.just("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.demo");
    }
}
