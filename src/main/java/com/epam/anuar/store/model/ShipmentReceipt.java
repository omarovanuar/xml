package com.epam.anuar.store.model;

import org.joda.money.Money;

public class ShipmentReceipt extends BaseEntity {
    private String customerName;
    private String shipper;
    private String address;
    private Money shippingCost;
    private int orderId;

    public ShipmentReceipt(Integer id, String shipper, Money shippingCost, String address, Order order) {
        super(id);
        this.customerName = order.getCustomerName();
        this.address = address;
        this.shipper = shipper;
        this.shippingCost = shippingCost;
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
        return shippingCost;
    }

    public void setShippingCost(Money shippingCost) {
        this.shippingCost = shippingCost;
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
