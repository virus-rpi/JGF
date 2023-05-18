/**
 * @author virus_rpi
 * @version 1.0
 */

import java.awt.*;
import java.awt.event.KeyEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.List;

public class Keyboard {
    private static final Map<Integer, Boolean> pressedKeys = new HashMap<>();
    private static List<Class<?>> registeredClasses = new ArrayList<>();
    private static Dictionary<Class<?>, String> methodNameDic = new Hashtable<>();
    private static Dictionary<Class<?>, Integer> keyCodeDic = new Hashtable<>();

    static {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(event -> {
            synchronized (Keyboard.class) {
                if (event.getID() == KeyEvent.KEY_PRESSED) {
                    pressedKeys.put(event.getKeyCode(), true);
                    runOnPresses(event.getKeyCode());
                } else if (event.getID() == KeyEvent.KEY_RELEASED) pressedKeys.put(event.getKeyCode(), false);
                return false;
            }
        });
    }
    /**
     * Diese Methode gibt zurück, ob die Taste mit dem eingegebenen Keycode gedrückt ist
     * @param keyCode Keycode der Taste
     * @return Boolean ob Taste gedrückt ist
     */
    public static boolean isKeyPressed(int keyCode) { // Any key code from the KeyEvent class
        return pressedKeys.getOrDefault(keyCode, false);
    }

    /**
     * Diese Methode kann Methoden registrieren, die ausgeführt werden sollen, wenn eine bestimmte Taste gedrückt wird.
     * @param clazz Klasse in der die auszuführende Methode liegt (z.B. ExampleClass.class)
     * @param keyCode Keycode der zudrückenden Taste (Liste mit Keycodes in README.txt)
     * @param methodName Name der auszuführenden Methode (muss public und static sein, darf keine Argumente benötigen)
     */
    public void registerOnPress(Class<?> clazz, int keyCode, String methodName) {
        registeredClasses.add(clazz);
        methodNameDic.put(clazz, methodName);
        keyCodeDic.put(clazz, keyCode);
    }

    /**
     * Diese Methode führt alle registrierten Methoden aus. Diese Methode wird automatisch ausgeführt.
     * @param keyCode Keycode der gedrückten Taste
     */
    private static void runOnPresses(int keyCode){
        for (Class<?> clazz : registeredClasses) {
            try {
                if (keyCode == keyCodeDic.get(clazz)) {
                    clazz.getMethod(methodNameDic.get(clazz)).invoke(null);
                }
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            }
        }
    }
}