package com.epam.anuar.storeOfMusicalInstruments.model;

import org.joda.money.Money;

import java.util.HashMap;
import java.util.Map;

public class Product extends BaseEntity{
    private String title;
    private Money price = Money.parse("KZT 0");
    private Map<String, String> parameter = new HashMap<>();

    public Product() {
    }

    public Product(int id) {
        super(id);
    }

    public Product(int id, String title, Money price) {
        super(id);
        this.title = title;
        this.price = price;
    }

    public Product(int id, String title, Money price, Map<String, String> parameter) {
        super(id);
        this.title = title;
        this.price = price;
        this.parameter = parameter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Product product = (Product) o;

        if (title != null ? !title.equals(product.title) : product.title != null) return false;
        if (price != null ? !price.equals(product.price) : product.price != null) return false;
        return parameter != null ? parameter.equals(product.parameter) : product.parameter == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (parameter != null ? parameter.hashCode() : 0);
        return result;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }

    public Map<String, String> getParameter() {
        return parameter;
    }

    public void setParameter(Map<String, String> parameter) {
        this.parameter = parameter;
    }

    @Override
    public String toString() {
        return "Product: " + title + "\n" +
                super.toString() +
                ", price: " + price + "\n" +
                parameter + "\n";
    }
}
