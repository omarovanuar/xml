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
    private List<String> param = new ArrayList<>();
    private Product tempProduct;
    private List<Product> products = new ArrayList<>();
    private boolean flag = false;


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
        } else if (flag) {
            param.add(qName);
        } else if(qName.equalsIgnoreCase("parameter")) {
            flag = true;
        }
    }


    public void characters(char[] ch, int start, int length) throws SAXException {
        tempVal = new String(ch, start, length);
        if (flag && tempVal.matches("(\\w)(.)*")) {
            param.add(tempVal);
        }

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
                for (int i = 0; i < param.size()-1; i+=2) {
                    tempProduct.addParameter(param.get(i), param.get(i+1));
                }
                flag = false;
                System.out.println(param);
                param = new ArrayList<>();
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
