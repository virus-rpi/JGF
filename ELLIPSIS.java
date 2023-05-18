/**
 * @author virus_rpi
 * @version 2.1
 */
public class ELLIPSIS extends SHAPE
{
    private int width;

    private int height;

    /**
     * Das ist der Konstruktor von der Klasse ELLIPSIS.
     * Hier werden die Standardwerte einer Ellipse festlegen
     */
    public ELLIPSIS()
    {
        super();
        super.X = 60;
        super.Y = 50;
        width = 60;
        height = 30;
        super.visible = true;
        super.r = 255;
        super.b = 0;
        super.g = 0;
        super.id = FRAME.getObject().create(FRAME.type.circle);
        draw();
    }

    /**
     * Diese Methode verändert die Höhe und Breite der Ellipse
     * @param neueBreite Die neue Breite
     * @param newHeight Die neue Höhe
     */
    public void setSize(int neueBreite, int newHeight) {
        width = neueBreite;
        height = newHeight;
        draw();
    }

    /**
     * Diese Methode gibt die Breite der Ellipse zurück
     * @return Die Breite der Ellipse
     */
    public int getWidth() {
        return width;
    }

    /**
     * Diese Methode gibt die Höhe der Ellipse zurück
     * @return Die Höhe der Ellipse
     */
    public int getHeight() {
        return height;
    }

    /**
     * Diese Methode malt die Ellipse neu
     */
    public void draw() {
        FRAME.getObject().draw(id, X, Y, width, height, r, g, b, visible, null, null, "", 0, 0);
    }
}
