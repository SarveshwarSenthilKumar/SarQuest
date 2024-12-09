package SarQuest.src.main;

import javax.swing.JFrame;
import java.util.*;
import SarQuest.src.*;
import SarQuest.src.entity.Player;

import javax.swing.ImageIcon;
import SarQuest.src.main.GamePanel;
import SarQuest.src.object.OBJ_Key;
import SarQuest.src.object.OBJ_Vault;

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import javax.imageio.ImageIO;

public class UI {
    GamePanel gp;
    Font arial_40, ariel_80B, ariel_instructions;

    BufferedImage keyImage;
    BufferedImage heartImage;
    BufferedImage vaultImage;

    BufferedImage playerImage;
    BufferedImage playerImage2;

    String time;

    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;

    double playTime;
    double value;
    DecimalFormat dFormat = new DecimalFormat("0.00");

    public UI(GamePanel gp){
        this.gp = gp;

        arial_40 = new Font("Arial", Font.PLAIN, 40);
        ariel_instructions = new Font("Arial", Font.PLAIN, 15);
        ariel_80B = new Font("Arial", Font.BOLD, 80);

        OBJ_Key key = new OBJ_Key();
        keyImage = key.image;

        Player player = new Player(gp, null);
        playerImage = player.down1;
        playerImage2 = player.down2;

        OBJ_Vault vault = new OBJ_Vault();
        vaultImage = vault.image;

        try {
            heartImage = ImageIO.read(getClass().getResourceAsStream("heart.png"));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public void showMessage(String text){

        message = text;
        messageOn = true;

    }

    public void draw(Graphics2D g2){

        value = Double.valueOf(dFormat.format(playTime));

        if  (value > 60.0){
            String seconds = "0";
            String minutes = String.valueOf((int) value/60);
            if (Integer.parseInt(minutes) < 10){
                minutes = "0"+minutes;
            }
            if ((value%60)>1){
                seconds = String.valueOf((int)value%60);
                if (Integer.parseInt(seconds) < 10){
                    seconds = "0"+seconds;
                }
                time = minutes + ":" + seconds;

            }
        }
        else if ((int)value % 60 == 0 && (int)value != 0){
            String minutes = String.valueOf((int) value/60);

            if (Integer.parseInt(minutes) < 10){
                minutes = "0"+minutes;
            }

            String seconds = "00";

            time = minutes + ":" + seconds;
        }
        else{
            time = String.valueOf(value);
        }

        if (gp.keyH.gameBeaten == true){

            g2.setFont(g2.getFont().deriveFont(40f));
            g2.setColor(Color.white);

            String text;
            int textLength;
            int x;
            int y;

            text = "You have found the protected bank vault!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();

            x = gp.screenWidth/2 - textLength/2;
            y = gp.screenHeight/2 - (gp.tileSize*2);
            g2.drawString(text, x, y);

            text = "Press 'R' to play again!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();

            g2.setColor(Color.white);

            x = gp.screenWidth/2 - textLength/2;
            y = gp.screenHeight/2 - (gp.tileSize*3);
            g2.drawString(text, x, y);

            text = "Your time is " + time +"!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();

            x = gp.screenWidth/2 - textLength/2;
            y = gp.screenHeight/2 + (gp.tileSize*4);
            g2.drawString(text, x, y);

            g2.setFont(ariel_80B);
            g2.setColor(Color.yellow);

            text = "Congratulations!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();

            x = gp.screenWidth/2 - textLength/2;
            y = gp.screenHeight/2 + (gp.tileSize*2);
            g2.drawString(text, x, y);

        }
        else if (gp.keyH.start == true){
            String text;
            int textLength;
            int x;
            int y;

            g2.setFont(ariel_80B);
            g2.setColor(Color.red);

            text = "SarQuest";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();

            x = gp.screenWidth/2 - textLength/2;
            y = gp.screenHeight/4;
            g2.drawString(text, x, y);

            g2.drawImage(playerImage, gp.tileSize*3, gp.tileSize+(gp.tileSize/2), gp.tileSize*2, gp.tileSize*2, null);
            g2.drawImage(playerImage2, gp.tileSize*11+(gp.tileSize/4), gp.tileSize+(gp.tileSize/2), gp.tileSize*2, gp.tileSize*2, null);

            String[] texts = new String[12];
            texts[0] = "W - Move Up";
            texts[1] = "A - Move Left";
            texts[2] = "S - Move Down";
            texts[3] = "D - Move Right";
            texts[4] = "CTRL - Sprint";
            texts[5] = "Shift - Slow Down";
            texts[6] = "M - Mute / Unmute Music";
            texts[7] = "B - Mute / Unmute Bee & Bird";
            texts[8] = "1 - Change Music Track";
            texts[9] = "P - Pause";
            texts[10] = "E - Exploration Mode";
            texts[11] = "R - Start / Restart Game";


            g2.setFont(ariel_instructions);
            g2.setColor(Color.white);

            for (int i = 0; i < texts.length; i++){
                x = (int) (gp.screenWidth/4 - textLength/1.5) + gp.screenWidth/8;
                y = (int) Math.round(gp.screenHeight/2 + ((gp.tileSize/2)*i));
                g2.drawString(texts[i], x, y);

            }
            g2.drawImage(vaultImage, (gp.maxScreenCol*gp.tileSize/2)+(gp.tileSize/2), (gp.maxScreenCol/2*gp.tileSize/2)+(gp.tileSize), gp.tileSize*7, gp.tileSize*7, null);

        }
        else if(gp.keyH.gameLost == true){
            g2.setFont(g2.getFont().deriveFont(40f));
            g2.setColor(Color.white);

            String text;
            int textLength;
            int x;
            int y;

            text = "You have lost all your health!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();

            x = gp.screenWidth/2 - textLength/2;
            y = gp.screenHeight/2 - (gp.tileSize*2);
            g2.drawString(text, x, y);

            text = "Press 'R' to play again!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();

            x = gp.screenWidth/2 - textLength/2;
            y = gp.screenHeight/2 - (gp.tileSize*3);
            g2.drawString(text, x, y);

            text = "Your time is " + time +"!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();

            x = gp.screenWidth/2 - textLength/2;
            y = gp.screenHeight/2 + (gp.tileSize*4);
            g2.drawString(text, x, y);

            g2.setFont(g2.getFont().deriveFont(75f));
            g2.setColor(Color.yellow);

            text = "Better luck next time!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();

            x = gp.screenWidth/2 - textLength/2;
            y = gp.screenHeight/2 + (gp.tileSize*2);
            g2.drawString(text, x, y);

        }
        else if (gp.keyH.explorationMode == false){
            g2.setFont(arial_40);
            g2.setColor(Color.white);


            for (int i = 0; i < gp.player.hearts; i++){
                g2.drawImage(heartImage, gp.tileSize/2+(i*gp.tileSize), gp.tileSize/2, gp.tileSize, gp.tileSize, null);
            }

            g2.drawImage(keyImage, gp.tileSize/2, gp.tileSize+(gp.tileSize/2), gp.tileSize, gp.tileSize, null);
            //g2.drawImage(img, x, y, width, height, bgcolor, observer)
            g2.drawString("x " + gp.player.hasKey, 74, 65+(gp.tileSize));
            if (gp.keyH.gamePaused == false){
                playTime += (double)1/60;
            }
            g2.drawString("Time: " + time, gp.tileSize*11, 65);

            if (gp.keyH.gamePaused == true){
                
                g2.setFont(ariel_80B);
                g2.drawString("PAUSED", (gp.tileSize*(gp.maxScreenRow/2))-(gp.tileSize+(gp.tileSize/4)), gp.tileSize*(gp.maxScreenRow/2));
            }

            if (messageOn == true){

                g2.setFont(g2.getFont().deriveFont(20f));
                g2.drawString(message, gp.tileSize/2, gp.tileSize*5);

                messageCounter ++;

                if (messageCounter > 120){
                    messageCounter = 0;
                    messageOn = false;
                }
            }

        }

    }
}
