import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
public class Music{

  public static void play(String args){
    String filepath =args;
    PlayMusic(filepath);
    
    
  }


public static void PlayMusic(String pathway ){
    try{
          File mscpath = new File(pathway);

          if(mscpath.exists()){
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(mscpath); //gets the music at the file path
            Clip sample = AudioSystem.getClip();//essentally the music player 
            sample.open(audioInput); //opening the cd player and inserting the music 
            int c = 0;
            int s = 5;
            JOptionPane.showMessageDialog(null,"It works perfectly");
            while(c<s){
                 sample.start();// starts playing the music
          }

        }
          else{
            System.out.println("File not found");
          }


    }
    catch(Exception e){
        System.out.println("Music crash \n"+e);
    }




}


}

