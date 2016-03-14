package com.epam.anuar.store;

import com.epam.anuar.store.xml.creator.UserXmlCreator;
import com.epam.anuar.store.xml.parser.UserSAXParser;

public class Runner {
    public static void main(String[] args) {
//        PerformFactory performFactory = new PerformFactory();
//        performFactory.perform();

//        UserDomParser udp = new UserDomParser();
//        udp.parseXmlFile();
//        udp.parseDocument();
//        udp.printData();
//
//        UserXmlCreator udc = new UserXmlCreator(udp.getUsers());
//        udc.createDocument();
//        udc.createDOMTree();
//        udc.printToFile();

        UserSAXParser userSAXParser = new UserSAXParser();
        userSAXParser.parseDocument();
        userSAXParser.printData();

        UserXmlCreator udc = new UserXmlCreator(userSAXParser.getMyEmpls());
        udc.createDocument();
        udc.createDOMTree();
        udc.printToFile();

    }
}
