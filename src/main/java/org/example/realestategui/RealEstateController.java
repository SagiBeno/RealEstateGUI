package org.example.realestategui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

public class RealEstateController implements Initializable {
    public static ArrayList<Realesate> realesates = new ArrayList<>();
    public static ArrayList<Seller> sellers = new ArrayList<>();
    public static ArrayList<Category> categories = new ArrayList<>();

    @FXML public ListView<String> sellersListview;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            MySqlService.getSellers();
            MySqlService.getCategories();
            MySqlService.getRealEstates();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        ArrayList<String> sellersName = new ArrayList<>();
        for (Seller seller : sellers) {
            sellersName.add(seller.getName());
        }
        Collections.sort(sellersName);
        ObservableList<String> sellersNameOL = FXCollections.observableList(sellersName);
        sellersListview.setItems(sellersNameOL);
    }
}
