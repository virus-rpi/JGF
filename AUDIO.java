import javax.sound.sampled.*;
import java.io.IOException;
import java.util.Objects;

/**
 * Diese Klasse kann Audio abspielen
 * 
 * @author virus_rpi
 * @version 1.0
 */
public class AUDIO
{
    /**
     * Konstruktor für Objekte der Klasse Audio
     */
    public AUDIO()
    {
    }
    
    /**
     * Diese Klasse Audio im wav format abspeilen, der am Pfad liegt, den man eingibt.
     * 
     * @param path    Pfad der .wav Datei
     */
    public void play(String path){
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(Objects.requireNonNull(AUDIO.class.getResource(path)));
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
