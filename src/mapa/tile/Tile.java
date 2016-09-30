package mapa.tile;

import graficos.HojaSprites;
import graficos.Pantalla;
import graficos.Sprite;

public class Tile {

    public int x;
    public int y;
    public static final int LADO = 32;

    public Sprite sprite;

    private boolean solido;
    private boolean pokemon;

    //Coleccion de tiles
    public static final Tile EmptyTile = new Tile(Sprite.EMPTY, true);
    public static final Tile GRASS = new Tile(Sprite.GRASS);
    public static final Tile PISO1 = new Tile(Sprite.PISO1);
    public static final Tile PISO2 = new Tile(Sprite.PISO2);
    public static final Tile PISO3 = new Tile(Sprite.PISO3);
    public static final Tile TRANSPISOHIERBA1 = new Tile(Sprite.TRANSPISOHIERBA1);
    public static final Tile TRANSPISOHIERBA2 = new Tile(Sprite.TRANSPISOHIERBA2);
    public static final Tile TRANSPISOHIERBA3 = new Tile(Sprite.TRANSPISOHIERBA3);
    public static final Tile TRANSPISOHIERBA4 = new Tile(Sprite.TRANSPISOHIERBA4);
    public static final Tile TRANSPISOHIERBA5 = new Tile(Sprite.TRANSPISOHIERBA5);
    public static final Tile TRANSPISOHIERBA6 = new Tile(Sprite.TRANSPISOHIERBA6);
    public static final Tile TRANSPISOHIERBA7 = new Tile(Sprite.TRANSPISOHIERBA7);
    public static final Tile ARENA1 = new Tile(Sprite.ARENA1);
    public static final Tile ARENA2 = new Tile(Sprite.ARENA2);
    public static final Tile TRANSARENAHIERBA1 = new Tile(Sprite.TRANSARENAHIERBA1);
    public static final Tile TRANSARENAHIERBA2 = new Tile(Sprite.TRANSARENAHIERBA2);
    public static final Tile TRANSARENAHIERBA3 = new Tile(Sprite.TRANSARENAHIERBA3);
    public static final Tile TRANSARENAHIERBA4 = new Tile(Sprite.TRANSARENAHIERBA4);
    public static final Tile TRANSARENAHIERBA5 = new Tile(Sprite.TRANSARENAHIERBA5);
    public static final Tile TRANSARENAHIERBA6 = new Tile(Sprite.TRANSARENAHIERBA6);
    public static final Tile TRANSARENAHIERBA7 = new Tile(Sprite.TRANSARENAHIERBA7);
    public static final Tile PIEDRAS1 = new Tile(Sprite.PIEDRAS1, true);
    public static final Tile PIEDRAS2 = new Tile(Sprite.PIEDRAS2, true);
    public static final Tile PIEDRAS3 = new Tile(Sprite.PIEDRAS3, true);
    public static final Tile PIEDRAS4 = new Tile(Sprite.PIEDRAS4, true);
    public static final Tile LUGIA1 = new Tile(Sprite.LUGIA1, true, true);
    public static final Tile LUGIA2 = new Tile(Sprite.LUGIA2, true, true);
    public static final Tile LUGIA3 = new Tile(Sprite.LUGIA3, true, true);
    public static final Tile LUGIA4 = new Tile(Sprite.LUGIA4, true, true);
    //public static final Tile mostrarMapa=new Tile(Sprite.mostrarMapa);
    //Fin coleccion de tiles

    public Tile(Sprite sprite) {//Se asume que el cuadro por defecto no es solido.
        this.sprite = sprite;
        solido = false;
        pokemon = false;
    }

    public Tile(Sprite sprite, boolean solido) {
        this.sprite = sprite;
        this.solido = solido;
        pokemon = false;
    }

    public Tile(Sprite sprite, boolean solido, boolean pokemon) {
        this.sprite = sprite;
        this.solido = solido;
        this.pokemon = pokemon;
    }

    //Cada clase tiene un metodo mostrar que se dibuja a si misma y esta informacion es pasada a la clase pantalla.
    //La que une todo, lo calcula y le da una sola imagen a la clase Juego
    public void mostrar(int x, int y, Pantalla pantalla) {
        //Como todos las clases de tiles heredan a la clase Tile se utiliza el metodo de este.
        pantalla.mostrarTile(x * 32, y * 32, this);
    }

    public boolean esSolido() {
        return solido;
    }

    public boolean esPokemon() {
        return pokemon;
    }
}
