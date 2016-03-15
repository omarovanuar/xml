package com.epam.anuar.store.xml.parser;

import com.epam.anuar.store.Runner;
import com.epam.anuar.store.model.User;
import org.joda.money.Money;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserSAXParser extends DefaultHandler{
    private String tempVal;
    private User tempUser;
    private List<User> users = new ArrayList<>();


    public void parseDocument() {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {
            SAXParser sp = spf.newSAXParser();
            sp.parse(Runner.class.getClassLoader().getResourceAsStream("users.xml"), this);
        } catch (SAXException | ParserConfigurationException | IOException se) {
            se.printStackTrace();
        }
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        tempVal = "";
        if(qName.equalsIgnoreCase("User")) {
            tempUser = new User();
        }
    }


    public void characters(char[] ch, int start, int length) throws SAXException {
        tempVal = new String(ch, start, length);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName){
            case "User":
                users.add(tempUser);
                break;
            case "id":
                tempUser.setId(Integer.parseInt(tempVal));
                break;
            case "status":
                tempUser.setStatus(User.Status.valueOf(tempVal));
                break;
            case "name":
                tempUser.setName(tempVal);
                break;
            case "address":
                tempUser.setAddress(tempVal);
                break;
            case "phoneNumber":
                tempUser.setPhoneNumber(tempVal);
                break;
            case "creditCard":
                tempUser.setCreditCard(tempVal);
                break;
            case "email":
                tempUser.setEmail(tempVal);
                break;
            case "wallet":
                tempUser.setWallet(Money.parse(tempVal));
                break;
            case "login":
                tempUser.setLogin(tempVal);
                break;
            case "password":
                tempUser.setPassword(tempVal);
                break;
        }

    }

    public void printData(){
        for (User user : users) {
            System.out.println(user.toString());
        }
    }

    public List getUsers() {
        return users;
    }
}
