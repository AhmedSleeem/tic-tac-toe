package gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.animation.StrokeTransition;
import javafx.scene.control.Accordion;
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

public class ChooseConnectionBase extends AnchorPane {

    protected final Button create;
    protected final Button join;
    protected final Button back;
    protected final Rectangle rectangle;
    protected final ImageView logo;
    protected final TextField textField;
    protected final InnerShadow innerShadow;
    
    protected MyAudioPlay audio=new MyAudioPlay();

    public ChooseConnectionBase() throws FileNotFoundException {

        create = new Button();
        join = new Button();
        back = new Button();
        rectangle = new Rectangle();
        logo = new ImageView();
        textField = new TextField();
        innerShadow = new InnerShadow();

        
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(500.0);
        setPrefWidth(590.0);
        setStyle("-fx-background-color: #4EB9F5;");

           create.setLayoutX(175.0);
        create.setLayoutY(338.0);
        create.setMnemonicParsing(false);
        create.setPrefHeight(30.0);
        create.setPrefWidth(246.0);
        create.setStyle("-fx-background-color: #F2EC3F; -fx-background-radius: 20PX;");
        create.setText("Create");
        create.setFont(new Font("System Bold", 14.0));
        
        create.setOnMouseClicked(e->{
            audio.play();
              
    
            try {
               
                
                if(!textField.getText().equals("")){
                    if(validateEmail(textField.getText())){
                        
                    
                create.getParent().getScene().setRoot(new CreateConnection(textField.getText()));
                    }else {
                        openDialog("please valid E-mail");
                    }
                }else {
                    openDialog("please Enter E-mail");
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ChooseConnectionBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        

       join.setLayoutX(175.0);
        join.setLayoutY(391.0);
        join.setMnemonicParsing(false);
        join.setPrefHeight(30.0);
        join.setPrefWidth(246.0);
        join.setStyle("-fx-background-color: #F2EC3F; -fx-background-radius: 20PX;");
        join.setText("Join");
        join.setFont(new Font("System Bold", 14.0));
        
        join.setOnMouseClicked(e->{
            audio.play();
              
    
            try {
               
                if(!textField.getText().equals("")){
                    if(validateEmail(textField.getText())){
                        
                    
                join.getParent().getScene().setRoot(new JoinConnection(textField.getText()));
                    }else {
                        openDialog("please valid E-mail");
                    }
                }else {
                    openDialog("please Enter E-mail");
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ChooseConnectionBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        

        back.setLayoutX(175.0);
        back.setLayoutY(444.0);
        back.setMnemonicParsing(false);
        back.setPrefHeight(30.0);
        back.setPrefWidth(246.0);
        back.setStyle("-fx-background-color: #F2EC3F; -fx-background-radius: 20PX;");
        back.setText("Back");
        back.setFont(new Font("System Bold", 14.0));
        
        back.setOnMouseClicked(e->{
            try {
                audio.play();
                back.getParent().getScene().setRoot(new Base());
            } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
        });
        
        

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
       

          textField.setLayoutX(179.0);
        textField.setLayoutY(282.0);
        textField.setPrefHeight(36.0);
        textField.setPrefWidth(238.0);
        textField.setPromptText("Player1's email");

        textField.setEffect(innerShadow);
        
        
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

        getChildren().add(create);
        getChildren().add(join);
        getChildren().add(back);
        getChildren().add(rectangle);
        getChildren().add(logo);
        getChildren().add(textField);

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
    
    boolean validateEmail(String email){
         String zeroTo255 = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
            String patternStr = zeroTo255;
            Pattern patternReg = Pattern.compile(patternStr); // Create the pattern
            
           return patternReg.matcher(email).matches();
                
        
    }
}
