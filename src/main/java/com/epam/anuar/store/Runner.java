package com.epam.anuar.store;

import com.epam.anuar.store.xml.builder.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Runner {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, IOException {
//        PerformFactory performFactory = new PerformFactory();
//
//        UserXmlBuilder userXmlBuilder = new UserXmlBuilder(performFactory.getUserArray());
//        userXmlBuilder.setDom(createDocument());
//        userXmlBuilder.createDOMTree();
//        userXmlBuilder.printToFile();
//
//        UserDomParser userDomParser = new UserDomParser();
//        userDomParser.parseXmlFile();
//        userDomParser.parseDocument();
//        userDomParser.printData();
//
//        UserSAXParser userSAXParser = new UserSAXParser();
//        userSAXParser.parseDocument();
//        userSAXParser.printData();
//
//        ProductXmlBuilder productXmlBuilder = new ProductXmlBuilder(performFactory.getProductArray());
//        productXmlBuilder.setDom(createDocument());
//        productXmlBuilder.createDOMTree();
//        productXmlBuilder.printToFile();
//
//        ProductDomParser productDomParser = new ProductDomParser();
//        productDomParser.parseXmlFile();
//        productDomParser.parseDocument();
//        productDomParser.printData();
//
//        ProductSAXParser productSAXParser = new ProductSAXParser();
//        productSAXParser.parseDocument();
//        productSAXParser.printData();
//
//        CartXmlBuilder cartXmlBuilder = new CartXmlBuilder(performFactory.getCartArray());
//        cartXmlBuilder.setDom(createDocument());
//        cartXmlBuilder.createDOMTree();
//        cartXmlBuilder.printToFile();
//
//        CartDomParser cartDomParser = new CartDomParser();
//        cartDomParser.parseXmlFile();
//        cartDomParser.parseDocument();
//        cartDomParser.printData();
//
//        CartSAXParser cartSAXParser = new CartSAXParser();
//        cartSAXParser.parseDocument();
//        cartSAXParser.printData();
//
//        OrderXmlBuilder orderXmlBuilder = new OrderXmlBuilder(performFactory.getOrderArray());
//        orderXmlBuilder.setDom(createDocument());
//        orderXmlBuilder.createDOMTree();
//        orderXmlBuilder.printToFile();

//        UserStAXParser userStAXParser = new UserStAXParser();
//        userStAXParser.parseSetUsers("users.xml");
//        userStAXParser.printData();
        ShipmentJAXB jaxb = new ShipmentJAXB();
        jaxb.shipmentUnmarshall();
    }
}
