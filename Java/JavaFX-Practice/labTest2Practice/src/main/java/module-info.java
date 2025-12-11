module org.example.labtestpractice {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.labtestpractice to javafx.fxml;
    exports org.example.labtestpractice;
}