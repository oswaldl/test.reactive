package com.test.reactive.maker;

/**
 * @author yanji.lz
 * @since 09/03/2018
 */
public class VegatableMaker {
    public static int make(){
        try {
            Thread.sleep(1000L);
            System.out.println("make vegtatble");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return 1;
    }
}
