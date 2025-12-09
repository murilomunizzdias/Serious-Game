package entity;

import centro.GamePanel;

public class NPC_1 extends Entity {

    public NPC_1(GamePanel gp){
        super(gp);
        direction="down";
        speed = 1;

        getImage();
        setDialogue();

    }

    public void getImage() {
        down1 = setup("/res/npc/npc1_down1");
        down2 = setup("/res/npc/npc1_down2");
        
        // PREENCHA AS OUTRAS DIREÇÕES (mesmo que seja com a imagem de baixo)
        // para evitar que ele suma ao virar.
        up1 = setup("/res/npc/npc1_down1"); // Ou use a imagem correta se tiver
        up2 = setup("/res/npc/npc1_down2");
        
        left1 = setup("/res/npc/npc1_down1");
        left2 = setup("/res/npc/npc1_down2");
        
        right1 = setup("/res/npc/npc1_down1");
        right2 = setup("/res/npc/npc1_down2");
    }

    public void setDialogue(){
        dialogues[0] = "Então você veio em busca\n da minha chave";
        dialogues[1] = "Se você tem o conhecimento necessário\n você passará";
        dialogues[2] = "Aqui está a mensagem criptografada:\n considere uma matriz inteira onde \n3,8...etc é um par";
        dialogues[3] = "[3, 8]   [5, 13]   [10, 26]   [6, 16]\n [5, 14]   [5, 14]   [6, 16]";
        dialogues[4]= "o quarto a esquerda esta a chave\n na qual a resposta é cesupas";
        dialogues[5]= "o quarto a direita baixo esta a chave\n na qual a resposta é munizio";
        dialogues[6] = "e a chave na direita cima é\n a qual a resposta é girotto";


    }

    
    public void speak(){
        super.speak();

    }
    


}



