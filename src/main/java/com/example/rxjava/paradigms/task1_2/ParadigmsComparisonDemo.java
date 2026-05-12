package com.example.rxjava.paradigms.task1_2;

import io.reactivex.rxjava3.core.Observable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ParadigmsComparisonDemo {
    public static void demonstrate() {
        System.out.println("------------- Task 1.2 begin -------------");
        List<String> cities = Arrays.asList(
                "Київ", "Харків", "Одеса", "Дніпро", "Запоріжжя",
                "Кривий Ріг", "Миколаїв", "Херсон", "Кропивницький",
                "Черкаси", "Суми", "Хмельницький", "Чернівці", "Каховка"
        );

        System.out.println("=== IMPERATIVE ===");

        List<String> result = new ArrayList<>();

        for (String city : cities) {

            if (city.startsWith("К")) {
                result.add(city.toUpperCase());
            }
        }

        Collections.sort(result);

        for (String city : result) {
            System.out.println(city);
        }

        System.out.println("\n=== STREAM API ===");

        cities.stream()
                .filter(city -> city.startsWith("К"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);

        System.out.println("=== RXJAVA ===");

        Observable.fromIterable(cities)
                .filter(city -> city.startsWith("К"))
                .map(String::toUpperCase)
                .sorted()
                .subscribe(System.out::println);

        System.out.println("------------- Task 1.2 end -------------");
        System.out.println();
    }
}
