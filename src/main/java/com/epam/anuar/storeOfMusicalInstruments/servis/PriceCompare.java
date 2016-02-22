package com.epam.anuar.storeOfMusicalInstruments.servis;

import com.epam.anuar.storeOfMusicalInstruments.model.Product;
import org.joda.money.Money;

import java.util.Comparator;

public class PriceCompare implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        Product product1 = (Product) o1;
        Product product2 = (Product) o2;
        Money price1 = product1.getPrice();
        Money price2 = product2.getPrice();
        price1.minus(price2);
        return price1.minus(price2).getAmountMajorInt();
    }
}
