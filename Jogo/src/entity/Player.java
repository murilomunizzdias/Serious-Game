package entity;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import centro.GamePanel;
import centro.KeyHandler;


public class Player extends Entity {
  
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;
    public int hasKey=0;

    public Player(GamePanel gp, KeyHandler keyH){
        super(gp);
        
        this.keyH = keyH;

        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);

        solidArea=new Rectangle();
        solidArea.x=8;
        solidArea.y=16;
        solidAreaDefaultX=solidArea.x;
        solidAreaDefaultY=solidArea.y;
        solidArea.width=32;
        solidArea.height=32;

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        worldX=gp.tileSize*16;//definir no txt
        worldY=gp.tileSize*22;//definir no txt
        speed= 3;
        direction="down";
    }
   public void getPlayerImage() {
        up1 = setup("/res/Oliver/Oliver_up_1");
        up2 = setup("/res/Oliver/Oliver_up_2");
        down1 = setup("/res/Oliver/Oliver_down_1");
        down2 = setup("/res/Oliver/Oliver_down_2");
        left1 = setup("/res/Oliver/Oliver_left_1");
        left2 = setup("/res/Oliver/Oliver_left_2");
        right1 = setup("/res/Oliver/Oliver_right_1");
        right2 = setup("/res/Oliver/Oliver_right_2");

    }
    
    public void update(){

        if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true){
            if(keyH.upPressed == true){
                direction="up";

            }else if(keyH.downPressed == true){
                direction="down";
                
            }else if(keyH.rightPressed == true){
                direction="right";
            
            }else if(keyH.leftPressed == true){
                direction="left";
                
            }

            //check tile collision
            collisionOn=false;
            gp.cChecker.checkTile(this);

            //check object collision
            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);
            
            //check npc collision
            int npcIndex = gp.cChecker.checkEntity(this,gp.npc);
            interactNpc(npcIndex);

            //IF COLLISION IS FALSE, PLAYER CAN MOVE
            if(collisionOn==false){
                switch(direction){
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                }
            }

            spriteCounter++;
            if(spriteCounter>10){
                if(spriteNum==1){
                    spriteNum=2;
                }else if(spriteNum==2){
                    spriteNum=1;
                }
                spriteCounter=0;
            }
        }
        
    }

    public int pickUpObject(int i) {
        if(i != 999){
            String objectName = gp.obj[i].name;

            switch (objectName) {
                case "WrongKey":
                    gp.obj[i] = null;
                    gp.ui.gameOver=true;
                    break;

                case "Key":
                    gp.playSE(1);
                    hasKey++;
                    gp.obj[i] = null;
                    gp.ui.showMessage("Voçê pegou uma chave!");
                    break;
                case "Door":
                    if(hasKey>0){
                        gp.playSE(3);
                        gp.obj[i] = null;
                        hasKey--;
                        gp.ui.showMessage("Você usou uma chave!");
                        break;
                    }else{
                        gp.ui.showMessage("Sem chaves no inventário");
                        break;
                        
                    }
                case "Boots":
                    gp.playSE(2);
                    speed += 1; // Aumenta a velocidade do jogador 
                    gp.obj[i] = null; // Remove as botas do jogo
                    gp.ui.showMessage("Acelerando!");
                    break;   

                case "Chest":
                    
                    gp.ui.gameFinished=true;
                    gp.stopMusic(); 
                    gp.playSE(4);
                    break;
                }

                
            }
        return 0;
    }

    public void interactNpc(int i){
        if(i != 999){
            if(gp.keyH.enterPressed == true){
                gp.gameState = gp.dialogueState;
                gp.npc[i].speak();
            }


        }
        gp.keyH.enterPressed = false; 
    }
    public void draw(Graphics2D g2){
        BufferedImage image = null;
        
        switch (direction) {
            case "up":
                if(spriteNum==1){
                    image=up1;
                }
                if(spriteNum==2){
                    image=up2;
                }
                break;
            case"down":
                if(spriteNum==1){
                    image=down1;
                }
                if(spriteNum==2){
                    image=down2;
                }
                break;
            case"left":
            if(spriteNum==1){
                    image=left1;
                }
                if(spriteNum==2){
                    image=left2;
                }
                break;
            case"right":
                if(spriteNum==1){
                    image=right1;
                }
                if(spriteNum==2){
                    image=right2;
                }
                break;
        }
        g2.drawImage(image,screenX ,screenY, null);
    }
}
