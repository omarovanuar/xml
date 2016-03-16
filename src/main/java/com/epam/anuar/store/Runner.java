package com.epam.anuar.store;

import com.epam.anuar.store.factory.PerformFactory;
import com.epam.anuar.store.xml.creator.CartXmlBuilder;
import com.epam.anuar.store.xml.creator.ProductXmlBuilder;
import com.epam.anuar.store.xml.creator.UserXmlBuilder;

import static com.epam.anuar.store.xml.creator.XmlBuilderService.*;

public class Runner {
    public static void main(String[] args) {
        PerformFactory performFactory = new PerformFactory();
        performFactory.perform();

//        UserDomParser udp = new UserDomParser();
//        udp.parseXmlFile();
//        udp.parseDocument();
//        udp.printData();
//
//        UserXmlBuilder udc = new UserXmlBuilder(udp.getUsers());
//        udc.createDocument();
//        udc.createDOMTree();
//        udc.printToFile();
//
//        UserSAXParser userSAXParser = new UserSAXParser();
//        userSAXParser.parseDocument();
//        userSAXParser.printData();
//
//        UserXmlBuilder udc = new UserXmlBuilder(performFactory.getUserArray());
//        udc.setDom(createDocument());
//        udc.createDOMTree();
//        udc.printToFile();

//        ProductDomParser pdp = new ProductDomParser();
//        pdp.parseXmlFile();
//        pdp.parseDocument();
//        pdp.printData();

//        ProductSAXParser productSAXParser = new ProductSAXParser();
//        productSAXParser.parseDocument();
//        productSAXParser.printData();

//        ProductXmlBuilder productXmlBuilder = new ProductXmlBuilder(performFactory.getProductArray());
//        productXmlBuilder.setDom(createDocument());
//        productXmlBuilder.createDOMTree();
//        productXmlBuilder.printToFile();

        CartXmlBuilder cartXmlBuilder = new CartXmlBuilder(performFactory.getCartArray());
        cartXmlBuilder.setDom(createDocument());
        cartXmlBuilder.createDOMTree();
        cartXmlBuilder.printToFile();

    }
}
