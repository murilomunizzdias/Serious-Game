package centro;
import object.OBJ_Key;
import object.OBJ_Wrong_Key;
import entity.NPC_1;
import entity.NPC_2;
import entity.NPC_3;
import entity.NPC_OldMan;
import object.OBJ_Boots;
import object.OBJ_Door;
import object.OBJ_Chest;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp=gp;
    }

    public void setObject(){
        
        gp.obj[0]= new OBJ_Key(gp);//CASA DE DIRETA, CIMA ESQUERDA
        gp.obj[0].worldX=44*gp.tileSize;
        gp.obj[0].worldY=14*gp.tileSize;

        gp.obj[1]= new OBJ_Key(gp);//CASA DE CIMA DIREITA CIMA
        gp.obj[1].worldX=34*gp.tileSize;
        gp.obj[1].worldY=5*gp.tileSize;  
        

        gp.obj[2]= new OBJ_Boots(gp);
        gp.obj[2].worldX=14*gp.tileSize;
        gp.obj[2].worldY=38*gp.tileSize;

        gp.obj[3]= new OBJ_Door(gp);//PORTA 1
        gp.obj[3].worldX=25*gp.tileSize;
        gp.obj[3].worldY=30*gp.tileSize;

        gp.obj[4]= new OBJ_Door(gp);//PORTA 2
        gp.obj[4].worldX=19*gp.tileSize;
        gp.obj[4].worldY=37*gp.tileSize;

        gp.obj[5]= new OBJ_Door(gp);//PORTA 3
        gp.obj[5].worldX=25*gp.tileSize;
        gp.obj[5].worldY=39*gp.tileSize;

        gp.obj[6]= new OBJ_Chest(gp);//BAU FINAL
        gp.obj[6].worldX=25*gp.tileSize;    
        gp.obj[6].worldY=44*gp.tileSize;

        gp.obj[7]= new OBJ_Wrong_Key(gp);//CASA DE CIMA DIREITA BAIXO
        gp.obj[7].worldX=35*gp.tileSize;    
        gp.obj[7].worldY=9*gp.tileSize;

        gp.obj[8]= new OBJ_Wrong_Key(gp);//CASA DE CIMA ESQUERDA
        gp.obj[8].worldX=18*gp.tileSize;    
        gp.obj[8].worldY=9*gp.tileSize;

        gp.obj[9]= new OBJ_Wrong_Key(gp);//CASA DE DIREITA, DIREITA BAIXO
        gp.obj[9].worldX=48*gp.tileSize;    
        gp.obj[9].worldY=16*gp.tileSize;

        gp.obj[10]= new OBJ_Wrong_Key(gp);//CASA DE DIREITA, DIREITA CIMA
        gp.obj[10].worldX=47*gp.tileSize;    
        gp.obj[10].worldY=14*gp.tileSize;


        gp.obj[11]= new OBJ_Wrong_Key(gp);//CASA DE ESQUERDA, cima
        gp.obj[11].worldX=4*gp.tileSize;    
        gp.obj[11].worldY=14*gp.tileSize;

        gp.obj[12]= new OBJ_Wrong_Key(gp);//CASA DE ESQUERDA, MEIO
        gp.obj[12].worldX=5*gp.tileSize;    
        gp.obj[12].worldY=18*gp.tileSize;

        gp.obj[13] = new OBJ_Key(gp);//CASA ESQUERDA, BAIXO
        gp.obj[13].worldX=5*gp.tileSize;
        gp.obj[13].worldY=21*gp.tileSize;


    }

    public void setNpc(){
        gp.npc[0]= new NPC_OldMan(gp);//dentro do castelo
        gp.npc[0].worldX =gp.tileSize*27;
        gp.npc[0].worldY = gp.tileSize*28;

        gp.npc[1]=new NPC_1(gp);//casa de cima
        gp.npc[1].worldX = gp.tileSize*22;
        gp.npc[1].worldY = gp.tileSize*12;

        gp.npc[2]= new NPC_2(gp);//casa da direita
        gp.npc[2].worldX = gp.tileSize*44;
        gp.npc[2].worldY = gp.tileSize*20;

        gp.npc[3]= new NPC_3(gp);//casa da esquerda
        gp.npc[3].worldX = gp.tileSize*1;
        gp.npc[3].worldY = gp.tileSize*24;
    }
}
