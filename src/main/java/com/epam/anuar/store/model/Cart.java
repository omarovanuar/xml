package com.epam.anuar.store.model;

import org.joda.money.Money;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

public class Cart extends BaseEntity {
    private List<Product> productList = new ArrayList<>();
    private DateTime executeDate;
    private Money productListPrice;

    public Cart(int id, DateTime date) {
        super(id);
        this.executeDate = date;
    }

    public Money calculateProductListPrice(){
        productListPrice = Money.parse("KZT 0");
        for (Product product : productList) {
            productListPrice = productListPrice.plus(product.getPrice());
        }
        return productListPrice;
    }

    public void addCartProduct(Product... products) {
        for (Product product : products) {
            productList.add(product);
        }
    }

    public void removeCartProduct(Product... products) {
        for (Product product : products) {
            productList.remove(product);
        }
    }

    public List<Product> getProductList() {
        return productList;
    }

    public DateTime getExecuteDate() {
        return executeDate;
    }

    public void setExecuteDate(DateTime executeDate) {
        this.executeDate = executeDate;
    }

    public Money getProductListPrice() {
        return productListPrice;
    }

    @Override
    public String toString() {
        return "Cart:\n" + super.toString() +
                ", productListPrice=" + productListPrice +
                ", executeDate=" + executeDate + "\n" +
                productList;
    }
}
