package com.epam.anuar.store;

import com.epam.anuar.store.xml.dom.creator.UserDomCreator;
import com.epam.anuar.store.xml.dom.parser.UserDomParser;
import com.epam.anuar.store.xml.sax.parser.UserSAXParser;

public class Runner {
    public static void main(String[] args) {
//        PerformFactory performFactory = new PerformFactory();
//        performFactory.perform();

        UserDomParser udp = new UserDomParser();
        udp.parseXmlFile();
        udp.parseDocument();
        udp.printData();

        UserDomCreator udc = new UserDomCreator(udp.getMyEmpls());
        udc.createDocument();
        udc.createDOMTree();
        udc.printToFile();

        UserSAXParser userSAXParser = new UserSAXParser();
        userSAXParser.parseDocument();
        userSAXParser.printData();
    }
}
