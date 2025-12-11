module org.example.product_app {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.product_app to javafx.fxml;
    exports org.example.product_app;
}