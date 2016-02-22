package com.epam.anuar.storeOfMusicalInstruments.model;

import org.joda.money.Money;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Accounting extends BaseEntity {
    private ArrayList<Product> soldProduct;
    private GregorianCalendar date;
    private int orderNumber;
    private Money resultPrice = Money.parse("KZT 0");

    public Accounting(int id, ArrayList<Product> soldProduct, GregorianCalendar date, int orderNumber) {
        super(id);
        this.soldProduct = soldProduct;
        this.date = date;
        this.orderNumber = orderNumber;
    }

    public Money priceSum(ArrayList<Product> soldProduct){
        this.soldProduct = soldProduct;
        for (Product product : soldProduct) {
            resultPrice = resultPrice.plus(product.getPrice());
        }
        return resultPrice;
    }

    @Override
    public String toString() {
        return "Accounting:\n" + super.toString() + "\n" +
                soldProduct +
                ", date=" + date.getTime() +
                ", orderNumber=" + orderNumber +
                ", resultPrice=" + resultPrice;
    }

    public ArrayList<Product> getSoldProduct() {
        return soldProduct;
    }

    public void setSoldProduct(ArrayList<Product> soldProduct) {
        this.soldProduct = soldProduct;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Money getResultPrice() {
        return resultPrice;
    }

    public void setResultPrice(Money resultPrice) {
        this.resultPrice = resultPrice;
    }
}
