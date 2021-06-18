package gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.StrokeTransition;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class GameOverBase extends AnchorPane {

    protected final ImageView logo;
    protected final Button saveGame;
    protected final Button reloadGame;
    protected final Button exit;
  //  protected final Rectangle rectangle;

    public GameOverBase() throws FileNotFoundException {

        logo = new ImageView();
        saveGame = new Button();
        reloadGame = new Button();
        exit = new Button();
      //  rectangle = new Rectangle();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(450.0);
        setPrefWidth(360.0);
        setStyle("-fx-background-color: #4EB9F5;");

  
   
     
   /*     rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.DODGERBLUE);
        rectangle.setHeight(200.0);
        rectangle.setLayoutX(73.0);
        rectangle.setLayoutY(33.0);
        rectangle.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(210.0); */

        logo.setFitHeight(200.0);
        logo.setFitWidth(350.0);
        logo.setLayoutX(78.0);
        logo.setLayoutY(35.0);
        logo.setPickOnBounds(true);
        logo.setPreserveRatio(true);
        FileInputStream file=new FileInputStream("src\\resources\\game-over.png");
        Image image=new Image(file);
        logo.setImage(image);
       
     

        saveGame.setLayoutX(95.0);
        saveGame.setLayoutY(265.0);
        saveGame.setMnemonicParsing(false);
        saveGame.setPrefHeight(30.0);
        saveGame.setPrefWidth(180.0);
        saveGame.setStyle("-fx-background-color: #F2EC3F; -fx-background-radius: 20px;");
        saveGame.setText("Save Your Game");
        saveGame.setFont(new Font("System Bold", 14.0));

        reloadGame.setLayoutX(93.0);
        reloadGame.setLayoutY(314.0);
        reloadGame.setMnemonicParsing(false);
        reloadGame.setPrefHeight(30.0);
        reloadGame.setPrefWidth(180.0);
        reloadGame.setStyle("-fx-background-color: #F2EC3F; -fx-background-radius: 20px;");
        reloadGame.setText("Reload Game");
        reloadGame.setFont(new Font("System Bold", 14.0));

        exit.setLayoutX(93.0);
        exit.setLayoutY(362.0);
        exit.setMnemonicParsing(false);
        exit.setPrefHeight(30.0);
        exit.setPrefWidth(180.0);
        exit.setStyle("-fx-background-color: #F2EC3F; -fx-background-radius: 20px;");
        exit.setText("Exit");
        exit.setFont(new Font("System Bold", 14.0));
        
        
      
     /*   // Animation for logo
           
        rectangle.setStrokeWidth(6);
        StrokeTransition stroke = new StrokeTransition();  
        stroke.setAutoReverse(true);  
        stroke.setCycleCount(500);  
        stroke.setDuration(Duration.millis(400));  
        stroke.setFromValue(Color.BLACK);  
        stroke.setToValue(Color.WHITE);  
        stroke.setShape(rectangle);  
        stroke.play(); */
 
     
        
        
      //  getChildren().add(rectangle);
        getChildren().add(logo);
        getChildren().add(saveGame);
        getChildren().add(reloadGame);
        getChildren().add(exit);
       

    }
}
