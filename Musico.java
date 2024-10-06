import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

 
public class Musico {
    public static void Run(String pathway,int c){
        try{
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(new File(pathway)); //gets the music at the file path
            Clip sample = AudioSystem.getClip();//essentally the music player 
            sample.open(audioInput); //opening the cd player and inserting the music
            int s=1;
            while (c<s) {

            sample.start();
        }

    }
        catch(LineUnavailableException e){
            e.printStackTrace();
        }
        catch(UnsupportedAudioFileException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    
}
