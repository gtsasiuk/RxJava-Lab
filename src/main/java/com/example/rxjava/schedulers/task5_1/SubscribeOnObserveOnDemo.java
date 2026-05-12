package com.example.rxjava.schedulers.task5_1;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SubscribeOnObserveOnDemo {
    public static void demonstrate() throws InterruptedException {
        System.out.println("------------- Task 5.1 begin -------------");
        Observable<String> images = Observable.just("photo_1.jpg", "photo_2.jpg", "photo_3.jpg");

        images.subscribeOn(Schedulers.io())
                .map(SubscribeOnObserveOnDemo::downloadImage)
                .observeOn(Schedulers.computation())
                .map(SubscribeOnObserveOnDemo::compressImage)
                .observeOn(Schedulers.trampoline())
                .subscribe(SubscribeOnObserveOnDemo::displayImage,
                        error -> System.out.println("(-) Помилка: " + error.getMessage()));

        Thread.sleep(5000);

        System.out.println("------------- Task 5.1 end -------------");
        System.out.println();
    }

    private static String downloadImage(String image) throws InterruptedException {
        System.out.println("[" + Thread.currentThread().getName() + "] " + "[ЗАВАНТ] Завантаження: " + image
        );
        Thread.sleep(1000);

        return image;
    }

    private static String compressImage(String image) throws InterruptedException {
        System.out.println("[" + Thread.currentThread().getName() + "] " + "[СТИСК] Стиснення: " + image);
        Thread.sleep(500);

        return image;
    }

    private static void displayImage(String image) {
        System.out.println("[" + Thread.currentThread().getName() + "] " + "[ФОТО] Відображення: " + image);
    }
}
