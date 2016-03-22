package com.epam.anuar.store.model;

import org.joda.money.Money;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ShipmentReceipt", propOrder = {
        "customerName",
        "shipper",
        "address",
        "shippingCost",
        "orderId"
})
public class ShipmentReceipt extends BaseEntity {
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlElement(required = true)
    private String customerName;
    @XmlElement(required = true)
    private String shipper;
    @XmlElement(required = true)
    private String address;
    @XmlElement(required = true)
    private String shippingCost;
    @XmlElement(required = true)
    private int orderId;

    public ShipmentReceipt() {
    }

    public ShipmentReceipt(Integer id, String shipper, Money shippingCost, String address, Order order) {
        super(id);
        this.customerName = order.getCustomerName();
        this.address = address;
        this.shipper = shipper;
        this.shippingCost = shippingCost.toString();
        this.orderId = order.getId();
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getShipper() {
        return shipper;
    }

    public void setShipper(String shipper) {
        this.shipper = shipper;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Money getShippingCost() {
        return Money.parse(shippingCost);
    }

    public void setShippingCost(Money shippingCost) {
        this.shippingCost = shippingCost.toString();
    }

    public int getOrderId() {
        return orderId;
    }

    @Override
    public String toString() {
        return "ShipmentReceipt: " + "Order " + super.toString() + "\n" +
                "customerName: " + customerName +
                ", orderId: " + orderId +
                ", address: " + address + "\n" +
                "shipper: " + shipper +
                ", shippingCost: " + shippingCost;
    }
}
