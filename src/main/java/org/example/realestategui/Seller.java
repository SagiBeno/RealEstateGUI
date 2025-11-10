package org.example.realestategui;

public class Seller {
    int id;
    String name;
    String phone;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public Seller (int id, String name, String phone) {
        this.setId(id);
        this.setName(name);
        this.setPhone(phone);
    }
}
