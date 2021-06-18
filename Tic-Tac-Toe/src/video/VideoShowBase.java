package video;

import database.GameRecorder;
import gui.Base;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import gui.SavePointMulti;
import gui.SavePointSingle;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VideoShowBase extends AnchorPane {

    protected final Button button;
    protected final Button button0;
    protected final Button button1;
     protected final String videoName;
     public GameRecorder gameRecorder;
     
     protected final VBox vBox;
     String camrFrom;

    public VideoShowBase(String name,GameRecorder gameRecorder,String camrFrom) {
        this.gameRecorder=gameRecorder;
         this.videoName = name;
         this.camrFrom=camrFrom;
           vBox = new VBox();
        button = new Button();
        button0 = new Button();
        button1 = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(500.0);
        setPrefWidth(590.0);
        setStyle("-fx-background-color: #4EB9F5;");
        
           AnchorPane.setBottomAnchor(vBox, 94.0);
        AnchorPane.setLeftAnchor(vBox, 0.0);
        AnchorPane.setRightAnchor(vBox, 0.39999999999997726);
        AnchorPane.setTopAnchor(vBox, 0.0);
        vBox.setPrefHeight(403.0);
        vBox.setPrefWidth(323.0);
        
        button.setLayoutX(44.0);
        button.setLayoutY(415.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(30.0);
        button.setPrefWidth(148.0);
        button.setStyle("-fx-background-color: #F2EC3F; -fx-background-radius: 20PX;");
        button.setText("Main Menu");
        button.setFont(new Font("System Bold", 14.0));
        
        button.setOnAction(e->{
            try {
                button.getParent().getScene().setRoot(new Base());
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        });

        button0.setLayoutX(233.0);
        button0.setLayoutY(415.0);
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(30.0);
        button0.setPrefWidth(148.0);
        button0.setStyle("-fx-background-color: #F2EC3F; -fx-background-radius: 20PX;");
        button0.setText("Save Game");
        button0.setFont(new Font("System Bold", 14.0));
        

        button1.setLayoutX(413.0);
        button1.setLayoutY(415.0);
        button1.setMnemonicParsing(false);
        button1.setPrefHeight(30.0);
        button1.setPrefWidth(148.0);
        button1.setStyle("-fx-background-color: #F2EC3F; -fx-background-radius: 20PX;");
        button1.setText("Exit");
        button1.setFont(new Font("System Bold", 14.0)); 
            
             MediaPlayer player = new MediaPlayer( new Media(getClass().getResource(videoName).toExternalForm()));
        MediaView mediaView = new MediaView(player);
        player.play();
        
         vBox.getChildren().add(mediaView);
        button.setOnAction((ActionEvent e) -> {
            player.stop();
           
            try {
                button.getParent().getScene().setRoot(new Base());
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            
        });
        
        
         button0.setOnAction(e->{
            
              player.stop();
            try {
                  try {
                    // if(!SavePointMulti.isSaved)SavePointMulti.isSaved=true;
                     button0.getParent().getScene().setRoot(new SavePointMulti(this.gameRecorder));
                  } catch (SQLException ex) {
                        ex.printStackTrace();
                      }
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        });
         button1.setOnAction(e->{
                  player.stop();
            System.exit(0);
        });

        
            getChildren().add(vBox);
        getChildren().add(button);
        getChildren().add(button0);
        getChildren().add(button1);
        
        
        
         
        
       
    }
}
