package com.epam.anuar.store.xml.creator;

import com.epam.anuar.store.model.Product;
import com.epam.anuar.store.model.User;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductXmlBuilder {
    List<Product> products = new ArrayList<>();
    private Document dom;

    public ProductXmlBuilder(List<Product> products) {
        this.products = products;
    }

    public void createDocument() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.newDocument();

        }catch(ParserConfigurationException pce) {
            System.out.println("Error while trying to instantiate DocumentBuilder " + pce);
            System.exit(1);
        }

    }

    public void createDOMTree(){
        Element rootEle = dom.createElement("products");
        dom.appendChild(rootEle);
        for (Product b : products) {
            Element productEle = createProductElement(b);
            rootEle.appendChild(productEle);
        }

    }

    private Element createProductElement(Product b){

        Element productEle = dom.createElement("product");
        Element idEle = dom.createElement("id");
        Text idText = dom.createTextNode(b.getId().toString());
        idEle.appendChild(idText);
        productEle.appendChild(idEle);

        Element titleEle = dom.createElement("title");
        Text titleText = dom.createTextNode(b.getTitle());
        titleEle.appendChild(titleText);
        productEle.appendChild(titleEle);

        Element priceEle = dom.createElement("price");
        Text priceText = dom.createTextNode(b.getPrice().toString());
        priceEle.appendChild(priceText);
        productEle.appendChild(priceEle);

        Element countEle = dom.createElement("count");
        Text countText = dom.createTextNode(b.getCount().toString());
        countEle.appendChild(countText);
        productEle.appendChild(countEle);

        Object[] key = b.getParameter().keySet().toArray();
        Object[] value = b.getParameter().values().toArray();

        Element paramEle = dom.createElement("parameter");
        for (int i = 0; i < b.getParameter().size(); i++) {
            if (b.getParameter().keySet().iterator().hasNext()) {
                Element paramMapEle = dom.createElement(key[i].toString());
                Text paramText = dom.createTextNode(value[i].toString());
                paramMapEle.appendChild(paramText);
                paramEle.appendChild(paramMapEle);
            }
        }

        productEle.appendChild(paramEle);

        return productEle;

    }

    public void printToFile(){

        try
        {
            OutputFormat format = new OutputFormat(dom);
            format.setIndenting(true);

            XMLSerializer serializer = new XMLSerializer(
                    new FileOutputStream(new File("src/main/resources/products1.xml")), format);

            serializer.serialize(dom);

        } catch(IOException ie) {
            ie.printStackTrace();
        }
    }
}