package com.epam.anuar.store.xml.parser;

import com.epam.anuar.store.Runner;
import com.epam.anuar.store.factory.PerformFactory;
import com.epam.anuar.store.model.Cart;
import com.epam.anuar.store.model.Product;
import org.joda.money.Money;
import org.joda.time.DateTime;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class CartSAXParser extends DefaultHandler{
    private String tempVal;
    private String tempProductId;
    private Cart tempCart;
    private List<Cart> carts = new ArrayList<>();


    public void parseDocument() {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {
            SAXParser sp = spf.newSAXParser();
            sp.parse(Runner.class.getClassLoader().getResourceAsStream("carts.xml"), this);
        } catch (SAXException | ParserConfigurationException | IOException se) {
            se.printStackTrace();
        }
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        tempVal = "";
        if(qName.equalsIgnoreCase("cart")) {
            tempCart = new Cart();
        } else if (qName.equalsIgnoreCase("product")) {
            tempProductId = attributes.getValue("id");
        }
    }


    public void characters(char[] ch, int start, int length) throws SAXException {
        tempVal = new String(ch, start, length);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName){
            case "cart":
                tempCart.calculateProductListPrice();
                carts.add(tempCart);
                break;
            case "id":
                tempCart.setId(Integer.parseInt(tempVal));
                break;
            case "createDate":
                tempCart.setCreateDate(DateTime.parse(tempVal));
                break;
            case "product":
                Method method;
                Product product = null;
                try {
                    method = PerformFactory.class.getMethod("getProductById", Integer.class);
                    product = (Product) method.invoke(new PerformFactory(), Integer.parseInt(tempProductId));
                } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                    e.printStackTrace();
                }
                tempCart.addCartProduct(product);
                break;
        }

    }

    public void printData(){
        for (Cart cart : carts) {
            System.out.println(cart.toString());
        }
    }

    public List getCarts() {
        return carts;
    }
}
