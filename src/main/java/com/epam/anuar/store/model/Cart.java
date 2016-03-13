package com.epam.anuar.store.model;

import org.joda.money.Money;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;

public class Cart extends BaseEntity {
    private List<Product> productList = new ArrayList<>();
    private DateTime createDate;
    private Money productListPrice;

    public Cart() {
    }

    public Cart(int id, DateTime createDate) {
        super(id);
        this.createDate = createDate;
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

    public DateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(DateTime createDate) {
        this.createDate = createDate;
    }

    public Money getProductListPrice() {
        return productListPrice;
    }

    @Override
    public String toString() {
        return "Cart:\n" + super.toString() +
                ", productListPrice=" + productListPrice +
                ", createDate=" + createDate + "\n" +
                productList;
    }
}
