package com.test.reactive.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author yanji.lz
 * @since 08/03/2018
 */
public class SomeObject {
    public List<Double> calculateOnShipments(List<Shipment> shipments, Function<Shipment, Double> function){
        List<Double> results = new ArrayList<>();
        for(Shipment s : shipments) {
          results.add(function.apply(s));
        }
        return results;

    }

    public static void main(String[] args) {
        List<Shipment> l = new ArrayList<Shipment>();


        SomeObject someObject = new SomeObject();
        // Using an anonymous class
        List<Double> result = someObject.calculateOnShipments(l, Shipment::calculateWeight);

        System.out.println(result);



        //TriFunction<Sum, String, String, Integer> anon =
        //  new TriFunction<Sum, String, String, Integer>() {
        //    @Override
        //    public Integer apply(Sum s, String arg1, String arg2) {
        //      return s.doSum(arg1, arg1);
        //    }
        //};
        //System.out.println(anon.apply(new Sum(), "1", "4"));


    }
}
