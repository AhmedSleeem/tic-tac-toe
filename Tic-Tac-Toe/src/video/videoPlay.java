package video;

import gui.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class videoPlay extends AnchorPane {

    protected final VBox vBox;
    protected final Button button;
   
    protected final String videoName;

    public videoPlay(String name) {
        
        this.videoName = name;

        vBox = new VBox();
        button = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(403.0);
        setPrefWidth(323.0);
        getStyleClass().add("video");
       // getStylesheets().add("video/style.css");
        
        AnchorPane.setBottomAnchor(vBox, 94.0);
        AnchorPane.setLeftAnchor(vBox, 0.0);
        AnchorPane.setRightAnchor(vBox, 0.39999999999997726);
        AnchorPane.setTopAnchor(vBox, 0.0);
        vBox.setPrefHeight(403.0);
        vBox.setPrefWidth(323.0);

        button.setLayoutX(199.0);
        button.setLayoutY(390.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(35.0);
        button.setPrefWidth(180.0);
        button.setText("Main Menu");

        getChildren().add(vBox);
        getChildren().add(button);
               
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

    }
}
