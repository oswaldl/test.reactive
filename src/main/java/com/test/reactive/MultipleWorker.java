package com.test.reactive;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import com.test.reactive.maker.EagAdder;
import com.test.reactive.maker.HotDogMaker;
import com.test.reactive.maker.PackageMaker;
import com.test.reactive.maker.PieMaker;
import com.test.reactive.maker.VegatableMaker;

/**
 * @author yanji.lz
 * @since 09/03/2018
 */
public class MultipleWorker {
    public static ExecutorService executorService = Executors.newFixedThreadPool(4);

    public void make(int number){
        for(int i=0; i<number; i++){
            makeOne();
        }
    }

    private void makeOne() {

        Future<Integer> pieMakerFuture = executorService.submit(PieMaker::make);

        Future<Integer> eagMakerFuture = executorService.submit(()-> EagAdder.makeAfter(pieMakerFuture)
        );

        Future<Integer> vegatableMakerFuture = executorService.submit(VegatableMaker::make);

        Future<Integer> hotDogMakerFuture = executorService.submit(HotDogMaker::make);

        Future<Integer> packageMakerFuture = executorService.submit(()-> PackageMaker
            .makeAfter(eagMakerFuture, vegatableMakerFuture, hotDogMakerFuture)
        );

        try {
            packageMakerFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();

        try {
            while (!executorService.awaitTermination(1, TimeUnit.SECONDS)) {
                System.out.println("线程池没有关闭");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("线程池已经关闭");

        System.out.println("make one wonderfull pie-eag-vegatable-hotdog food!!!!!");
    }

}
