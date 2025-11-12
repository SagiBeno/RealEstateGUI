package org.example.realestategui;

import java.time.LocalDate;

public class Realesate {
    int area;
    Category category;
    LocalDate createAt;
    String description;
    int floors;
    boolean freeOfCharge;
    int id;
    String imageUrl;
    String latLong;
    int rooms;
    Seller seller;

    private double latitude;
    private double longitude;

    public void setArea(int area) {
        this.area = area;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public void setFreeOfCharge(boolean freeOfCharge) {
        this.freeOfCharge = freeOfCharge;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setLatLong(String latLong) {
        this.latLong = latLong;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public int getArea() {
        return area;
    }

    public Category getCategory() {
        return category;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public String getDescription() {
        return description;
    }

    public int getFloors() {
        return floors;
    }

    public boolean getFreeOfCharge() {
        return freeOfCharge;
    }

    public int getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getLatLong() {
        return latLong;
    }

    public int getRooms() {
        return rooms;
    }

    public Seller getSeller() {
        return seller;
    }

    public Realesate (int area, Category category, LocalDate createAt, String description, int floors, boolean freeOfCharge, int id, String imageUrl, String latLong, int rooms, Seller seller) {
        this.setArea(area);
        this.setCategory(category);
        this.setCreateAt(createAt);
        this.setDescription(description);
        this.setFloors(floors);
        this.setFreeOfCharge(freeOfCharge);
        this.setId(id);
        this.setImageUrl(imageUrl);
        this.setLatLong(latLong);
        this.setRooms(rooms);
        this.setSeller(seller);
    }
}