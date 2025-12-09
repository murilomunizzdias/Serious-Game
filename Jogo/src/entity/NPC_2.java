package entity;

import centro.GamePanel;

public class NPC_2 extends Entity {
    
    public NPC_2(GamePanel gp){
        super(gp);
        direction="down";
        speed = 1;

        getImage();
        setDialogue();

    }

public void getImage() {
    down1 = setup("/res/npc/npc2_down1");
    down2 = setup("/res/npc/npc2_down2");
    
    // PREENCHA AS OUTRAS DIREÇÕES (mesmo que seja com a imagem de baixo)
    // para evitar que ele suma ao virar.
    up1 = setup("/res/npc/npc2_down1"); // Ou use a imagem correta se tiver
    up2 = setup("/res/npc/npc2_down2");
    
    left1 = setup("/res/npc/npc2_down1");
    left2 = setup("/res/npc/npc2_down2");
    
    right1 = setup("/res/npc/npc2_down1");
    right2 = setup("/res/npc/npc2_down2");
}

    public void setDialogue(){
        dialogues[0] = "Bem vindo desafiante";
        dialogues[1] = "Você nunca vai conseguir\n HAHAHAHA";
        dialogues[2] = "Aqui está a mensagem criptografada:\n considere uma matriz inteira onde 3,8\n...etc é um par";
        dialogues[3] = "[5 13] [4 11] [6 15] [7 19] \n[4 10] [0 0] [6 16]";
        dialogues[4]= "o quarto em cima na esquerda esta a chave\n na qual a resposta é inducao";
        dialogues[5]= "o quarto a direita em cima esta a chave\n na qual a resposta é secreta";
        dialogues[6] = "o primeiro quarto esta a chave\n a qual a resposta é resolva";

    }

    
    public void speak(){
        super.speak();

    }
    
}
