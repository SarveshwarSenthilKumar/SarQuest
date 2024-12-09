package SarQuest.src.main;

import javax.swing.JFrame;
import java.util.*;
import SarQuest.src.*;
import javax.swing.ImageIcon;

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

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("SarQuest");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGameThread();

    }
}
