package centro;
import entity.Player;
import tile.TileManager;
import object.SuperObject;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class GamePanel extends JPanel implements Runnable{
    //Screen settings
    final int originalTileSize = 16;//size of characters e tires]
    final int scale = 3;//ja que monitores tem uma resolução muito grandes vamos scalar os bonecos

    public final int tileSize=originalTileSize*scale;//scalade 48x48
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth= tileSize * maxScreenCol;//768 pixels
    public final int screenHeight = tileSize * maxScreenRow;//576 pixels

    //WORLD SETTINGS
    public final int maxWorldCol=50;
    public final int maxWorldRow=50;
   

    //FPS
    int fps=60;
    KeyHandler keyH= new KeyHandler();
    Thread gameThread;
    public Player player = new Player(this, keyH, fps, fps);
    public CollisionChecker cChecker= new CollisionChecker(this);
    public AssetSetter aSetter= new AssetSetter(this);
    public UI ui= new UI(this); 
    public SuperObject obj[] = new SuperObject[10];
    Sound sound = new Sound();
    Sound music = new Sound();
    Sound se = new Sound();
    //Tile manager
    TileManager tileM = new TileManager(this);

    //player initial position
    int playerX=100;
    int playerY=100;
    int playerSpeed=4;

   

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);//better rendering
        this.addKeyListener(keyH);
        this.setFocusable(true);

    }

    public void setupGame(){
        aSetter.setObject();
        playMusic(0);
    }
    public void starGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    public void run(){//Game loop core of our game
        while (gameThread != null) {
            double drawInterval= 1000000000/fps;//1 bilhao de nano segundos = 1 segundo
            double delta=0;
            long currentTime;
            long lastTime = System.nanoTime();
            long timer = 0;
            int drawCount=0;
            
            while (gameThread != null) {
                currentTime = System.nanoTime();

                delta += (currentTime-lastTime)/ drawInterval;
                timer += (currentTime-lastTime);
                lastTime = currentTime;

                if(delta>=1){
                    //System.out.println("GAME IS RUNNING");
                    //Update: update information sucha as character positions
                    update();
                    //Draw: draw the screen with the update information
                    repaint();//confuso mas é como tu chama o paintComponent
                    delta--;
                    drawCount++;
                }

                if (timer >= 1000000000){//display do fps
                    System.out.println("FPS: "+drawCount);
                    drawCount = 0;
                    timer = 0;
                }
            }
            
        }   
    }

    public void update(){
        player.update();
    }

    public void paintComponent(Graphics graphs){
        super.paintComponent(graphs);

        Graphics2D g2 = (Graphics2D)graphs;

        for (int i = 0; i < obj.length; i++) {
            if(obj[i]!=null){
                obj[i].draw(g2, this);
            }
        }
        //tile
        tileM.draw(g2);
        //object
        for (int i = 0; i < obj.length; i++) {
            if(obj[i]!=null){
                obj[i].draw(g2, this);
            }
        }
        //player
        player.draw(g2);

        //UI
        ui.draw(g2);
        
        g2.dispose();//save memory
    }

    public void playMusic(int i){
        music.setFile(i);
        music.play();
        music.loop();
    }

    public void stopMusic(){
        music.stop();
    }

    public void playSE(int i){
        se.setFile(i);
        se.play();
    }
}
