package com.epam.anuar.store.model;

import org.joda.money.Money;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

public class Order extends BaseEntity{
    private String customerName;
    private String phoneNumber;
    private Money productListPrice;
    private String creditCard;
    private List<Product> productList = new ArrayList<>();
    private DateTime executeDate;

    public Order() {
    }

    public Order(int id, User user, String creditCard, Cart cart) {
        super(id);
        this.customerName = user.getName();
        this.phoneNumber = user.getPhoneNumber();
        this.creditCard = creditCard;
        this.executeDate = cart.getExecuteDate();
        this.productList = cart.getProductList();
        this.productListPrice = cart.getProductListPrice();
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Money getProductListPrice() {
        return productListPrice;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public DateTime getExecuteDate() {
        return executeDate;
    }

    public String productNameList(){
        String name = "";
        for (Product product : productList) {
            name += (product.getTitle() + "\n");
        }
        return name;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customerName='" + customerName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", productListPrice=" + productListPrice +
                ", creditCard='" + creditCard + '\'' +
                ", executeDate='" + executeDate + '\'' +
                "\n" + productNameList() + '}';
    }
}
