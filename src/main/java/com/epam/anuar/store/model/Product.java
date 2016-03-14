package com.epam.anuar.store.model;

import org.joda.money.Money;

import java.util.HashMap;
import java.util.Map;

// TODO Unfinished class
public class Product extends BaseEntity{
    private String title;
    private Money price = Money.parse("KZT 0");
    private Map<String, String> parameter = new HashMap<>();
    private boolean available;
    private int count;

    public Product() {
    }

    public Product(Integer id) {
        super(id);
    }

    public Product(int id, String title, Money price, int count) {
        super(id);
        this.title = title;
        this.price = price;
        this.count = count;
        this.available = isAvailable();
    }

    public Product(int id, String title, Money price, Map<String, String> parameter, int count) {
        super(id);
        this.title = title;
        this.price = price;
        this.parameter = parameter;
        this.count = count;
        this.available = isAvailable();
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

    public boolean isAvailable() {
        return this.count > 0;
    }

    public String stringAvailable() {
        return (this.available) ?  "yes" : "no";
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

    public void addParameter(String key, String value){
        parameter.put(key, value);
    }

    public void removeParameter(String key){
        parameter.remove(key);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        if (count < 0) this.count = count;
        else this.count = 0;
    }

    @Override
    public String toString() {
        return "Product: " + title + "\n" +
                super.toString() +
                ", price: " + price +
                ", available: " + stringAvailable() + "\n" +
                parameter + "\n";
    }
}
