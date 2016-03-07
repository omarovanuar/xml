package com.epam.anuar.store.model;

import org.joda.money.Money;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order extends BaseEntity{
    private String customerName;
    private String phoneNumber;
    private Money price;
    private String creditCard;
    private List<Product> productList = new ArrayList<>();
    private DateTime executeTime;

    public Order() {
    }

    public Order(int id, User user, String creditCard, DateTime executeTime) {
        super(id);
        this.customerName = user.getName();
        this.phoneNumber = user.getPhoneNumber();
        this.creditCard = creditCard;
        this.executeTime = executeTime;
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

    public DateTime getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(DateTime executeTime) {
        this.executeTime = executeTime;
    }

    public void addParameters(Product... products){
        Collections.addAll(productList, products);
    }

    public void calculatePrice() {
        price = Money.parse("KZT 0");
        for (Product product : productList) {
            price = price.plus(product.getPrice());
        }
    }

    public void removeParameters(Product... products) {
        for (Product product : products) {
            productList.remove(product);
        }
    }

    public String productNameList(){
        String name = "";
        for (Product product : productList) {
            name += (product.getTitle() + "\n");
        }
        return name;
    }

    public List<Product> getProductList() {
        return productList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customerName='" + customerName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", price=" + price +
                ", creditCard='" + creditCard + '\'' +
                ", executeTime='" + executeTime + '\'' +
                "\n" + productNameList() + '}';
    }
}
