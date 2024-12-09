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

public class OBJ_ForbiddenBeans extends SuperObject {
    public OBJ_ForbiddenBeans() {
        name = "Forbidden Beans";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("objects/beans.png"));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
