/**
 * @author virus_rpi
 * @version 3.0
 */

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.util.*;
import java.util.List;


public class FRAME {

    private static FRAME zeichenfläche;

    private JFrame fenster;
    private MalPanel malPanel;
    private BufferedImage  hintergrundbild;
    private Graphics2D gDC;
    private java.util.List<Grafiksymbol> alleSymbole;
    private java.util.List<Integer> series;
    private GraphicsConfiguration gfxConf;
    Dimension screenSize;

    /**
     * Dies ist der Konstruktor von der Klasse FRAME.
     * Hier wird das Fenster erstellt und Standardwerte festgelegt
     */
    public FRAME()
    {
        fenster = new JFrame("Game");
        fenster.setLocation(50,50);
        fenster.setResizable(false);
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel contentPane = (JPanel) fenster.getContentPane();

        malPanel = new MalPanel();
        malPanel.setPreferredSize(new Dimension(800,600));
        contentPane.add(malPanel);
        fenster.pack();

        gfxConf = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        hintergrundbild = gfxConf.createCompatibleImage(malPanel.getWidth(), malPanel.getHeight());
        gDC = hintergrundbild.createGraphics();
        delete();

        alleSymbole = new ArrayList<Grafiksymbol>();
        series = new ArrayList<Integer>();

        fenster.setVisible(true);
        fenster.toFront();

        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    }

    /**
     * Diese Methode gibt die Bildschirmbreite zurück
     * @return Die Breite des Bildschirms
     */
    public int getScreenWidth(){
        return screenSize.width;
    }

    /**
     * Diese Methode gibt die Bildschirmhöhe zurück
     * @return Die Höhe des Bildschirms
     */
    public int getScreenHeight(){
        return screenSize.height;
    }
    /**
     * Gib Liste an Objekten zurück
     * @return Liste an Objekten
     */
    public List<Grafiksymbol> getSymbols() {
        return alleSymbole;
    }
    /**
     * Diese Methode gibt die Breite des Fensters zurück
     * @return Die Breite des Fensters
     */
    public int getWidth() {
        return fenster.getWidth();
    }

    /**
     * Diese Methode gibt die Höhe des Fensters zurück
     * @return Die Höhe des Fensters
     */
    public int getHeight() {
        return fenster.getHeight();
    }

    /**
     * Diese Methode gibt die X Position des Fensters auf dem Bildschirm zurück
     * @return Die X Position des Fensters
     */
    public int getX(){
        return fenster.getX();
    }

    /**
     * Diese Methode gibt die Y Position des Fensters auf dem Bildschirm zurück
     * @return Die Y Position des Fensters
     */
    public int getY(){
        return fenster.getY();
    }

    /**
     * Diese Methode gibt das Objekt Fenster zurück
     * @return Das fenster Objekt
     */
    public JFrame getFrame() {
        return fenster;
    }

    /**
     * Diese Methode kann festgelegt, ob man die Größe des Fensters verändern kann
     * @param resizable true um es zu erlauben false um es zu verbieten
     */
    public void setResizable(boolean resizable){
        fenster.setResizable(resizable);
    }

    /**
     * Diese Methode kann die Hintergrundfarbe des Fensters verändern
     * @param r Rot anteil der Farbe (von 0 bis 255)
     * @param g Grüm anteil der Farbe (von 0 bis 255)
     * @param b Blau anteil der Farbe (von 0 bis 255)
     */
    public void setBackgroudColor(int r, int g, int b){
        gDC.setBackground(new Color(r, g, b));
    }

    /**
     * Diese Methode gibt ein Objekt FRAME zurück
     * @return Jedes mal das gleiche FRAME Objekt
     */
    public static FRAME getObject()
    {
        if (zeichenfläche == null)
            zeichenfläche = new FRAME();

        return zeichenfläche;
    }

    /**
     * Diese Methode registriert ein Objekt in FRAME.
     * Zum Beispiel: FRAME.getObject().create(FRAME.type.nEck);
     * @param in_type Typ der Form (nEck, circle, text, picture)
     * @return Die id des Objekts, die man benutzt, um Variablen des Objekts zu verändern oder das Objekt zu malen
     */
    public int create(type in_type)
    {
        alleSymbole.add(new Grafiksymbol(in_type));
        series.add(alleSymbole.size());
        return alleSymbole.size();
    }

    /**
     * Malt ein Objekt auf dem Fenster
     * @param id Id des Objekts, dass man bekommt wenn man das Objekt mit create() registriert
     * @param X X Position des Fensters
     * @param Y X Position des Fensters
     * @param width Wenn Objekt breite hat hier angeben, sonnst 0 angeben
     * @param height Wenn Objekt höhe hat hier angeben, sonnst 0 angeben
     * @param r Rot anteil der Farbe (von 0 bis 255) des Objekts
     * @param g Grüm anteil der Farbe (von 0 bis 255) des Objekts
     * @param b Blau anteil der Farbe (von 0 bis 255) des Objekts
     * @param visible Dieser Parameter bestimmt, ob das Objekt angezeigt werden soll (boolean)
     * @param pointsX Liste an X Positionen, wenn man Polygons zeichnet, sonnst null
     * @param pointsY Liste an Y Positionen, wenn man Polygons zeichnet, sonnst null
     * @param text Wenn man Text Objekt zeichnet hier Text angeben, sonnst ""
     * @param font_size Schriftgröße der Text Objekt, wenn man Text zeichnet, sonnst 0
     * @param points Anzahl der Punkte des Polygons, wenn man ein Polygon malen lässt sonst 0
     */
    public void draw(int id, int X, int Y, int width, int height, int r, int g, int b, boolean visible, int[] pointsX, int[] pointsY, String text, int font_size, int points)
    {
        if (id>=1 && id<=alleSymbole.size())
        {
            Grafiksymbol symbol = alleSymbole.get(id-1);
            symbol.x = Math.max(X,0);
            symbol.y = Math.max(Y,0);
            symbol.w = Math.max(width,0);
            symbol.h = Math.max(height,0);
            symbol.r = r;
            symbol.g = g;
            symbol.b = b;
            symbol.pointsX = pointsX;
            symbol.pointsY = pointsY;
            symbol.sichtbar = visible;
            symbol.text = text;
            symbol.fs = font_size;
            symbol.points = points;
            delete();
            DrawAll();
        }
    }

    /**
     * Diese Methode ändert das Bild, das von einem Bild Objekt angezeigt wird
     * @param id Id des Bild Objekts
     * @param pic BufferedImage das angezeigt werden soll
     */
    public void setPic(int id, BufferedImage pic){
        if (id>=1 && id<=alleSymbole.size()){
            Grafiksymbol symbol = alleSymbole.get(id-1);
            symbol.pic = pic;
        }
    }

    /**
     * Ändert den Alpha channel des Objekts, dessen id man angibt
     * @param id Id des Objekts
     * @param a Alpha channel wert
     */
    public void setAlpha(int id, int a){
        if (id>=1 && id<=alleSymbole.size()){
            Grafiksymbol symbol = alleSymbole.get(id-1);
            symbol.a = a;
        }
    }

    /**
     * Diese Methode verschiebt das Objekt eine Layer nach oben
     * @param id id des Objekts
     */
    public void moveLayerUp(int id){
        try {
            Collections.swap(series, series.indexOf(id), series.indexOf(id)+1);
        }
        catch(java.lang.IndexOutOfBoundsException e){}
        DrawAll();
    }

    /**
     * Diese Methode verschiebt das Objekt eine Layer nach unten
     * @param id Id des Objekts
     */
    public void moveLayerDown(int id){
        try {
            Collections.swap(series, series.indexOf(id), series.indexOf(id)-1);
        }
        catch(java.lang.IndexOutOfBoundsException e){}
        DrawAll();
    }
    
    //Credit: DraqzzlQ
    /**
     * Diese Methode rendert die Objekte auf dem Bildschirm
     * @author DraqzzlQ
     */
    private void DrawAll() {
        BufferedImage _hintergrundbild = gfxConf.createCompatibleImage(malPanel.getWidth(), malPanel.getHeight());
        gDC = _hintergrundbild.createGraphics();
        for (int id: series){
            Grafiksymbol symbol = alleSymbole.get(id-1);
            if (symbol.sichtbar) symbol.draw();
        }

        hintergrundbild = _hintergrundbild;

        malPanel.repaint();
    }

    /**
     * Löscht alles gezeichneten vom Bildschirm
     */
    private void delete()
    {
        Color aktuell = gDC.getColor();
        setColor(255, 255, 255, 255);
        gDC.fillRect(0,0,hintergrundbild.getWidth(), hintergrundbild.getHeight());
        gDC.setColor(aktuell);
    }

    /**
     * Setzt die Zeichenfarbe von gDC
     * @param r Rot anteil der Farbe (von 0 bis 255)
     * @param g Grüm anteil der Farbe (von 0 bis 255)
     * @param b Blau anteil der Farbe (von 0 bis 255)
     * @param a Alpha Channel der Farbe (von 0 bis 255)
     */
    public void setColor(int r, int g, int b, int a){
        gDC.setColor(new Color(r,g,b,a));
    }

    private class MalPanel extends JPanel
    {
        public void paint(Graphics g)
        {
            g.drawImage(hintergrundbild, 0, 0, null);
        }
    }

    /**
     * Hier werden die verschiedenen Arten von Formen definiert
     */
    public enum type {nEck, circle, text, picture}

    /**
     * Diese Methode gibt gDC zurück
     * @return gDC
     */
    public Graphics2D getgDC() {
        return gDC;
    }

    /**
     * Diese Klasse ist die definition eines Grafiksymbols
     */
    public class Grafiksymbol {
        public int r;
        public int g;
        public int b;
        public int a;
        public int[] pointsX;
        public int[] pointsY;
        public int fs;
        public int points;
        int x, y, w, h;
        boolean sichtbar;
        String text;
        type Type;
        BufferedImage pic;

        /**
         * Konstruktor der Klasse Grafiksymbol
         * @param in_type Typ des Objekts
         */
        Grafiksymbol(type in_type)
        {
            x=0; y=0; w=0; h=0;
            sichtbar = false;
            this.Type = in_type;
            text = "";
            r = 0;
            g = 0;
            b = 0;
            a = 255;
            pointsX = new int[]{0, 0, 0};
            pointsY = new int[]{0, 0, 0};
            fs = 0;
            points = 3;
            pic = null;
        }

        /**
         * Diese Methode malt das Grafiksymbol
         */
        public void draw() {
            setColor(r, g, b, a);
            if (Type == type.nEck) {
                gDC.fillPolygon(pointsX, pointsY, points);
            } else if (Type == type.circle) {
                gDC.fillOval(x, y, w, h);
            } else if (Type == type.text) {
                Font font = new Font("Monospaced", Font.PLAIN, fs);
                gDC.setFont(font);
                gDC.drawString(text , x, y);
            } else if (Type == type.picture) {
                gDC.drawImage(pic, null, x, y);
            }
        }

        /**
         * Diese Methode gibt die X Position des Objekts zurück
         * @return X Position des Objekts
         */
        public int getX() {
            return x;
        }

        /**
         * Diese Methode gibt die Y Position des Objekts zurück
         * @return Y Position des Objekts
         */
        public int getY() {
            return y;
        }

        /**
         * Diese Methode gibt die Breite des Objekts zurück
         * @return Die Breite des Objekts
         */
        public int getW() {
            return w;
        }

        /**
         * Diese Methode gibt die Höhe des Objekts zurück
         * @return Die Höhe des Objekts
         */
        public int getH() {
            return h;
        }
    }

}
