package gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.StrokeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import video.MyAudioPlay;

public class CreateConnection extends AnchorPane {

    protected final Rectangle rectangle;
    protected final ImageView logo;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Button back;
    protected final String userEmail;
    
      protected final String playSymbol = "X";
      protected MyAudioPlay audio= new MyAudioPlay();
    
    ServerSocket server;
    GameOnLine mainServerPage;
    Socket s;

    public CreateConnection(String userEmail) throws FileNotFoundException {
        this.userEmail=userEmail;
        rectangle = new Rectangle();
        logo = new ImageView();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        back = new Button();

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
       

       
        label.setLayoutX(177.0);
        label.setLayoutY(286.0);
        label.setPrefHeight(30.0);
        label.setPrefWidth(246.0);
        label.setText("This is Your IP");
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font("System Bold Italic", 24.0));

        label0.setLayoutX(177.0);
        label0.setLayoutY(330.0);
        label0.setPrefHeight(17.0);
        label0.setPrefWidth(186.0);
        label0.setText("192.168.1.1");
        label0.setTextFill(javafx.scene.paint.Color.WHITE);
        label0.setFont(new Font("System Bold Italic", 24.0));

        label1.setLayoutX(177.0);
        label1.setLayoutY(372.0);
        label1.setText("Give it to the other player");
        label1.setTextFill(javafx.scene.paint.Color.WHITE);
        label1.setFont(new Font("System Bold Italic", 24.0));

         back.setLayoutX(175.0);
        back.setLayoutY(434.0);
        back.setMnemonicParsing(false);
        back.setPrefHeight(30.0);
        back.setPrefWidth(246.0);
        back.setStyle("-fx-background-color: #F2EC3F; -fx-background-radius: 20PX;");
        back.setText("Back");
        back.setFont(new Font("System Bold", 14.0));
        
       back.setOnAction((ActionEvent e) -> {
            audio.play();
            try {  
                back.getParent().getScene().setRoot(new ChooseConnectionBase());
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                }
            try{
                if(server != null)
                    server.close();
            } catch(IOException ioX) {
                ioX.printStackTrace();
                System.out.println("Server closed");
            
            }
        });
       
        try{
            server = new ServerSocket(5000);
            
            // Get the connected IP address not the static one
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress("google.com", 80));
            
            String ip = socket.getLocalAddress().getHostAddress();
            label.setText("This is your IP Address");
            label0.setText( ip ); 
            this.new ClientListener(); // Listen to the other player
            socket.close();
            
        } catch (IOException ex) { 
            ex.printStackTrace();
                        label.setText("Connection unavailable or another player \nhas created a game on this machine");

        }
        
        
        
        
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
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(back);
        
        
        

    }
    class ClientListener extends Thread {
       
       public ClientListener() {   
                start();
       }        


        public void run() {
            try {
                Platform.runLater(new Runnable() {
                    public void run() {
                        back.getScene().getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
                            public void handle(WindowEvent we) {
                                try{
                                    if(server != null){
                                        server.close();
                                        System.out.println("Server closing from closing button");
//                                        Platform.exit();
                                    }
                                    System.exit(0);
                                } catch(IOException ioX) {
                                    ioX.printStackTrace();
                                    System.out.println("Server closing error");
                                }
                            }
                        });
                    }
                }); 
                 s = server.accept();
                 System.out.println("connected");
                 mainServerPage = new GameOnLine(playSymbol,userEmail, s, server);
                 
                 Platform.runLater(new Runnable() {
                     public void run() {
                         label.getParent().getScene().setRoot(mainServerPage);
                     }
                 });
                 
                 while(true) { // close connections when game is ended
                     if(mainServerPage.gameEnded) {
                         try {
                             s.close();
                             server.close();
                             System.out.println("Server closing");
                         } catch(IOException ex) {ex.printStackTrace();}
                         finally {
                             break;
                         }
                     }
                 }
            } 
            catch(SocketException ex) {
                try {
                    server.close();
                    ex.printStackTrace();
                    System.out.println("Server from thread closed in socket exception");
                } catch(IOException socketEx) {socketEx.printStackTrace();}
            }
            catch(IOException ex) {
                ex.printStackTrace();
                System.out.println("Server from thread closed");
            }
        }   
    }
}
