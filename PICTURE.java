import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Beschreiben Sie hier die Klasse PICTURE.
 * 
 * @author virus_rpi
 * @version 2.0
 */
public class PICTURE extends SHAPE
{
    private BufferedImage img;
    int height, width;
    /**
     * Konstruktor für Objekte der Klasse PICTURE
     */
    public PICTURE() throws IOException {
        super.id = FRAME.getObject().create(FRAME.type.picture);
        super.X = 0;
        super.Y = 0;
        super.visible = true;
        img = ImageIO.read(new File("example.jpg"));
        height = img.getHeight();
        width = img.getWidth();
        draw();
    }
    @Override
    public void draw(){
        FRAME.getObject().setPic(super.id, img);
        FRAME.getObject().draw(super.id, super.X, super.Y, width, height, 0, 0, 0, super.visible, null, null, null, 0, 0);
    }

    public void setPic(String path) throws IOException {
        img = ImageIO.read(new File(path));
        draw();
    }
    public void setPicFromURL(String path) throws IOException {
        img = ImageIO.read(new URL(path));
        draw();
    }

    public void setSize(int w, int h) throws IOException {
        img = resizeImage(img, w, h);
        draw();
    }
    public void resize(double percent) throws IOException {
        double p = percent/100;
        img = resizeImage(img, (int)(width*p), (int)(height*p));
        draw();
    }
    
    private BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        graphics2D.dispose();
        return resizedImage;
    }
}
