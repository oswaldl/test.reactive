package com.test.reactive;

import com.test.reactive.maker.EagAdder;
import com.test.reactive.maker.HotDogMaker;
import com.test.reactive.maker.PackageMaker;
import com.test.reactive.maker.PieMaker;
import com.test.reactive.maker.VegatableMaker;

/**
 * @author yanji.lz
 * @since 09/03/2018
 */
public class SingleWorker {
    public void make(int number){
        for(int i=0; i<number; i++){
            makeOne();
        }
    }

    private void makeOne() {
        PieMaker.make();
        EagAdder.make();
        VegatableMaker.make();
        HotDogMaker.make();
        PackageMaker.make();
        System.out.println("make one wonderfull pie-eag-vegatable-hotdog food!!!!!");
    }
}
