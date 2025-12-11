module org.example.labtest {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;


    opens org.example.demographic to javafx.fxml;
    exports org.example.demographic;
}