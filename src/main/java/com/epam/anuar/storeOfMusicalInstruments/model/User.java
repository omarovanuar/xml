package com.epam.anuar.storeOfMusicalInstruments.model;

public class User extends BaseEntity{

    private String status;
    private String name;
    private String email;
    private String phoneNumber;

    public User() {
    }

    public User(int id, String status, String name, String phoneNumber, String email) {
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
                "status='" + status + '\'' +
                ", \nname='" + name + '\'' +
                ", \nname='" + phoneNumber + '\'' +
                ", \nemail='" + email + '\'' +
                '}' + "\n";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
