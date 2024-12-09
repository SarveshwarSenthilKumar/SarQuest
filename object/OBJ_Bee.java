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

public class OBJ_Bee extends SuperObject {
    public OBJ_Bee() {
        name = "Bee";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("objects/bee.png"));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
