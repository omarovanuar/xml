package com.epam.anuar.storeOfMusicalInstruments.model;

import org.joda.money.Money;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Order extends BaseEntity{
    private String customerName;
    private String phoneNumber;
    private Money price;
    private String creditCard;
    private ArrayList<Product> productList;
    private GregorianCalendar date;

    public Order() {
    }

    public Order(int id, String customerName, String phoneNumber, Money price, String creditCard, GregorianCalendar date,
                 ArrayList<Product> productList) {
        super(id);
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.price = price;
        this.creditCard = creditCard;
        this.date = date;
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customerName='" + customerName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", price=" + price +
                ", creditCard='" + creditCard + '\'' +
                ", date='" + date.getTime() + '\'' +
                ", \nproductList=" + productList +
                '}';
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }
}
