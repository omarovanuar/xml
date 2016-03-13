package com.epam.anuar.store.model;

import org.joda.money.Money;

public class User extends BaseEntity{
    public enum Status{
        ADMIN, MODERATOR, REGISTERED_USER, GUEST
    }
    private Status status;
    private String name;
    private String address;
    private String phoneNumber;
    private String creditCard;
    private String email;
    private Money wallet;

    public User() {
    }

    public User(int id, Status status, String name, String address, String phoneNumber, String creditCard, String email, Money wallet) {
        super(id);
        this.status = status;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.creditCard = creditCard;
        this.email = email;
        this.wallet = wallet;
    }

    @Override
    public String toString() {
        return "User{" +
                super.toString() +
                ", status='" + status + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", Phone Number='" + phoneNumber + '\'' +
                ", Credit card='" + creditCard + '\'' +
                ", email='" + email + '\'' +
                ", wallet='" + wallet + '\'' +
                '}';
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Money getWallet() {
        return wallet;
    }

    public void setWallet(Money wallet) {
        this.wallet = wallet;
    }
}
