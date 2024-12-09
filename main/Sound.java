package SarQuest.src.main;

import java.net.*;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;;

public class Sound {

    public Clip clip;
    URL soundURL[] = new URL[30];

    public Sound(){
        soundURL[0] = getClass().getResource("sound/SarQuest.wav");
        soundURL[1] = getClass().getResource("sound/collectKey.wav");
        soundURL[2] = getClass().getResource("sound/powerupEarned.wav");
        soundURL[3] = getClass().getResource("sound/openDoor.wav");
        soundURL[4] = getClass().getResource("sound/endingFanfare.wav");
        soundURL[5] = getClass().getResource("sound/SarQuestMusic.wav");
        soundURL[6] = getClass().getResource("sound/failure.wav");
        soundURL[7] = getClass().getResource("sound/heartlost.wav");
        soundURL[8] = getClass().getResource("sound/disadvantage.wav");
        soundURL[9] = getClass().getResource("sound/birdcall.wav");
        soundURL[10] = getClass().getResource("sound/beesound.wav");
        soundURL[11] = getClass().getResource("sound/SarQuestTheme2.wav");

    }

    public void setFile(int i) {

        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void play(){
        
        clip.start();

    }

    public void loop(){

        clip.loop(Clip.LOOP_CONTINUOUSLY);

    }

    public void stop(){

        clip.stop();

    }
}
