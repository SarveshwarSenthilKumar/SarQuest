package SarQuest.src.main;

import java.util.*;

public class functions {
    public static void clr(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public static int[] range(int[] parameters){
        int beginning = parameters[0];
        int stop = parameters[1];
        int step = parameters[2];

        int[] range = {};

        for (int i = beginning; i < stop; i=i+step){
            range = Arrays.copyOf(range, range.length + 1);
            range[range.length - 1] = i;
        }

        return range;
    }

}