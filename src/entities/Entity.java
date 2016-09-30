package entities;

import mapa.Mapa;

public abstract class Entity {

    protected int x;
    protected int y;

    private boolean eliminado = false;

    protected Mapa mapa;

    public void actualizar() {
    }

    public void mostrar() {
    }

    public void eliminar() {
        eliminado = true;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public int getX() {
        return x;
    }

    public void desplazarX(int desplazamientoX) {
        x += desplazamientoX;
    }

    public void desplazarY(int desplazamientoY) {
        y += desplazamientoY;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }
}
