package mapa;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import mapa.tile.Tile;

public class LoadedMap extends Mapa {

    private int[] pixels;

    public LoadedMap(String ruta) {
        super(ruta);
    }

    @Override
    protected void cargarMapa(String ruta) {
        try {
            BufferedImage imagen = ImageIO.read(LoadedMap.class.getResource(ruta));
            ancho = imagen.getWidth();
            alto = imagen.getHeight();

            tilescat = new Tile[ancho * alto];
            pixels = new int[ancho * alto];
            imagen.getRGB(0, 0, ancho, alto, pixels, 0, ancho);//Punto inicial 0, Punto inicial 0, el ancho de la hoja, el alto de la hoja, el array en el que vamos a guardar la informacion, 0 que es el desplazamiento y el tamaño de la linea horizontal que queremos escanear.
        } catch (IOException ex) {
            Logger.getLogger(LoadedMap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void generarMapa() {
        for (int i = 0; i < pixels.length; i++) {
            switch (pixels[i]) {
                //Se coloca ff antes de cada color para denotar opacidad al 100%, sino solo se vería un cuadro negro.
                case 0xff656060:
                    tilescat[i] = Tile.GRASS;
                    continue;
                case 0xff6d5353:
                    tilescat[i] = Tile.PISO1;
                    continue;
                case 0xffb46565:
                    tilescat[i] = Tile.PISO2;
                    continue;
                case 0xff473737:
                    tilescat[i] = Tile.PISO3;
                    continue;
                case 0xff682c2c:
                    tilescat[i] = Tile.TRANSPISOHIERBA1;
                    continue;
                case 0xffc23e3e:
                    tilescat[i] = Tile.TRANSPISOHIERBA2;
                    continue;
                case 0xff912c2c:
                    tilescat[i] = Tile.TRANSPISOHIERBA3;
                    continue;
                case 0xffbd1414:
                    tilescat[i] = Tile.TRANSPISOHIERBA4;
                    continue;
                case 0xff9e80b0:
                    tilescat[i] = Tile.TRANSPISOHIERBA5;
                    continue;
                case 0xff755e84:
                    tilescat[i] = Tile.TRANSPISOHIERBA6;
                    continue;
                case 0xff51415d:
                    tilescat[i] = Tile.TRANSPISOHIERBA7;
                    continue;
                case 0xff950909:
                    tilescat[i] = Tile.ARENA1;
                    continue;
                case 0xff5d0000:
                    tilescat[i] = Tile.ARENA2;
                    continue;
                case 0xff380101:
                    tilescat[i] = Tile.TRANSARENAHIERBA1;
                    continue;
                case 0xffc08aac:
                    tilescat[i] = Tile.TRANSARENAHIERBA2;
                    continue;
                case 0xff976d88:
                    tilescat[i] = Tile.TRANSARENAHIERBA3;
                    continue;
                case 0xff694d5e:
                    tilescat[i] = Tile.TRANSARENAHIERBA4;
                    continue;
                case 0xffc5328b:
                    tilescat[i] = Tile.TRANSARENAHIERBA5;
                    continue;
                case 0xff7b2659:
                    tilescat[i] = Tile.TRANSARENAHIERBA6;
                    continue;
                case 0xff421630:
                    tilescat[i] = Tile.TRANSARENAHIERBA7;
                    continue;
                case 0xff83bddb:
                    tilescat[i] = Tile.PIEDRAS1;
                    continue;
                case 0xff40904a:
                    tilescat[i] = Tile.PIEDRAS2;
                    continue;
                case 0xff2d6734:
                    tilescat[i] = Tile.PIEDRAS3;
                    continue;
                case 0xff164a1c:
                    tilescat[i] = Tile.PIEDRAS4;
                    continue;
                case 0xffde9af4:
                    tilescat[i] = Tile.LUGIA1;
                    continue;
                case 0xff9af4a7:
                    tilescat[i] = Tile.LUGIA2;
                    continue;
                case 0xff69a772:
                    tilescat[i] = Tile.LUGIA3;
                    continue;
                case 0xff2b7536:
                    tilescat[i]=Tile.LUGIA4;
                    continue;
                default:
                    tilescat[i] = Tile.EmptyTile;
                //Siempre añadir ff a el numero hexadecimal del color.
            }
        }
    }
}
