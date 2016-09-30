package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener {

    private final static int numeroTeclas = 120;
    private final boolean[] teclas = new boolean[numeroTeclas];

    //No se usan getters ni setters porque son valores que se necesitan utilizar de manera rapida durante la ejecucion del juego.
    public boolean arriba;
    public boolean abajo;
    public boolean izquierda;
    public boolean derecha;
    public boolean cerrar;
    public boolean correr;
    

    public void actualizar() {
        arriba = teclas[KeyEvent.VK_UP];
        abajo = teclas[KeyEvent.VK_DOWN];
        izquierda = teclas[KeyEvent.VK_LEFT];
        derecha = teclas[KeyEvent.VK_RIGHT];
        cerrar = teclas[KeyEvent.VK_ESCAPE];
        correr=teclas[KeyEvent.VK_X];
    }

    @Override
    public void keyPressed(KeyEvent e) {//Pulsado pero no soltado.
        teclas[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {//Cuando se suelta la tecla que se ha usado.
        teclas[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {//Tecla que ya se ha pulsado y soltado.
    }
}
