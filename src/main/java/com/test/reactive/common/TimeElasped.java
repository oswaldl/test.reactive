package com.test.reactive.common;

import java.util.function.Consumer;

/**
 * @author yanji.lz
 * @since 08/03/2018
 */
public class TimeElasped {
    public static void run(Consumer<Integer> consumer){
        long start = System.currentTimeMillis();
        System.out.println("-----------------start-----------------");
        consumer.accept(1);
        System.out.println("-----------------done:"+(System.currentTimeMillis()-start));
    }
}
