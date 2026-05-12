package com.example.rxjava.specialized.task4_1;

import io.reactivex.rxjava3.core.Single;

public class SingleDemo {
    public static void demonstrate() {
        System.out.println("------------- Task 4.1 begin -------------");
        getUserById(42).subscribe(user -> System.out.println("(+) Знайдено: " + user),
                    error -> System.out.println("(-) Помилка: " + error.getMessage()));

        getUserById(-1)
                .subscribe(user -> System.out.println("(+) Знайдено: " + user),
                        error -> System.out.println("(-) Помилка: " + error.getMessage()));

        System.out.println("------------- Task 4.1 end -------------");
        System.out.println();
    }

    private static Single<String> getUserById(int id) {
        if (id > 0) {
            return Single.just("Користувач #" + id + ": Іван Франко");
        } else {
            return Single.error(new IllegalArgumentException("ID не може бути від'ємним або нульовим"));
        }
    }
}
