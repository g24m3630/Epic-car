import javax.swing.*;
public class App {
    public static void main(String[] args) throws Exception {

        int width = 600;
        int height =600;

        JFrame frame = new JFrame("FLAPPY BIRD 💕❤️🦜🦜🦜");
        frame.setSize(width,height);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setVisible(true);
        

       Background background= new Background();
        frame.add(background);
        frame.pack();
        background.requestFocus();
        frame.setVisible(true);
    }
}
