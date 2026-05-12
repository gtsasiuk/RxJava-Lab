package com.example.rxjava.operators.task3_2;

import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;
import java.util.List;

public class FlatMapDemo {
    public static void demonstrate() {
        System.out.println("------------- Task 3.2 - flatMap begin -------------");

        List<FoodOrder> orders = Arrays.asList(
                new FoodOrder("ZAM-01", Arrays.asList("Піца Маргарита","Кола 0.5л")),
                new FoodOrder("ZAM-02", Arrays.asList("Борщ","Вареники","Компот")),
                new FoodOrder("ZAM-03", Arrays.asList("Суші-сет 20шт", "Місо-суп"))
        );

        Observable.fromIterable(orders)
                .flatMap(order ->
                        Observable.fromIterable(order.items())
                )
                .subscribe(item ->
                        System.out.println(">> " + item)
                );

        System.out.println("------------- Task 3.2 - flatMap end -------------");
        System.out.println();
    }
}
