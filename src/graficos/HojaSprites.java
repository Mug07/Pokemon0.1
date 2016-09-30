package graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class HojaSprites {

    private final int ancho;
    private final int alto;
    public final int[] pixels;

    //coleccion hoja sprites
    public static HojaSprites hmapa = new HojaSprites("/recursos/texturas/hojaesprites.png", 320, 320);   
    public static HojaSprites personaje = new HojaSprites("/recursos/texturas/personaje.png", 128, 96);
    //fin de la coleccion

    public HojaSprites(final String ruta, final int ancho, final int alto) {
        this.ancho = ancho;
        this.alto = alto;

        pixels = new int[ancho * alto];
        BufferedImage imagen;
        try {
            imagen = ImageIO.read(HojaSprites.class.getResource(ruta));
            imagen.getRGB(0, 0, ancho, alto, pixels, 0, ancho);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public int[] getPixels() {
        return pixels;
    }

}
