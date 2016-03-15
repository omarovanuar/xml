package com.epam.anuar.store.xml.parser;

import com.epam.anuar.store.Runner;
import com.epam.anuar.store.model.Product;
import com.epam.anuar.store.model.User;
import org.joda.money.Money;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductSAXParser extends DefaultHandler {
    private String tempVal;
    private Product tempProduct;
    private List<Product> products = new ArrayList<>();


    public void parseDocument() {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {
            SAXParser sp = spf.newSAXParser();
            sp.parse(Runner.class.getClassLoader().getResourceAsStream("products.xml"), this);
        } catch (SAXException | ParserConfigurationException | IOException se) {
            se.printStackTrace();
        }
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        tempVal = "";
        if(qName.equalsIgnoreCase("product")) {
            tempProduct = new Product();
        }
    }


    public void characters(char[] ch, int start, int length) throws SAXException {
        tempVal = new String(ch, start, length);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName){
            case "product":
                products.add(tempProduct);
                break;
            case "id":
                tempProduct.setId(Integer.parseInt(tempVal));
                break;
            case "title":
                tempProduct.setTitle(tempVal);
                break;
            case "price":
                tempProduct.setPrice(Money.parse(tempVal));
                break;
            case "count":
                tempProduct.setCount(Integer.parseInt(tempVal));
                break;
            case "parameter":
                tempProduct.addParameter(tempVal, tempVal);
                break;
        }

    }

    public void printData(){
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    public List getProducts() {
        return products;
    }

}
