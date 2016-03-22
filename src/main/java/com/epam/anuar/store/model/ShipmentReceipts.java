package com.epam.anuar.store.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class ShipmentReceipts {
    @XmlElement(name="ShipmentReceipts")
    private ArrayList<ShipmentReceipt> list = new ArrayList<>();

    public ShipmentReceipts() {
        super();
    }

    public void setList(ArrayList<ShipmentReceipt> list) {
        this.list = list;
    }

    public boolean add(ShipmentReceipt sr) {
        return list.add(sr);
    }

    @Override
    public String toString() {
        return "ShipmentReceipts [list=" + list + "]";
    }

}
