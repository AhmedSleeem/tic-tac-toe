package gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.animation.StrokeTransition;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import video.MyAudioPlay;

public class JoinConnection extends AnchorPane {

    protected final Rectangle rectangle;
    protected final ImageView logo;
    protected final Button back;
    protected final Button join;
    protected final TextField textFieldIP;
    protected final InnerShadow innerShadow;
    
    protected  String userEmail;
    
    protected MyAudioPlay audio= new MyAudioPlay();
    
     GameOnLine mainClientPage;
    protected final String playSymbol = "O";

    public JoinConnection(String userEmail) throws FileNotFoundException {
        
        this.userEmail=userEmail;
        rectangle = new Rectangle();
        logo = new ImageView();
        back = new Button();
        join = new Button();
        textFieldIP = new TextField();
        innerShadow = new InnerShadow();

       setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(500.0);
        setPrefWidth(590.0);
        setStyle("-fx-background-color: #4EB9F5;");

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#4eb9f5"));
        rectangle.setHeight(253.0);
        rectangle.setLayoutX(170.0);
        rectangle.setLayoutY(14.0);
        rectangle.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(253.0);

        logo.setFitHeight(242.0);
        logo.setFitWidth(238.0);
        logo.setLayoutX(177.0);
        logo.setLayoutY(20.0);
        logo.setPickOnBounds(true);
        logo.setPreserveRatio(true);
        FileInputStream file=new FileInputStream("src\\resources\\new.png");
        Image image=new Image(file);
        logo.setImage(image);
       

        back.setLayoutX(175.0);
        back.setLayoutY(427.0);
        back.setMnemonicParsing(false);
        back.setPrefHeight(30.0);
        back.setPrefWidth(246.0);
        back.setStyle("-fx-background-color: #F2EC3F; -fx-background-radius: 20PX;");
        back.setText("Back");
        back.setFont(new Font("System Bold", 14.0));
        
        back.setOnAction((ActionEvent e) -> {
            audio.play();
            try {           
                back.getParent().getScene().setRoot(new Base());
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        });


         join.setLayoutX(174.0);
        join.setLayoutY(369.0);
        join.setMnemonicParsing(false);
        join.setPrefHeight(30.0);
        join.setPrefWidth(246.0);
        join.setStyle("-fx-background-color: #F2EC3F; -fx-background-radius: 20PX;");
        join.setText("Join");
        join.setFont(new Font("System Bold", 14.0));
        
        join.setOnAction((ActionEvent e) -> {
            String zeroTo255 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
            String patternStr = zeroTo255 + "\\." + zeroTo255 + "\\." +
                                zeroTo255 + "\\." + zeroTo255; 

            Pattern patternReg = Pattern.compile(patternStr); // Create the pattern
            Socket s = null;
            try {
                audio.play();
                if(!textFieldIP.getText().equals("")){
                    if(patternReg.matcher(textFieldIP.getText()).matches()){ 
// check if it is valid ip 
                        if(InetAddress.getByName(textFieldIP.getText()).isReachable(500)){ // the ip address is reachable
                            s = new Socket(textFieldIP.getText(), 5000);

                            mainClientPage = new GameOnLine(playSymbol,userEmail, s, null);
                            join.getParent().getScene().setRoot(mainClientPage);
                        } else {
                            openDialog("Can't reach this IP address\nTry again");
                        }
                    } else {
                        openDialog("You entered a wrong IP address");
                    }
                } else {
                    openDialog("You have to enter an IP address");
                }
            } catch(IOException ex) {
                ex.printStackTrace();
                try{
                    s.close();
                } catch(IOException ioX) {ioX.printStackTrace();}
            };     
        });
        
        

        textFieldIP.setLayoutX(174.0);
        textFieldIP.setLayoutY(303.0);
        textFieldIP.setPrefHeight(37.0);
        textFieldIP.setPrefWidth(246.0);
        textFieldIP.setPromptText("Enter IP");

        textFieldIP.setEffect(innerShadow);;
        
        
        // Animation for logo
           
        rectangle.setStrokeWidth(6);
        StrokeTransition stroke = new StrokeTransition();  
        stroke.setAutoReverse(true);  
        stroke.setCycleCount(500);  
        stroke.setDuration(Duration.millis(400));  
        stroke.setFromValue(Color.BLACK);  
        stroke.setToValue(Color.WHITE);  
        stroke.setShape(rectangle);  
        stroke.play();     

        getChildren().add(rectangle);
        getChildren().add(logo);
        getChildren().add(back);
        getChildren().add(join);
        getChildren().add(textFieldIP);

    }
     void openDialog(String content) {
        Dialog <String> dialog = new Dialog();
        dialog.setResizable(false);
        
        StackPane pane = new StackPane();
        Text text = new Text(content);
        pane.getChildren().add(text);
        
        dialog.getDialogPane().setContent(pane);
        
        ButtonType okBtn = new ButtonType("Okay");
        
        dialog.getDialogPane().getButtonTypes().add(okBtn);
        
        dialog.showAndWait();
    }
}
