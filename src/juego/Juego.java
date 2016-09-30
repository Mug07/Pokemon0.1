package juego;

import control.Teclado;
import entities.criaturas.Jugador;
import graficos.Pantalla;
import graficos.Sprite;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import mapa.LoadedMap;
import mapa.Mapa;
//import mapa.MapaGenerado;

public class Juego extends Canvas implements Runnable {

    private static final int ANCHO = 25 * 32, ALTO = 20 * 32;
    //private static int anchoimagen = (ANCHO / 2) - 30, altoimagen = (ALTO / 2) - 30;
    private static volatile boolean running = false;

    private static String contaps = "";
    private static String contfps = "";

    private static int aps = 0;
    private static int fps = 0;

    public JFrame ventana;
    private static Thread thread;
    private static Teclado teclado;
    private static Pantalla pantalla;

    private static Mapa mapa;
    private static Jugador jugador;

    private static BufferedImage imagen = new BufferedImage(ANCHO, ALTO, BufferedImage.TYPE_INT_RGB);
    private static int[] pixels = ((DataBufferInt) imagen.getRaster().getDataBuffer()).getData();
    private static final ImageIcon icono = new ImageIcon(Juego.class.getResource("/recursos/icono/iconopikachu.png"));
    //private static ImageIcon Ash= new ImageIcon(Juego.class.getResource("/recursos/texturas/trainerspritesheet.png"));

    //private static final ImageIcon bulbasaur= new ImageIcon(Juego.class.getResource("/recursos/texturas/bulbasaur_gif.gif"));
    //private static final ImageIcon lago= new ImageIcon(Juego.class.getResource("/recursos/texturas/lago.png"));
    private Juego() {
        try {
            setPreferredSize(new Dimension(ANCHO, ALTO));
            //Se instancia a mapa con mapagenerado que es como una clase mas especifica de la clase mapa, la cual no puede ser instanciada por ser abstract.
            pantalla = new Pantalla(ANCHO, ALTO);
            //mapa = new MapaGenerado(32, 32);//64 Son el numero de tiles que tendrá el mapa.
            mapa = new LoadedMap("/recursos/texturas/mapapixeles.png");
            teclado = new Teclado();
            jugador = new Jugador(mapa, teclado, Sprite.ABAJO0, 384, 304);
            addKeyListener(teclado);
            ventana = new JFrame("Pokemon");
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setResizable(false);
            ventana.setIconImage(icono.getImage());
            ventana.setLayout(new BorderLayout());
            ventana.add(this, BorderLayout.CENTER);
            ventana.pack();
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        Juego juego = new Juego();
        juego.init();
    }

    private synchronized void init() {
        running = true;
        thread = new Thread(this, "Graficos");
        thread.start();
    }

    private synchronized void tick() {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void actualizar() {
        teclado.actualizar();
        jugador.actualizar();
        if (teclado.cerrar) {
            System.exit(0);
        }
        /*if (jugador.getX() >= 522 && jugador.getX() <= 700) {
            running = false;
            JOptionPane.showMessageDialog(null, "Encontraste un lugia.");
            //Batalla batalla= new Batalla();
        }*/
        aps++;
    }

    private void mostrar() {
        BufferStrategy estrategia = getBufferStrategy();
        //El buffer calcula primero la imagen y la transmite a la pantalla, es mas eficiente que calcular las imagenes a la vez que se dibujan
        //De este modo todo se dibuja mas suave
        if (estrategia == null) {
            createBufferStrategy(3);
            return;
        }
        pantalla.limpiar();
        mapa.mostrar(jugador.getX() - pantalla.getAncho() / 2 + jugador.getSprite().getLado() / 2, jugador.getY() - pantalla.getAlto() / 2 + jugador.getSprite().getLado() / 2, pantalla);
        jugador.mostrar(pantalla);//Polimorfismo de sobrecarga
        System.arraycopy(pantalla.pixels, 0, pixels, 0, pixels.length);
        Graphics g = estrategia.getDrawGraphics();
        g.setColor(Color.red);
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
        g.drawString(contaps, 10, 20);
        g.drawString(contfps, 10, 35);
        g.drawString("X: " + jugador.getX(), 10, 50);
        g.drawString("Y: " + jugador.getY(), 10, 65);
        g.dispose();
        estrategia.show();
        fps++;
    }

    @Override
    public void run() {
        final int NS_PS = 1000000000;
        final byte APS_OBJETIVO = 60;
        final double NS_PA = NS_PS / APS_OBJETIVO;

        long refActualizacion = System.nanoTime();
        long refContador = System.nanoTime();

        double tTranscurrido;
        double delta = 0;

        requestFocus();

        while (running) {
            long startTime = System.currentTimeMillis();
            long currentTime = 0;
            final long inicioBucle = System.nanoTime();
            tTranscurrido = inicioBucle - refActualizacion;
            refActualizacion = inicioBucle;
            delta += tTranscurrido / NS_PA;
            currentTime = System.currentTimeMillis() - startTime;

            while (delta >= 1) {
                actualizar();
                delta--;
            }

            mostrar();
            if ((System.nanoTime() - refContador) > NS_PS) {
                contaps = "APS: " + aps;
                contfps = "FPS: " + fps;
                aps = 0;
                fps = 0;
                refContador = System.nanoTime();
            }
        }
    }
}
