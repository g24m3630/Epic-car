import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Background extends JFrame implements ActionListener {
    int imageheight = 600;
    int imageWeight = 600;

    //Image backgoundImg;
    JButton button;
    JFrame frame = new JFrame("main page");

    int width = 600;
    int height =600;
    Background() {   //constructer 
        /*setPreferredSize(new Dimension(imageWeight,imageheight));
        setBackground(Color.green);
        */
        
        ImageIcon icon = new ImageIcon("iceBackground.jpg");
        button  = new JButton();
        button.setBounds(220,230,140,80);
        button.setText("PLAY");
        button.addActionListener(this);
        button.setBackground(Color.lightGray);


        frame.setTitle("Floppy");
        frame.setSize(width,height);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(button);
        frame.setLayout(null);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button){
            System.out.println("ohk it works");


        }
    }
    private static class imageIcon {

        public imageIcon() {
        }
    }

}
