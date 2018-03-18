package com.test.reactive.maker;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author yanji.lz
 * @since 09/03/2018
 */
public class PackageMaker {
    public static int make(){
        try {
            Thread.sleep(1000L);
            System.out.println("package them all together");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return 1;
    }

    public static int makeAfter(Future<Integer>... futures){
        try {
            for(Future <Integer>future: futures){
                future.get();
            }
            make();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return 1;
    }

    public static void makeFlow(){
        make();

        //return "";
    }

    public static <U> U makeFlow(Void aVoid) {
        make();
        return null;
    }
}
