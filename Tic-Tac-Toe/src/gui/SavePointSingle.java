package gui;

import database.Mysql;
import database.GameRecorder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class SavePointSingle extends AnchorPane {

    protected final ImageView imageView;
    protected final Button button;
    protected final ImageView imageView0;
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
    protected final Label label4;
    protected final Label label5;
    
     public GameRecorder gameRecorder;
     
     Button[]btns= new Button[9];
     
      Color xForeground = Color.BLUE;
    Color oForeground = Color.RED;
    
    protected Mysql mysql ;
    int idx=0;
        boolean state=true;
        
        String hhhhh;

    public SavePointSingle(GameRecorder gameRecorder,String h) throws FileNotFoundException, SQLException {
        this.gameRecorder=gameRecorder;
        this.hhhhh=h;
        mysql=new Mysql();
        mysql.addPlayer("computer");
        mysql.addPlayer("DRAW");
        System.out.println("winner "+gameRecorder.getWinner());
        if(!hhhhh.equals("history")){
        if(gameRecorder.getWinner().equalsIgnoreCase("DRAW")){
            mysql.updatePlayer2draw(gameRecorder.getPlayer1());
                   mysql.updatePlayer2draw(gameRecorder.getPlayer2());
        }else if(gameRecorder.getWinner().equalsIgnoreCase(gameRecorder.getPlayer1())){
             mysql.updatePlayer2win(gameRecorder.getPlayer1());
                   mysql.updatePlayer2loss(gameRecorder.getPlayer2());
        }else{
             mysql.updatePlayer2loss(gameRecorder.getPlayer1());
                   mysql.updatePlayer2win(gameRecorder.getPlayer2());
        }
        
        
        mysql.insertGame(gameRecorder.getPlayer1(), gameRecorder.getPlayer2(), gameRecorder.getWinner(), 
                gameRecorder.getPos1(), gameRecorder.getPos2(), gameRecorder.getPos3(),
                gameRecorder.getPos4(), gameRecorder.getPos5(), gameRecorder.getPos6(),
                gameRecorder.getPos7(), gameRecorder.getPos8(), gameRecorder.getPos9());
       
        }
        

        imageView = new ImageView();
        button = new Button();
        imageView0 = new ImageView();
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
        label4 = new Label();
        label5 = new Label();
        
        btns[0]=button0;
        btns[1]=button1;
        btns[2]=button2;
        btns[3]=button3;
        btns[4]=button4;
        btns[5]=button5;
        btns[6]=button6;
        btns[7]=button7;
        btns[8]=button8;
        
        for (int i = 0; i < 9; i++) {
            btns[i].setFont(Font.font("Arial", FontWeight.BOLD, 34));
        btns[i].setStyle("-fx-background-color: #4EB9F5;");
        }
        
        
        
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(500.0);
        setPrefWidth(590.0);
        setStyle("-fx-background-color: #4EB9F5;");

        imageView.setFitHeight(330.0);
        imageView.setFitWidth(400.0);
        imageView.setLayoutX(133.0);
        imageView.setLayoutY(79.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        FileInputStream file=new FileInputStream("src\\resources\\board_1.png");
        Image image=new Image(file);
        imageView.setImage(image);

        button.setLayoutX(447.0);
        button.setLayoutY(420.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(40.0);
        button.setPrefWidth(130.0);
        button.setStyle("-fx-background-color: #F2EC3F; -fx-background-radius: 20px;");
        button.setText("Next");
        button.setFont(new Font("System Bold", 14.0));
        
         button.setOnAction(e -> {
            if(idx<9){
                if(state){
                     label1.setText("X");
                     label1.setTextFill(xForeground);
                }else {
                    label1.setText("O");
                     label1.setTextFill(oForeground);
                }
            switch(idx){
                case 0:
                    if(gameRecorder.getPos1()>0){
                    if(state){
                        
                        btns[gameRecorder.getPos1()-1].setText("x");
                         btns[gameRecorder.getPos1()-1].setTextFill(xForeground);
                    }else {
                        btns[gameRecorder.getPos1()-1].setText("o");
                         btns[gameRecorder.getPos1()-1].setTextFill(oForeground);
                    }++idx;
                    }
                    break;
                case 1:
                    if(gameRecorder.getPos2()>0){
                    if(state){
                        btns[gameRecorder.getPos2()-1].setText("x");
                         btns[gameRecorder.getPos2()-1].setTextFill(xForeground);
                    }else {
                        btns[gameRecorder.getPos2()-1].setText("o");
                         btns[gameRecorder.getPos2()-1].setTextFill(oForeground);
                    }++idx;
                    }
                    break;
                case 2:
                      if(gameRecorder.getPos3()>0){
                    if(state){
                        btns[gameRecorder.getPos3()-1].setText("x");
                         btns[gameRecorder.getPos3()-1].setTextFill(xForeground);
                    }else {
                        btns[gameRecorder.getPos3()-1].setText("o");
                         btns[gameRecorder.getPos3()-1].setTextFill(oForeground);
                    }++idx;
                      }
                    break;
                case 3:
                    if(gameRecorder.getPos4()>0){
                    if(state){
                        btns[gameRecorder.getPos4()-1].setText("x");
                         btns[gameRecorder.getPos4()-1].setTextFill(xForeground);
                         
                    }else {
                        btns[gameRecorder.getPos4()-1].setText("o");
                         btns[gameRecorder.getPos4()-1].setTextFill(oForeground);
                    }++idx;
                    }
                    break;
                case 4:
                      if(gameRecorder.getPos5()>0){
                    if(state){
                        btns[gameRecorder.getPos5()-1].setText("x");
                         btns[gameRecorder.getPos5()-1].setTextFill(xForeground);
                    }else {
                        btns[gameRecorder.getPos5()-1].setText("o");
                         btns[gameRecorder.getPos5()-1].setTextFill(oForeground);
                    }
                      ++idx;
                      }
                    break; 
                case 5:
                      if(gameRecorder.getPos6()>0){
                    if(state){
                        btns[gameRecorder.getPos6()-1].setText("x");
                         btns[gameRecorder.getPos6()-1].setTextFill(xForeground);
                    }else{
                        btns[gameRecorder.getPos6()-1].setText("o");
                         btns[gameRecorder.getPos6()-1].setTextFill(oForeground);
                    }++idx;
                      }
                    break;
                    
                    
                case 6:
                      if(gameRecorder.getPos7()>0){
                    if(state){
                        btns[gameRecorder.getPos7()-1].setText("x");
                         btns[gameRecorder.getPos7()-1].setTextFill(xForeground);
                    }else {
                        btns[gameRecorder.getPos7()-1].setText("o");
                         btns[gameRecorder.getPos7()-1].setTextFill(oForeground);
                    }++idx;
                      }
                    break;
                    
                case 7:
                      if(gameRecorder.getPos8()>0){
                    if(state){
                        btns[gameRecorder.getPos8()-1].setText("x");
                         btns[gameRecorder.getPos8()-1].setTextFill(xForeground);
                    }else{
                        btns[gameRecorder.getPos8()-1].setText("o");
                         btns[gameRecorder.getPos8()-1].setTextFill(oForeground);
                    }++idx;
                      }
                    break;
                    
                case 8:
                      if(gameRecorder.getPos9()>0){
                    if(state){
                        btns[gameRecorder.getPos9()-1].setText("x");
                         btns[gameRecorder.getPos9()-1].setTextFill(xForeground);
                    }else {
                        btns[gameRecorder.getPos9()-1].setText("o");
                         btns[gameRecorder.getPos9()-1].setTextFill(oForeground);
                    }++idx;
                      }
                    break;                
            }
            if(idx<9){
                label5.setText(" "+(idx));
            }
            state=!state;
            
           }
            
        });

        imageView0.setFitHeight(40.0);
        imageView0.setFitWidth(68.0);
        imageView0.setLayoutX(9.0);
        imageView0.setLayoutY(11.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);

        imageView1.setFitHeight(40.0);
        imageView1.setFitWidth(55.0);
        imageView1.setLayoutX(8.0);
        imageView1.setLayoutY(8.0);

        FileInputStream file1=new FileInputStream("src\\resources\\undo_1.png");
     Image image2=new Image(file1);
        imageView1.setImage(image2);
        
         imageView1.setOnMouseClicked(e->{
            
            try {
                imageView1.getParent().getScene().setRoot(new Base());
            } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
            }
        });
        
        label.setLayoutX(144.0);
        label.setLayoutY(15.0);
        label.setText(gameRecorder.getPlayer1());
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font("System Bold", 15.0));

        label0.setLayoutX(413.0);
        label0.setLayoutY(15.0);
        label0.setText(gameRecorder.getPlayer2());
        label0.setTextFill(javafx.scene.paint.Color.WHITE);
        label0.setFont(new Font("System Bold", 15.0));

        label1.setLayoutX(293.0);
        label1.setLayoutY(3.0);
        label1.setText("X");
        label1.setTextFill(javafx.scene.paint.Color.valueOf("#ff5a5a"));
        label1.setFont(new Font("System Bold", 16.0));

        label2.setLayoutX(161.0);
        label2.setLayoutY(38.0);
        label2.setText("X");
        label2.setTextFill(xForeground);
        label2.setFont(new Font("System Bold", 14.0));

        label3.setLayoutX(448.0);
        label3.setLayoutY(38.0);
        label3.setText("O");
        label3.setTextFill(oForeground);
        label3.setFont(new Font("System Bold", 14.0));

      button0.setLayoutX(136.0);
        button0.setLayoutY(89.0);
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(85.0);
        button0.setPrefWidth(88.0);
        button0.setStyle("-fx-background-color: #4EB9F5;");

        button1.setLayoutX(250.0);
        button1.setLayoutY(95.0);
        button1.setMnemonicParsing(false);
        button1.setPrefHeight(85.0);
        button1.setPrefWidth(95.0);
        button1.setStyle("-fx-background-color: #4EB9F5;");

        button2.setLayoutX(373.0);
        button2.setLayoutY(89.0);
        button2.setMnemonicParsing(false);
        button2.setPrefHeight(85.0);
        button2.setPrefWidth(88.0);
        button2.setStyle("-fx-background-color: #4EB9F5;");

        button3.setLayoutX(144.0);
        button3.setLayoutY(202.0);
        button3.setMnemonicParsing(false);
        button3.setPrefHeight(85.0);
        button3.setPrefWidth(88.0);
        button3.setStyle("-fx-background-color: #4EB9F5;");

        button4.setLayoutX(254.0);
        button4.setLayoutY(201.0);
        button4.setMnemonicParsing(false);
        button4.setPrefHeight(85.0);
        button4.setPrefWidth(88.0);
        button4.setStyle("-fx-background-color: #4EB9F5;");

        button5.setLayoutX(365.0);
        button5.setLayoutY(201.0);
        button5.setMnemonicParsing(false);
        button5.setPrefHeight(85.0);
        button5.setPrefWidth(88.0);
        button5.setStyle("-fx-background-color: #4EB9F5;");

        button6.setLayoutX(143.0);
        button6.setLayoutY(318.0);
        button6.setMnemonicParsing(false);
        button6.setPrefHeight(85.0);
        button6.setPrefWidth(80.0);
        button6.setStyle("-fx-background-color: #4EB9F5;");

        button7.setLayoutX(251.0);
        button7.setLayoutY(309.0);
        button7.setMnemonicParsing(false);
        button7.setPrefHeight(85.0);
        button7.setPrefWidth(95.0);
        button7.setStyle("-fx-background-color: #4EB9F5;");

        button8.setLayoutX(372.0);
        button8.setLayoutY(316.0);
        button8.setMnemonicParsing(false);
        button8.setPrefHeight(85.0);
        button8.setPrefWidth(88.0);
        button8.setStyle("-fx-background-color: #4EB9F5;");

        label4.setLayoutX(252.0);
        label4.setLayoutY(31.0);
        label4.setPrefHeight(20.0);
        label4.setPrefWidth(44.0);
        label4.setText("Step");
        label4.setTextFill(javafx.scene.paint.Color.WHITE);
        label4.setFont(new Font("System Bold", 16.0));

        label5.setLayoutX(321.0);
        label5.setLayoutY(32.0);
        label5.setText("0");
        label5.setTextFill(javafx.scene.paint.Color.valueOf("#f2ec3f"));
        label5.setFont(new Font("System Bold", 16.0));

        getChildren().add(imageView);
        getChildren().add(button);
        getChildren().add(imageView0);
        getChildren().add(imageView1);
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
        getChildren().add(label4);
        getChildren().add(label5);

    }
}
