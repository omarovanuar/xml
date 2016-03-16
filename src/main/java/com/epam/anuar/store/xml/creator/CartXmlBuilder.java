package com.epam.anuar.store.xml.creator;

import com.epam.anuar.store.model.Cart;
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

public class CartXmlBuilder {
    List<Cart> carts = new ArrayList<>();
    private Document dom = null;

    public CartXmlBuilder(List<Cart> carts) {
        this.carts = carts;
    }

    public void createDOMTree(){
        Element rootEle = dom.createElement("Carts");
        dom.appendChild(rootEle);
        for (Cart b : carts) {
            Element userEle = createCartElement(b);
            rootEle.appendChild(userEle);
        }

    }

    private Element createCartElement(Cart b){

        Element cartEle = dom.createElement("Cart");
        Element idEle = dom.createElement("id");
        Text idText = dom.createTextNode(b.getId().toString());
        idEle.appendChild(idText);
        cartEle.appendChild(idEle);

//        Element statusEle = dom.createElement("createDate");
//        Text statusText = dom.createTextNode(b.getStatus().toString());
//        statusEle.appendChild(statusText);
//        userEle.appendChild(statusEle);
//
//        Element nameEle = dom.createElement("name");
//        Text nameText = dom.createTextNode(b.getName());
//        nameEle.appendChild(nameText);
//        userEle.appendChild(nameEle);
//
//        Element addressEle = dom.createElement("address");
//        Text addressText = dom.createTextNode(b.getAddress());
//        addressEle.appendChild(addressText);
//        userEle.appendChild(addressEle);
//
//        Element phoneNumberEle = dom.createElement("phoneNumber");
//        Text phoneNumberText = dom.createTextNode(b.getPhoneNumber());
//        phoneNumberEle.appendChild(phoneNumberText);
//        userEle.appendChild(phoneNumberEle);
//
//        Element creditCardEle = dom.createElement("creditCard");
//        Text creditCardText = dom.createTextNode(b.getCreditCard());
//        creditCardEle.appendChild(creditCardText);
//        userEle.appendChild(creditCardEle);
//
//        Element emailEle = dom.createElement("email");
//        Text emailText = dom.createTextNode(b.getEmail());
//        emailEle.appendChild(emailText);
//        userEle.appendChild(emailEle);
//
//        Element walletEle = dom.createElement("wallet");
//        Text walletText = dom.createTextNode(b.getWallet().toString());
//        walletEle.appendChild(walletText);
//        userEle.appendChild(walletEle);
//
//        Element loginEle = dom.createElement("login");
//        Text loginText = dom.createTextNode(b.getLogin());
//        loginEle.appendChild(loginText);
//        userEle.appendChild(loginEle);
//
//        Element passEle = dom.createElement("password");
//        Text passText = dom.createTextNode(b.getPassword());
//        passEle.appendChild(passText);
//        userEle.appendChild(passEle);

        return cartEle;

    }

    public void printToFile(){

        try
        {
            OutputFormat format = new OutputFormat(dom);
            format.setIndenting(true);

            XMLSerializer serializer = new XMLSerializer(
                    new FileOutputStream(new File("src/main/resources/carts1.xml")), format);

            serializer.serialize(dom);

        } catch(IOException ie) {
            ie.printStackTrace();
        }
    }

    public void setDom(Document dom) {
        this.dom = dom;
    }
}
