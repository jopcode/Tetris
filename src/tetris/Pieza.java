package tetris;

import java.awt.Graphics;

public class Pieza implements Runnable, InformacionGeneral{
    SuperficieDeDibujo superficieDeDibujo;
    Tablero tablero;
    Imagen imagen;
    Dupla posicion = new Dupla(5, 5);
    Tetrimino PA = Tetrimino.Aleatorio();
    Tetrimino Proximos[] = new Tetrimino[7];
    Thread Hilo = new Thread(this);

    public Pieza(SuperficieDeDibujo superficieDeDibujo) {
        this.superficieDeDibujo = superficieDeDibujo;
        this.tablero = superficieDeDibujo.tablero;
        this.imagen = superficieDeDibujo.imagen;

        for (int i = 0; i < Proximos.length; i++) {
            Proximos[i] = Tetrimino.Aleatorio();
        }
        Hilo.start();
    }


    public void reiniciar() {
        almacenarEnTablero();
        posicion = new Dupla(4,0);
        PA = Proximos[0];
        for (int i = 0; i < Proximos.length-1; i++) {
            Proximos[i] = Proximos[i+1];
        }
        Proximos[Proximos.length-1] = Tetrimino.Aleatorio();
    }

    public void dibujar(Graphics g) {
        for (int i = 0; i < 4; i++) {
            imagen.dibujarPeriferico(new Dupla(posicion.X + PA.periferico[i].X, posicion.Y + PA.periferico[i].Y), g, PA.nombre);
        }

        for (int i = 0; i < Proximos.length; i++) {
            Dupla pos = new Dupla(12, 1+i*3);
            for (int j = 0; j < Proximos[i].periferico.length; j++) {
                double XReal = Proximos[i].periferico[j].X + pos.X;
                double YReal = Proximos[i].periferico[j].Y + pos.Y;

                imagen.dibujarPeriferico(new Dupla(XReal, YReal),g, Proximos[i].nombre);
            }
        }

    }

    public void almacenarEnTablero() {
        for (int i = 0; i < PA.periferico.length; i++) {
            int columna = PA.periferico[i].intX() + posicion.intX(),
                    fila = PA.periferico[i].intY() + posicion.intY();
            int dato = PA.nombre;

            tablero.Tablero[columna][fila] = dato;
        }
    }

    public void moverDerecha() {
        posicion.moverDerecha();
        if(movimientoErroneo()) {
            posicion.moverIzquierda();
        }
    }

    public void girarDerecha() {
        PA.girarDerecha();
        if(movimientoErroneo()) {
            PA.girarIzquierda();
        }
    }

    public void moverIzquierda() {
        posicion.moverIzquierda();
        if(movimientoErroneo()) {
            posicion.moverDerecha();
        }
    }

    public void moverAbajo() {
        posicion.moverAbajo();
        if(movimientoErroneo()) {
            posicion.moverArriba();
            reiniciar();
            tablero.borrarCompletados();
        }
    }

    public boolean movimientoErroneo() {
        for (int i = 0; i < PA.periferico.length; i++) {
            double XReal = PA.periferico[i].X + posicion.X;
            double YReal = PA.periferico[i].Y + posicion.Y;

            if(XReal > tablero.COLUMNAS-1 || XReal<0) {
                return true;
            }

            if(YReal > tablero.FILAS-1 ) {
                return true;
            }

            if(tablero.Obtener((int)XReal, (int)YReal) != NO_TETRIMINO) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void run() {
        try {
            while(true) {
                moverAbajo();
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println("tetris.Pieza.run() - error thread");
        }
    }
}
