package com.epam.anuar.storeOfMusicalInstruments.model;

import org.joda.money.Money;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Accounting extends BaseEntity {
    private ArrayList<Product> soldProductList = new ArrayList<>();
    private GregorianCalendar date;
    private Money resultPrice;

    public Accounting(int id,  GregorianCalendar date) {
        super(id);
        this.date = date;
    }

    public Money priceSum(){
        resultPrice = Money.parse("KZT 0");
        for (Product product : soldProductList) {
            resultPrice = resultPrice.plus(product.getPrice());
        }
        return resultPrice;
    }

    public void addSoldProduct(Order... orders) {
        for (Order order : orders) {
            soldProductList.addAll(order.getProductList());
        }
    }

    public ArrayList<Product> getSoldProductList() {
        return soldProductList;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public Money getResultPrice() {
        return resultPrice;
    }

    public void setResultPrice(Money resultPrice) {
        this.resultPrice = resultPrice;
    }

    @Override
    public String toString() {
        return "Accounting:\n" + super.toString() +
                ", resultPrice=" + resultPrice +
                ", date=" + date.getTime() + "\n" +
                soldProductList;
    }
}
