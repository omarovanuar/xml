package com.epam.anuar.store.xml.creator;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class XmlBuilderService {

    public static Document createDocument() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch(ParserConfigurationException pce) {
            System.out.println("Error while trying to instantiate DocumentBuilder " + pce);
            System.exit(1);
        }
        Document dom = db.newDocument();
        return dom;
    }
}
