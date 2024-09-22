import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class Background extends JPanel implements ActionListener,KeyListener {
    int height = 600;
    int width = 600;

    JFrame frame = new JFrame("Flappy Bird 💕❤️🦜🦜🦜");
    Image Top;
    Image mid ;
    Image birds;
    Image bot;
    Image ice;
    //instances for the bird...
    int birdX=width/6;
    int birdY=height/2;
    int birdwidth = 40;
    int birdheight = 30;

    class Bird{
      int X = birdX;
      int Y = birdY;
      int bwidth = birdwidth;
      int bheight = birdheight;
      Image bmge;
      Bird(Image bmge){
          this.bmge = bmge;
      }
    }
    int pipeX = width;
    int pipeY = 0;
    int pipewidth = 100;
    int pipeheight = 472;
    class Pipe{
      int Xp = pipeX;
      int Yp= pipeY;
      int Pwidth = pipewidth;
      int Pheight = pipeheight;
      Image pimg;
      boolean succ = false;
      Pipe(Image pimg){
        this.pimg=pimg;

      }
    }
    int speedP=-4;
    ArrayList<Pipe> pipes;
    
    Bird bird;
    Random rand =new Random();
    Timer time;
    boolean gameOver= false;
    Timer pipesTimer;
    int speed = 0;
    int opp = 1;
    double score = 0.0;
    Background() {   //constructer 
        setPreferredSize(new Dimension(width,height));
        //setBackground(Color.blue);
        setFocusable(true);
        addKeyListener(this);
       Top = new ImageIcon(getClass().getResource("./tube.png")).getImage();
        mid = new ImageIcon(getClass().getResource("./tube2.png")).getImage();
        birds = new ImageIcon(getClass().getResource("./bird.png")).getImage();
        bot = new ImageIcon(getClass().getResource("./iceBackground.jpg")).getImage();
        ice = new ImageIcon(getClass().getResource("./try.png")).getImage(); 
        
        bird = new Bird(birds);
      time = new Timer(1000/60,this);
      pipes = new ArrayList<>();
      pipesTimer = new Timer(1500,new ActionListener() {
        @Override
	public void actionPerformed(ActionEvent e){
      pipeimport();
  } 
    
      });
    
      pipesTimer.start();
      time.start();
    }
    public void pipeimport(){
      int randPipes = (int) ((pipeY - pipeheight/4) - Math.random()*(pipeheight/2));
      int position= width/4;
      Pipe toppipe=new Pipe(Top);
      toppipe.Yp= randPipes;
      pipes.add(toppipe);
      Pipe bottompipes = new Pipe(mid);
      bottompipes.Yp= toppipe.Yp + position + pipeheight;
      pipes.add(bottompipes); 

    }
   public void paintComponent(Graphics g){
        super.paintComponent(g);
       draw(g);
      
    }
    public void acc(){
      speed +=opp;
      bird.Y +=speed;
      bird.Y = Math.max(bird.Y,0);
      int i =0;
      while(i < pipes.size()){
        Pipe pipe= pipes.get(i);
        pipe.Xp += speedP;
        i++;
        if(!pipe.succ && bird.X > pipe.Yp + pipewidth){
          pipe.succ = true;
          score += 0.5;

        }
      }
      if(bird.Y> width){
        gameOver=true;
      }
    }
    public void draw(Graphics g){
      g.drawImage(bot, 0, 0, width, height, null);

      g.drawImage(bird.bmge, bird.X, bird.Y, bird.bwidth, bird.bheight, null);
      int i =0; 
    while(i< pipes.size()){
      Pipe pipe = pipes.get(i);
      
    
    g.drawImage(pipe.pimg, pipe.Xp, pipe.Yp, pipe.Pwidth, pipe.Pheight, null);
    i++;
    }
    g.setColor(Color.black);
    g.setFont(new Font("Arial",Font.PLAIN, 32));
    if(gameOver){
      g.drawImage(ice, 0, 0, width, height, null);
    }
    else{
      g.drawString(String.valueOf((int) score) , 10, 30);
    }
    }
	@Override
	public void actionPerformed(ActionEvent e) {
    
    acc();
  
	repaint();
  if(gameOver){
    pipesTimer.stop();
    time.stop();
  }
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
	if(e.getKeyCode() == KeyEvent.VK_SPACE){
    speed = -9;
  }	
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
	}
}