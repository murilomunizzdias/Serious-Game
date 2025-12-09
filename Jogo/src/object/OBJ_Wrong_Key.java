package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import centro.GamePanel;

public class OBJ_Wrong_Key extends SuperObject {
    GamePanel gp;

    public OBJ_Wrong_Key(GamePanel gp){ 
        name = "WrongKey";

        try {
            image =ImageIO.read(getClass().getResourceAsStream("/res/objects/key.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
