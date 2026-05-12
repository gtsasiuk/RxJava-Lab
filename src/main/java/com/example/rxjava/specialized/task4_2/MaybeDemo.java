package com.example.rxjava.specialized.task4_2;

import io.reactivex.rxjava3.core.Maybe;

public class MaybeDemo {
    public static void demonstrate() {
        System.out.println("------------- Task 4.2 - Maybe begin -------------");

        findInCache("user:1")
                .defaultIfEmpty("Завантажено з БД")
                .subscribe(value -> System.out.println("[КЕШ (+)] Знайдено: " + value),
                        error -> System.out.println("[КЕШ (!)] Помилка: " + error.getMessage()));

        findInCache("user:2")
                .defaultIfEmpty("Завантажено з БД")
                .subscribe(value -> System.out.println("[КЕШ (-)] Кеш-міс. Значення: " + value),
                        error -> System.out.println("[КЕШ (!)] Помилка: " + error.getMessage()));

        findInCache("user:error")
                .defaultIfEmpty("Завантажено з БД")
                .subscribe(
                        value ->
                                System.out.println("[КЕШ (+)] Знайдено: " + value),

                        error ->
                                System.out.println("[КЕШ (!)] Помилка: " + error.getMessage())
                );

        System.out.println("------------- Task 4.2 - Maybe end -------------");
        System.out.println();
    }

    private static Maybe<String> findInCache(String key) {
        return switch (key) {
            case "user:1" -> Maybe.just("{'name':'Леся','age':28}");
            case "user:2" -> Maybe.empty();
            case "user:error" -> Maybe.error(new RuntimeException("Redis недоступний"));

            default -> Maybe.empty();
        };
    }
}
