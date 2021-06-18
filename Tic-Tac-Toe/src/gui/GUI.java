
package gui;



import database.Dbase;
import database.TableCheck;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import video.MyAudioPlay;

public class GUI extends Application {  
    
    @Override
    public void start(Stage stage) throws FileNotFoundException {
       
        TicTacToe startPage=new TicTacToe();
        Base choosePlay=new Base();
        MyAudioPlay audio= new MyAudioPlay();
        Dbase d= new Dbase();
        new TableCheck("players");
        new TableCheck("game");
        
  
         Scene sceneStartPage=new Scene(startPage);   
         
          stage.setScene(sceneStartPage);
         
         Scene sceneChoosePlay=new Scene(choosePlay); 
  
        
         stage.setScene(sceneChoosePlay);
         stage.setResizable(false);
       
        
        stage.setTitle("Tic Tac Toe");
        stage.show();
    }
    

    public static void main(String[] args) {
        launch(args);
    }
    
}
