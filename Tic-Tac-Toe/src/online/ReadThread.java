
package online;


import gui.GameOnLine;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javafx.application.Platform;

public class ReadThread extends Thread{
    Socket socket;
    GameOnLine gamePage;
    DataInputStream dis;
    
    public ReadThread(Socket s, GameOnLine page) {
        this.socket = s;
        this.gamePage = page;
        
        try {
            dis = new DataInputStream(s.getInputStream());
        } catch(IOException ex) {
            System.out.println("Socket closed");
            try{
                if(dis != null)
                    dis.close();
            } catch(IOException ioX) {ioX.printStackTrace();}
        }
        
        start();
    }
    
    public void run() {
    
        try{
            if(dis != null){
                int played = dis.readInt();
                if(gamePage.idx<9){
                gamePage.pos[gamePage.idx++]=played+1;
                    }
                String h=dis.readLine();
                StringBuilder tmp =new StringBuilder();
                for(char t:h.toCharArray()){
                    if(t!=' '||t!='\n')tmp.append(t);
                }
                System.out.println("builder "+tmp.toString());
                gamePage.secondUser=tmp.toString();
                Platform.runLater(()->{
               gamePage.label0.setText(gamePage.secondUser);
                });
                System.out.println("");

                Platform.runLater(new Runnable() { // This function has to be run using an application thread
                    public void run() {
                        gamePage.makeScreenEffected(played);
                    }
                });  
            }
            
        } catch(IOException ex) {
            Platform.runLater(new Runnable() { // This function has to be run using an application thread
                public void run() {
                    gamePage.openDialog("Other player closed the game");
                    try{
                        dis.close();
                        socket.close();
                        if(gamePage.server != null)
                            gamePage.server.close();
                        System.out.println("Other player has closed");             
                        System.exit(0);
                    } catch(IOException e) {e.printStackTrace();}
                }
            }); 
            

        }
    }
    
}
