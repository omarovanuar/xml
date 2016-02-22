package com.epam.anuar.storeOfMusicalInstruments.factory;

import com.epam.anuar.storeOfMusicalInstruments.model.Product;
import com.epam.anuar.storeOfMusicalInstruments.servis.Aggregate;
import com.epam.anuar.storeOfMusicalInstruments.servis.PriceCompare;
import com.epam.anuar.storeOfMusicalInstruments.servis.Search;
import org.joda.money.Money;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PerformFactory {
    private ArrayList<Product> productArray;
    private ArrayList<Product> aggregateList;
    private Money sumPrice = Money.parse("KZT 0");
    private Product searchResult;

    public void perform(){

        productArray = new ArrayList<>();

        Product product1 = new Product(53, "Acoustic Guitar Ibanez-NX-630", Money.parse("KZT 360.99"), new HashMap<>());
        Map<String, String> parameter1 = new HashMap<>();
        parameter1.put("color", "red-black");
        parameter1.put("Strings Number", "12");
        parameter1.put("Fret Number", "20");
        product1.setParameter(parameter1);
        productArray.add(product1);

        Product product2 = new Product(1, "Electroguitar Fender-Squire-MM60", Money.parse("KZT 500.65"));
        Map<String, String> parameter2 = new HashMap<>();
        parameter2.put("color", "black");
        parameter2.put("Strings Number", "6");
        parameter2.put("Fret Number", "20");
        parameter2.put("Pick-up Scheme", "H_S");
        parameter2.put("Number of tone regulators", "2");
        product2.setParameter(parameter2);
        productArray.add(product2);

        Product product3 = new Product(5, "Electro-acoustic guitar Fender SXC", Money.parse("KZT 415.48"));
        Map<String, String> parameter3 = new HashMap<>();
        parameter3.put("color", "brown");
        parameter3.put("Strings Number", "6");
        parameter3.put("Fret Number", "21");
        parameter3.put("Volume installation", "regulator");
        parameter3.put("Preamplifier", "yes");
        product3.setParameter(parameter3);
        productArray.add(product3);

        Product product4 = new Product(14, "Amplifier Samsung-SuperBass-s300", Money.parse("KZT 222.35"));
        Map<String, String> parameter4 = new HashMap<>();
        parameter4.put("Power capacity", "150V");
        parameter4.put("Guitar input", "AUX");
        parameter4.put("Dimension", "20x20x30");
        parameter4.put("Weight", "12 kg");
        product4.setParameter(parameter4);
        productArray.add(product4);

        Product product5 = new Product(3, "Effectprocessor YAMAHA-EP300", Money.parse("KZT 214.65"));
        Map<String, String> parameter5 = new HashMap<>();
        parameter5.put("Effect number", "20");
        parameter5.put("User-Program number", "10");
        parameter5.put("Tuner", "yes");
        product5.setParameter(parameter5);
        productArray.add(product5);

        Product product6 = new Product(8, "Case for Fender Squire electroguitar", Money.parse("KZT 21.3"));
        Map<String, String> parameter6 = new HashMap<>();
        parameter6.put("color", "black");
        product6.setParameter(parameter6);
        productArray.add(product6);

        Product product7 = new Product(11, "Guitar strings D'dario", Money.parse("KZT 10.5"));
        Map<String, String> parameter7 = new HashMap<>();
        parameter7.put("Diameters", "10, 11, 12, 13, 14, 15");
        parameter7.put("Material", "Silver");
        product7.setParameter(parameter7);
        productArray.add(product7);

        aggregateList = new ArrayList<>();
        Aggregate aggregate = new Aggregate(aggregateList, product1, product7, product4, product5);
        PriceCompare priceCompare = new PriceCompare();
        Collections.sort(aggregateList, priceCompare);
        sumPrice = aggregate.calculateAggregatePrice(aggregateList);

        System.out.println(aggregate + "\n");
        System.out.println("Price of aggregate: " + sumPrice + "\n");

        aggregate.addProduct(product6);
        sumPrice = aggregate.calculateAggregatePrice(aggregateList);

        System.out.println(aggregate+ "\n");
        System.out.println("Price of aggregate: " + sumPrice + "\n");

        Search search = new Search();
        searchResult = search.search(aggregateList, product1);
        System.out.println(searchResult);
    }
}
