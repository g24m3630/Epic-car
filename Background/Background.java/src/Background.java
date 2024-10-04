import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class Background extends JPanel implements ActionListener,KeyListener {
    int height = 700;
    int width = 1360;

    JFrame frame = new JFrame("Flappy Bird 💕❤️🦜🦜🦜");
    Image Top;
    Image mid ;
    Image birds;
    Image bot;
    Image ice;
    Image golds;
    Image bronzes;
    Image silvers;
    Image platinums ;
  
    //instances for the bronze..
    int bronzeX=70;
    int bronzeY=30;
    int bronzewidth = 40;
    int bronzeheight = 30;
    class Bronze{
      int Xb = bronzeX;
      int Yb = bronzeY;
      int bswidth = bronzewidth;
      int bsheight = bronzeheight;
      Image zmge;
      Bronze(Image zmge){
        this.zmge = zmge;
    }
  }
  //Instances for the Silver
  int silverX=20;
  int silverY=30;
  int silverwidth = 40;
  int silverheight = 30;
 
class Silver{
    int Xs = silverX;
    int Ys = silverY;
    int swidth = silverwidth;
    int sheight = silverheight;
    Image smge;
    Silver(Image smge){
      this.smge = smge;
  }
}
  //Instances for the Platinum
  int platinumX=20;
  int platinumY=30;
  int platinumwidth = 40;
  int platinumheight = 30;
 
class Platinum{
    int Xm = platinumX;
    int Ym = platinumY;
    int mwidth = platinumwidth;
    int mheight = platinumheight;
    Image pmge;
    Platinum(Image pmge){
      this.pmge = pmge;
  }
}


    //instances for the gold...

    int goldX=20;
    int goldY=30;
    int goldwidth = 40;
    int goldheight = 30;
   
class Gold{
      int Xg = goldX;
      int Yg = goldY;
      int gwidth = goldwidth;
      int gheight = goldheight;
      Image gmge;
      Gold(Image gmge){
        this.gmge = gmge;
    }
  }
  ///class for the bird/....
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
    //instances for the pipe....
    int pipeX = width ;
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

   private  int speedP=-9;      //speed for the pipe....
  private  ArrayList<Pipe> pipes; ///list for the pipe...
    
  public static  Platinum platinum; 
  public static  Silver silver;
  public static  Bird bird;
   private  static  Gold gold;
   private  static  Bronze bronze;
    public Random rand =new Random();
    private Timer time;
   public  boolean gameOver= false;
   public  Timer pipesTimer;
   public  int speed = 0; /// speed of the bird...
    int opp = 1;           ///speed of the bird opposed downwards 
    double score = 0.0;
    int timerScore;
    Background() {   //constructer 
        setPreferredSize(new Dimension(width,height));
        setBackground(Color.pink);
        setFocusable(true);
        addKeyListener(this);
       Top = new ImageIcon(getClass().getResource("./tube.png")).getImage();
        mid = new ImageIcon(getClass().getResource("./tube2.png")).getImage();
        birds = new ImageIcon(getClass().getResource("./bird.png")).getImage();
        bot = new ImageIcon(getClass().getResource("./iceBackground.jpg")).getImage();
        ice = new ImageIcon(getClass().getResource("./try.png")).getImage(); 
        golds = new ImageIcon(getClass().getResource("./gold.png")).getImage();
        bronzes = new ImageIcon(getClass().getResource("./bronze.png")).getImage();
        silvers = new ImageIcon(getClass().getResource("./Silver.png")).getImage();
        platinums = new ImageIcon(getClass().getResource("./Platinum.png")).getImage();
        platinum = new Platinum(platinums);
        silver = new Silver(silvers);
        bird = new Bird(birds);
        gold=new Gold(golds);
        bronze=new Bronze(bronzes);
      time = new Timer(1000/60,this);
      pipes = new ArrayList<>();

      pipesTimer = new Timer(1600,new ActionListener() {
        @Override
        
	public void actionPerformed(ActionEvent e){
      pipeimport();
      repaint();

  } 
    
      });
    
      pipesTimer.start(); 
      time.start();       
    }
    ////importing the pipes.....
    public void pipeimport(){
      int randPipes = (int) ((pipeY - pipeheight/6) - Math.random()*(pipeheight/2));
      int position= width/8;
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
    ///tracking motion...
    public void acc(){
      speed +=opp;
      bird.Y +=speed;
      bird.Y = Math.max(bird.Y,0);
      int i =0;
      while(i < pipes.size()){

        Pipe pipe= pipes.get(i);
        pipe.Xp += speedP;
        i++;
        if(!pipe.succ && bird.X > pipe.Yp + pipewidth ){
          pipe.succ = true;
          score += 0.5;
         timerScore = (int)score*3;

        }
        if(Intersection(bird,pipe)){
          gameOver = true ;
        }
      
      if(bird.Y> width){
        gameOver=true;
      
      
    }
    }
    }
   public boolean Intersection(Bird flop, Pipe pip) {
      return flop.X < pip.Xp + pip.Pwidth &&   //flop's top left corner doesn't reach pip's top right corner
             flop.X + flop.bwidth > pip.Xp &&   //flop's top right corner passes pip's top left corner
             flop.Y < pip.Yp + pip.Pheight &&  //flop's top left corner doesn't reach pip's bottom left corner
             flop.Y + flop.bheight > pip.Yp;
    }
    public void draw(Graphics g){
      g.drawImage(bot, 0, 0, width , height, null);

      g.drawImage(bird.bmge, bird.X, bird.Y, bird.bwidth, bird.bheight, null);
      int i =0; 
    while(i< pipes.size()){
      Pipe pipe = pipes.get(i);
      g.drawImage(pipe.pimg, pipe.Xp, pipe.Yp, pipe.Pwidth, pipe.Pheight, null);
      i++;
    }

    g.setColor(Color.darkGray );
    g.setFont(new Font("Arial",Font.PLAIN, 32));
    
    if(gameOver){
     g.drawImage(ice, 0, 0, width, height, null);
      pipesTimer.stop();
    
      time.stop();
      g.drawString("  Score : "+String.valueOf((int) score) , 100 , 300);
         g.drawString("  CLICK TO START ", 100 , 350);
         
    }
    else{
      g.drawString("  Score : "+String.valueOf((int) score) , 10, 30);
      g.setFont(new Font("Arial",Font.PLAIN, 22));
      g.drawString("  P--> PAUSE   " , 10, 100);
      g.drawString("  R--> RESUME   " , 10, 150);
    }
    if(score >=5){
      speedP =-20;
     score +=0.01;
    }
    if(score >=10){
      g.drawImage(bronze.zmge, bronze.Xb - 40 , bronze.Yb, bronze.bswidth, bronze.bsheight, null);
  
    }
    if(score >=50){
      g.drawImage(silver.smge, silver.Xs + 40, silver.Ys  , silver.swidth, silver.sheight, null);
    }
    if(score >=100){
      g.drawImage(gold.gmge, gold.Xg + 80, gold.Yg, gold.gwidth, gold.gheight, null);
    }
    if(score >=200){
      g.drawImage(platinum.pmge, platinum.Xm + 120, platinum.Ym ,  platinum.mwidth, platinum.mheight, null);
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
		/////////////////////////////////
  
	}
	@Override
	public void keyPressed(KeyEvent e) {
    if(e.getKeyCode()== KeyEvent.VK_P){
      pipesTimer.stop();
      time.stop();
    }
    if(e.getKeyCode()== KeyEvent.VK_R){
      pipesTimer.start();
      time.start();
      
    }
    
	if(e.getKeyCode() == KeyEvent.VK_SPACE){
    speed = -9;
  }	
  
  if(gameOver){
    bird.Y=birdY;
    pipes.clear();
    speed = 0;
    score = 0;
    gameOver = false;
    pipesTimer.start();
    time.start();

  }
	}
	@Override
	public void keyReleased(KeyEvent e) {
		///////////////////////////
	}
}