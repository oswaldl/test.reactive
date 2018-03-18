package com.test.reactive;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.test.reactive.maker.EagAdder;
import com.test.reactive.maker.HotDogMaker;
import com.test.reactive.maker.PackageMaker;
import com.test.reactive.maker.PieMaker;
import com.test.reactive.maker.VegatableMaker;

/**
 * @author yanji.lz
 * @since 09/03/2018
 */
public class MultipleWorkerNewer {

    public void make(int number){
        for(int i=0; i<number; i++){
            makeOne();
        }
    }

    private void makeOne() {

        CompletableFuture<Integer> pieMakerFuture = CompletableFuture.supplyAsync(PieMaker::make);

        CompletableFuture eagMakerFuture = pieMakerFuture.thenAcceptAsync(EagAdder::make);

        CompletableFuture<Integer> vegatableMakerFuture = CompletableFuture.supplyAsync(VegatableMaker::make);

        CompletableFuture<Integer> hotDogMakerFuture = CompletableFuture.supplyAsync(HotDogMaker::make);

        CompletableFuture<Void> packageMakerFuture =
            CompletableFuture.allOf(eagMakerFuture, vegatableMakerFuture, hotDogMakerFuture).thenRun(PackageMaker::make);

        try {
            packageMakerFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("make one wonderfull pie-eag-vegatable-hotdog food!!!!!");
    }

}
