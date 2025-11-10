package org.example.realestategui;

import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RealEstateController implements Initializable {
    public static ArrayList<Realesate> realesates = new ArrayList<>();
    public static ArrayList<Seller> sellers = new ArrayList<>();
    public static ArrayList<Category> categories = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            MySqlService.getSellers();
            MySqlService.getCategories();
            MySqlService.getRealEstates();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        
    }
}
