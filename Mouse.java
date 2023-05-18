/**
 * @author virus_rpi
 * @version 1.9
 */

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.*;

public class Mouse
{
    private boolean mousePressed;
    private int leftClicked;
    private int middleClicked;
    private int rightClicked;
    private boolean mouseEntered;

    /**
     * Konstruktor der Klasse Mouse
     * Hier wird ein MouseListener zu FRAME hinzugefügt.
     */
    public Mouse()
    {
        FRAME.getObject().getFrame().addMouseListener(new MouseListener()
        {
                public void mousePressed(MouseEvent me) {
                    mousePressed = true;
                }
                public void mouseReleased(MouseEvent me) {
                    mousePressed = false;
                }
                public void mouseEntered(MouseEvent me) {mouseEntered = true;}
                public void mouseExited(MouseEvent me) {mouseEntered = false;}
                public void mouseClicked(MouseEvent me) {
                    if(me.getButton() == MouseEvent.BUTTON1) {
                        leftClicked++;
                      }
                    if(me.getButton() == MouseEvent.BUTTON2) {
                        middleClicked++;
                      }
                    if(me.getButton() == MouseEvent.BUTTON3) {
                        rightClicked++;
                    }
                }
            }
        );
    }

    /**
     * Diese Methode gibt die X Position der Maus zurück
     * @return Die X Position der Maus
     */
    public int getMouseX(){
        PointerInfo info = MouseInfo.getPointerInfo();
        Point location = info.getLocation();
        int frameX = FRAME.getObject().getX();
        int screenX = FRAME.getObject().getScreenWidth();
        if (location.x-frameX != 0){
            return (location.x-frameX)/(screenX/1280);
        } else {
            return (location.x-frameX);
        }
    }

    /**
     * Diese Methode gibt die Y Position der Mau zurück
     * @return Die Y Position der Maus
     */
    public int getMouseY(){
        PointerInfo info = MouseInfo.getPointerInfo();
        Point location = info.getLocation();
        int frameY = FRAME.getObject().getY();
        int screenY = FRAME.getObject().getScreenHeight();
        if (location.y-frameY != 0){
            return (location.y-frameY)/(screenY/720);
        } else {
            return (location.y-frameY);
        }
    }

    /**
     * Diese Methode gibt zurück, ob eine Maustaste gedrückt wird
     * @return Gibt true zurück, wenn Maustaste gedrückt ist
     */
    public boolean isMousePressed() {
        return mousePressed;
    }

    /**
     * Diese Methode gibt zurück wie oft die linke Maustaste gedrückt wurde
     * @return Anzahl wie oft die linke Maustaste gedrückt wurde
     */
    public int getLeftClicked() {
        return leftClicked;
    }

    /**
     * Diese Methode gibt zurück wie oft die mittlere Maustaste gedrückt wurde
     * @return Anzahl wie oft die mittlere Maustaste gedrückt wurde
     */
    public int getMiddleClicked() {
        return middleClicked;
    }

    /**
     * Diese Methode gibt zurück wie oft die rechte Maustaste gedrückt wurde
     * @return Anzahl wie oft die rechte Maustaste gedrückt wurde
     */
    public int getRightClicked() {
        return rightClicked;
    }

    /**
     * Diese Methode gibt zurück, ob die Maus im Fenster ist
     * @return Ein boolean, ob Maus im Fenster ist
     */
    public boolean isMouseEntered() {
        return mouseEntered;
    }

    /**
     * Diese Methode gibt zurück, ob die Maus in einem bestimmten Bereich ist
     * @param x1 X Position 1
     * @param y1 Y Position 1
     * @param x2 X Position 2
     * @param y2 Y Position 2
     * @return Boolean, ob Maus in einem bestimmten Bereich ist
     */
    public boolean isMouseInArea(int x1, int y1, int x2, int y2) {
        return getMouseX()>x1&&getMouseX()<x2&&getMouseY()>y1&&getMouseY()<y2;
    }

    /**
     * Dise Methode gibt zurück, ob die Maus über einem bestimmten Objekt ist und eine Maustaste gedrückt wird
     * @param id ID des Objektes, die man bekommt, wenn man getId() eines Objektes verwendet
     * @return Boolean ob Maus über Objekt ist und eine Maustaste gedrückt wird
     */
    public boolean clickedObject(int id) {
        int x1;
        int y1;
        int x2;
        int y2;
        if (id >= 1 && id <= FRAME.getObject().getSymbols().size()) {
            x1 = FRAME.getObject().getSymbols().get(id - 1).getX();
            y1 = FRAME.getObject().getSymbols().get(id - 1).getY();
            x2 = FRAME.getObject().getSymbols().get(id - 1).getX()+FRAME.getObject().getSymbols().get(id - 1).getW();
            y2 = FRAME.getObject().getSymbols().get(id - 1).getY()+FRAME.getObject().getSymbols().get(id - 1).getH();
            
            return isMouseInArea(x1, y1, x2, y2) && isMousePressed();
        } else {
            return false;
        }
    }
}
