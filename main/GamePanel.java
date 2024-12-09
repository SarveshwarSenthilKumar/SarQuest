package SarQuest.src.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import SarQuest.src.entity.Player;
import SarQuest.src.file.TileManager;
import SarQuest.src.object.SuperObject;

public class GamePanel extends JPanel implements Runnable {
    
    // Screen Settings
    final int originalTileSize = 16; //16x16 pixels
    final int scale = 3;

    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    public final int maxWorldCol = 50;
    public final int maxWorldRow = 60;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    public int birdCounter = 0;
    public int beeCounter = 5;

    int FPS = 60;

    public TileManager tileM = new TileManager(this);
    public KeyHandler keyH = new KeyHandler();
    Sound music = new Sound();
    Sound se = new Sound();
    
    public CollisionChecker cChecker = new CollisionChecker(this);
    public Player player = new Player(this, keyH);
    public SuperObject obj[] = new SuperObject[24];
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    Thread gameThread;

    public int gameState;
    public final int playState = 1;
    public final int pauseState = 2;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
        playMusic(keyH.musicInt);
        gameState = playState;
        
    }
    public void run() {

        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null){

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;

            timer += (currentTime - lastTime);

            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if (timer >= 1000000000){
                /*
                sarvesh.src.main.functions.clr();
                System.out.println("FPS: " + drawCount);*/
                drawCount = 0;
                timer = 0;
                
                if (keyH.BBSEallow == true){
                    birdCounter ++;
                    beeCounter ++;
                }

                if (birdCounter == 10){
                    birdCounter = 0;
                    playSE(9);
                }
                if (beeCounter == 10){
                    beeCounter = 0;
                    playSE(10);
                }
            }

            if (keyH.initiated == true){
                if (keyH.musicMuted == true){
                    stopMusic();
                    keyH.initiated = false;
                }
                else if (keyH.musicMuted == false){
                    playMusic(keyH.musicInt);
                    keyH.initiated = false;
                }
            }
            if (keyH.temp == true){
                playMusic(keyH.musicInt);
                keyH.temp = false;
            }
            if (keyH.changeTrack == true){
                stopMusic();
                playMusic(keyH.musicInt);
                keyH.changeTrack = false;
            }
            if (keyH.newGame == true){
                player = new Player(this, keyH);
                obj = new SuperObject[24];
                aSetter = new AssetSetter(this);
                ui.playTime = 0;
                keyH.gameBeaten = false;
                keyH.gameLost = false;
                keyH.newGame = false;
            }
        }
    }

    public void update(){

        player.update();


    }
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        if (keyH.start == false){
            tileM.draw(g2);

            for (int i = 0; i < obj.length; i++){
                if (obj[i] != null){
                    obj[i].draw(g2, this);
                }
            }

            player.draw(g2);

            ui.draw(g2);

        }
        else{
            tileM.draw(g2);
            ui.draw(g2);

        }

        g2.dispose();
    }

    public void playMusic(int i){

        music.setFile(i);
        music.play();
        music.loop();
    }
    public void stopMusic() {
        
        music.stop();
    }
    public void playSE(int i){

        se.setFile(i);
        se.play();
    }

}
