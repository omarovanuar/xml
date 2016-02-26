package com.epam.anuar.storeOfMusicalInstruments.servis;

import com.epam.anuar.storeOfMusicalInstruments.model.BaseEntity;
import com.epam.anuar.storeOfMusicalInstruments.model.Product;
import org.joda.money.Money;

import java.util.ArrayList;
import java.util.Collections;

public class Aggregate {
    private ArrayList aggregateArray = new ArrayList();

    public Money calculateAggregatePrice(ArrayList<Product> aggregateArray){
        Money sumPrice = Money.parse("KZT 0");
        for (Product o : aggregateArray) {
            sumPrice = sumPrice.plus(o.getPrice());
        }
        return sumPrice;
    }

    public void addProduct(BaseEntity... args){
        Collections.addAll(this.aggregateArray, args);
    }

    public void removeProduct(BaseEntity... args){
        for (BaseEntity arg : args) {
            this.aggregateArray.remove(arg);
        }
    }

    public ArrayList getAggregateArray() {
        return aggregateArray;
    }

    @Override
    public String toString() {
        return "Aggregate{" +
                "\n" + this.aggregateArray +
                '}';
    }
}