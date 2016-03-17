package com.epam.anuar.store.xml.builder;

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
        Element rootEle = dom.createElement("carts");
        dom.appendChild(rootEle);
        for (Cart b : carts) {
            Element userEle = createCartElement(b);
            rootEle.appendChild(userEle);
        }

    }

    private Element createCartElement(Cart b){

        Element cartEle = dom.createElement("cart");
        Element idEle = dom.createElement("id");
        Text idText = dom.createTextNode(b.getId().toString());
        idEle.appendChild(idText);
        cartEle.appendChild(idEle);

        Element createDateEle = dom.createElement("createDate");
        Text createDateText = dom.createTextNode(b.getCreateDate().toString());
        createDateEle.appendChild(createDateText);
        cartEle.appendChild(createDateEle);

        Element productListEle = dom.createElement("productList");
        for (int i = 0; i < b.getProductList().size(); i++) {
            if (b.getProductList().iterator().hasNext()) {
                Element productEle = dom.createElement("product");
                productEle.setAttribute("id", b.getProductList().get(i).getId().toString());
                Text productText = dom.createTextNode(b.getProductList().get(i).getTitle());
                productEle.appendChild(productText);
                productListEle.appendChild(productEle);
            }
        }

        cartEle.appendChild(productListEle);


        Element priceEle = dom.createElement("productListPrice");
        Text priceText = dom.createTextNode(b.getProductListPrice().toString());
        priceEle.appendChild(priceText);
        cartEle.appendChild(priceEle);

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
