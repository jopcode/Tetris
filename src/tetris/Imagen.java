package tetris;

import java.awt.Color;
import java.awt.Graphics;

public class Imagen implements InformacionGeneral{
    
    SuperficieDeDibujo superficieDeDibujo;
    Dupla posicionTablero;
 
    
    public Imagen(SuperficieDeDibujo superficieDeDibujo) {
        this.superficieDeDibujo = superficieDeDibujo;
        posicionTablero = superficieDeDibujo.tablero.posicion;
    }
    
    public Dupla calcularPosicion(Dupla pos) {
        int X = (int)(pos.X * ANCHO_TETRIMINO + posicionTablero.X);
        int Y = (int)(pos.Y * ALTO_TETRIMINO + posicionTablero.Y);
        return new Dupla(X, Y);
    }
    
    public void dibujarPeriferico(Dupla pos, Graphics g, int tipo) {
        Color color;
        switch(tipo){
            case 0:
                g.setColor(new Color(228, 0, 39));
                break;
            case 1:
                g.setColor(new Color(0, 228, 39));
                break;
            case 2:
                g.setColor(new Color(0, 78, 228));
                break;
            case 3:
                g.setColor(new Color(228, 98, 0));
                break;
            case 4:
                g.setColor(new Color(158,19, 228));
                break;
            case 5:
                g.setColor(new Color(228, 222, 0));
                break;
            case 6:
                g.setColor(new Color(0, 228, 228));
                break;
        }
        g.fillRect((int)calcularPosicion(pos).X, (int)calcularPosicion(pos).Y, ANCHO_TETRIMINO, ALTO_TETRIMINO);
        g.setColor(Color.BLACK);
        g.drawRect((int)calcularPosicion(pos).X, (int)calcularPosicion(pos).Y, ANCHO_TETRIMINO, ALTO_TETRIMINO);
    }
}
