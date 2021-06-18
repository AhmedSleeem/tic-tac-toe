/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author Hp450
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.RotateTransition;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import video.MyAudioPlay;

public class GameLevel extends AnchorPane {
    
  
    protected final Button easy;
    protected final Button middle;
    protected final ImageView rotationImage2;
    protected final Button hard;
     protected final Button button;
    protected  String userEmail;
    protected final ImageView backBIcon;
    
    protected MyAudioPlay audio=new MyAudioPlay();
    
    public GameLevel(String userEmail) throws FileNotFoundException{
        rotationImage2 = new ImageView();
        this.userEmail=userEmail;
        backBIcon=new ImageView();
        button=new Button();
        easy = new Button();
        middle = new Button();
        hard = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(500.0);
        setPrefWidth(590.0);
        setStyle("-fx-background-color: #FFFFFF;");
       // setStyle("-fx-background-image: 'bbb';");
       
        button.setLayoutX(1.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(60.0);
        button.setPrefWidth(65.0);
        button.setStyle("-fx-background-color: #FFFFFF;");
        

       /* backBIcon.setFitHeight(60.0);
        backBIcon.setFitWidth(65.0);
        backBIcon.setLayoutX(4.0);
        backBIcon.setPickOnBounds(true);
        backBIcon.setPreserveRatio(true);*/
       // backBIcon.setImage(new Image(getClass().getResource("../resources/undo%20(1).png").toExternalForm()));
        FileInputStream backIIcon = new FileInputStream("src\\resources\\undo_1.png");
        Image iiconn = new Image(backIIcon);
        ImageView backview = new ImageView(iiconn);
        backview.setFitHeight(40.0);
        backview.setFitWidth(40.0);
        button.setGraphic(backview);
        
        button.setOnAction(e->{
            try {
                button.getParent().getScene().setRoot(new Base());
            } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
        });
       
         rotationImage2.setFitHeight(254.0);
        rotationImage2.setFitWidth(339.0);
        rotationImage2.setLayoutX(126.0);
        rotationImage2.setLayoutY(68.0);
        rotationImage2.setPickOnBounds(true);
        rotationImage2.setPreserveRatio(true);
       // rotationImage2.setImage(new Image(getClass().getResource("../resources/proj.png").toExternalForm()));
        FileInputStream proj2 = new FileInputStream("src\\resources\\proj.png");
        Image image2 = new Image(proj2);
        rotationImage2.setImage(image2);

     

         easy.setLayoutX(33.0);
        easy.setLayoutY(389.0);
        easy.setMnemonicParsing(false);
        easy.setPrefHeight(39.0);
        easy.setPrefWidth(135.0);
        easy.setStyle("-fx-background-color: #F7E036; -fx-background-radius: 20px;");
        easy.setText("easy");
         easy.setFont(javafx.scene.text.Font.font("Arial", FontWeight.BOLD, 14.0));
        
        easy.setOnMouseClicked(e->{
            audio.play();    
            try {
                easy.getParent().getScene().setRoot(new GameSingle(this.userEmail,1));
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
               
        });

        middle.setLayoutX(228.0);
        middle.setLayoutY(389.0);
        middle.setMnemonicParsing(false);
        middle.setPrefHeight(39.0);
        middle.setPrefWidth(135.0);
        middle.setStyle("-fx-background-color: #F6BE00; -fx-background-radius: 20px;");
        middle.setText("meduim");
         middle.setFont(javafx.scene.text.Font.font("Arial", FontWeight.BOLD, 14.0));
         middle.setOnMouseClicked(e->{
            audio.play();    
            try {
                middle.getParent().getScene().setRoot(new GameSingle(this.userEmail,2));
            } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
               
        });

       
        hard.setLayoutX(420.0);
        hard.setLayoutY(389.0);
        hard.setMnemonicParsing(false);
        hard.setPrefHeight(39.0);
        hard.setPrefWidth(135.0);
        hard.setStyle("-fx-background-color: #EA9B11; -fx-background-radius: 20px;");
        hard.setText("hard");
         hard.setFont(javafx.scene.text.Font.font("Arial", FontWeight.BOLD, 14.0));
        hard.setOnMouseClicked(e->{
            audio.play();    
            try {
                hard.getParent().getScene().setRoot(new GameSingle(this.userEmail,3));
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
               
        });
           //rotation image code
        RotateTransition rotate = new RotateTransition();
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setByAngle(360);
        rotate.setCycleCount(500);
        rotate.setDuration(Duration.millis(1000));
        rotate.setAutoReverse(false);
        rotate.setNode(rotationImage2);
        rotate.play();
        
        
        getChildren().add(rotationImage2);
        getChildren().add(easy);
        getChildren().add(button);
        getChildren().add(backBIcon);
        getChildren().add(middle);
        getChildren().add(hard);
    
    }

    
}
