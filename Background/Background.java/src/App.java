import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class App {
    JFrame frame = new JFrame("FLAPPY BIRD 💕❤️🦜🦜🦜");
    JButton button;
    App(){
        button  = new JButton();
        button.setBounds(220,230,140,80);
        button.setText("PLAY");
        
        frame.setTitle("Floppy");
        frame.setSize(800,1360);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(button);
        frame.setLayout(null);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
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
      
    }

   public class Title implements ActionListener{
        public void actionPerformed(ActionEvent event){
            Gamescreen();

        }

    }
}
  