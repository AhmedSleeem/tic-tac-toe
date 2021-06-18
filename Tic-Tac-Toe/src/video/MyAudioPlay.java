
package video;

import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class MyAudioPlay {
                 

    public void play(){
        Media sound = new Media(new File("src/video/audio.mp3").toURI().toString());
                 MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
                     try {
                         TimeUnit.MILLISECONDS.sleep(80);
                     } catch (InterruptedException ex) {
                         Logger.getLogger(MyAudioPlay.class.getName()).log(Level.SEVERE, null, ex);
                     }
}
}
