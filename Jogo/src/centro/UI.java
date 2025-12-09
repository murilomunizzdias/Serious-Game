package centro;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import object.OBJ_Key;

import java.awt.BasicStroke;
import java.awt.Color;


public class UI {
    GamePanel gp;
    Font arial_40, arial_80B;
    BufferedImage keyImage;
    Graphics2D g2;
    public boolean messageOn=false;
    public String message="";
    public int messageCounter=0;
    public boolean gameFinished=false;
    public boolean gameOver = false;//eu fiz
    public String currentDialogue="";
    public int commandNum = 0;

    


    public UI(GamePanel gp) {
        this.gp = gp;

        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80B = new Font("Arial", Font.BOLD, 80);
        OBJ_Key key = new OBJ_Key(gp);
        keyImage = key.image;
    }

    public void showMessage(String text){
        message=text;
        messageOn=true;
    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;

        g2.setFont(arial_40);
        g2.setColor(Color.white);
        //TITLE STATE
        if(gp.gameState==gp.titleState){
            drawTitleScreen();
        }
        //PLAY
        if(gp.gameState==gp.playState){
          
            g2.setFont(arial_40);
            g2.setColor(Color.white);
            g2.drawImage(keyImage, gp.tileSize/2, gp.tileSize/2 , gp.tileSize, gp.tileSize, null);
            g2.drawString("x "+ gp.player.hasKey, 74, 65);
        }
        //PAUSE
        if(gp.gameState==gp.pauseState){
            
            drawPauseScreen();
        }
        //DIALOGUE
        if(gp.gameState==gp.dialogueState){
            drawDialogueScreen();
        }

        if(gameFinished==true){
            g2.setFont(arial_40);
            g2.setColor(Color.YELLOW);

            String text;
            int texLength;  
            int x;
            int y; 

            text = "Você achou o tesouro!";
            texLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth/2 - texLength/2;
            y = gp.screenHeight/2 - (gp.tileSize*3);
            g2.drawString(text, x, y);


            g2.setFont(arial_80B);
            g2.setColor(Color.YELLOW);
            text = "fim de jogo!";
            texLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth/2 - texLength/2;
            y = gp.screenHeight/2 + (gp.tileSize*2);
            g2.drawString(text, x, y);

            gp.gameThread = null;
        }

        if(gameOver==true){
            
            g2.setFont(arial_40);
            g2.setColor(Color.RED);

            String text;
            int texLength;  
            int x;
            int y; 
            
            text = "Você errou a resposta";
            texLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth/2 - texLength/2;
            y = gp.screenHeight/2 - (gp.tileSize*3);
            g2.drawString(text, x, y);


            g2.setFont(arial_80B);
            g2.setColor(Color.RED);
            text = "GAME OVER!";
            texLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth/2 - texLength/2;
            y = gp.screenHeight/2 + (gp.tileSize*2);
            g2.drawString(text, x, y);

            gp.gameThread = null;
        }


        //messages
        if(messageOn){
            g2.setFont(g2.getFont().deriveFont(30F));
            g2.drawString(message, gp.tileSize/2, gp.tileSize*5);

            messageCounter++;

            if(messageCounter> 120){
                messageCounter=0;
                messageOn = false;
            }
        }



    }

    public void drawTitleScreen(){
        
        g2.setColor(new Color(70,120,80));
        g2.fillRect(0,0, gp.screenWidth, gp.screenHeight);
        //TITLE NAME
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
        String text = "Unravel";
        int x = getXforCenteredText(text);
        int y = gp.tileSize*3;
        
        //shadow
        g2.setColor(Color.black);
        g2.drawString(text, x+5, y+5);
        
        //main color
        g2.setColor(Color.white);
        g2.drawString(text, x, y);

        //Pedro
        x = gp.screenWidth/2 - (gp.tileSize*2)/2;
        y += gp.tileSize*2;
        g2.drawImage(gp.player.down2,x,y,gp.tileSize*2,gp.tileSize*2,null);

        //menu
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));

        //Start

        text="Start";
        x=getXforCenteredText(text);
        y += gp.tileSize*3.5;
        g2.drawString(text, x, y);
        if(commandNum == 0){
            g2.drawString(">", x-gp.tileSize, y);
        }

        //Load
        text="!Load!";
        x=getXforCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);
        if(commandNum == 1  ){
            g2.drawString(">", x-gp.tileSize, y);
        }

        //Quit
        text="Quit";
        x=getXforCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);
        if(commandNum == 2){
            g2.drawString(">", x-gp.tileSize, y);
        }
        
    }

    public void drawDialogueScreen(){
        //windown
        int x = gp.tileSize*3;
        int y = gp.tileSize/2;
        int width = gp.screenWidth - (gp.tileSize*4);
        int height = gp.tileSize*4;

        drawSubWindow(x, y, width, height);

        g2.setFont(g2.getFont().deriveFont(Font.ITALIC,26F));
        x += gp.tileSize;
        y += gp.tileSize;
        for(String line : currentDialogue.split("\n")){
            g2.drawString(line, x, y);
            y += 40;
        }
        
    }

    public void drawSubWindow(int x, int y, int width, int height){
        Color c = new Color(0,0,0,220);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);

        c=new Color(255,255,255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);


    }

    public void drawPauseScreen(){  
        
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,80));
        String text = "PAUSED";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight/2;

        g2.drawString(text, x, y);
    }

    public int getXforCenteredText(String text){
        int lenght= (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - lenght/2;
        return x;
    }
}
