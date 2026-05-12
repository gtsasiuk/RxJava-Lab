package com.example.rxjava;

import com.example.rxjava.backpressure.task6_1.DebounceDemo;
import com.example.rxjava.backpressure.task6_2.BufferDemo;
import com.example.rxjava.backpressure.task6_2.FlowableBackpressureDemo;
import com.example.rxjava.errors.task7_1.ErrorRecoveryDemo;
import com.example.rxjava.observable.task2_1.FirstObservableDemo;
import com.example.rxjava.observable.task2_2.ColdObservableDemo;
import com.example.rxjava.observable.task2_2.HotObservableDemo;
import com.example.rxjava.operators.task3_1.MapFilterDemo;
import com.example.rxjava.operators.task3_2.FlatConcatDemo;
import com.example.rxjava.operators.task3_2.FlatMapDemo;
import com.example.rxjava.paradigms.task1_1.FunctionalStyleDemo;
import com.example.rxjava.paradigms.task1_2.ParadigmsComparisonDemo;
import com.example.rxjava.schedulers.task5_1.SubscribeOnObserveOnDemo;
import com.example.rxjava.schedulers.task5_2.ParallelServiceDemo;
import com.example.rxjava.specialized.task4_1.SingleDemo;
import com.example.rxjava.specialized.task4_2.CompletableDemo;
import com.example.rxjava.specialized.task4_2.MaybeDemo;

public class Main {
    public static void main(String[] args) throws Exception {
        FunctionalStyleDemo.demonstrate();
        ParadigmsComparisonDemo.demonstrate();
        FirstObservableDemo.demonstrate();
        ColdObservableDemo.demonstrate();
        HotObservableDemo.demonstrate();
        MapFilterDemo.demonstrate();
        FlatMapDemo.demonstrate();
        FlatConcatDemo.demonstrate();
        SingleDemo.demonstrate();
        MaybeDemo.demonstrate();
        CompletableDemo.demonstrate();
        SubscribeOnObserveOnDemo.demonstrate();
        ParallelServiceDemo.demonstrate();
        DebounceDemo.demonstrate();
        BufferDemo.demonstrate();
        FlowableBackpressureDemo.demonstrate();
        ErrorRecoveryDemo.demonstrate();

    }
}
