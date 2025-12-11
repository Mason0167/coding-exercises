package org.example.product_app;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ProductApp extends Application {
    private TableView<Product> table = new TableView<>();
    private final ObservableList<Product> data =
            FXCollections.observableArrayList(
                    new Product("Laptop", 1200, 5),
                    new Product("Mouse", 25.50, 50)
            );

    // form fields
    private TextField nameInput = new TextField();
    private TextField priceInput = new TextField();
    private TextField quantityInput = new TextField();

    private Label statusLabel = new Label("Ready");

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Product Inventory CRUD demo");

        // Set up table (Read operation)
        TableColumn<Product, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Product, Double> priceCol = new TableColumn<>("Price");
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Product, Integer> quantityCol = new TableColumn<>("Quantity");
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        // Show the current information
        table.setItems(data);
        table.getColumns().addAll(nameCol, priceCol, quantityCol);


        nameInput.setPromptText("Product Name");
        priceInput.setPromptText("Price");
        quantityInput.setPromptText("Quantity");

        // CRUD
        Button createButton = new Button("Create");
        createButton.setOnAction(e -> {
            createData();
        });

//        Button readButton = new Button("Read");
//        readButton.setOnAction(e -> {
//
//        });

        Button updateButton = new Button("Update");
        updateButton.setOnAction(e -> {
            updateData();
        });

        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> {
            deleteData();
        });

        // CSS Style format in JAva FX
        statusLabel.setStyle("-fx-font-weight: bold;");

        // Form layout
        HBox formLayout = new HBox(10);
        // or VBox formLayout = new VBox(10);
        // Check cheat sheet
        formLayout.setPadding(new Insets(10));
        formLayout.getChildren().addAll(nameInput, priceInput, quantityInput, createButton, updateButton, deleteButton);

        // VBox
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(statusLabel,table, formLayout);

        // Scene
        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.show();

    }

    private void createData() {
        try{
            String name = nameInput.getText().trim();
            double price = Double.parseDouble(priceInput.getText());
            int quantity = Integer.parseInt(quantityInput.getText());

            Product newProduct = new Product(name, price, quantity);
            data.add(newProduct);

            statusLabel.setText("Product Created");
            statusLabel.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");

            clearInput();

        }catch(Exception ex){
            statusLabel.setText("Product is not Created");
        }
    }

    private void deleteData() {
        Product selectedProduct = table.getSelectionModel().getSelectedItem();
        if(selectedProduct != null) {
            data.remove(selectedProduct);

            statusLabel.setText("Product Deleted");
            statusLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold");

            clearInput();
        }
    }

    private void updateData() {
        Product selectedProduct = table.getSelectionModel().getSelectedItem();

        if (selectedProduct != null) {
            try{
                String nName = nameInput.getText();
                double nPrice = Double.parseDouble(priceInput.getText());
                int nQuantity = Integer.parseInt(quantityInput.getText());

                selectedProduct.setName(nName);
                selectedProduct.setPrice(nPrice);
                selectedProduct.setQuantity(nQuantity);

                table.refresh();
                statusLabel.setText("Product Updated");
                statusLabel.setStyle("-fx-text-fill: green; -fx-font-weight: bold");

                clearInput();
            }
            catch(Exception ex){

            }
        }
    }

    private void clearInput() {
        quantityInput.clear();
        priceInput.clear();
        nameInput.clear();
    }

}