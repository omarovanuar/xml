package com.epam.anuar.store.model;

public class User extends BaseEntity{
    public enum Status{
        ADMIN, MODERATOR, REGISTERED_USER, GUEST
    }
    private Status status;
    private String name;
    private String email;
    private String phoneNumber;


    public User() {
    }

    public User(int id, Status status, String name, String phoneNumber, String email) {
        super(id);
        this.status = status;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                super.toString() +
                ", status='" + status + '\'' +
                ", name='" + name + '\'' +
                ", name='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
