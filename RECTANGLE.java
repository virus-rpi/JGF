/**
 * @author: virus_rpi 
 * @version: 2.0
 */
public class RECTANGLE extends POLYGON {
    private int width;
    private int height;

    /**
     * Das ist der Konstruktor von der Klasse RECTANGLE.
     * Hier werden die Standardwerte eines Rechteckes definiert.
     * Mehr informationen zu den Methoden von RECTANGLE findest du in der Dokumentation von POLYGON
     */

    public RECTANGLE() {
        super();
        super.X = 60;
        super.Y = 50;
        width = 60;
        height = 30;
        super.visible = true;
        super.r = 255;
        super.b = 0;
        super.g = 0;
        super.pointsX = new int[]{super.X, super.X+width, super.X+width, super.X};
        super.pointsY = new int[]{super.Y, super.Y, super.Y+height, super.Y+height};
        super.rotation = 0;
        draw();
    }

    /**
     * Diese Methode verändert die Größe vom Rechteck
     * @param neueBreite
     * @param newHeight
     */
    public void setSize(int neueBreite, int newHeight) {
        width = neueBreite;
        height = newHeight;
        draw();
    }

    /**
     * Diese Methode malt das Rechteck im Fenster.
     */
    @Override
    public void draw() {
        super.pointsX = new int[]{super.X, super.X+width, super.X+width, super.X};
        super.pointsY = new int[]{super.Y, super.Y, super.Y+height, super.Y+height};
        if (super.mirrored){
            super.mirrorCalc();
        }
        super.rotateCoordinates();
        super.updatePos();
        FRAME.getObject().draw(super.id, super.X, super.Y, width, height, super.r, super.g, super.b, super.visible, super.pointsX, super.pointsY, "", 0, 4);
    }

}
