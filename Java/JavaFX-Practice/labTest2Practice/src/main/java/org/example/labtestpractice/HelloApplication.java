package org.example.labtestpractice;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class HelloApplication extends Application {
    private static int counter = 0;

    @Override
    public void start(Stage stage) throws IOException {
        // Counter
        Label countLabel = new Label("Count: 0");
        countLabel.setStyle("-fx-text-fill: White; -fx-font-size: 30");

        // Clicked text
        Label clickedText = new Label("Button Clicked!");
        clickedText.setStyle("-fx-text-fill: Red; -fx-font-size: 10");
        clickedText.setVisible(false);

        // Btn
        Button clickBtn = new Button("Click Me!");
        clickBtn.setOnAction(e -> {
            counter++;
            countLabel.setText("Count: " + counter);

            clickedText.setVisible(true);
            PauseTransition pt = new PauseTransition(Duration.seconds(1));
            pt.setOnFinished(ev -> clickedText.setVisible(false)); // hide after 5 sec
            pt.play();
        });
        clickBtn.setStyle("-fx-background-color: blue; " +
                "-fx-text-fill: white; -fx-border-radius: 45;");
        clickBtn.setPrefSize(110, 40);

        // form layout
        VBox vBox = new VBox(20);
        vBox.setAlignment(Pos.CENTER);
        vBox.setStyle("-fx-background-color: darkblue");
        vBox.getChildren().addAll(countLabel, clickBtn, clickedText);

        Scene scene = new Scene(vBox, 300, 300);

        stage.setTitle("JavaFX Click Counter");
        stage.setScene(scene);
        stage.show();
    }
}