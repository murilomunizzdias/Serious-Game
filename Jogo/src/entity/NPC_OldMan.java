package entity;



import centro.GamePanel;


public class NPC_OldMan extends Entity {

    public NPC_OldMan(GamePanel gp){
        super(gp);
        direction="down";
        speed = 1;

        getImage();
        setDialogue();

    }

    public void getImage() {
        up1 = setup("/res/npc/oldman_up_1");
        up2 = setup("/res/npc/oldman_up_2");
        down1 = setup("/res/npc/oldman_down_1");
        down2 = setup("/res/npc/oldman_down_2");
        left1 = setup("/res/npc/oldman_left_1");
        left2 = setup("/res/npc/oldman_left_2");
        right1 = setup("/res/npc/oldman_right_1");
        right2 = setup("/res/npc/oldman_right_2");

    }

    public void setDialogue(){
        dialogues[0] = "Olá pedro!, eu sou o grande mago Casseb";
        dialogues[1] = "Então você veio em busca do tesouro....";
        dialogues[2] = "Conseguir ele não será fácil, \n será preciso conhecer CRIPTOGRAFIA!";
        dialogues[3] = "Você deve seguir os três caminhos abaixos";
        dialogues[4] = "lá meus aprendizes vão te apresentar uma\n mensagem criptografada,\ndecifrando ela voce ganha uma chave!";
        dialogues[5] = "Para criptografar, você tera que\n usar essa chave:";
        dialogues[6] = "[1 2]\n[5 3]\n anote isso em um caderno\nai no mundo real";
        dialogues[7] = "Eu sei que estou num\n jogo....";
        dialogues[8] = "Anote também nosso seguinte\n alfabeto";
        dialogues[9] = "A (0,0)  B (1,0)  C (2,0)  D (3,0)  E (4,0)\nF (0,1)  G (1,1)  I (2,1)  J (3,1)  L (4,1)\nM (0,2)  N (1,2)  O (2,2)  P (3,2)  R (4,2)\nS (0,3)  T (1,3)  U (2,3)  [Espaço] (3,3)";
        dialogues[10] = "A matriz chave 2x2 que eu te dei\n vai estar multiplicando a palavra deles\n construida no nosso alfabeto";
        dialogues[11] = "Basta você usar a chave de forma\n INVERSA para achar a palavra";
        dialogues[12] = "Conseguindo três você \nconsegue passar pelo castelo";
        dialogues[13] = "Boa sorte, você vai precisar....\n uma dica, explore os caminhos\n da esquerda, posso ter\n deixado uma surpresa mágica";
        dialogues[14] = "Se achar difícil lembre, \npelo menos nao é prova por indução";

    }

    
    public void speak(){
        super.speak();

    }
    


}
