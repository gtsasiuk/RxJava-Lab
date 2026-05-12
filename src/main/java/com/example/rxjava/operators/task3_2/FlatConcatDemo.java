package com.example.rxjava.operators.task3_2;

import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FlatConcatDemo {
    public static void demonstrate() throws InterruptedException {
        List<FoodOrder> orders = Arrays.asList(
                new FoodOrder("ZAM-01", Arrays.asList("Піца Маргарита","Кола 0.5л")),
                new FoodOrder("ZAM-02", Arrays.asList("Борщ","Вареники","Компот")),
                new FoodOrder("ZAM-03", Arrays.asList("Суші-сет 20шт", "Місо-суп"))
        );

        System.out.println("------------- Task 3.2 - flatMap with delay begin -------------");

        Observable.fromIterable(orders)
                .flatMap(order ->
                        Observable.fromIterable(order.items())
                                .delay(500, TimeUnit.MILLISECONDS)
                )
                .subscribe(item ->
                        System.out.println("flatMap >> " + item)
                );

        Thread.sleep(3000);

        System.out.println("\n------------- Task 3.2 - concatMap with delay begin -------------");

        Observable.fromIterable(orders)
                .concatMap(order ->
                        Observable.fromIterable(order.items())
                                .delay(500, TimeUnit.MILLISECONDS)
                )
                .subscribe(item ->
                        System.out.println("concatMap >> " + item)
                );

        Thread.sleep(5000);
        System.out.println("\n------------- Task 3.2 end -------------");
        System.out.println();
    }
}
