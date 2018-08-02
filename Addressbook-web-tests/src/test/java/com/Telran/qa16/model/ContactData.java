package com.Telran.qa16.model;

public class ContactData {
    private String ferstName;
    private  String lastName;
    private  String address;
    private  String email;
    private  String phone;

    public ContactData setFerstName(String ferstName) {
        this.ferstName = ferstName;
        return this;
    }

    public ContactData setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ContactData setAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData setEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactData setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getFerstName() {
        return ferstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
