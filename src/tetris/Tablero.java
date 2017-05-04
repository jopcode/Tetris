package tetris;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Tablero {

    final int COLUMNAS = 10, FILAS = 20, LADO = 28;
    String Tablero[][];
    SuperficieDeDibujo superficieDeDibujo;
    int anchoSDD, altoSDD;
    Dupla posicion;
    Imagen imagen;
    int lineas = 0;

    public Tablero(SuperficieDeDibujo superficieDeDibujo) {
        this.superficieDeDibujo = superficieDeDibujo;
        calcularPosicion();
        Tablero = new String[COLUMNAS][FILAS];
        casillasVacias();
    }

    public void casillasVacias() {
        for (int Y = 0; Y < FILAS; Y++) {
            for (int X = 0; X < COLUMNAS; X++) {
                Tablero[X][Y] = "";
            }
        }
    }

    public void borrarCompletados() {
        int Y = FILAS - 1;

        while (Y >= 0) {
            int X = 0;
            while (X < COLUMNAS && !Tablero[X][Y].equals("")) {
                X++;
            }

            if (X == COLUMNAS) {
                lineas++;
                bajarCompletos(Y);
            } else {
                Y--;
            }
            System.out.println("Lineas: " + lineas);
        }
    }
    
    
    public void bajarCompletos(int Y) {
        for (int X = 0; X < COLUMNAS; X++) {
            Tablero[X][Y] = "";
        }

        while (Y >= 0) {
            for (int X = 0; X < COLUMNAS; X++) {
                Tablero[X][Y] = Y == 0 ? "" : Tablero[X][Y - 1];
            }
            Y--;
        }
    }
    
    public void calcularPosicion() {
        anchoSDD = superficieDeDibujo.getWidth();
        altoSDD = superficieDeDibujo.getHeight();
        posicion = new Dupla((anchoSDD - COLUMNAS * LADO) / 2, (altoSDD - FILAS * LADO) / 2);
    }

    public void dibujar(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Verdana", Font.PLAIN, 16));
        g.drawString("Score:" + lineas, (int)(LADO + posicion.Y), LADO);
        
        for (int Y = 0; Y < FILAS; Y++) {
            for (int X = 0; X < COLUMNAS; X++) {
                Dupla posTemp = new Dupla(X * LADO + posicion.X, Y * LADO + posicion.Y);

                if ((Tablero[X][Y]).equals("")) {
                    Color color;
                    if ((X + Y) % 2 == 0) {
                        color = new Color(69, 13, 153);
                    } else {
                        color = new Color(55, 11, 122);
                    }
                    g.setColor(color);
                    g.fillRect(posTemp.intX(), posTemp.intY(), LADO, LADO);

                    g.setColor(new Color(0, 0, 0));
                    g.drawRect(posTemp.intX(), posTemp.intY(), LADO, LADO);
                } else {
                    imagen.dibujarPeriferico(new Dupla(X, Y), g, Tablero[X][Y]);
                }

            }
        }
    }

    public String Obtener(int X, int Y) {
        if (Y >= 0) {
            return Tablero[X][Y];
        }
        return "";
    }
}
