package com.test.reactive;

import com.test.reactive.common.TimeElasped;
import lombok.val;

/**
 * @author yanji.lz
 * @since 08/03/2018
 */
public class Main {

    public static void main(String[] args) {
        SingleWorker singleWorker = new SingleWorker();
        TimeElasped.run(singleWorker::make);

        MultipleWorker multipleWorker = new MultipleWorker();
        TimeElasped.run(multipleWorker::make);

        MultipleWorkerNewer multipleWorkerNewer = new MultipleWorkerNewer();
        TimeElasped.run(multipleWorkerNewer::make);

        val 煎饼侠fucture;
    }

}
