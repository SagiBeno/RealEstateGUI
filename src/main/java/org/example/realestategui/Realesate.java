package org.example.realestategui;

import java.time.LocalDate;

public class Realesate {
    int area;
    int categoryId;
    LocalDate createAt;
    String description;
    int floors;
    boolean freeOfCharge;
    int id;
    String imageUrl;
    String latLong;
    int rooms;
    int sellerId;

    public void setArea(int area) {
        this.area = area;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public int getArea() {
        return area;
    }

    public int getCategoryId() {
        return categoryId;
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

    public int getSellerId() {
        return sellerId;
    }

    public Realesate(int area, int categoryId, LocalDate createAt, String description, int floors, boolean freeOfCharge, int id, String imageUrl, String latLong, int rooms, int sellerId) {
        this.setArea(area);
        this.setCategoryId(categoryId);
        this.setCreateAt(createAt);
        this.setDescription(description);
        this.setFloors(floors);
        this.setFreeOfCharge(freeOfCharge);
        this.setId(id);
        this.setImageUrl(imageUrl);
        this.setLatLong(latLong);
        this.setRooms(rooms);
        this.setSellerId(sellerId);
    }
}
