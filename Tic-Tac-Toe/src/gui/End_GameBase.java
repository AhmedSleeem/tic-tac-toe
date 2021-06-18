package gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.animation.StrokeTransition;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class End_GameBase extends AnchorPane {

    protected final Button saveGame;
    protected final Button reloadGame;
    protected final Button exit;
    protected final Label label;
    protected final Circle circle;
    protected final ImageView logo;
   

    public End_GameBase() throws FileNotFoundException {

        saveGame = new Button();
        reloadGame = new Button();
        exit = new Button();
        label = new Label();
        circle = new Circle();
        logo = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(450.0);
        setPrefWidth(360.0);
        setStyle("-fx-background-color: #4EB9F5;");

        saveGame.setLayoutX(93.0);
        saveGame.setLayoutY(314.0);
        saveGame.setMnemonicParsing(false);
        saveGame.setPrefHeight(30.0);
        saveGame.setPrefWidth(180.0);
        saveGame.setStyle("-fx-background-color: #F2EC3F; -fx-background-radius: 20px;");
        saveGame.setText("Save Your Game");
        saveGame.setFont(new Font("System Bold", 14.0));

        reloadGame.setLayoutX(93.0);
        reloadGame.setLayoutY(355.0);
        reloadGame.setMnemonicParsing(false);
        reloadGame.setPrefHeight(30.0);
        reloadGame.setPrefWidth(180.0);
        reloadGame.setStyle("-fx-background-color: #F2EC3F; -fx-background-radius: 20px;");
        reloadGame.setText("Reload Game");
        reloadGame.setFont(new Font("System Bold", 14.0));

        exit.setLayoutX(94.0);
        exit.setLayoutY(398.0);
        exit.setMnemonicParsing(false);
        exit.setPrefHeight(30.0);
        exit.setPrefWidth(178.0);
        exit.setStyle("-fx-background-color: #F2EC3F; -fx-background-radius: 20px;");
        exit.setText("Exit");
        exit.setFont(new Font("System Bold", 14.0));

        label.setLayoutX(77.0);
        label.setLayoutY(13.0);
        label.setText("congratulations");
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font("System Bold", 28.0));
        
        logo.setFitHeight(250.0);
        logo.setFitWidth(340.0);
        logo.setLayoutX(52.0);
        logo.setLayoutY(53.0);
        logo.setPickOnBounds(true);
        logo.setPreserveRatio(true);
        FileInputStream file=new FileInputStream("src\\resources\\balloons.png");
        Image image=new Image(file);
        logo.setImage(image);
      
       

       // circle.setFill(javafx.scene.paint.Color.DODGERBLUE);
        circle.setFill(new ImagePattern(image));
        circle.setLayoutX(177.0);
        circle.setLayoutY(178.0);
        circle.setRadius(120.0);
        circle.setStroke(javafx.scene.paint.Color.BLACK);
        circle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);

      
       // Animation for congratulation image
           
        circle.setStrokeWidth(6);
        StrokeTransition stroke = new StrokeTransition();  
        stroke.setAutoReverse(true);  
        stroke.setCycleCount(500);  
        stroke.setDuration(Duration.millis(500));  
        stroke.setFromValue(Color.BLACK);  
        stroke.setToValue(Color.WHITE);  
        stroke.setShape(circle);  
        stroke.play();     
        
       

        getChildren().add(saveGame);
        getChildren().add(reloadGame);
        getChildren().add(exit);
        getChildren().add(label);
        getChildren().add(circle);
        getChildren().add(logo);

    }
}
