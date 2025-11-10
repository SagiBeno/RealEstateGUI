package org.example.realestategui;

import java.sql.*;
import java.time.LocalDate;

public class MySqlService {

    public static void getSellers() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ingatlan";
        String queryStr = "SELECT * FROM sellers";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, "root", "");
            PreparedStatement stmt = conn.prepareStatement(queryStr);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                RealEstateController.sellers.add(new Seller(id, name, phone));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getCategories() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ingatlan";
        String queryStr = "SELECT * FROM categories";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, "root", "");
            PreparedStatement stmt = conn.prepareStatement(queryStr);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                RealEstateController.categories.add(new Category(id, name));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getRealEstates() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ingatlan";
        String queryStr = "SELECT * FROM realestates";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, "root", "");
            PreparedStatement stmt = conn.prepareStatement(queryStr);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int categoryId = resultSet.getInt("categoryId");
                int sellerId = resultSet.getInt("sellerId");
                String description = resultSet.getString("description");
                LocalDate createAt = resultSet.getDate("createAt").toLocalDate();
                boolean freeofcharge = ( resultSet.getInt("freeofcharge") != 0 );
                String imageUrl = resultSet.getString("imageUrl");
                int area = resultSet.getInt("area");
                int rooms = resultSet.getInt("rooms");
                int floors = resultSet.getInt("floors");
                String latlong = resultSet.getString("latlong");
                RealEstateController.realesates.add(new Realesate(area, categoryId, createAt, description, floors, freeofcharge, id, imageUrl, latlong, rooms, sellerId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
