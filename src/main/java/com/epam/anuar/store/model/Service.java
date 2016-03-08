package com.epam.anuar.store.model;

import java.util.Comparator;
import java.util.List;

public class Service {

    public static final Comparator<Product> PRODUCT_PRICE_COMPARATOR = (o1, o2) -> o1.getPrice().compareTo(o2.getPrice());
    public static final Comparator<Order> ORDER_PRICE_COMPARATOR = (o1, o2) -> o1.getProductListPrice().compareTo(o2.getProductListPrice());
    public static final Comparator<Product> PRODUCT_TITLE_COMPARATOR = (o1, o2) -> o1.getTitle().compareTo(o2.getTitle());

    public static Product search(List<Product> arrayList, Product product){
        Product result = new Product();
        for (Product o : arrayList) {
            if (o.equals(product)){
                result = o;
            }
        }
        return result;
    }
}
