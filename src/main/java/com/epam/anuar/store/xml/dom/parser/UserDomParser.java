package com.epam.anuar.store.xml.dom.parser;

import com.epam.anuar.store.Runner;
import com.epam.anuar.store.model.User;
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
import java.util.List;

public class UserDomParser {
    private Document dom;
    private List<User> myEmpls = new ArrayList<>();

    public void parseXmlFile(){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.parse(Runner.class.getClassLoader().getResourceAsStream("users.xml"));
        }catch(ParserConfigurationException | SAXException | IOException pce) {
            pce.printStackTrace();
        }
    }

    public void parseDocument(){
        Element docEle = dom.getDocumentElement();

        NodeList nl = docEle.getElementsByTagName("User");
        if(nl != null && nl.getLength() > 0) {
            for(int i = 0 ; i < nl.getLength();i++) {
                Element el = (Element)nl.item(i);
                User e = getUser(el);
                myEmpls.add(e);
            }
        }
    }

    private User getUser(Element empEl) {

        int id = getIntValue(empEl, "id");
        User.Status status = getEnumValue(empEl, "status");
        String name = getTextValue(empEl, "name");
        String address = getTextValue(empEl, "address");
        String phoneNumber = getTextValue(empEl, "phoneNumber");
        String creditCard = getTextValue(empEl, "creditCard");
        String email = getTextValue(empEl, "email");
        Money wallet = getMoneyValue(empEl, "wallet");
        String login = getTextValue(empEl, "login");
        String password = getTextValue(empEl, "password");

        User e = new User(id, status, name, address, phoneNumber, creditCard, email, wallet);
        e.setLogin(login);
        e.setPassword(password);

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

    private Integer getIntValue(Element ele, String tagName) {
        return Integer.parseInt(getTextValue(ele,tagName));
    }

    private User.Status getEnumValue(Element ele, String tagName) {
        return User.Status.valueOf(getTextValue(ele, tagName));
    }

    private Money getMoneyValue(Element ele, String tagName) {
        return Money.parse(getTextValue(ele, tagName));
    }

    public void printData(){
        for (Object myEmpl : myEmpls) {
            System.out.println(myEmpl.toString());
        }
    }

    public List<User> getMyEmpls() {
        return myEmpls;
    }
}
