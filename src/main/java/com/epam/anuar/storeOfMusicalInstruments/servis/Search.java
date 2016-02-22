package com.epam.anuar.storeOfMusicalInstruments.servis;

import com.epam.anuar.storeOfMusicalInstruments.model.Product;

import java.util.ArrayList;

public class Search {
    public Product search(ArrayList<Product> arrayList, Product product){
        Product result = new Product();
        for (Product o : arrayList) {
            if (o.equals(product)){
                result = o;
            }
        }
        return result;
    }
}
