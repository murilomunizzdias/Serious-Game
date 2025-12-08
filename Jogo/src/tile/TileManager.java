
package tile;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import java.awt.Graphics2D;

import centro.GamePanel;
import centro.UtilityTool;
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
    
        setup(0, "grass", false);
        setup(1, "wall", true);
        setup(2, "water", true);
        setup(3, "earth", false);
        setup(4, "tree", true);
        setup(5, "sand", false);
            
      
    }

    public void draw(Graphics2D g2){
        int worldCol=0;
        int worldRow=0;

        while(worldCol<gp.maxWorldCol && worldRow<gp.maxWorldRow){
            int tileNum= mapTileNum[worldCol][worldRow];

            int x= worldCol*gp.tileSize;
            int y= worldRow*gp.tileSize;
            int screenX= x - gp.player.worldX + gp.player.screenX;
            int screenY= y - gp.player.worldY + gp.player.screenY;

            if(x > gp.player.worldX - gp.player.screenX - gp.tileSize &&
               x < gp.player.worldX + gp.player.screenX + gp.tileSize &&
               y > gp.player.worldY - gp.player.screenY - gp.tileSize &&
               y < gp.player.worldY + gp.player.screenY + gp.tileSize){

                g2.drawImage(tile[tileNum].image, screenX, screenY, null);
            }
            
            worldCol++;
          
            if(worldCol==gp.maxWorldCol){
                worldCol=0;
                worldRow++;
                
            }
        }
    }

    public void setup(int index, String imagePath, boolean collision){
        UtilityTool uTool = new UtilityTool();

        try {
            tile[index]= new Tile();
            tile[index].image= ImageIO.read(getClass().getResourceAsStream("/res/Tiles/"+imagePath+".png"));
            tile[index].image=uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
            tile[index].collision=collision;
        } catch (IOException e) {
            
        }
    }
    public void loadMap(String filePath){
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int worldCol=0;
            int worldRow=0;  
            while(worldCol<gp.maxWorldCol && worldRow<gp.maxWorldRow){
                String line = br.readLine();  

                while(worldCol<gp.maxWorldCol){
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[worldCol]);
                    mapTileNum[worldCol][worldRow]=num;
                    worldCol++;
                }
                if(worldCol==gp.maxWorldCol){
                    worldCol=0;
                    worldRow++;
                }
            }
            br.close();
        } catch (Exception e) {
            
        }
    }
}
