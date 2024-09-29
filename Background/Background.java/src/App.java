import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;
public class App extends JPanel {
    JFrame frame = new JFrame("FLAPPY BIRD 💕❤️🦜🦜🦜");
    JButton button;
    App(){
       
        button  = new JButton();
        button.setBounds(220,230,140,80);
        button.setText("PLAY");
      
      
        frame.setSize(900,900);  
        frame.setVisible(true); 
        //frame.setVisible(true);
        frame.add(button);
        frame.setLayout(null);
        frame.setResizable(false);

        
        Title title = new Title();
        button.addActionListener(title);
    }
    public static void main(String[] args) throws Exception {
        new App();
    }
    public void Gamescreen(){
        JFrame frame = new JFrame("FLAPPY BIRD 💕❤️🦜🦜🦜");
        button.setVisible(false);

        Background background= new Background();
       frame.add(background);  
       frame.setSize(600,600);  
       frame.setVisible(true); 
        frame.add(background); 
        frame.pack();
        background.requestFocus();
       frame.setVisible(true);
       frame.setResizable(false);
     
    }

   public class Title implements ActionListener{
        public void actionPerformed(ActionEvent event){
            Gamescreen();

        }

    }
}
  