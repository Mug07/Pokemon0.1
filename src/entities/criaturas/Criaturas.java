package entities.criaturas;

import entities.Entity;
import graficos.Sprite;

public abstract class Criaturas extends Entity {

    protected Sprite sprite;
    protected char direccion = 'n';
    protected boolean enMovimiento = false;

    @Override
    public void actualizar() {
    }

    @Override
    public void mostrar() {
    }

    public void mover(int desplazamientoX, int desplazamientoY) {
        if (desplazamientoX > 0) {
            direccion = 'e';
        }
        if (desplazamientoX < 0) {
            direccion = 'w';
        }
        if (desplazamientoY > 0) {
            direccion = 's';
        }
        if (desplazamientoY < 0) {
            direccion = 'n';
        }

        if (!isEliminado()) {
            if (!enColision(desplazamientoX, 0) && !esPokemon(desplazamientoX, 0)) {
                desplazarX(desplazamientoX);
            } else if (esPokemon(desplazamientoX, 0)) {
                System.out.println("gg");
            }
            if (!enColision(0, desplazamientoY) && !esPokemon(0, desplazamientoY)) {
                desplazarY(desplazamientoY);
            } else if (esPokemon(0, desplazamientoY)) {
                System.out.println("gg");
            }
        }
    }

    private boolean enColision(int desplazamientoX, int desplazamientoY) {
        boolean colision = false;
        int posicionX = x + desplazamientoX;//Lo que se movio el jugador en los dos ejes.
        int posicionY = y + desplazamientoY;

        int margenIzquierdo = -6;//Como el sprite no ocupa todo el cuadro del tile entonces se coloca un margen para percibir el tile desde el brazo
        int margenDerecho = 18;

        int margenSuperior = -8;
        int margenInferior = 31;

        int bordeIzquierdo = (posicionX + margenDerecho) / sprite.getLado();
        int bordeDerecho = (posicionX + margenDerecho + margenIzquierdo) / sprite.getLado();
        int bordeSuperior = (posicionY + margenInferior) / sprite.getLado();
        int bordeInferior = (posicionY + margenInferior + margenSuperior) / sprite.getLado();

        if (posicionY < 500) {
            if (mapa.getTilescat(bordeIzquierdo + bordeSuperior * mapa.getAncho()).esSolido()) {
                colision = true;
            }
            if (mapa.getTilescat(bordeIzquierdo + bordeInferior * mapa.getAncho()).esSolido()) {
                colision = true;
            }
            if (mapa.getTilescat(bordeDerecho + bordeSuperior * mapa.getAncho()).esSolido()) {
                colision = true;
            }
            if (mapa.getTilescat(bordeDerecho + bordeInferior * mapa.getAncho()).esSolido()) {
                colision = true;
            }
        }
        return colision;
    }

    private boolean esPokemon(int desplazamientoX, int desplazamientoY) {
        boolean pokemon = false;
        int posicionX = x + desplazamientoX;//Lo que se movio el jugador en los dos ejes.
        int posicionY = y + desplazamientoY;

        int margenIzquierdo = -6;//Como el sprite no ocupa todo el cuadro del tile entonces se coloca un margen para percibir el tile desde el brazo
        int margenDerecho = 18;

        int margenSuperior = -4;
        int margenInferior = 31;

        int bordeIzquierdo = (posicionX + margenDerecho) / sprite.getLado();
        int bordeDerecho = (posicionX + margenDerecho + margenIzquierdo) / sprite.getLado();
        int bordeSuperior = (posicionY + margenInferior) / sprite.getLado();
        int bordeInferior = (posicionY + margenInferior + margenSuperior) / sprite.getLado();

        if (posicionY < 500) {
            if (mapa.getTilescat(bordeIzquierdo + bordeSuperior * mapa.getAncho()).esPokemon()) {
                pokemon = true;
            }
            if (mapa.getTilescat(bordeIzquierdo + bordeInferior * mapa.getAncho()).esPokemon()) {
                pokemon = true;
            }
            if (mapa.getTilescat(bordeDerecho + bordeSuperior * mapa.getAncho()).esPokemon()) {
                pokemon = true;
            }
            if (mapa.getTilescat(bordeDerecho + bordeInferior * mapa.getAncho()).esPokemon()) {
                pokemon = true;
            }
        }
        return pokemon;
    }
}
