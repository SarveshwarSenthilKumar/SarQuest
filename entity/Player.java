package SarQuest.src.entity;

import SarQuest.src.main.KeyHandler;
import SarQuest.src.file.Tile;
import SarQuest.src.main.GamePanel;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.text.html.CSS;

//Don't Show hearts
//Don't Show Time
//Don't show Keys
//When reached vault, don't show end card
//Open all objects


import java.util.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import java.awt.image.BufferedImage;

public class Player extends Entity {
    
    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    public int hearts = 3;

    public int messageTimer;

    public int damageTimer = 0;

    public int hasKey = 0;
    public int hasFakeKey = 0;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - gp.tileSize/2;
        screenY = gp.screenHeight/2 - gp.tileSize/2;

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 24;
        solidArea.height = 24;

        setDefaultValues();
        getPlayerImage();

    }
    public void setDefaultValues(){

        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 23;
        speed = 4;
        direction = "down";
        hearts = 3;
        hasKey = 0;
        hasFakeKey = 0;
    }
    
    public void getPlayerImage(){
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("res/player/up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("res/player/up2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("res/player/down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("res/player/down2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("res/player/left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("res/player/left2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("res/player/right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("res/player/right2.png"));
            
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
  
    }
    public void update(){
        if (keyH.newGame == true){
            setDefaultValues();
        }
        if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed){
            spriteCounter++;
            if (keyH.upPressed == true) {
                direction = "up";
            }
            else if (keyH.downPressed == true) {
                direction = "down";
            }
            else if (keyH.leftPressed == true) {
                direction = "left";
            }
            else if (keyH.rightPressed == true) {
                direction = "right";
            }

            collisionOn = false;
            gp.cChecker.checkTile(this);

            int objIndex = gp.cChecker.checkObject(this, true);

            if (damageTimer > 0 && damageTimer < 120){
                damageTimer++;
            }
            else if (damageTimer == 120){
                damageTimer = 0;
            }
            pickUpObject(objIndex);

            if (collisionOn == false){

                switch (direction){
                    case "up":
                        if (keyH.sprint == true){
                            speed+=1;
                        }
                        if (keyH.slowDown == true){
                            speed/=2;
                        }
                        worldY -= speed;
                        if (keyH.sprint == true){
                            speed-=1;
                        }
                        if (keyH.slowDown == true){
                            speed*=2;
                        }
                        break;
                    case "down":
                        if (keyH.sprint == true){
                            speed+=1;
                        }
                        if (keyH.slowDown == true){
                            speed/=2;
                        }
                        worldY += speed;
                        if (keyH.sprint == true){
                            speed-=1;
                        }
                        if (keyH.slowDown == true){
                            speed*=2;
                        }
                        break;
                    case "left":
                        if (keyH.sprint == true){
                            speed+=1;
                        }
                        if (keyH.slowDown == true){
                            speed/=2;
                        }
                        worldX -= speed;
                        if (keyH.sprint == true){
                            speed-=1;
                        }
                        if (keyH.slowDown == true){
                            speed*=2;
                        }
                        break;
                    case "right":
                        if (keyH.sprint == true){
                            speed+=1;
                        }
                        if (keyH.slowDown == true){
                            speed/=2;
                        }
                        worldX += speed;
                        if (keyH.sprint == true){
                            speed-=1;
                        }   
                        if (keyH.slowDown == true){
                            speed*=2;
                        }
                        break;
                }
            } 
    
            if (spriteCounter > 13) {
                if (spriteNum == 1){
                    spriteNum = 2;
                }
                else if (spriteNum == 2){
                    spriteNum = 1;
                }
                spriteCounter=0;
            }
        }
        else {
            spriteNum = 1;
        }
        

    }
    public void pickUpObject(int index){

        if (index != 999){

            String objectName = gp.obj[index].name;

            switch (objectName){
                case "Key":
                    gp.playSE(1);
                    hasKey ++;
                    gp.obj[index] = null;
                    gp.ui.showMessage("You have picked up a USB Key!");
                    break;
                case "Door":
                    if (keyH.explorationMode == true){
                        gp.obj[index] = null;
                        break;
                    }
                    if (hasKey > 0){
                        if (hasKey == 1 && gp.obj[14] == null && hasFakeKey == 0){
                            hasKey --;
                            hasFakeKey ++;
                            gp.ui.showMessage("This key is a fake key, find another key to open this door!");
                            messageTimer ++;
                        }
                        else{
                            if (messageTimer > 0 && messageTimer < 60){
                                messageTimer = 0;
                            }

                            gp.playSE(3);
                            gp.obj[index] = null;
                            hasKey --;

                            gp.ui.showMessage("You have used a USB key to open this door!");
                        }
                    }
                    else{
                        if (messageTimer > 60){
                            messageTimer = 0;
                        }
                        else if (messageTimer > 0 && messageTimer <= 60){
                            messageTimer ++;
                        }


                        if (messageTimer == 0){
                            gp.ui.showMessage("You need a USB key to open this door!");

                        }


                    }
                    break;
                case "Vault":
                    gp.stopMusic();
                    gp.playSE(4);
                    if (keyH.explorationMode == false){
                        keyH.gameBeaten = true;
                    }
                    
                    break;
                case "Lettuce Lemonade":
                    gp.playSE(2);
                    speed += 2;
                    gp.obj[index] = null;

                    gp.ui.showMessage("You drank Liam's Lettuce Lemonade, your speed has been increased by 50%!");

                    break;
                case "Instructions to Swim":
                    gp.playSE(2);
                    gp.tileM.tile[3].collision = false;
                    gp.tileM.tile[4].collision = false;
                    gp.tileM.tile[5].collision = false;
                  
                    gp.obj[index] = null;

                    gp.ui.showMessage("You picked up Liam's Instructions to Swim, you can now walk on water!");

                    break;
                case "Forbidden Beans":
                    gp.playSE(2);
                    speed += 4;
                    gp.obj[index] = null;

                    gp.ui.showMessage("You ate Abhijay's Can of Beans, your speed has been increased by 100%!");

                    break;
                case "Bee":
                    Random rand = new Random();
                    int speedNum = rand.nextInt(3);
                    if (speedNum == 2){
                        gp.playSE(2);
                        speed += 1;
                        gp.ui.showMessage("The bee gave you honey, your speed has been increased by 25%");
                    }
                    else{
                        gp.playSE(8);
                        speed -= 1;
                        gp.ui.showMessage("The bee stung you, your speed has been decreased by 25%");
                    }
                    gp.obj[index] = null;
                    break;
                case "Liam's Wingams":
                    gp.playSE(2);
                    
                    gp.obj[index] = null;

                    for (Tile tile : gp.tileM.tile){
                        if (tile.collision == true){
                            tile.collision = false;
                        }
                    }

                    gp.ui.showMessage("You picked up Liam's Wingams, your can now walk over anything!");

                    break;
                case "Broken Glass":
                    if (keyH.explorationMode == true){
                        gp.obj[index] = null;
                        break;
                    }
                    if (damageTimer == 0){
                        hearts --;
                        gp.playSE(7);
                        damageTimer ++;
                    }
                    else if(damageTimer > 0 && damageTimer < 120){
                        damageTimer ++;
                    }
                    else if (damageTimer == 120){
                        damageTimer = 0;
                    }
                    if (hearts == 0){
                        gp.stopMusic();
                        gp.playSE(6);
                        keyH.gameLost = true;
                        
                        break;
                    }
            }
        }
    }

    public void draw(Graphics2D g2){

        /*
        g2.setColor(Color.white);

        g2.fillRect(x, y, gp.tileSize, gp.tileSize);*/

        BufferedImage image = null;

        switch(direction) {
            case "up":
                if (spriteNum == 1){
                    image = up1;
                }
                if (spriteNum == 2){
                    image = up2;
                }
                
                break;
            case "down":
                if (spriteNum == 1){
                    image = down1;
                }
                if (spriteNum == 2){
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1){
                    image = left1;
                }
                if (spriteNum == 2){
                    image = left2;
                }
        
                break;
            case "right":
                if (spriteNum == 1){
                    image = right1;
                }
                if (spriteNum == 2){
                    image = right2;
                }
              
                break;
        }
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);

    }

}
