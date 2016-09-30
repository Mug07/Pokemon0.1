package graficos;

import entities.criaturas.Jugador;
import mapa.tile.Tile;

public final class Pantalla {

    /*Esta clase se encarga de ensamblar la imagen que se dibuja en pantalla, todo debe calcularse por separado en otras clases
    Luego la clase pantalla lo conecta todo y se lo da a la clase juego para hacerlo mas eficiente.
    Todo se calcula en buffer o sea en memoria y la clase juego lo muestra ya calculado
     */
    private final int ancho;
    private final int alto;

    private int difX;
    private int difY;

    public final int[] pixels;

    public Pantalla(final int ancho, final int alto) {
        this.ancho = ancho;
        this.alto = alto;
        pixels = new int[ancho * alto];
    }

    public void limpiar() {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }

    public void mostrarTile(int compensacionX, int compensacionY, Tile tile) {
        compensacionX -= difX;
        //Compensacion X y Y son para saber en que cuanto se ha desplazado el mapa respecto a la pantalla principal.
        compensacionY -= difY;
        for (int y = 0; y < tile.sprite.getLado(); y++) {
            int posY = y + compensacionY;
            for (int x = 0; x < tile.sprite.getLado(); x++) {
                int posX = x + compensacionX;
                if (posX < -tile.sprite.getLado() || posX >= ancho || posY < 0 || posY >= alto) {
                    break;
                }
                if (posX < 0) {
                    posX = 0;
                }
                pixels[posX + posY * ancho] = tile.sprite.pixels[x + y * tile.sprite.getLado()];
            }
        }
    }

    public void mostrarJugador(int compensacionX, int compensacionY, Jugador jugador) {
        compensacionX -= difX;
        compensacionY -= difY;
        for (int y = 0; y < jugador.getSprite().getLado(); y++) {
            int posY = y + compensacionY;
            for (int x = 0; x < jugador.getSprite().getLado(); x++) {
                int posX = x + compensacionX;
                if (posX < -jugador.getSprite().getLado() || posX >= ancho || posY < 0 || posY >= alto) {
                    break;
                }
                if (posX < 0) {
                    posX = 0;
                }
                int colorPixelJugador = jugador.getSprite().pixels[x + y * jugador.getSprite().getLado()];
                if (colorPixelJugador != 0xffff00ff) {
                    pixels[posX + posY * ancho] = colorPixelJugador;
                }
            }
        }
    }
    
    public void mostrarPokemon(int compensacionX, int compensacionY, Jugador jugador) {
        compensacionX -= difX;
        compensacionY -= difY;
        for (int y = 0; y < jugador.getSprite().getLado(); y++) {
            int posY = y + compensacionY;
            for (int x = 0; x < jugador.getSprite().getLado(); x++) {
                int posX = x + compensacionX;
                if (posX < -jugador.getSprite().getLado() || posX >= ancho || posY < 0 || posY >= alto) {
                    break;
                }
                if (posX < 0) {
                    posX = 0;
                }
                int colorPixelJugador = jugador.getSprite().pixels[x + y * jugador.getSprite().getLado()];
                if (colorPixelJugador != 0xffff00ff) {
                    pixels[posX + posY * ancho] = colorPixelJugador;
                }
            }
        }
    }

    public void setDif(final int difX, final int difY) {
        this.difX = difX;
        this.difY = difY;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

}
