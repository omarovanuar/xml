package com.epam.anuar.storeOfMusicalInstruments.model;

import org.joda.money.Money;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.stream.Collectors;

public class Order extends BaseEntity{
    private String customerName;
    private String phoneNumber;
    private Money price;
    private String creditCard;
    private ArrayList<Product> productList = new ArrayList<>();
    private ArrayList<String> productNameList = new ArrayList<>();
    private GregorianCalendar date;

    public Order() {
    }

    public Order(int id, String customerName, String phoneNumber, String creditCard, GregorianCalendar date) {
        super(id);
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.creditCard = creditCard;
        this.date = date;
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

    public void setOrderParameters(Product... products){
        price = Money.parse("KZT 0");
        for (Product product : products) {
            productList.add(product);
            price = price.plus(product.getPrice());
            productNameList.add(product.getTitle());
        }
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customerName='" + customerName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", price=" + price +
                ", creditCard='" + creditCard + '\'' +
                ", date='" + date.getTime() + '\'' +
                ", \nproductList=" + productNameList +
                '}';
    }
}
