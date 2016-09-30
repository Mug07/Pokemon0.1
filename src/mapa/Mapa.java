package mapa;

import graficos.Pantalla;
import mapa.tile.Tile;

public abstract class Mapa {

    protected int ancho;
    protected int alto;

    protected int[] tiles;
    protected Tile[] tilescat;

    public Mapa(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        tiles = new int[ancho * alto];
        generarMapa();
    }

    public Mapa(String ruta) {
        cargarMapa(ruta);
        generarMapa();
    }

    protected void generarMapa() {

    }

    protected void cargarMapa(String ruta) {

    }

    public void actualizar() {

    }

    public void mostrar(int compensacionX, int compensacionY, final Pantalla pantalla) {
        pantalla.setDif(compensacionX, compensacionY);
        int o = compensacionX / 32;//Bit shifting, se rueda 5 bits a la derecha que seria lo mismo que dividir entre 32
        int e = (compensacionX + pantalla.getAncho() + Tile.LADO) / 32;
        int n = compensacionY / 32;
        int s = (compensacionY + pantalla.getAlto() + Tile.LADO) / 32;
        //Se recorre todo el tile como si se fuera de norte a sur mientras a la vez se va de oeste a este, como recorriendo una matriz.
        for (int y = n; y < s; y++) {
            for (int x = o; x < e; x++) {
                //getTile(x, y).mostrar(x, y, pantalla);  
                if (x < 0 || y < 0 || x >= ancho || y >= alto) {
                    Tile.EmptyTile.mostrar(x, y, pantalla);
                } else {
                    tilescat[x + y * ancho].mostrar(x, y, pantalla);
                }
            }
        }
    }

    public int getAncho() {
        return ancho;
    }
    
    public Tile getTilescat(int posicion) {
        return tilescat[posicion];
    }
}
