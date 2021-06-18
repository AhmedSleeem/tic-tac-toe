package gui;

import AI.BacktrackMiniMax;
import database.Mysql;
import database.GameRecorder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.util.Callback;
import video.MyAudioPlay;
import video.VideoShowBase;


public class GameSingle extends AnchorPane {

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
    protected final Button button9;
    protected final Button backIcon;
    protected final ImageView imageView0;
    protected  String userEmail;
    protected int gameLevel;
    
    
    protected final Button btn[] = new Button[9];

    private boolean end = false;
    private boolean playerturn = true;
  
    private final String X = "X";
    private final String O = "O";
    int count = 0;
    int[] pos=new int[10];
   
    String state;
    
     Color xForeground = Color.BLUE;
    Color oForeground = Color.RED;
    
    MyAudioPlay audio= new MyAudioPlay();
   

    public GameSingle(String userEmail,int gameLevel) throws FileNotFoundException {
        
        this.gameLevel=gameLevel;
        this.userEmail=userEmail;
        
        
        newGame = new Button();
        button9=new Button();
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
        
        
        Color xForeground = Color.BLUE;
    Color oForeground = Color.RED;
        backIcon.setOnMouseClicked(e->{
            
            
                if(!end){
                    openDialog("Are you sure ? ");
                   
                }
            
        });
       
        newGame.setOnAction((ActionEvent e) -> {
            audio.play();
            reset();
        });

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
        newGame.setVisible(false);
        newGame.setFont(new Font("System Bold", 14.0));
        
            imageView1.setFitHeight(40.0);
        imageView1.setFitWidth(55.0);
        imageView1.setLayoutX(4.0);
        imageView1.setLayoutY(6.0);
      
         FileInputStream file=new FileInputStream("src\\resources\\undo_1.png");
         Image image=new Image(file);
        imageView1.setImage(image);
        

        imageView.setFitHeight(330.0);
        imageView.setFitWidth(400.0);
        imageView.setLayoutX(133.0);
        imageView.setLayoutY(79.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
         file=new FileInputStream("src\\resources\\board_1.png");
         image=new Image(file);
        imageView.setImage(image);
        
        
        
        imageView0.setFitHeight(40.0);
        imageView0.setFitWidth(68.0);
        imageView0.setLayoutX(35.0);
        imageView0.setLayoutY(95.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        
        
        btn[0] = button0;
        btn[1] = button1;
        btn[2] = button2;
        btn[3] = button3;
        btn[4] = button4;
        btn[5] = button5;
        btn[6] = button6;
        btn[7] = button7;
        btn[8] = button8;
        
        for (int i = 0; i < 9; i++) {
            btn[i].setStyle("-fx-background-color: #4EB9F5;");
        }
      
        
        
      
        label.setLayoutX(144.0);
        label.setLayoutY(15.0);
        label.setText(userEmail);
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font("System Bold", 15.0));

        label0.setLayoutX(413.0);
        label0.setLayoutY(15.0);
        label0.setText("Computer");
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
        getChildren().add(button9);
        for (int i = 0; i < 9; i++) {
            btn[i].setFont(Font.font("Arial", FontWeight.BOLD, 34));
            btn[i].addEventHandler(ActionEvent.ACTION, e -> {
                    actionPerformed(e);
            });
        }
      
    }
    
    protected void mouseclicked(javafx.scene.input.MouseEvent mouseEvent) {
        EventHandler<ActionEvent> eventHandler = (ActionEvent e) -> {
            actionPerformed(e);
        };
    }

    protected void actionPerformed(ActionEvent e) {
       
       BacktrackMiniMax str = new BacktrackMiniMax(this.gameLevel);  
      // parm = 1 #Easy Level
      // parm = 2 #Normal Level
      // parm = 3 #Hard Level
      
        Mysql turn=new Mysql();      

        if (count <= 9 && !end) {
            if (playerturn) {
                for (int i = 0; i < 9; i++) {
                    if (e.getSource() == btn[i]) {
                        if (btn[i].getText().equals("")) {
                            btn[i].setText(X);
                             btn[i].setTextFill(xForeground);
                            str.setPlayer(i);
                            playerturn = false;
                            pos[count]=i+1;
                            System.out.println("pos X" +pos[count]);
                            count++;
                            System.out.println("btn" + i);
                            checkgame();
                        }
                    }
                }
            }
           
            if ( !playerturn && count != 9 && !end) {
                int r = str.move(O);
                System.out.println(r);
                pos[count]=r+1;
                count++;
                btn[r].setText(O);
                btn[r].setTextFill(oForeground);
                str.setComp(r);
                playerturn = true;
                checkgame();
            }
        }
        
        if (count == 9 || end) {
            GameRecorder gameRecorder=new GameRecorder(pos[0],pos[1],pos[2], pos[3],pos[4],
                    pos[5],pos[6],pos[7],pos[8], userEmail, "computer", 
                    state.equals("winning.mp4")?userEmail:state.equals("losing.mp4")?"computer":"DRAW");
            reset();
            button1.getParent().getScene().setRoot(new VideoShowBase(state,gameRecorder,"single"));
        
        }
    }

    private void checkgame() {

        String[] p;
        String sp = X;
        int i, j, k;
        String winner = null;
        //sql db=new sql();
        p = new String[9];

        for (i = 0; i < 9; i++) {
            p[i] = btn[i].getText();
        }

        for (int x = 0; x < 2; x++) {
            for (j = k = 0; j < 9; j += 3, k++) {
                if ((sp.equals(p[j]) && sp.equals(p[j + 1]) && sp.equals(p[j + 2])) // Check The Rows 
                        || (sp.equals(p[k]) && sp.equals(p[k + 3]) && sp.equals(p[k + 6])) // Check The Columns
                        ) {
                    if (X.equals(sp)) {
                        
                            state = "winning.mp4";  
                            winner=userEmail;
                    }
                    if (O.equals(sp)) {
                            state = "losing.mp4"; 
                            winner="computer";
                    }
                    end = true;
                    stop();
                }
                }
            if ((sp.equals(p[0]) && sp.equals(p[4]) && sp.equals(p[8])) // Check Diagnoal (\)
                    || (sp.equals(p[6]) && sp.equals(p[4]) && sp.equals(p[2])) // Check Diagonal (/)
                    ) {
                if (X.equals(sp)) {
                        state = "winning.mp4";                     
                        winner=userEmail;
                }
                if (O.equals(sp)) {
                        state = "losing.mp4";
                        winner="computer";
                }
                end = true;
                stop();}
            sp = O;
        }

        if (count == 9 && end == false) {
                state = "tie.mp4";
                winner="Tie";
        }
        if(winner!=null){
        //db.update(winner);
        }
    }

    private void reset(){
        BacktrackMiniMax str = new BacktrackMiniMax(0);
        
        str.resetStr();
        count = 0;
        for(int i = 0 ; i < 9 ; i++){
            btn[i].setText("");
        }
        playerturn = true;
        end = false;
    }
    private void stop() {
        System.out.println("Thank you for playing");
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
        
        ButtonType okBtn2 = new ButtonType("Cancle");
        dialog.getDialogPane().getButtonTypes().add(okBtn2); 
        Optional<String> showAndWait = dialog.showAndWait();
        
    }
}
