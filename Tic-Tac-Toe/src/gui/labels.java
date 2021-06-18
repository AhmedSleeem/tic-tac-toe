package gui;

import database.GameRecorder;
import database.Mysql;
import static gui.SavePointMulti.gameRecorder;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public  class labels extends AnchorPane {

    protected final Button button;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Label label2;
    protected final Label label3;
    protected final Label label4;
    protected final Label label5;
    protected final Label label6;
    protected final Label label7;
    protected final  ArrayList<GameRecorder> sss=new ArrayList<>();
    
    Mysql mysql = new Mysql();
    
    public final ArrayList<Label> arr=new ArrayList();
     

    String userEmail; 
    public labels(String userName) throws SQLException {
        
        userEmail=userName;
        button = new Button();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        label3 = new Label();
        label4 = new Label();
        label5 = new Label();
        label6 = new Label();
        label7 = new Label();
        
        arr.add(label);
        arr.add(label0);
        arr.add(label1);
        arr.add(label2);
        arr.add(label3);
        arr.add(label4);
        arr.add(label5);
        arr.add(label6);
        arr.add(label7);
        
        
        

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(500.0);
        setPrefWidth(590.0);
        setStyle("-fx-background-color: #4EB9F5;");

        button.setLayoutX(228.0);
        button.setLayoutY(439.0);
        button.setMaxHeight(USE_PREF_SIZE);
        button.setMaxWidth(USE_PREF_SIZE);
        button.setMinHeight(USE_PREF_SIZE);
        button.setMinWidth(USE_PREF_SIZE);
        button.setMnemonicParsing(false);
        button.setPrefHeight(39.0);
        button.setPrefWidth(135.0);
        button.setStyle("-fx-background-color: #F2EC3F; -fx-background-radius: 20px;");
        button.setText("Back");

        label.setLayoutX(9.0);
        label.setLayoutY(14.0);
        label.setPrefHeight(39.0);
        label.setPrefWidth(563.0);
        label.setText("Label");

        label0.setLayoutX(14.0);
        label0.setLayoutY(53.0);
        label0.setPrefHeight(39.0);
        label0.setPrefWidth(563.0);
        label0.setText("Label");

        label1.setLayoutX(9.0);
        label1.setLayoutY(123.0);
        label1.setPrefHeight(39.0);
        label1.setPrefWidth(563.0);
        label1.setText("Label");

        label2.setLayoutX(14.0);
        label2.setLayoutY(162.0);
        label2.setPrefHeight(39.0);
        label2.setPrefWidth(563.0);
        label2.setText("Label");

        label3.setLayoutX(9.0);
        label3.setLayoutY(92.0);
        label3.setPrefHeight(39.0);
        label3.setPrefWidth(563.0);
        label3.setText("Label");

        label4.setLayoutX(9.0);
        label4.setLayoutY(201.0);
        label4.setPrefHeight(39.0);
        label4.setPrefWidth(563.0);
        label4.setText("Label");

        label5.setLayoutX(9.0);
        label5.setLayoutY(240.0);
        label5.setPrefHeight(39.0);
        label5.setPrefWidth(563.0);
        label5.setText("Label");

        label6.setLayoutX(9.0);
        label6.setLayoutY(279.0);
        label6.setPrefHeight(39.0);
        label6.setPrefWidth(563.0);
        label6.setText("Label");

        label7.setLayoutX(9.0);
        label7.setLayoutY(340.0);
        label7.setPrefHeight(39.0);
        label7.setPrefWidth(563.0);
        label7.setText("Label");
        
        for(Label l:arr){
            l.setText("");
             l.setPrefHeight(50.0);
        l.setPrefWidth(563.0);
        l.setFont(new Font("System Bold", 14.0));
        //l.setStyle("-fx-background-color: #F2EC3F; -fx-background-radius: 20px;");
        }
        
        ArrayList<ArrayList<String>> showHistory = mysql.showHistory(userName);
        int idx=0;

        
        for(ArrayList<String> l:showHistory){
            GameRecorder gameRecorder=new GameRecorder();
            gameRecorder.setPlayer1(l.get(0));
            gameRecorder.setPlayer2(l.get(1));
            gameRecorder.setWinner(l.get(2));
            gameRecorder.setPos1(Integer.parseInt(l.get(3)));
            gameRecorder.setPos2(Integer.parseInt(l.get(4)));
            gameRecorder.setPos3(Integer.parseInt(l.get(5)));
            gameRecorder.setPos4(Integer.parseInt(l.get(6)));
            gameRecorder.setPos5(Integer.parseInt(l.get(7)));
            gameRecorder.setPos6(Integer.parseInt(l.get(8)));
            gameRecorder.setPos7(Integer.parseInt(l.get(9)));
            gameRecorder.setPos8(Integer.parseInt(l.get(10)));
            gameRecorder.setPos9(Integer.parseInt(l.get(11)));
            sss.add(gameRecorder);
            if(idx<arr.size()){
            arr.get(idx).setText((idx+1)+"   "+gameRecorder.getPlayer1()+"             vs           "+
                    gameRecorder.getPlayer2());
            ++idx;
            }
        }
        
        for(Label l:arr){
            l.setOnMouseClicked(e->{
                
                int indexOf = arr.indexOf(l);
                try {
                   
                    button.getParent().getScene().setRoot(new SavePointSingle(sss.get(indexOf),"history"));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(labels.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(labels.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            });
        }

        getChildren().add(button);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(label2);
        getChildren().add(label3);
        getChildren().add(label4);
        getChildren().add(label5);
        getChildren().add(label6);
        getChildren().add(label7);

    }
}
