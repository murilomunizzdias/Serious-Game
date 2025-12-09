package entity;

import centro.GamePanel;

public class NPC_3 extends Entity {

    public NPC_3(GamePanel gp){
        super(gp);
        direction="down";
        speed = 1;

        getImage();
        setDialogue();

    }

    public void getImage() {
        down1 = setup("/res/npc/npc3_down1");
        down2 = setup("/res/npc/npc3_down2");
        
        // PREENCHA AS OUTRAS DIREÇÕES (mesmo que seja com a imagem de baixo)
        // para evitar que ele suma ao virar.
        up1 = setup("/res/npc/npc3_down1"); // Ou use a imagem correta se tiver
        up2 = setup("/res/npc/npc3_down2");
        
        left1 = setup("/res/npc/npc3_down1");
        left2 = setup("/res/npc/npc3_down2");
        
        right1 = setup("/res/npc/npc3_down1");
        right2 = setup("/res/npc/npc3_down2");
    }

    public void setDialogue(){
        dialogues[0]= "Bem vindo jovem, então \n Casseb te mandou até mim";
        dialogues[1] = "Ja vou avisando que a minha\n é a mais dificíl";
        dialogues[2] = "Aqui está a mensagem criptografada:\n considere uma matriz inteira onde 3,8\netc é um par";
        dialogues[3] = "[4, 11]   [5, 13]   [4, 11]   [5, 14] \n [8, 20]   [4, 11]   [6, 15]   [6, 16]";
        dialogues[4]= "o primeiro esta a chave\n na qual a resposta é nintendo";
        dialogues[5]= "o quarto do meio a direita esta a chave\n na qual a resposta é terraria";
        dialogues[6] = "e a chave em cima é\n a qual a resposta é fallouts";
        
        

    }

    
    public void speak(){
        super.speak();

    }
    
}
