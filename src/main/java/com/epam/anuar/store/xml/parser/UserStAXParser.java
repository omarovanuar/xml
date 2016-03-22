package com.epam.anuar.store.xml.parser;

import com.epam.anuar.store.Runner;
import com.epam.anuar.store.model.User;
import org.joda.money.Money;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class UserStAXParser {

    private Set<User> users = new HashSet<>();
    private XMLInputFactory inputFactory;
    public UserStAXParser() {
        inputFactory = XMLInputFactory.newInstance();
    }

    public void parseSetUsers(String filename) {
        InputStream inputStream = null;
        XMLStreamReader reader;
        String name;
        try {
            inputStream = Runner.class.getClassLoader().getResourceAsStream(filename);
            reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (name == "user") {
                        User user = parseUser(reader);
                        users.add(user);
                    }
                }
            }
        } catch (XMLStreamException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }

    private User parseUser(XMLStreamReader reader) throws XMLStreamException {
        User tempUser = new User();
        String tempVal;

        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    tempVal = reader.getLocalName();
                    switch (tempVal) {
                        case "id":
                            tempVal = getXMLText(reader);
                            tempUser.setId(Integer.parseInt(tempVal));
                            break;
                        case "status":
                            tempVal = getXMLText(reader);
                            tempUser.setStatus(User.Status.valueOf(tempVal));
                            break;
                        case "name":
                            tempVal = getXMLText(reader);
                            tempUser.setName(tempVal);
                            break;
                        case "address":
                            tempVal = getXMLText(reader);
                            tempUser.setAddress(tempVal);
                            break;
                        case "phoneNumber":
                            tempVal = getXMLText(reader);
                            tempUser.setPhoneNumber(tempVal);
                            break;
                        case "creditCard":
                            tempVal = getXMLText(reader);
                            tempUser.setCreditCard(tempVal);
                            break;
                        case "email":
                            tempVal = getXMLText(reader);
                            tempUser.setEmail(tempVal);
                            break;
                        case "wallet":
                            tempVal = getXMLText(reader);
                            tempUser.setWallet(Money.parse(tempVal));
                            break;
                        case "login":
                            tempVal = getXMLText(reader);
                            tempUser.setLogin(tempVal);
                            break;
                        case "password":
                            tempVal = getXMLText(reader);
                            tempUser.setPassword(tempVal);
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    tempVal = reader.getLocalName();
                    if (tempVal == "user") {
                        return tempUser;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Error");
    }


    public void printData() {
        users.forEach(System.out::println);
    }

}
