package gui;

import database.GameRecorder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import video.VideoShowBase;

public class GameMulti extends AnchorPane {

    protected final Button newGame;
    protected final ImageView imageView;
    protected final ImageView imageView1;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Label label2;
    protected final Label label3;
    protected final Button button0;
    protected final Button button1;
    protected final Button button2;
    protected final Button button3;
    protected final Button button4;
    protected final Button button5;
    protected final Button button6;
    protected final Button button7;
    protected final Button button8;
    protected final Button backIcon;
    protected final ImageView imageView0;
   // protected final Button playAgain;
    
    
     boolean isGameEnds;
    boolean isFirstPlayerTurn = true;
    int XOCounter = 0;
    Color xForeground = Color.BLUE;
    Color oForeground = Color.RED;
    
    int []pos=new int[9];
    int count=0;
    
    //store emails of the two players
    protected  String userOneEmail;
    protected  String userTwoEmail2;
    
   

    public GameMulti(String userEmail,String userEmail2) throws FileNotFoundException {
        
        this.userTwoEmail2=userEmail2;
        this.userOneEmail=userEmail;
        
       // playAgain = new Button();
        newGame = new Button();
        imageView = new ImageView();
        imageView1 = new ImageView();
        
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        label3 = new Label();
        button0 = new Button();
        button1 = new Button();
        button2 = new Button();
        button3 = new Button();
        button4 = new Button();
        button5 = new Button();
        button6 = new Button();
        button7 = new Button();
        button8 = new Button();
        
     
        
        
       
        
        backIcon = new Button();
        imageView0 = new ImageView();

          setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(500.0);
        setPrefWidth(590.0);
        setStyle("-fx-background-color: #4EB9F5;");


        newGame.setLayoutX(447.0);
        newGame.setLayoutY(428.0);
        newGame.setMnemonicParsing(false);
        newGame.setPrefHeight(40.0);
        newGame.setPrefWidth(130.0);
        newGame.setStyle("-fx-background-color: #F2EC3F; -fx-background-radius: 20px;");
        newGame.setText("Play Again");
        newGame.setFont(new Font("System Bold", 14.0));
        newGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startNewGame();
            }
        });
        
        
        

        imageView.setFitHeight(330.0);
        imageView.setFitWidth(400.0);
        imageView.setLayoutX(133.0);
        imageView.setLayoutY(79.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        FileInputStream file=new FileInputStream("src\\resources\\board_1.png");
        Image image=new Image(file);
        imageView.setImage(image);
        
        imageView0.setFitHeight(40.0);
        imageView0.setFitWidth(68.0);
        imageView0.setLayoutX(9.0);
        imageView0.setLayoutY(11.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        
         imageView1.setFitHeight(40.0);
        imageView1.setFitWidth(55.0);
        imageView1.setLayoutX(4.0);
        imageView1.setLayoutY(6.0);
      
         file=new FileInputStream("src\\resources\\undo_1.png");
         image=new Image(file);
        imageView1.setImage(image);
        
        
       
        label.setLayoutX(143.0);
        label.setLayoutY(15.0);
        label.setText(userEmail);
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font("System Bold", 15.0));

       label0.setLayoutX(424.0);
        label0.setLayoutY(15.0);
        label0.setText(userEmail2);
        label0.setTextFill(javafx.scene.paint.Color.WHITE);
        label0.setFont(new Font("System Bold", 15.0));

        label1.setLayoutX(300.0);
        label1.setLayoutY(18.0);
        label1.setText("X");
        label1.setTextFill(javafx.scene.paint.Color.valueOf("#ff5a5a"));
        label1.setFont(new Font("System Bold", 16.0));

        label2.setLayoutX(161.0);
        label2.setLayoutY(40.0);
        label2.setText("X");
        label2.setTextFill(xForeground);
        label2.setFont(new Font("System Bold", 14.0));

        label3.setLayoutX(448.0);
        label3.setLayoutY(40.0);
        label3.setText("O");
        label3.setTextFill(oForeground);
        label3.setFont(new Font("System Bold", 14.0));

       
       
        button0.setLayoutX(135.0);
        button0.setLayoutY(87.0);
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(85.0);
        button0.setPrefWidth(88.0);
        button0.setStyle("-fx-background-color: #4EB9F5;");
        //button0.setVisible(false);
        button0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               actionTaken(button0);
            }
        });
        button0.setFont(Font.font("Arial", FontWeight.BOLD, 34));
        button0.setStyle("-fx-background-color: #4EB9F5;");

      button1.setLayoutX(250.0);
        button1.setLayoutY(95.0);
        button1.setMnemonicParsing(false);
        button1.setPrefHeight(85.0);
        button1.setPrefWidth(95.0);
        button1.setStyle("-fx-background-color: #4EB9F5;");
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                actionTaken(button1);
            }
        });
        button1.setFont(Font.font("Arial", FontWeight.BOLD, 34));
        button1.setStyle("-fx-background-color: #4EB9F5;");

     button2.setLayoutX(372.0);
        button2.setLayoutY(90.0);
        button2.setMnemonicParsing(false);
        button2.setPrefHeight(85.0);
        button2.setPrefWidth(88.0);
        button2.setStyle("-fx-background-color: #4EB9F5;");
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                actionTaken(button2);
            }
        });
        button2.setFont(Font.font("Arial", FontWeight.BOLD, 34));
        button2.setStyle("-fx-background-color: #4EB9F5;");
       button3.setLayoutX(144.0);
        button3.setLayoutY(201.0);
        button3.setMnemonicParsing(false);
        button3.setPrefHeight(85.0);
        button3.setPrefWidth(88.0);
        button3.setStyle("-fx-background-color: #4EB9F5;");
        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                actionTaken(button3);
            }
        });
        button3.setFont(Font.font("Arial", FontWeight.BOLD, 34));
        button3.setStyle("-fx-background-color: #4EB9F5;");

      
        button4.setLayoutX(254.0);
        button4.setLayoutY(200.0);
        button4.setMnemonicParsing(false);
        button4.setPrefHeight(85.0);
        button4.setPrefWidth(88.0);
        button4.setStyle("-fx-background-color: #4EB9F5;");
        button4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                actionTaken(button4);
            }
        });
        button4.setFont(Font.font("Arial", FontWeight.BOLD, 34));
        button4.setStyle("-fx-background-color: #4EB9F5;");

     button5.setLayoutX(365.0);
        button5.setLayoutY(200.0);
        button5.setMnemonicParsing(false);
        button5.setPrefHeight(85.0);
        button5.setPrefWidth(88.0);
        button5.setStyle("-fx-background-color: #4EB9F5;");
        button5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                actionTaken(button5);
            }
        });
        button5.setFont(Font.font("Arial", FontWeight.BOLD, 34));
        button5.setStyle("-fx-background-color: #4EB9F5;");

            button6.setLayoutX(143.0);
        button6.setLayoutY(316.0);
        button6.setMnemonicParsing(false);
        button6.setPrefHeight(85.0);
        button6.setPrefWidth(80.0);
        button6.setStyle("-fx-background-color: #4EB9F5;");
        button6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                actionTaken(button6);
            }
        });
        button6.setFont(Font.font("Arial", FontWeight.BOLD, 34));
        button6.setStyle("-fx-background-color: #4EB9F5;");

        button7.setLayoutX(251.0);
        button7.setLayoutY(307.0);
        button7.setMnemonicParsing(false);
        button7.setPrefHeight(85.0);
        button7.setPrefWidth(95.0);
        button7.setStyle("-fx-background-color: #4EB9F5;");
        button7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                actionTaken(button7);
            }
        });
        button7.setFont(Font.font("Arial", FontWeight.BOLD, 34));
        button7.setStyle("-fx-background-color: #4EB9F5;");

        button8.setLayoutX(373.0);
        button8.setLayoutY(316.0);
        button8.setMnemonicParsing(false);
        button8.setPrefHeight(85.0);
        button8.setPrefWidth(88.0);
        button8.setStyle("-fx-background-color: #4EB9F5;");
        button8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                actionTaken(button8);
            }
        });
        button8.setFont(Font.font("Arial", FontWeight.BOLD, 34));
        button8.setStyle("-fx-background-color: #4EB9F5;");

      
                backIcon.setLayoutX(4.0);
backIcon.setLayoutY(4.0);
backIcon.setMnemonicParsing(false);
backIcon.setPrefHeight(50.0);
backIcon.setPrefWidth(52.0);
backIcon.setStyle("-fx-background-color: #4EB9F5;");

       backIcon.setOnAction(e->
       {
       
       try {
                backIcon.getParent().getScene().setRoot(new Base());
            } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
            }
       });
        
  
          
        getChildren().add(imageView);
        getChildren().add(newGame);
        getChildren().add(imageView0);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(label2);
        getChildren().add(label3);
        getChildren().add(button0);
        getChildren().add(button1);
        getChildren().add(button2);
        getChildren().add(button3);
        getChildren().add(button4);
        getChildren().add(button5);
        getChildren().add(button6);
        getChildren().add(button7);
        getChildren().add(button8);
        getChildren().add(backIcon);
        getChildren().add(imageView1);

    }
    
    
    
     private void checkIfGameEnds() {

        String t00 = button0.getText();
        String t01 = button1.getText();
        String t02 = button2.getText();
        String t10 = button3.getText();
        String t11 = button4.getText();
        String t12 = button5.getText();
        String t20=  button6.getText();
        String t21 = button7.getText();
        String t22 = button8.getText();

        if (t00.equals(t01) && t00.equals(t02) && !t00.equals("")) {
            isGameEnds = true;
            colorBackgroundWinnerButtons(button0, button1, button2);
        }

        if (t10.equals(t11) && t10.equals(t12) && !t10.equals("")) {
            isGameEnds = true;
            colorBackgroundWinnerButtons(button3, button4, button5);
        }

        if (t20.equals(t21) && t20.equals(t22) && !t20.equals("")) {
            isGameEnds = true;
            colorBackgroundWinnerButtons(button6, button7, button8);
        }

        if (t00.equals(t10) && t00.equals(t20) && !t00.equals("")) {
            isGameEnds = true;
            colorBackgroundWinnerButtons(button0, button3, button6);
        }

        if (t01.equals(t11) && t01.equals(t21) && !t01.equals("")) {
            isGameEnds = true;
            colorBackgroundWinnerButtons(button1, button4, button7);
        }

        if (t02.equals(t12) && t02.equals(t22) && !t02.equals("")) {
            isGameEnds = true;
            colorBackgroundWinnerButtons(button2, button5, button8);
        }

        if (t00.equals(t11) && t00.equals(t22) && !t00.equals("")) {
            isGameEnds = true;
            colorBackgroundWinnerButtons(button0, button4, button8);
        }

        if (t02.equals(t11) && t02.equals(t20) && !t02.equals("")) {
            isGameEnds = true;
            colorBackgroundWinnerButtons(button2, button4, button6);
        }

        if( XOCounter >= 9)
        {
             
            
            
            isGameEnds = true;
            isFirstPlayerTurn = true;
            XOCounter = 0;
        }

        if(isGameEnds == true)
        {
            GameRecorder gameRecorder=new GameRecorder(pos[0], pos[1], 
                    pos[2], pos[3], pos[4], pos[5],pos[6] , 
                    pos[7], pos[8], userOneEmail, userTwoEmail2, "DRAW");
            
            
                
            backIcon.getParent().getScene().setRoot(new VideoShowBase("tie.mp4", gameRecorder,
                    "multi"));
            
            XOCounter = 0;
            newGame.requestFocus();
        }

    }
     private void colorBackgroundWinnerButtons(Button b1, Button b2, Button b3) {
        b1.setStyle("-fx-background-color: yellow;");
        b2.setStyle("-fx-background-color: yellow;");
        b3.setStyle("-fx-background-color: yellow;");
        
        if(b1.getText().equalsIgnoreCase("X")){
            GameRecorder gameRecorder=new GameRecorder(pos[0], pos[1], 
                    pos[2], pos[3], pos[4], pos[5],pos[6] , 
                    pos[7], pos[8], userOneEmail, userTwoEmail2, userOneEmail);
            b1.getParent().getScene().setRoot(new VideoShowBase("winning.mp4", gameRecorder,
                    "multi"));
        }else {
             GameRecorder gameRecorder=new GameRecorder(pos[0], pos[1], 
                    pos[2], pos[3], pos[4], pos[5],pos[6] , 
                    pos[7], pos[8], userOneEmail, userTwoEmail2, userTwoEmail2);
            b1.getParent().getScene().setRoot(new VideoShowBase("losing.mp4", gameRecorder,
                    "multi"));
        }
    }
     
     private void setCurrentPlayerSymbol() {

        if (isFirstPlayerTurn == true) {
            label1.setText("X");
            label1.setTextFill(xForeground);
        } else {
            label1.setText("O");
            label1.setTextFill(oForeground);
        }

    }
     
    private void startNewGame() {
        isGameEnds = false;
        
     isFirstPlayerTurn = true;
    XOCounter = 0;
    count=0;
        
        setCurrentPlayerSymbol();
        //-fx-cursor: hand;
        button0.setText("");
        button1.setText("");
        button2.setText("");
        button3.setText("");
        button4.setText("");
        button5.setText("");
        button6.setText("");
        button7.setText("");
        button8.setText("");
        button0.setStyle("-fx-background-color: #4EB9F5 ; ");
        button1.setStyle("-fx-background-color: #4EB9F5 ; ");
        button2.setStyle("-fx-background-color: #4EB9F5 ; ");
        button3.setStyle("-fx-background-color: #4EB9F5 ; ");
        button4.setStyle("-fx-background-color: #4EB9F5 ; ");
        button5.setStyle("-fx-background-color: #4EB9F5 ; ");
        button6.setStyle("-fx-background-color: #4EB9F5 ; ");
        button7.setStyle("-fx-background-color: #4EB9F5 ; ");
        button8.setStyle("-fx-background-color: #4EB9F5 ; ");
    }
    
    private void actionTaken(Button btn){
        if( isGameEnds == false && btn.getText().equals("") ){
            ++XOCounter;
                    if(isFirstPlayerTurn) {
                        btn.setTextFill(xForeground);
                        btn.setText("X");
                    }
                    else {
                        btn.setTextFill(oForeground);
                        btn.setText("O");
                    }
                     if(count<9){
            if(btn==button0)pos[count++]=1;
            else if(btn==button1)pos[count++]=2;
            else if(btn==button2)pos[count++]=3;
            else if(btn==button3)pos[count++]=4;
            else if(btn==button4)pos[count++]=5;
            else if(btn==button5)pos[count++]=6;
            else if(btn==button6)pos[count++]=7;
            else if(btn==button7)pos[count++]=8;
            else if(button8==btn)pos[count++]=9;
        }
                    checkIfGameEnds();
                    setCurrentPlayerSymbol();
                    isFirstPlayerTurn = !isFirstPlayerTurn;
                    setCurrentPlayerSymbol();
                
       
        }
    }
}
