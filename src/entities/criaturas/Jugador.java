package entities.criaturas;

import control.Teclado;
import graficos.Pantalla;
import graficos.Sprite;
import mapa.Mapa;

public class Jugador extends Criaturas {

    private Teclado teclado;

    private int animacion;

    public Jugador(Mapa mapa, Teclado teclado, Sprite sprite) {
        this.mapa=mapa;
        this.teclado = teclado;
        this.sprite = sprite;
    }

    public Jugador(Mapa mapa, Teclado teclado, Sprite sprite, int posicionX, int posicionY) {
        this.mapa=mapa;
        this.teclado = teclado;
        this.sprite = sprite;
        this.x = posicionX;
        this.y = posicionY;
    }

    //Todos los calculos se hacen en el metodo actualizar.
    @Override
    public void actualizar() {

        int desplazamientoX = 0;
        int desplazamientoY = 0;

        int vMovimiento = 1;

        if (animacion < 32767) {
            animacion++;
        } else {
            animacion = 0;
        }
        if (teclado.correr) {
            vMovimiento = 2;
        }
        if (teclado.arriba) {
            desplazamientoY -= vMovimiento;
        }
        if (teclado.abajo) {
            desplazamientoY += vMovimiento;
        }
        if (teclado.izquierda) {
            desplazamientoX -= vMovimiento;
        }
        if (teclado.derecha) {
            desplazamientoX += vMovimiento;
        }

        if (desplazamientoX != 0 || desplazamientoY != 0) {
            mover(desplazamientoX, desplazamientoY);
            enMovimiento = true;
        } else {
            enMovimiento = false;
        }
        /*if (direccion == 'n') {
            sprite = Sprite.ARRIBA0;
            if (enMovimiento) {
                int resto = animacion % 30;
                if (resto > 15) {
                    sprite = Sprite.ARRIBA1;
                } else {
                    sprite = Sprite.ARRIBA2;
                }
            }
        }*/
        if (direccion == 'n') {
            sprite = Sprite.ARRIBA0;
            if (enMovimiento) {
                int resto = animacion % 40;
                if (resto > 10 && resto <= 20) {
                    sprite = Sprite.ARRIBA1;
                } else if (resto > 20 && resto <= 30) {
                    sprite = Sprite.ARRIBA0;
                } else if (resto > 30) {
                    sprite = Sprite.ARRIBA2;
                } else {
                    sprite = Sprite.ARRIBA0;
                }
            }
        }

        if (direccion == 's') {
            sprite = Sprite.ABAJO0;
            if (enMovimiento) {
                int resto = animacion % 40;
                if (resto > 10 && resto <= 20) {
                    sprite = Sprite.ABAJO1;
                } else if (resto > 20 && resto <= 30) {
                    sprite = Sprite.ABAJO0;
                } else if (resto > 30) {
                    sprite = Sprite.ABAJO2;
                } else {
                    sprite = Sprite.ABAJO0;
                }
            }
        }
        if (direccion == 'w') {
            sprite = Sprite.IZQUIERDA0;
            if (enMovimiento) {
                int resto = animacion % 40;
                if (resto > 10 && resto <= 20) {
                    sprite = Sprite.IZQUIERDA1;
                } else if (resto > 20 && resto <= 30) {
                    sprite = Sprite.IZQUIERDA0;
                } else if (resto > 30) {
                    sprite = Sprite.IZQUIERDA2;
                } else {
                    sprite = Sprite.IZQUIERDA0;
                }
            }
        }
        if (direccion == 'e') {
            sprite = Sprite.DERECHA0;
            if (enMovimiento) {
                int resto = animacion % 40;
                if (resto > 10 && resto <= 20) {
                    sprite = Sprite.DERECHA1;
                } else if (resto > 20 && resto <= 30) {
                    sprite = Sprite.DERECHA0;
                } else if (resto > 30) {
                    sprite = Sprite.DERECHA2;
                } else {
                    sprite = Sprite.DERECHA0;
                }
            }
        }
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void mostrar(Pantalla pantalla) {
        pantalla.mostrarJugador(x, y, this);
    }
}
