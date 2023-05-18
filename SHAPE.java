
/**
 * Beschreiben Sie hier die Klasse SHAPE.
 * 
 * @author virus_rpi
 * @version 1.0
 */
public class SHAPE
{
    public int r;
    public int g;
    public int b;
    public int id;
    public int X;
    public int Y;
    public boolean visible;
    /**
     * Konstruktor für Objekte der Klasse SHAPE
     */
    public SHAPE()
    {
        r = 255;
        g = 0;
        b = 0;
        id = 0;
        X = 0;
        Y = 0;
    }
    /**
     * Diese Methode verändert die Farbe des Objekts mit RGB input
     * @param r_in Der Rot anteil der Farbe (von 0 bis 255)
     * @param g_in Der Grün anteil der Farbe (von 0 bis 255)
     * @param b_in Der Blau anteil der Farbe (von 0 bis 255)
     */
    public void setColor(int r_in, int g_in, int b_in) {
        r = r_in;
        b = b_in;
        g = g_in;
        draw();
    }

    /**
     * Diese Methode verändert die durchsichtigkeit eines Objekts (Alpha channel)
     * @param alpha Alpha channel von 0-255
     */
    public void setAlpha(int alpha) {
        FRAME.getObject().setAlpha(id, alpha);
        draw();
    }

    /**
     * Diese Methode verschiebt das Vieleck zu den Koordinaten NeuesX und NeuesY
     * @param NeuesX Die Neue X Position des Objekts
     * @param NeuesY Die Neue Y Position des Objekts
     */
    public void setPos(int NeuesX, int NeuesY) {
        X = NeuesX;
        Y = NeuesY;
        draw();
    }

    /**
     * Diese Methode gibt die aktuelle X Position zurück
     * @return X Position des Objekts
     */
    public int getX() {
        return X;
    }

    /**
     * Diese Methode gibt die aktuelle Y Position zurück
     * @return Y Position des Objekts
     */
    public int getY() {
        return Y;
    }

    /**
     * Diese Methode gibt zurück ob das Objekt sichtbar ist.
     * @return Gibt true zurück wenn Objekts sichtbar, sonst false
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * Diese Methode kann das Objekt sichtbar bzw. unsichtbar machen.
     * @param neueSichtbarkeit Sichtbarkeit des Objekts (true, wenn es sichtbar werden soll, sonst false)
     */
    public void setVisible(boolean neueSichtbarkeit) {
        visible = neueSichtbarkeit;
        draw();
    }

    /**
     * Diese Methode schaltet zwischen sichtbar und unsichtbar hin und her je nachdem, ob es gerade sichtbar oder unsichtbar ist
     */
    public void toggleVisibility(){
        visible = !visible;
        draw();
    }

    /**
     * Diese Methode gibt die ID des Objekts zurück
     * @return Die ID des Objekts
     */
    public int getId() {
        return id;
    }

    /**
     * Platzhalter für draw() Methode
     */
    public void draw(){}

    public void moveLayerUp(){
        FRAME.getObject().moveLayerUp(id);
    }
    public void moveLayerDown(){
        FRAME.getObject().moveLayerDown(id);
    }
}
