package gui;

import database.GameRecorder;
import database.Mysql;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import online.CheckGameIfItFinished;
import online.ReadThread;
import video.VideoShowBase;


public class GameOnLine extends AnchorPane {

    protected final Button newGame;
    protected final ImageView imageView;
    protected final Label label;
    public final Label label0;
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
    protected final Button button9=new Button();
    protected final Button backIcon;
    protected final ImageView imageView0;
    protected final ImageView imageView1;
    
    public  Vector<Button> boxes;
   public String mySymbol;
   public String oponentSymbol;
   public String playerWon;
   public boolean yourTurn = false;
    public boolean gameEnded = false;
   public int move = -1;
    public static Map<Integer, String> movesPlayed;
   public Socket socket;
   public DataOutputStream dos;
    String mode;
   public ServerSocket server;
   
    Color xForeground = Color.BLUE;
    Color oForeground = Color.RED;
    
   public String username;
    public String secondUser;
    Mysql mysql =new Mysql();
    
   static public int[]pos=new int[9];
   static public int idx=0;

    public GameOnLine(String mySymbol, String username,Socket socket, ServerSocket server) throws FileNotFoundException {
          this.server = server;
        this.mode = mode;
        try {
            mysql.addPlayer(username);
        } catch (SQLException ex) {
ex.printStackTrace();       
        }
        this.socket = socket;
        boxes = new Vector<>();
        movesPlayed = new HashMap<>();
        this.username=username;
        this.mySymbol = mySymbol;
        if(mySymbol.equals("X")) {
            oponentSymbol = "O";
            yourTurn = true;
        } else {
            oponentSymbol = "X";
        }
        
        try {
            dos = new DataOutputStream(socket.getOutputStream());
        } catch(IOException ex) {ex.printStackTrace();}


        newGame = new Button();
        imageView = new ImageView();
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
        imageView1 = new ImageView();
        
           boxes.add(button0);
        boxes.add(button1);
        boxes.add(button2);
        boxes.add(button3);
        boxes.add(button4);
        boxes.add(button5);
        boxes.add(button6);              
        boxes.add(button7);
        boxes.add(button8);
        
        

         setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(500.0);
        setPrefWidth(590.0);
        setStyle("-fx-background-color: #4EB9F5;");

   newGame.setLayoutX(447.0);
        newGame.setLayoutY(420.0);
        newGame.setMnemonicParsing(false);
        newGame.setPrefHeight(40.0);
        newGame.setPrefWidth(130.0);
        newGame.setStyle("-fx-background-color: #F2EC3F; -fx-background-radius: 20px;");
        newGame.setText("Play Again");
        newGame.setFont(new Font("System Bold", 14.0));

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
        imageView0.setLayoutX(35.0);
        imageView0.setLayoutY(95.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
       

        label.setLayoutX(144.0);
        label.setLayoutY(15.0);
        label.setText(username);
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font("System Bold", 15.0));

        label0.setLayoutX(413.0);
        label0.setLayoutY(15.0);
        label0.setText("waiting..");
        label0.setTextFill(javafx.scene.paint.Color.WHITE);
        label0.setFont(new Font("System Bold", 15.0));

        label1.setLayoutX(293.0);
        label1.setLayoutY(19.0);
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

        button9.setDisable(true);
        button9.setLayoutX(8.0);
        button9.setLayoutY(6.0);
        button9.setMnemonicParsing(false);
        button9.setPrefHeight(40.0);
        button9.setPrefWidth(55.0);
        button9.setStyle("-fx-background-color: #4EB9F5;");
    
       
       backIcon.setLayoutX(9.0);
        backIcon.setLayoutY(11.0);
        backIcon.setMnemonicParsing(false);
        backIcon.setPrefHeight(40.0);
        backIcon.setPrefWidth(52.0);
        backIcon.setStyle("-fx-background-color: #4EB9F5;");
        backIcon.setVisible(false);
        
        imageView1.setFitHeight(40.0);
        imageView1.setFitWidth(55.0);
        imageView1.setLayoutX(7.0);
        imageView1.setLayoutY(10.0);
        
        for (int i = 0; i < 9; i++) {
            boxes.get(i).setText("");
            boxes.get(i).setStyle("-fx-background-color: #4EB9F5;");
             boxes.get(i).setFont(Font.font("Arial", FontWeight.BOLD, 34));
        }

    

        getChildren().add(newGame);
        getChildren().add(imageView);
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
        getChildren().add(button9);
        getChildren().add(backIcon);
        getChildren().add(imageView0);
        getChildren().add(imageView1);

     if(!yourTurn) {
            new ReadThread(socket, this);
        }
     
               
        for(Button text: boxes) {
            text.setOnMouseClicked(event -> {
                if(yourTurn && !gameEnded){
                    if(!movesPlayed.containsKey(boxes.indexOf(text))){
                        text.setText(mySymbol);
                        if(mySymbol.equalsIgnoreCase("x")){
                            text.setTextFill(xForeground);
                        }else{
                             text.setTextFill(oForeground);
                        }
                        
                        move = boxes.indexOf(text);
                        System.out.println("index ------> "+move);
                        pos[idx++]=move+1;
                        movesPlayed.putIfAbsent(Integer.valueOf(boxes.indexOf(text)), String.valueOf(mySymbol));
                        
                        try{
                            dos.writeInt(move);
                            dos.writeChars(username+"\n");
                        } catch(IOException ex) {
                            openDialog("Other player closed the game");
                            try{
                                dos.close();
                                socket.close();
                                if(server != null)
                                    server.close();
                                System.exit(0);
                            } catch(IOException e) {e.printStackTrace();}
                        }
                        new CheckGameIfItFinished(this);
                        
                        if(gameEnded) {
                            System.out.println("map  --->"+movesPlayed);
                         
                            GameRecorder gameRecorder=new GameRecorder(pos[0],pos[1],pos[2], pos[3],pos[4],
                    pos[5],pos[6],pos[7],pos[8], username, secondUser, "DRAW");
                            System.out.println(playerWon);
                            if(playerWon.equals(mySymbol)) {
                                gameRecorder.setWinner(username);
                                
                                button0.getParent().getScene().setRoot(new VideoShowBase("winning.mp4",gameRecorder,"multi"));
                            } else if(playerWon.equals(oponentSymbol)){
                                // loss
                                gameRecorder.setWinner(secondUser);
                                button0.getParent().getScene().setRoot(new VideoShowBase("losing.mp4",gameRecorder,"multi"));
                            }
                            else {
                                // tie
                                button0.getParent().getScene().setRoot(new VideoShowBase("tie.mp4",gameRecorder,"multi"));
                            }
                            
                            try{
                                dos.close();
                                socket.close();
                                if(server != null)
                                    server.close();
                            } catch(IOException ioX) {System.out.println("Server is closed");}

                        }
                        
                        changeTurn();
                    }                   
                }
            });
        }
    }
    
   public void changeTurn() {
        move = -1;
        
        if(yourTurn) {
            yourTurn = false;
            new ReadThread(socket, this);
        } else {yourTurn = true;}
    }
    
  public  void makeScreenEffected(int playedMove) {

        movesPlayed.put(playedMove, oponentSymbol);
        
        boxes.elementAt(playedMove).setText(oponentSymbol);
        if(oponentSymbol.equalsIgnoreCase("x")){
                            boxes.elementAt(playedMove).setTextFill(xForeground);
                        }else{
                             boxes.elementAt(playedMove).setTextFill(oForeground);
                        }
        
        new CheckGameIfItFinished(this);
        
        if(gameEnded) {
            int pos[]=new int[9];
                            int idx=0;
                            for(Integer key:movesPlayed.keySet()){
                                pos[idx]=key;
                                ++idx;
                            }
                            GameRecorder gameRecorder=new GameRecorder(pos[0],pos[1],pos[2], pos[3],pos[4],
                    pos[5],pos[6],pos[7],pos[8], username, secondUser, "DRAW");
                            System.out.println(playerWon);
                            if(playerWon.equals(mySymbol)) {
                                gameRecorder.setWinner(username);
                                
                                button0.getParent().getScene().setRoot(new VideoShowBase("winning.mp4",gameRecorder,"multi"));
                            } else if(playerWon.equals(oponentSymbol)){
                                // loss
                                gameRecorder.setWinner(secondUser);
                                button0.getParent().getScene().setRoot(new VideoShowBase("losing.mp4",gameRecorder,"multi"));
                            }
                            else {
                                // tie
                                button0.getParent().getScene().setRoot(new VideoShowBase("tie.mp4",gameRecorder,"multi"));
                            }
            
            try{
                dos.close();
                socket.close();
                if(server != null)
                    server.close();
            } catch(IOException ioX) {
                ioX.printStackTrace();
                      
                System.out.println("Server is closed");
            }
        }
        
        changeTurn();
    }
    
   public void openDialog(String content) {
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
