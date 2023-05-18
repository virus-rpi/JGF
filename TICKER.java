/**
 * @author DraqzzIQ, virus_rpi
 * @version 2.0
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TICKER {
  private static List<TICKEVENT> listeners;
  private static Timer timer = new Timer();

  private static TimerTask task;

  /**
   * Das ist der Konstruktor von der Klasse TICKER. Hier wird der delay zwischen den ticks festgelegt.
   * @param delay Abstand zwischen den Ticks in Millisekunden
   */
  public TICKER(int delay){
    if(listeners != null){
      return;
    }
    listeners  = new ArrayList<>();

    initTimer(delay);
  }
  /**
   * Fügt eine Klasse zum Event Listener hinzu. Die Klasse muss TICKEVENT implementieren
   * @param tickevent hier Variablen in der eine Instanz der Klasse gespeichert ist angeben.
   */
  public static void addTickListener(TICKEVENT tickevent){
    listeners.add(tickevent);
  }

  /**
   * Diese Methode führt alle Tick funktionen aus
   */
  private static void tick(){
    for (TICKEVENT listener: listeners) {
      listener.tick();
    }
  }

  /**
   * Diese Methode führt tick() alle delay Millisekunden aus
   * @param delay Millisekunden
   */
  private void initTimer(int delay){
    task = new TimerTask() {
      @Override
      public void run() {
          tick();
      }
    };
    timer.scheduleAtFixedRate(task, 0, delay);
  }
}