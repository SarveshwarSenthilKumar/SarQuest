package SarQuest.src.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import SarQuest.src.main.Sound;
import SarQuest.src.entity.Player;
import SarQuest.src.main.GamePanel;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed;
    public boolean musicMuted = false;
    public boolean initiated;
    public boolean changeTrack;
    public int musicInt = 0;
    public boolean close;
    public boolean newGame = false;
    public boolean gamePaused = false;
    public boolean gameBeaten = false;
    public boolean gameLost = false;
    public boolean explorationMode = false;
    public boolean temp = false;

    public boolean start = true;

    public boolean BBSEallow = true;

    public boolean sprint = false;
    public boolean slowDown = false;

    GamePanel gp;

    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
    
        int code = e.getKeyCode();

        if (gamePaused == false && gameLost == false && gameBeaten == false){
            if (code == KeyEvent.VK_CONTROL){
                sprint = true;
            }
            if (code == KeyEvent.VK_SHIFT){
                slowDown = true;
            }
            if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
                upPressed = true;
            }
            if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
                downPressed = true;
            }
            if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT){
                leftPressed = true;
            }
            if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT){
                rightPressed = true;
            }
            if (code == KeyEvent.VK_M){
                if (musicMuted == false){
                    musicMuted = true;
                    initiated = true;
                }
                else{
                    musicMuted = false;
                    initiated = true;
                }
                    
            }
            if (code == KeyEvent.VK_1){
                musicMuted = false;
                if (musicInt == 0){
                    musicInt = 5;
                    changeTrack = true;
                }
                else if (musicInt == 5){
                    musicInt = 11;
                    changeTrack = true;
                }
                else{
                    musicInt = 0;
                    changeTrack = true;
                }
            }
        }
    
        if (code == KeyEvent.VK_R){

            if (start == true){
                start = false;
            }

            explorationMode = false;

            newGame = true;

        }
        if (code == KeyEvent.VK_P){
            if (gamePaused == false){
                gamePaused = true;
                upPressed = false;
                downPressed = false;
                leftPressed = false;
                rightPressed = false;
                musicMuted = true;
                initiated = true;
            }
            else{
                musicMuted = false;
                initiated = true;
                gamePaused = false;
            }
        }
        if (code == KeyEvent.VK_B){
            if (BBSEallow == true){
                BBSEallow = false;
            }
            else{
                BBSEallow = true;
            }

        }

        if (code == KeyEvent.VK_E){
            explorationMode = true;
        }

        
    }
    @Override
    public void keyReleased(KeyEvent e) {
        
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_SHIFT){
            slowDown = false;
        }

        if (code == KeyEvent.VK_CONTROL){
            sprint = false;
        }

        if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
            upPressed = false;
        }
        if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
            downPressed = false;
        }
        if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT){
            leftPressed = false;
        }
        if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT){
            rightPressed = false;
        }
        
    }
}
