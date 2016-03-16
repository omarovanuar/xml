package com.epam.anuar.store;

import com.epam.anuar.store.factory.PerformFactory;
import com.epam.anuar.store.xml.builder.CartXmlBuilder;
import com.epam.anuar.store.xml.builder.ProductXmlBuilder;
import com.epam.anuar.store.xml.builder.UserXmlBuilder;
import com.epam.anuar.store.xml.parser.ProductDomParser;
import com.epam.anuar.store.xml.parser.UserDomParser;

import static com.epam.anuar.store.xml.builder.XmlBuilderService.*;

public class Runner {
    public static void main(String[] args) {
        PerformFactory performFactory = new PerformFactory();
        performFactory.perform();

        UserDomParser udp = new UserDomParser();
        udp.parseXmlFile();
        udp.parseDocument();
        udp.printData();

//        UserSAXParser userSAXParser = new UserSAXParser();
//        userSAXParser.parseDocument();
//        userSAXParser.printData();

        UserXmlBuilder udc = new UserXmlBuilder(performFactory.getUserArray());
        udc.setDom(createDocument());
        udc.createDOMTree();
        udc.printToFile();

        ProductDomParser pdp = new ProductDomParser();
        pdp.parseXmlFile();
        pdp.parseDocument();
        pdp.printData();

//        ProductSAXParser productSAXParser = new ProductSAXParser();
//        productSAXParser.parseDocument();
//        productSAXParser.printData();

        ProductXmlBuilder productXmlBuilder = new ProductXmlBuilder(performFactory.getProductArray());
        productXmlBuilder.setDom(createDocument());
        productXmlBuilder.createDOMTree();
        productXmlBuilder.printToFile();

        CartXmlBuilder cartXmlBuilder = new CartXmlBuilder(performFactory.getCartArray());
        cartXmlBuilder.setDom(createDocument());
        cartXmlBuilder.createDOMTree();
        cartXmlBuilder.printToFile();

    }
}
