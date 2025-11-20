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
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth= tileSize * maxScreenCol;//768 pixels
    final int screenHeight = tileSize * maxScreenRow;//576 pixels

    //FPS
    int fps=60;
    KeyHandler keyH= new KeyHandler();
    Thread gameThread;
    Player player = new Player(this, keyH);

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
        player.draw(g2);
        g2.dispose();//save memory
    }
}
