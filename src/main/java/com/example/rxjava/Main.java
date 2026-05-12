package com.example.rxjava;

import com.example.rxjava.observable.task2_1.FirstObservableDemo;
import com.example.rxjava.observable.task2_2.ColdObservableDemo;
import com.example.rxjava.observable.task2_2.HotObservableDemo;
import com.example.rxjava.operators.task3_1.MapFilterDemo;
import com.example.rxjava.paradigms.task1_1.FunctionalStyleDemo;
import com.example.rxjava.paradigms.task1_2.ParadigmsComparisonDemo;

public class Main {
    public static void main(String[] args) throws Exception {
        FunctionalStyleDemo.demonstrate();
        ParadigmsComparisonDemo.demonstrate();
        FirstObservableDemo.demonstrate();
        ColdObservableDemo.demonstrate();
        HotObservableDemo.demonstrate();
        MapFilterDemo.demonstrate();
    }
}
