/**
 * @author: virus_rpi 
 * @version: 1.0
 */
public class CUSTOMPOLYGON extends POLYGON {
    /**
     * Das ist der Konstruktor von der Klasse CUSTOM-POLYGON.
     * Hier werden die Standardwerte eines Polygons definiert.
     * Mehr informationen zu den Methoden von CUSTOM-POLYGON findest du in der Dokumentation von POLYGON
     */
    public CUSTOMPOLYGON(int[] pointsX, int[] pointsY) {
        super();
        super.X = 60;
        super.Y = 50;
        super.visible = true;
        super.r = 255;
        super.b = 0;
        super.g = 0;
        super.pointsX = pointsX;
        super.pointsY = pointsY;
        super.rotation = 0;
        super.updatePos();
        draw();
    }

    /**
     * Diese Methode ändert die X Positionen der Punkte
     * @param pX Liste an X Positionen
     */
    public void setPositionsX(int[] pX){
        super.pointsX = pX;
    }

    /**
     * Diese Methode ändert die Y Positionen der Punkte
     * @param pY Liste an Y Positionen
     */
    public void setPositionsY(int[] pY){
        super.pointsY = pY;
    }
}
