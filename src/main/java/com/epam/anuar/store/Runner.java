package com.epam.anuar.store;

import com.epam.anuar.store.factory.PerformFactory;
import com.epam.anuar.store.xml.creator.ProductXmlBuilder;

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
//        UserXmlBuilder udc1 = new UserXmlBuilder(userSAXParser.getUsers());
//        udc.createDocument();
//        udc.createDOMTree();
//        udc.printToFile();

//        ProductDomParser pdp = new ProductDomParser();
//        pdp.parseXmlFile();
//        pdp.parseDocument();
//        pdp.printData();

        ProductXmlBuilder productXmlCreator = new ProductXmlBuilder(performFactory.productArray);
        productXmlCreator.createDocument();
        productXmlCreator.createDOMTree();
        productXmlCreator.printToFile();
    }
}
