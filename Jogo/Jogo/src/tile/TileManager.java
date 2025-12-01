
package tile;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import java.awt.Graphics2D;
import centro.GamePanel;
public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];

    public TileManager(GamePanel gp){
        this.gp=gp;
        tile=new Tile[10];
        mapTileNum=new int[gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap("/res/maps/mapa1.txt");
    }

    public void getTileImage(){
        try {
            tile[0]= new Tile();
            tile[0].image= ImageIO.read(getClass().getResourceAsStream("/res/Tiles/grass.png"));
            
            tile[1]= new Tile();
            tile[1].image= ImageIO.read(getClass().getResourceAsStream("/res/Tiles/wall.png"));
            tile[1].collision=true;

            tile[2]= new Tile();
            tile[2].image= ImageIO.read(getClass().getResourceAsStream("/res/Tiles/water.png"));
            tile[2].collision=true; 

            tile[3]= new Tile();
            tile[3].image= ImageIO.read(getClass().getResourceAsStream("/res/Tiles/earth.png"));

            tile[4]= new Tile();
            tile[4].image= ImageIO.read(getClass().getResourceAsStream("/res/Tiles/tree.png"));
            tile[4].collision=true; 
            
            tile[5]= new Tile();
            tile[5].image= ImageIO.read(getClass().getResourceAsStream("/res/Tiles/sand.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2){
        int col=0;
        int row=0;

        while(col<gp.maxWorldCol && row<gp.maxWorldRow){
            int tileNum= mapTileNum[col][row];

            int x= col*gp.tileSize;
            int y= row*gp.tileSize;
            int screenX= x - gp.player.worldX + gp.player.screenX;
            int screenY= y - gp.player.worldY + gp.player.screenY;

            if(x > gp.player.worldX - gp.player.screenX - gp.tileSize &&
               x < gp.player.worldX + gp.player.screenX + gp.tileSize &&
               y > gp.player.worldY - gp.player.screenY - gp.tileSize &&
               y < gp.player.worldY + gp.player.screenY + gp.tileSize){

                g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            }
            
            col++;
          
            if(col==gp.maxWorldCol){
                col=0;
                row++;
                
            }
        }
    }

    public void loadMap(String filePath){
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col=0;
            int row=0;  
            while(col<gp.maxWorldCol && row<gp.maxWorldRow){
                String line = br.readLine();  

                while(col<gp.maxWorldCol){
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row]=num;
                    col++;
                }
                if(col==gp.maxWorldCol){
                    col=0;
                    row++;
                }
            }
            br.close();
        } catch (Exception e) {
            
        }
    }
}
