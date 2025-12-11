package org.example.labtest2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private TextField text1Input =  new TextField("Text 1");
    private TextField text2Input =  new TextField("Text 2");
    private Label feedbackLabel = new Label("Input Text and Press a Button");

    @Override
    public void start(Stage stage) throws IOException {

        // Check emptiness
        if(text1Input.getText().isEmpty() || text2Input.getText().isEmpty()){
            feedbackLabel.setText("Error: Missing Input");
        }

        // Btn
        Button lengthBtn = new Button("Length");
        lengthBtn.setOnAction(e -> {
            try{
                int text1Length = text1Input.getText().trim().length();
                int text2Length = text2Input.getText().trim().length();
                int totalLength = text1Length + text2Length;

                feedbackLabel.setText("Length: " + totalLength);
            }
            catch(Exception ex){
                feedbackLabel.setText("Please enter a valid text");
            }
        });

        Button compareBtn = new Button("Compare");
        compareBtn.setOnAction(e -> {
            try{
                String text1 = text1Input.getText().trim();
                String text2 = text2Input.getText().trim();

                if(text1.equals(text2)){
                    feedbackLabel.setText("Texts Match");
                }else feedbackLabel.setText("Texts Do Not Match");
            }
            catch (Exception ex){
                feedbackLabel.setText("Please enter a valid text");
            }
        });

        Button startBtn = new Button("Starts With");
        startBtn.setOnAction(e -> {
            try{
                String text1 = text1Input.getText().trim();
                String text2 = text2Input.getText().trim();

                if(text1.startsWith(text2)){
                    feedbackLabel.setText("Text 1 STARTS with Text 2");
                }else feedbackLabel.setText("Text 1 NOT STARTS with Text 2");
            }
            catch (Exception ex){
                feedbackLabel.setText("Please enter a valid text");
            }
        });

        Button swapBtn = new Button("Swap");
        swapBtn.setOnAction(e -> {
            String text1 = text1Input.getText().trim();
            String text2 = text2Input.getText().trim();
            String textTemp = text2;
            String textTemp2 = text1;

            feedbackLabel.setText("Before: \n" + text1 + ", " + text2 + "\n"
                    + "After: \n" + textTemp + ", " + textTemp2);
        });

        // Horizontal Form layout
        HBox inputForm = new HBox(10);
        inputForm.setAlignment(Pos.CENTER);
        inputForm.setPadding(new Insets(10));
        inputForm.getChildren().addAll(text1Input, text2Input);

        // Vertical Form
        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(10));
        vBox.getChildren().addAll(inputForm, feedbackLabel, lengthBtn, compareBtn, startBtn, swapBtn);




        Scene scene = new Scene(vBox, 500, 400);
        stage.setTitle("Simple Text Analyzer");
        stage.setScene(scene);
        stage.show();
        
        
        
        
        
    }

    public static void main(String[] args) {
        launch();
    }
}