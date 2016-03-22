package com.epam.anuar.store.xml.builder;

import com.epam.anuar.store.model.Order;
import com.epam.anuar.store.model.ShipmentReceipt;
import com.epam.anuar.store.model.ShipmentReceipts;
import org.joda.money.Money;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;

public class ShipmentJAXB {
    public void shipmentMarshall() {
        try {
            JAXBContext context = JAXBContext.newInstance(ShipmentReceipts.class);
            Marshaller m = context.createMarshaller();
            ShipmentReceipts sr = new ShipmentReceipts() {
                {
                    Order order1 = new Order(1, "Golovin Mikhail");
                    ShipmentReceipt shipmentReceipt1 = new ShipmentReceipt(500, "KAZPOST", Money.parse("KZT 300"), "Golubie prudi 13-1", order1);
                    this.add(shipmentReceipt1);
                    Order order2 = new Order(2, "Smagulova Dinara");
                    ShipmentReceipt shipmentReceipt2 = new ShipmentReceipt(501, "KAZPOST", Money.parse("KZT 300"), "Satibaldina 4-13", order2);
                    this.add(shipmentReceipt2);
                }
            };
            m.marshal(sr, new FileOutputStream(new File("src/main/resources/shipment.xml")));
            m.marshal(sr, System.out);
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void shipmentUnmarshall() {
        try {
            JAXBContext jc = JAXBContext.newInstance(ShipmentReceipts.class);
            Unmarshaller u = jc.createUnmarshaller();
            FileReader reader = new FileReader(new File("src/main/resources/shipment.xml"));
            ShipmentReceipts shipmentReceipts = (ShipmentReceipts) u.unmarshal(reader);
            System.out.println(shipmentReceipts);
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
