package tetris;

public class Tetrimino implements InformacionGeneral{
    Dupla periferico[];
    int nombre;

    public static Tetrimino Aleatorio() {
        return consultar(TETRIMINOS_NOMBRE[(int)(Math.random()*6.9)]);
    }
    
    public Tetrimino(Dupla periferico0,Dupla periferico1,Dupla periferico2,Dupla periferico3, int nombre) {
        periferico = new Dupla[4];
        periferico[0] = periferico0;
        periferico[1] = periferico1;
        periferico[2] = periferico2;
        periferico[3] = periferico3;
       
        this.nombre = nombre;
    }
    
    public static Tetrimino consultar(int nombre) {
        switch(nombre) {
            case TETRIMINO_Z:
                return new Tetrimino(new Dupla(0,0), new Dupla(-1,-1), new Dupla(0,-1), new Dupla(1,0), nombre);
            case TETRIMINO_S:
                return new Tetrimino(new Dupla(0,0), new Dupla(-1,0), new Dupla(0,-1), new Dupla(1,-1), nombre);
            case TETRIMINO_J:
                return new Tetrimino(new Dupla(0,0), new Dupla(-1,-1), new Dupla(-1,0), new Dupla(1,0), nombre);
            case TETRIMINO_L:
                return new Tetrimino(new Dupla(0,0), new Dupla(-1,0), new Dupla(-1,-1), new Dupla(1,0), nombre);
            case TETRIMINO_T:
                return new Tetrimino(new Dupla(0,0), new Dupla(0,-1), new Dupla(-1,0), new Dupla(1,0), nombre);
            case TETRIMINO_O:
                return new Tetrimino(new Dupla(0,0), new Dupla(0,-1), new Dupla(1,-1), new Dupla(1,0), nombre);
            case TETRIMINO_I:
                return new Tetrimino(new Dupla(0,0), new Dupla(-1,0), new Dupla(1,0), new Dupla(2,0), nombre);
            
        }
        return new Tetrimino(new Dupla(0,0), new Dupla(0,0), new Dupla(0,0), new Dupla(0,0), nombre);
    }
    
    public void girarDerecha() {
        for (int i = 0; i < periferico.length; i++) {
            periferico[i].girarDerecha();
        }
    }
    
    public void girarIzquierda() {
        for (int i = 0; i < periferico.length; i++) {
            periferico[i].girarIzquierda();
        }
    }
}
