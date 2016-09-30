package graficos;

public final class Sprite {

    private final int lado, lado1, lado2;

    private int x;
    private int y;

    public int[] pixels;
    private HojaSprites hoja;
    //Colección de sprites del personaje
    public static final Sprite ABAJO0=new Sprite(32,0,0,HojaSprites.personaje);
    public static final Sprite ABAJO1=new Sprite(32,0,1,HojaSprites.personaje);
    public static final Sprite ABAJO2=new Sprite(32,0,2,HojaSprites.personaje);
    
    public static final Sprite ARRIBA0=new Sprite(32,1,0,HojaSprites.personaje);
    public static final Sprite ARRIBA1=new Sprite(32,1,1,HojaSprites.personaje);
    public static final Sprite ARRIBA2=new Sprite(32,1,2,HojaSprites.personaje);
    
    public static final Sprite DERECHA0=new Sprite(32,2,0,HojaSprites.personaje);
    public static final Sprite DERECHA1=new Sprite(32,2,1,HojaSprites.personaje);
    public static final Sprite DERECHA2=new Sprite(32,2,2,HojaSprites.personaje);
    
    public static final Sprite IZQUIERDA0=new Sprite(32,3,0,HojaSprites.personaje);
    public static final Sprite IZQUIERDA1=new Sprite(32,3,1,HojaSprites.personaje);
    public static final Sprite IZQUIERDA2=new Sprite(32,3,2,HojaSprites.personaje);
    //Fin de colección de sprites de personaje
    
    //Colección de sprites de los pokemon;
    public static final Sprite LUGIA1=new Sprite(32,0,3,HojaSprites.hmapa);
    public static final Sprite LUGIA2=new Sprite(32,1,3,HojaSprites.hmapa);
    public static final Sprite LUGIA3=new Sprite(32,0,4,HojaSprites.hmapa);
    public static final Sprite LUGIA4=new Sprite(32,1,4,HojaSprites.hmapa);
    //Fin colección de sprites de personaje
    
    //Colección de sprites
    public static final Sprite GRASS = new Sprite(32, 0, 0, HojaSprites.hmapa);
    public static final Sprite EMPTY = new Sprite(32, 0);
    public static final Sprite PISO1 = new Sprite(32, 1, 0, HojaSprites.hmapa);
    public static final Sprite PISO2 = new Sprite(32, 1, 1, HojaSprites.hmapa);
    public static final Sprite PISO3 = new Sprite(32, 1, 2, HojaSprites.hmapa);
    public static final Sprite TRANSPISOHIERBA1 = new Sprite(32, 2, 0, HojaSprites.hmapa);//Trans se refiere a transicion.
    public static final Sprite TRANSPISOHIERBA2 = new Sprite(32, 2, 1, HojaSprites.hmapa);
    public static final Sprite TRANSPISOHIERBA3 = new Sprite(32, 2, 2, HojaSprites.hmapa);
    public static final Sprite TRANSPISOHIERBA4 = new Sprite(32, 2, 3, HojaSprites.hmapa);
    public static final Sprite TRANSPISOHIERBA5 = new Sprite(32, 4, 1, HojaSprites.hmapa);
    public static final Sprite TRANSPISOHIERBA6 = new Sprite(32, 5, 1, HojaSprites.hmapa);
    public static final Sprite TRANSPISOHIERBA7 = new Sprite(32, 6, 1, HojaSprites.hmapa);
    public static final Sprite ARENA1 = new Sprite(32, 0, 1, HojaSprites.hmapa);
    public static final Sprite ARENA2 = new Sprite(32, 0, 2, HojaSprites.hmapa);
    public static final Sprite TRANSARENAHIERBA1 = new Sprite(32, 3, 0, HojaSprites.hmapa);
    public static final Sprite TRANSARENAHIERBA2 = new Sprite(32, 3, 1, HojaSprites.hmapa);
    public static final Sprite TRANSARENAHIERBA3 = new Sprite(32, 3, 2, HojaSprites.hmapa);
    public static final Sprite TRANSARENAHIERBA4 = new Sprite(32, 3, 3, HojaSprites.hmapa);
    public static final Sprite TRANSARENAHIERBA5 = new Sprite(32, 4, 2, HojaSprites.hmapa);
    public static final Sprite TRANSARENAHIERBA6 = new Sprite(32, 5, 2, HojaSprites.hmapa);
    public static final Sprite TRANSARENAHIERBA7 = new Sprite(32, 6, 2, HojaSprites.hmapa);
    public static final Sprite PIEDRAS1= new Sprite(32,4,0,HojaSprites.hmapa);
    public static final Sprite PIEDRAS2= new Sprite(32,5,0,HojaSprites.hmapa);
    public static final Sprite PIEDRAS3= new Sprite(32,6,0,HojaSprites.hmapa);
    public static final Sprite PIEDRAS4= new Sprite(32,7,0,HojaSprites.hmapa);
    //Fin de la coleccón

    public Sprite(int lado, final int columna, final int fila, HojaSprites hoja) {
        this.lado = lado;
        this.lado1=0;
        this.lado2=0;
        pixels = new int[lado * lado];

        this.x = columna * lado;
        this.y = fila * lado;
        this.hoja = hoja;

        for (int y = 0; y < lado; y++) {
            for (int x = 0; x < lado; x++) {
                pixels[x + y * lado] = hoja.pixels[(x + this.x) + (y + this.y) * hoja.getAncho()];
            }
        }
    }

    /*public Sprite(int lado1, int lado2, final int columna, final int fila, HojaSprites hoja) {
        this.lado=0;
        this.lado1 = lado1;
        this.lado2 = lado2;
        pixels = new int[lado1 * lado2];
        
        this.x = columna * 32;
        this.y = fila * lado2;
        this.hoja = hoja;
        
        for (int y = 0; y < lado2; y++) {
            for (int x = 0; x < lado1; x++) {
                pixels[x + y * lado2] = hoja.pixels[(x + this.x) + (y + this.y) * hoja.getAncho()];
            }
        }
    }*/

    public Sprite(final int lado, final int color) {
        this.lado = lado;
        this.lado1=0;
        this.lado2=0;
        pixels = new int[lado * lado];
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = color;
        }
    }

    public int getLado() {
        return lado;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}
