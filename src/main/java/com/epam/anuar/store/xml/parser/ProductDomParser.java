package com.epam.anuar.store.xml.parser;

import com.epam.anuar.store.Runner;
import com.epam.anuar.store.model.Product;
import org.joda.money.Money;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDomParser {
    private Document dom;
    private List<Product> products = new ArrayList<>();

    public void parseXmlFile(){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.parse(Runner.class.getClassLoader().getResourceAsStream("products.xml"));
        }catch(ParserConfigurationException | SAXException | IOException pce) {
            pce.printStackTrace();
        }
    }

    public void parseDocument(){
        Element docEle = dom.getDocumentElement();

        NodeList nl = docEle.getElementsByTagName("Product");
        if(nl != null && nl.getLength() > 0) {
            for(int i = 0 ; i < nl.getLength();i++) {
                Element el = (Element)nl.item(i);
                Product e = getProduct(el);
                products.add(e);
            }
        }
    }

    private Product getProduct(Element empEl) {

        int id = getIntValue(empEl, "id");
        String title = getTextValue(empEl, "title");
        Money price = getMoneyValue(empEl, "price");
        int count = getIntValue(empEl, "count");
        Map parameter = getMapValue(empEl, "parameter");


        Product e = new Product(id, title, price, parameter, count);

        return e;
    }

    private String getTextValue(Element ele, String tagName) {
        String textVal = null;
        NodeList nl = ele.getElementsByTagName(tagName);
        if(nl != null && nl.getLength() > 0) {
            Element el = (Element)nl.item(0);
            textVal = el.getFirstChild().getNodeValue();
        }

        return textVal;
    }

    private Map getMapValue(Element ele, String tagName) {
        Map<String, String> parameter = new HashMap<>();
        String key, value;

        NodeList nl1 = ele.getElementsByTagName(tagName);
        Element el1 = (Element)nl1.item(0);
        NodeList nl2 = el1.getElementsByTagName("color");
        for (int i = 0; i < nl1.getLength(); i++) {
            Element el2 = (Element)nl2.item(i);
            key = el2.getTagName();
            value = el2.getFirstChild().getNodeValue();
            parameter.put(key, value);
        }
        return parameter;
    }


    private Integer getIntValue(Element ele, String tagName) {
        return Integer.parseInt(getTextValue(ele,tagName));
    }

    private Money getMoneyValue(Element ele, String tagName) {
        return Money.parse(getTextValue(ele, tagName));
    }

    public void printData(){
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    public List<Product> getProducts() {
        return products;
    }
}
