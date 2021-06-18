package gui;

import database.Mysql;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.animation.StrokeTransition;
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

public class TwoPlayerGame extends AnchorPane {

    protected final ImageView logo;
    protected final TextField textField;
    protected final InnerShadow innerShadow;
    protected final TextField textField0;
    protected final InnerShadow innerShadow0;
    protected final Button btnStart;
    protected final Rectangle rectangle;
     protected final Button back;
    protected final ImageView imageView0;
    
    protected Mysql mysql =new Mysql();
    
    protected MyAudioPlay audio= new MyAudioPlay();

    public TwoPlayerGame() throws FileNotFoundException {

        logo = new ImageView();
        textField = new TextField();
        innerShadow = new InnerShadow();
        textField0 = new TextField();
         rectangle = new Rectangle();
        innerShadow0 = new InnerShadow();
        btnStart = new Button();
         back = new Button();
        imageView0 = new ImageView();

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
        

        textField.setLayoutX(174.0);
        textField.setLayoutY(281.0);
        textField.setPrefHeight(37.0);
        textField.setPrefWidth(246.0);
        textField.setPromptText("Player1's email");

        textField.setEffect(innerShadow);

        textField0.setLayoutX(175.0);
        textField0.setLayoutY(331.0);
        textField0.setPrefHeight(37.0);
        textField0.setPrefWidth(246.0);
        textField0.setPromptText("Player2's email");

        textField0.setEffect(innerShadow0);

        btnStart.setLayoutX(174.0);
        btnStart.setLayoutY(388.0);
        btnStart.setMnemonicParsing(false);
        btnStart.setPrefHeight(30.0);
        btnStart.setPrefWidth(246.0);
        btnStart.setStyle("-fx-background-color: #F2EC3F; -fx-background-radius: 20PX;");
        btnStart.setText(" New Game");
        btnStart.setFont(new Font("System Bold", 14.0));
        
        btnStart.setOnMouseClicked(e->{
            audio.play();
              
    
            if(!textField.getText().equals("")){
                if(validateEmail(textField.getText())){
                    
                    if(!textField0.getText().equals("")){
                        
                        if(validateEmail(textField0.getText())){
                            try {
                                if(textField.getText().equalsIgnoreCase(textField0.getText())){
                                     openDialog("the two players can't use the same Email");
                                }else{
                                    
                                    try {
                                        mysql.addPlayer(textField.getText());
                                        mysql.addPlayer(textField0.getText());
                                    } catch (SQLException ex) {
                                            ex.printStackTrace();
                                        }
                                    
                                 btnStart.getParent().getScene().setRoot(new GameMulti(textField.getText(),textField0.getText()));
                                }
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(TwoPlayerGame.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }else {
                            openDialog("second player : please valid E-mail");
                        }
                    }else {
                         openDialog("second player : please Enter E-mail");
                    }
                    
                    
                }else {
                    openDialog("first player : please valid E-mail");
                }
            }else {
                openDialog("first player : please Enter E-mail");
            }
        });
        
          back.setLayoutX(175.0);
        back.setLayoutY(440.0);
        back.setMnemonicParsing(false);
        back.setPrefHeight(30.0);
        back.setPrefWidth(246.0);
        back.setStyle("-fx-background-color: #F2EC3F; -fx-background-radius: 20PX;");
        back.setText("Back");
        back.setFont(new Font("System Bold", 14.0));
        back.setOnMouseClicked(e->{
        
            try {
                back.getParent().getScene().setRoot(new Base());
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        });
        
        
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
        getChildren().add(textField);
        getChildren().add(textField0);
        getChildren().add(btnStart);
        getChildren().add(back);
        getChildren().add(imageView0);
         

    }
    
    boolean validateEmail(String email){
         String zeroTo255 = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
            String patternStr = zeroTo255;
            Pattern patternReg = Pattern.compile(patternStr); // Create the pattern
            
           return patternReg.matcher(email).matches();
                
        
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
