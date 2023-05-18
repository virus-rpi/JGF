import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * @author virus_rpi
 * @version 2.0
 */
public abstract class POLYGON extends SHAPE{
    public int[] pointsX;
    public int[] pointsY;

    public double rotation;
    public boolean mirrored;

    /**
     * Das ist der Konstruktor der Klasse POLYGON.
     * Hier werden die Standardwerte für ein Vieleck festgelegt.
     */
    public POLYGON() {
        super();
        mirrored = false;
        super.visible = true;
        super.r = 255;
        super.b = 0;
        super.g = 0;
        super.X = 0;
        super.Y = 0;
        super.id = FRAME.getObject().create(FRAME.type.nEck);
        this.pointsX = new int[]{};
        this.pointsY = new int[]{};
        updatePos();
        rotation = 0;
    }

    /**
     * Diese Methode wird benutzt um zu berechnen welche Koordinaten ein Punkt hat, wenn das Objekt gedreht wird
     */
    public void rotateCoordinates() {
        int centerX = 0;
        int centerY = 0;
        for (int i = 0; i < pointsX.length; i++) {
            centerX += pointsX[i];
            centerY += pointsY[i];
        }
        centerX /= pointsX.length;
        centerY /= pointsY.length;

        for (int i = 0; i < pointsX.length; i++) {
            double angle = Math.toRadians(rotation);
            double cos = Math.cos(angle);
            double sin = Math.sin(angle);

            int x = pointsX[i] - centerX;
            int y = pointsY[i] - centerY;

            int rotatedX = (int) (x * cos - y * sin);
            int rotatedY = (int) (x * sin + y * cos);

            pointsX[i] = rotatedX + centerX;
            pointsY[i] = rotatedY + centerY;
        }
    }

    /**
     * Diese Methode rotiert das Objekt um angle Grad im Uhrzeigersinn.
     * @param angle Winkel um wie viel das Objekt gedreht werden soll
     */
    public void rotate(double angle){
        rotation = rotation + angle;
        draw();
    }

    /**
     * Diese Methode setzt die Rotation des Objektes auf 0°
     */
    public void resetRotation(){
        rotation = 0;
        draw();
    }

    /**
     * Diese Methode setzt die Rotation des Objekts auf einen bestimmten Winkel
     * @param angle Der neue Winkel des Objekts
     */
    public void setRotation(double angle){
        rotation = angle;
        draw();
    }

    /**
     * Diese Methode wird benutzt um zu berechnen wo die Punkte des Objekts liegen müssen wenn es gespiegelt wird
     */
    public void mirrorCalc(){
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        for (int x : pointsX) {
            minX = Math.min(minX, x);
            maxX = Math.max(maxX, x);
        }
        int centerX = (minX + maxX) / 2;
        for (int i = 0; i < pointsX.length; i++) {
            pointsX[i] = 2 * centerX - pointsX[i];
        }
    }

    /**
     * Diese Methode spiegelt das Objekt an der Y Achse des ungedrehten Objekts
     */
    public void mirror(){
        mirrored = !mirrored;
        draw();
    }

    /**
     * Mit dieser Methode kann man die Liste der X Koordinaten der Punkte des Objekts neu festlegen.
     * @param pointsX Liste an X Koordinaten (Zum Beispiel: new int[]{10, 20, 30})
     */
    public void newXPoints(int[] pointsX){
        this.pointsX = pointsX;
    }
    /**
     * Mit dieser Methode kann man die Liste der Y Koordinaten der Punkte des Objekts neu festlegen.
     * @param pointsY Liste an Y Koordinaten (Zum Beispiel: new int[]{30, 20, 50})
     */
    public void newYPoints(int[] pointsY){
        this.pointsY = pointsY;
    }

    /**
     * Diese Methode verändert die Koordinaten der Punkte auf die der X und Y Koordinate des Objekts
     */
    public void updatePos(){
        for (int i = 0; i < pointsX.length; i++){
            pointsX[i] += X;
        }
        for (int i = 0; i < pointsY.length; i++){
            pointsY[i] += Y;
        }
    }


    /**
     * Diese Methode malt das Objekt neu
     */
    @Override
    public void draw() {
        updatePos();
        if (mirrored){
            mirrorCalc();
        }
        rotateCoordinates();
        int width = Collections.max(Arrays.stream(pointsX).boxed().collect(Collectors.toList())) - Collections.min(Arrays.stream(pointsX).boxed().collect(Collectors.toList()));
        int height = Collections.max(Arrays.stream(pointsY).boxed().collect(Collectors.toList())) - Collections.min(Arrays.stream(pointsY).boxed().collect(Collectors.toList()));
        FRAME.getObject().draw(id, X, Y, width, height, r, g, b, visible, pointsX, pointsY, "", 0, pointsX.length);
    }
}

