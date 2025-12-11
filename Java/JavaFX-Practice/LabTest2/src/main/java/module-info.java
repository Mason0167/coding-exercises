module org.example.labtest {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.labtest2 to javafx.fxml;
    exports org.example.labtest2;
}