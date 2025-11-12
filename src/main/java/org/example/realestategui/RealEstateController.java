package org.example.realestategui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

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

    public int sellerId = 0;

    @FXML public ListView<String> sellersListview;
    @FXML public Label sellerName;
    @FXML public Label sellerPhone;
    @FXML public Label adNumber;

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

    public void handleSeller(MouseEvent mouseEvent) {
        String selectedSeller = sellersListview.getSelectionModel().getSelectedItem();
        for (Seller seller : sellers) {
            if (seller.getName().equals(selectedSeller)) {
                sellerId = seller.getId();
                sellerName.setText(seller.getName());
                sellerPhone.setText(seller.getPhone());
            }
        }
    }

    @FXML
    public void handleAdLoading(ActionEvent actionEvent) {
        int adQuantity = 0;
        for (Realesate realesate : realesates) {
            if (realesate.getSeller().getId() == sellerId) {
                adQuantity++;
            }
        }

        if (adQuantity != 0) {
            adNumber.setText(String.valueOf(adQuantity));
        } else {
            adNumber.setText("Nincs hirdetés");
        }
    }
}
