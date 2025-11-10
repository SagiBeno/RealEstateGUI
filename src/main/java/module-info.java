module org.example.realestategui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens org.example.realestategui to javafx.fxml;
    exports org.example.realestategui;
}