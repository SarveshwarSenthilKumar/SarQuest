package SarQuest.src.object;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import javax.swing.JPanel;
import java.util.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

import java.awt.image.BufferedImage;


public class OBJ_ITS extends SuperObject {
    public OBJ_ITS() {
        name = "Instructions to Swim";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("objects/paper.png"));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
