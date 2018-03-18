package com.test.reactive.maker;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author yanji.lz
 * @since 09/03/2018
 */
public class EagAdder {
    public static int make(){
        try {
            Thread.sleep(1000L);
            System.out.println("add an eag on pie");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return 1;
    }

    public static int makeAfter(Future<Integer> pieMakerFuture){
        try {

            pieMakerFuture.get();

            make();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return 1;
    }

    public static int make(int i){
        return make();
    }


}
