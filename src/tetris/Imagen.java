package tetris;

import java.awt.Color;
import java.awt.Graphics;

public class Imagen {
    
    SuperficieDeDibujo superficieDeDibujo;
    Dupla posicionTablero;
    int lado;
    
    public Imagen(SuperficieDeDibujo superficieDeDibujo) {
        this.superficieDeDibujo = superficieDeDibujo;
        posicionTablero = superficieDeDibujo.tablero.posicion;
        lado = superficieDeDibujo.tablero.LADO;
    }
    
    public Dupla calcularPosicion(Dupla pos) {
        int X = (int)(pos.X * lado + posicionTablero.X);
        int Y = (int)(pos.Y * lado + posicionTablero.Y);
        return new Dupla(X, Y);
    }
    
    public void dibujarPeriferico(Dupla pos, Graphics g, String tipo) {
        Color color;
        switch(tipo){
            case"Z":
                g.setColor(new Color(228, 0, 39));
                break;
            case"S":
                g.setColor(new Color(0, 228, 39));
                break;
            case"J":
                g.setColor(new Color(0, 78, 228));
                break;
            case"L":
                g.setColor(new Color(228, 98, 0));
                break;
            case"T":
                g.setColor(new Color(158,19, 228));
                break;
            case"O":
                g.setColor(new Color(228, 222, 0));
                break;
            case"I":
                g.setColor(new Color(0, 228, 228));
                break;
        }
        g.fillRect((int)calcularPosicion(pos).X, (int)calcularPosicion(pos).Y, lado, lado);
        g.setColor(Color.BLACK);
        g.drawRect((int)calcularPosicion(pos).X, (int)calcularPosicion(pos).Y, lado, lado);
    }
}
