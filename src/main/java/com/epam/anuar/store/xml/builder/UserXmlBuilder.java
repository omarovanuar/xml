package com.epam.anuar.store.xml.builder;

import com.epam.anuar.store.model.User;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserXmlBuilder {
    List<User> users = new ArrayList<>();
    private Document dom = null;

    public UserXmlBuilder(List<User> users) {
        this.users = users;
    }

    public void createDOMTree(){
        Element rootEle = dom.createElement("users");
        dom.appendChild(rootEle);
        for (User b : users) {
            Element userEle = createUserElement(b);
            rootEle.appendChild(userEle);
        }

    }

    private Element createUserElement(User b){

        Element userEle = dom.createElement("user");
        Element idEle = dom.createElement("id");
        Text idText = dom.createTextNode(b.getId().toString());
        idEle.appendChild(idText);
        userEle.appendChild(idEle);

        Element statusEle = dom.createElement("status");
        Text statusText = dom.createTextNode(b.getStatus().toString());
        statusEle.appendChild(statusText);
        userEle.appendChild(statusEle);

        Element nameEle = dom.createElement("name");
        Text nameText = dom.createTextNode(b.getName());
        nameEle.appendChild(nameText);
        userEle.appendChild(nameEle);

        Element addressEle = dom.createElement("address");
        Text addressText = dom.createTextNode(b.getAddress());
        addressEle.appendChild(addressText);
        userEle.appendChild(addressEle);

        Element phoneNumberEle = dom.createElement("phoneNumber");
        Text phoneNumberText = dom.createTextNode(b.getPhoneNumber());
        phoneNumberEle.appendChild(phoneNumberText);
        userEle.appendChild(phoneNumberEle);

        Element creditCardEle = dom.createElement("creditCard");
        Text creditCardText = dom.createTextNode(b.getCreditCard());
        creditCardEle.appendChild(creditCardText);
        userEle.appendChild(creditCardEle);

        Element emailEle = dom.createElement("email");
        Text emailText = dom.createTextNode(b.getEmail());
        emailEle.appendChild(emailText);
        userEle.appendChild(emailEle);

        Element walletEle = dom.createElement("wallet");
        Text walletText = dom.createTextNode(b.getWallet().toString());
        walletEle.appendChild(walletText);
        userEle.appendChild(walletEle);

        Element loginEle = dom.createElement("login");
        Text loginText = dom.createTextNode(b.getLogin());
        loginEle.appendChild(loginText);
        userEle.appendChild(loginEle);

        Element passEle = dom.createElement("password");
        Text passText = dom.createTextNode(b.getPassword());
        passEle.appendChild(passText);
        userEle.appendChild(passEle);

        return userEle;

    }

    public void printToFile(){

        try
        {
            OutputFormat format = new OutputFormat(dom);
            format.setIndenting(true);

            XMLSerializer serializer = new XMLSerializer(
                    new FileOutputStream(new File("src/main/resources/users1.xml")), format);

            serializer.serialize(dom);

        } catch(IOException ie) {
            ie.printStackTrace();
        }
    }

    public void setDom(Document dom) {
        this.dom = dom;
    }
}
