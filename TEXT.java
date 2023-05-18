/**
 * @author virus_rpi
 * @version 2.0
 */
public class TEXT extends SHAPE
{
    private String txt;
    private int fs;


    /**
     * Erzeugt einen neuen Text mit einer Standardposition und einer
     * Standardfüllfarbe. Das zugehörige Symbol wird sofort angezeigt.
     */
    public TEXT() {
        super();
        super.X = 60;
        super.Y = 50;
        super.r = 0;
        super.g = 0;
        super.b = 0;
        fs = 20;
        txt="Text";
        visible = true;
        super.id = FRAME.getObject().create(FRAME.type.text);
        draw();
    }

    /**
     * Diese Methode setzt die Schriftgröße des Textes
     * @param font_size Schriftgröße
     */
    public void setSize(int font_size) {
        fs = font_size;
        draw();
    }

    /**
     * Diese Methode ändert den Text des Textobjekts
     * @param txt_in String der angezeigt werden soll
     */
    public void setText(String txt_in) {
        txt = txt_in;
        draw();
    }

    /**
     * Diese Methode malt das Objekt neu
     */
    @Override
    public void draw() {
        FRAME.getObject().draw(super.id, super.X, super.Y, 0, 0, super.r, super.g, super.b, super.visible, new int[]{}, new int[]{}, txt, fs, 0);
    }

}
