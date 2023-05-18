/**
 * @author: virus_rpi
 * @version 2.0
 */
public class TRIANGLE extends POLYGON{
    private int width;
    private int height;
    private type Type;

    /**
     * Das ist der Konstruktor von der Klasse TRIANGLE.
     * Hier werden die Standardwerte eines Dreieckes definiert.
     * Mehr informationen zu den Methoden von TRIANGLE findest du in der Dokumentation von POLYGON
     */
    public TRIANGLE() {
        super();
        super.X = 60;
        super.Y = 50;
        width = 60;
        height = 30;
        super.visible = true;
        super.r = 255;
        super.b = 0;
        super.g = 0;
        Type = type.isosceles;
        super.rotation = 0;
        super.pointsX = new int[]{super.X, super.X + (width / 2), super.X - (width / 2)};
        super.pointsY = new int[]{super.Y, super.Y + height, super.Y + height};
        draw();
    }

    /**
     * Diese Methode verändert die Größe vom Dreieck
     * @param neueBreite
     * @param newHeight
     */
    public void setSize(int neueBreite, int newHeight) {
        width = neueBreite;
        height = newHeight;
        draw();
    }

    /**
     * Diese Methode verändert den Typ des Dreiecks
     * @param new_type Entweder Rechtwinklig oder nicht. (TRIANGLE.type.right oder TRIANGLE.type.isosceles)
     */
    public void setType(type new_type) {
        Type = new_type;
        draw();
    }

    /**
     * Hier wird festgelegt welche, Typen von Dreiecken es gibt
     */
    public enum type {right, isosceles}

    /**
     * Diese Methode malt das Dreieck neu
     */
    @Override
    public void draw() {
        System.out.println(super.X);
        System.out.println(super.Y);
        System.out.println(width);
        System.out.println(height);
        if (Type == type.right){
            super.pointsX = new int[]{super.X, super.X+width, super.X};
            super.pointsY = new int[]{super.Y, super.Y+height, super.Y+height};
        } else if (Type == type.isosceles) {
            super.pointsX = new int[]{super.X, super.X + (width / 2), super.X - (width / 2)};
            super.pointsY = new int[]{super.Y, super.Y + height, super.Y + height};
        }
        if (super.mirrored){
            super.mirrorCalc();
        }
        super.rotateCoordinates();
        super.updatePos();
        FRAME.getObject().draw(super.id, super.X, super.Y, width, height, super.r, super.g, super.b, super.visible, super.pointsX, super.pointsY, "", 0, 3);
    }

}

