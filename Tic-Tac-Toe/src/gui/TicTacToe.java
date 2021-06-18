package gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.animation.RotateTransition;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class TicTacToe extends AnchorPane {

    protected final ImageView logo;
    protected final Button startBtn;

    public TicTacToe() throws FileNotFoundException {

        logo = new ImageView();
        startBtn = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(500.0);
        setPrefWidth(590.0);
        setStyle("-fx-background-color: #FFFFFF;");

        logo.setFitHeight(259.0);
        logo.setFitWidth(332.0);
        logo.setLayoutX(14.0);
        logo.setLayoutY(53.0);
        logo.setPickOnBounds(true);
        logo.setPreserveRatio(true);

       
        FileInputStream proj = new FileInputStream("src\\resources\\proj.png");
        Image image = new Image(proj);
        logo.setImage(image);
        startBtn.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        startBtn.setLayoutX(95.0);
        startBtn.setLayoutY(340.0);
        startBtn.setMnemonicParsing(false);
        startBtn.setPrefHeight(33.0);
        startBtn.setPrefWidth(171.0);
        startBtn.setFont(new Font("System Bold",18.0));
      //  startBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        startBtn.setStyle("-fx-background-color:  #F2EC3F; -fx-background-radius: 20px;");
        startBtn.setText("start game");
        startBtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        
        RotateTransition rotate = new RotateTransition(); 
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setByAngle(360);
        rotate.setCycleCount(500);        
        rotate.setDuration(Duration.millis(1000));
        rotate.setAutoReverse(false);
        rotate.setNode(logo);
        rotate.play();

        getChildren().add(logo);
        getChildren().add(startBtn);

    }
}
