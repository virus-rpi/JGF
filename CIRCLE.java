/**
 * @author virus_rpi
 * @version 2.0
 */
public class CIRCLE extends ELLIPSIS
{
    private int radius;

    /**
     * Konstruktor der Klasse CIRCLE.
     * Hier werden die Standardwerte eines Kreises definiert.
     */
    public CIRCLE() {
        super();
        super.X = 60;
        super.Y = 50;
        radius = 20;
        super.visible = true;
        super.r = 255;
        super.b = 0;
        super.g = 0;
        super.id = FRAME.getObject().create(FRAME.type.circle);
        draw();
    }

    /**
     * Diese Methode setzt den Radius des Kreises auf radius.
     * @param radius Der neue Radius
     */
    public void setSize(int radius) {
        this.radius = radius;
        draw();
    }

    /**
     * Diese Methode git den Radius des Kreises zurück
     * @return Der Radius des Kreises
     */
    public int getSize() {
        return radius;
    }

    /**
     * Malt Kreis neu
     */
    @Override
    public void draw() {
        FRAME.getObject().draw(id, X-radius, Y-radius, 2*radius, 2*radius, r, g, b, visible, new int[]{},new int[]{}, "", 0, 0);
    }

}

