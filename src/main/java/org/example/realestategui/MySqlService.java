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
        String queryStr = """
                SELECT realestates.id, categoryId, categories.name, realestates.sellerId, sellers.name, sellers.phone, realestates.createAt, realestates.description, realestates.freeofcharge, realestates.imageUrl, realestates.area, realestates.rooms, realestates.floors, realestates.latlong
                FROM realestates
                INNER JOIN categories ON categories.id = realestates.categoryId
                INNER JOIN sellers ON sellers.id = realestates.sellerId    
            """;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, "root", "");
            PreparedStatement stmt = conn.prepareStatement(queryStr);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("realestates.id");
                Category category = new Category(resultSet.getInt("categoryId"), resultSet.getString("categories.name"));
                Seller seller = new Seller(resultSet.getInt("realestates.sellerId"), resultSet.getString("sellers.name"), resultSet.getString("sellers.phone"));
                String description = resultSet.getString("realestates.description");
                LocalDate createAt = resultSet.getDate("realestates.createAt").toLocalDate();
                boolean freeofcharge = ( resultSet.getInt("realestates.freeofcharge") != 0 );
                String imageUrl = resultSet.getString("realestates.imageUrl");
                int area = resultSet.getInt("realestates.area");
                int rooms = resultSet.getInt("realestates.rooms");
                int floors = resultSet.getInt("realestates.floors");
                String latlong = resultSet.getString("realestates.latlong");
                Realesate realesate = new Realesate(area, category, createAt, description, floors, freeofcharge, id, imageUrl, latlong, rooms, seller);
                RealEstateController.realesates.add(realesate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
