package org.example.demographic;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

// Layout and graphics
public class HelloApplication extends Application {

    // Constraint
    private static final double SCENE_WIDTH = 600;
    private static final double SCENE_HEIGHT = 400;
    private static final double BALL_RADIUS = 20;
    private static final double PADDLE_WIDTH = 20;
    private static final double PADDLE_HEIGHT = 100;

    private static double dx = 20;
    private static double dy = 20;
    private static int score = 0;
    private static boolean gameOver = false;

    private static final double SPEED_INCREASE_FACTOR = 1.05;


    // Object

    Circle ball;
    Rectangle paddle;
    Timeline timeline;
    Text scoreText;
    Text gameOverText;

    @Override
    public void start(Stage stage) throws IOException {

        Pane pane = new Pane();

        // Create a ball
        ball = new Circle(BALL_RADIUS, Color.BLUEVIOLET);

        // Change location of the ball
        ball.setCenterX(SCENE_WIDTH / 2);
        ball.setCenterY(SCENE_HEIGHT / 2);

        // Paddle
        paddle = new Rectangle(PADDLE_WIDTH, PADDLE_HEIGHT);
        paddle.setX(10);

        // Score Text
        scoreText = new Text("SCORE : 0");
        scoreText.setFont(new Font("Arial", 24));
        scoreText.setFill(Color.BLACK);
        scoreText.setX(SCENE_WIDTH / 2 - 50);
        scoreText.setY(30);

        // Game Over text
        gameOverText = new Text("GAME OVER\nPress R to restart");
        gameOverText.setFont(new Font("Arial", 40));
        gameOverText.setFill(Color.RED);
        gameOverText.setX(SCENE_WIDTH / 2 - 150);
        gameOverText.setY(SCENE_HEIGHT / 2 - 50);
        gameOverText.setVisible(false);

        pane.getChildren().addAll(ball, paddle, scoreText, gameOverText);

        // Animation
        timeline = new Timeline(new KeyFrame(Duration.millis(40), e -> {
            ball.setCenterX(ball.getCenterX() + dx);
            ball.setCenterY(ball.getCenterY() + dy);

            // Check if the ball touch the vertical wall
            if(ball.getCenterX() + BALL_RADIUS >= SCENE_WIDTH) {
                // Reversing the bounce
                dx *= -1;
            }

            // Check if the ball touch the horizontal wall
            if(ball.getCenterY() + BALL_RADIUS >= SCENE_HEIGHT ||
                    ball.getCenterY() - BALL_RADIUS <= 0) {
                // Reversing the bounce
                dy *= -1;
            }

            // Find the intersection of two object!
            // Hit is detected
            if(ball.getBoundsInParent().intersects(paddle.getBoundsInParent())) {
                dx *= -1;
                score ++;
                scoreText.setText("Score: " + score);
                dx *= SPEED_INCREASE_FACTOR;
                dy *= SPEED_INCREASE_FACTOR;
            }

            // Game over
            if(ball.getCenterX() - BALL_RADIUS <= 0){
                gameOverText.setVisible(true);
                timeline.stop();
            }
        }));

        // This runs forever
        timeline.setCycleCount(Timeline.INDEFINITE);

        // This runs the timeline
        timeline.play();

        Scene scene = new Scene(pane,  SCENE_WIDTH, SCENE_HEIGHT);
        scene.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.R) {
                resetGame();
                timeline.play();
            }
        });

        // set user's mouse
        scene.setOnMouseMoved(event -> {
            double mouseY = event.getY();
            paddle.setY(mouseY - PADDLE_HEIGHT / 2);

            // Prevent paddle from going off the screen
            if(paddle.getY() < 0) paddle.setY(0);
            else if(paddle.getY() + PADDLE_HEIGHT > SCENE_HEIGHT) paddle.setY(SCENE_HEIGHT);

        });

        // Each stage (Window!) need at least a scene
        // stage.setScene(scene); => always at the very bottom
        stage.setScene(scene);
        stage.setTitle("Bouncing ball");

        // By default, is hidden
        stage.show();
    }

    public void resetGame(){
        score = 0;
        scoreText.setText("Score : 0");
        gameOverText.setVisible(false);

        ball.setCenterX(SCENE_WIDTH / 2);
        ball.setCenterY(SCENE_HEIGHT / 2);

        // offset to the paddle
        paddle.setX(10);
        paddle.setY(SCENE_HEIGHT / 2 - PADDLE_HEIGHT / 2);


    }
}