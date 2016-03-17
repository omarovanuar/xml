package com.epam.anuar.store;

import com.epam.anuar.store.factory.PerformFactory;
import com.epam.anuar.store.xml.builder.CartXmlBuilder;
import com.epam.anuar.store.xml.builder.ProductXmlBuilder;
import com.epam.anuar.store.xml.builder.UserXmlBuilder;
import com.epam.anuar.store.xml.parser.*;

import java.lang.reflect.InvocationTargetException;

import static com.epam.anuar.store.xml.builder.XmlBuilderService.*;

public class Runner {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        PerformFactory performFactory = new PerformFactory();

        UserXmlBuilder udc = new UserXmlBuilder(performFactory.getUserArray());
        udc.setDom(createDocument());
        udc.createDOMTree();
        udc.printToFile();

        UserDomParser udp = new UserDomParser();
        udp.parseXmlFile();
        udp.parseDocument();
        udp.printData();

        UserSAXParser userSAXParser = new UserSAXParser();
        userSAXParser.parseDocument();
        userSAXParser.printData();

        ProductXmlBuilder productXmlBuilder = new ProductXmlBuilder(performFactory.getProductArray());
        productXmlBuilder.setDom(createDocument());
        productXmlBuilder.createDOMTree();
        productXmlBuilder.printToFile();

        ProductDomParser pdp = new ProductDomParser();
        pdp.parseXmlFile();
        pdp.parseDocument();
        pdp.printData();

        ProductSAXParser productSAXParser = new ProductSAXParser();
        productSAXParser.parseDocument();
        productSAXParser.printData();

        CartXmlBuilder cartXmlBuilder = new CartXmlBuilder(performFactory.getCartArray());
        cartXmlBuilder.setDom(createDocument());
        cartXmlBuilder.createDOMTree();
        cartXmlBuilder.printToFile();

        CartDomParser cartDomParser = new CartDomParser();
        cartDomParser.parseXmlFile();
        cartDomParser.parseDocument();
        cartDomParser.printData();

        CartSAXParser cartSAXParser = new CartSAXParser();
        cartSAXParser.parseDocument();
        cartSAXParser.printData();
    }
}
