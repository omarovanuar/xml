package com.epam.anuar.store.xml.parser;

import com.epam.anuar.store.Runner;
import com.epam.anuar.store.factory.PerformFactory;
import com.epam.anuar.store.model.Cart;
import com.epam.anuar.store.model.Product;
import org.joda.money.Money;
import org.joda.time.DateTime;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class CartDomParser {
    private Document dom;
    private List<Cart> carts = new ArrayList<>();

    public void parseXmlFile(){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.parse(Runner.class.getClassLoader().getResourceAsStream("carts.xml"));
        }catch(ParserConfigurationException | SAXException | IOException pce) {
            pce.printStackTrace();
        }
    }

    public void parseDocument() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Element docEle = dom.getDocumentElement();

        NodeList nl = docEle.getElementsByTagName("cart");
        if(nl != null && nl.getLength() > 0) {
            for(int i = 0 ; i < nl.getLength();i++) {
                Element el = (Element)nl.item(i);
                Cart e = getCart(el);
                carts.add(e);
            }
        }
    }

    private Cart getCart(Element empEl) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        int id = getIntValue(empEl, "id");
        DateTime createDate = getDateTimeValue(empEl, "createDate");

        Cart e = new Cart(id, createDate);
        getProductList(e, empEl);
        e.calculateProductListPrice();

        return e;
    }

    private void getProductList(Cart e, Element empEl) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        NodeList productListNL = empEl.getChildNodes().item(5).getChildNodes();
        for (int i = 1; i < productListNL.getLength(); i+=2) {
            Element productEl = (Element) productListNL.item(i);
            String id = productEl.getAttribute("id");

            Method method = PerformFactory.class.getMethod("getProductById", Integer.class);
            Product product = (Product) method.invoke(new PerformFactory(), Integer.parseInt(id));
            e.addCartProduct(product);

        }
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

    private Integer getIntValue(Element ele, String tagName) {
        return Integer.parseInt(getTextValue(ele,tagName));
    }


    private Money getMoneyValue(Element ele, String tagName) {
        return Money.parse(getTextValue(ele, tagName));
    }

    private DateTime getDateTimeValue(Element ele, String tagName) {
        return DateTime.parse(getTextValue(ele, tagName));
    }

    public void printData(){
        for (Cart cart : carts) {
            System.out.println(cart.toString());
        }
    }

    public List<Cart> getCarts() {
        return carts;
    }
}
