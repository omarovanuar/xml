package com.epam.anuar.store.xml.builder;

import com.epam.anuar.store.model.Cart;
import com.epam.anuar.store.model.Order;
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

public class OrderXmlBuilder {
    List<Order> orders = new ArrayList<>();
    private Document dom = null;

    public OrderXmlBuilder(List<Order> orders) {
        this.orders = orders;
    }

    public void createDOMTree(){
        Element rootEle = dom.createElement("orders");
        dom.appendChild(rootEle);
        for (Order b : orders) {
            Element orderEle = createOrderElement(b);
            rootEle.appendChild(orderEle);
        }

    }

    private Element createOrderElement(Order b){

        Element orderEle = dom.createElement("order");
        Element idEle = dom.createElement("id");
        Text idText = dom.createTextNode(b.getId().toString());
        idEle.appendChild(idText);
        orderEle.appendChild(idEle);

        Element customerNameEle = dom.createElement("customerName");
        Text customerNameText = dom.createTextNode(b.getCustomerName());
        customerNameEle.appendChild(customerNameText);
        orderEle.appendChild(customerNameEle);

        Element phoneNumberEle = dom.createElement("phoneNumber");
        Text phoneNumberText = dom.createTextNode(b.getPhoneNumber());
        phoneNumberEle.appendChild(phoneNumberText);
        orderEle.appendChild(phoneNumberEle);

        Element productListPriceEle = dom.createElement("productListPrice");
        Text productListPriceText = dom.createTextNode(b.getProductListPrice().toString());
        productListPriceEle.appendChild(productListPriceText);
        orderEle.appendChild(productListPriceEle);

        Element creditCardEle = dom.createElement("creditCard");
        Text creditCardText = dom.createTextNode(b.getCreditCard());
        creditCardEle.appendChild(creditCardText);
        orderEle.appendChild(creditCardEle);

        Element executeDateEle = dom.createElement("executeDate");
        Text executeDateText = dom.createTextNode(b.getExecuteDate().toString());
        executeDateEle.appendChild(executeDateText);
        orderEle.appendChild(executeDateEle);


        Element productListEle = dom.createElement("productList");
        for (int i = 0; i < b.getProductList().size(); i++) {
            if (b.getProductList().iterator().hasNext()) {
                Element productEle = dom.createElement("product");
                Text productText = dom.createTextNode(b.getProductList().get(i).getTitle());
                productEle.appendChild(productText);
                productListEle.appendChild(productEle);
            }
        }

        orderEle.appendChild(productListEle);

        return orderEle;
    }

    public void printToFile(){

        try
        {
            OutputFormat format = new OutputFormat(dom);
            format.setIndenting(true);

            XMLSerializer serializer = new XMLSerializer(
                    new FileOutputStream(new File("src/main/resources/orders.xml")), format);

            serializer.serialize(dom);

        } catch(IOException ie) {
            ie.printStackTrace();
        }
    }

    public void setDom(Document dom) {
        this.dom = dom;
    }
}
