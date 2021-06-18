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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import video.MyAudioPlay;

public class Base extends AnchorPane{
    
    
    protected final Button Single;
     protected final Button button;
    protected final Button Offline;
    protected final Button exit;
    protected final Button Online;
    protected final ImageView rotationImage;
    
    //Audio
    MyAudioPlay audio=new MyAudioPlay();
    
     public Base() throws FileNotFoundException{
     
     
        Single = new Button();
        Offline = new Button();
        exit = new Button();
        Online = new Button();
        rotationImage=new ImageView();
        button=new Button();

         setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(500.0);
        setPrefWidth(590.0);
        setStyle("-fx-background-color: #FFFFFF;");

             rotationImage.setFitHeight(249.0);
        rotationImage.setFitWidth(330.0);
        rotationImage.setLayoutX(130.0);
        rotationImage.setLayoutY(51.0);
        rotationImage.setPickOnBounds(true);
        rotationImage.setPreserveRatio(true);
       // rotationImage.setImage(new Image(getClass().getResource("../resources/proj.png").toExternalForm()));
        FileInputStream proj = new FileInputStream("src\\resources\\proj.png");
        Image image = new Image(proj);
        rotationImage.setImage(image);
      

         Single.setLayoutX(33.0);
        Single.setLayoutY(383.0);
        Single.setMnemonicParsing(false);
        Single.setPrefHeight(39.0);
        Single.setPrefWidth(135.0);
        Single.setStyle("-fx-background-color: #F2EC3F; -fx-background-radius: 20px;");
        Single.setText("single player");
        Single.setFont(javafx.scene.text.Font.font("Arial", FontWeight.BOLD, 14.0));
        
        
        Single.setOnMouseClicked(e->{
         try {
             audio.play();
             Single.getParent().getScene().setRoot(new OnePlayerGame());
         } catch (FileNotFoundException ex) {
             Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, ex);
         }
        });

      Offline.setLayoutX(422.0);
        Offline.setLayoutY(383.0);
        Offline.setMnemonicParsing(false);
        Offline.setPrefHeight(39.0);
        Offline.setPrefWidth(135.0);
        Offline.setStyle("-fx-background-color: #F2EC3F; -fx-background-radius: 20px;");
        Offline.setText("offline players");
        Offline.setFont(javafx.scene.text.Font.font("Arial", FontWeight.BOLD, 14.0));
        
         Offline.setOnMouseClicked(e->{
         try {
             audio.play();
             Offline.getParent().getScene().setRoot(new TwoPlayerGame());
         } catch (FileNotFoundException ex) {
             Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, ex);
         }
        });
        Online.setLayoutX(228.0);
        Online.setLayoutY(383.0);
        Online.setMnemonicParsing(false);
        Online.setPrefHeight(39.0);
        Online.setPrefWidth(135.0);
        Online.setStyle("-fx-background-color: #F2EC3F; -fx-background-radius: 20px;");
        Online.setText("online players");
        Online.setFont(javafx.scene.text.Font.font("Arial", FontWeight.BOLD, 14.0));
        
         Online.setOnMouseClicked(e->{
         try {
             audio.play();
             Online.getParent().getScene().setRoot(new ChooseConnectionBase());
         } catch (FileNotFoundException ex) {
             Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, ex);
         }
        });

        button.setLayoutX(228.0);
        button.setLayoutY(430.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(39.0);
        button.setPrefWidth(135.0);
        button.setFont(javafx.scene.text.Font.font("Arial", FontWeight.BOLD, 14.0));
        button.setStyle("-fx-background-color: #F2EC3F; -fx-background-radius: 20px;");
        button.setText("History");
        
        button.setOnAction(e->{
            
            try {
                button.getParent().getScene().setRoot(new History());
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
        rotate.setNode(rotationImage);
        rotate.play();

        getChildren().add(rotationImage);
        getChildren().add(Single);
        getChildren().add(Online);
        getChildren().add(Offline);
        getChildren().add(button);
     
     }
}
