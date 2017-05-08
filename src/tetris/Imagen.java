package tetris;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Imagen implements InformacionGeneral{
    
    SuperficieDeDibujo superficieDeDibujo;
    Dupla posicionTablero;
    final String[] NOMBRE_IMAGEN = {"Z", "S", "J", "L", "T", "O", "I"}; 
    //Color TetriminosColor[] = {new Color(228, 0, 39), new Color(0, 228, 39), new Color(0, 78, 228), new Color(228, 98, 0), new Color(158,19, 228), new Color(228, 222, 0),  new Color(0, 228, 228)};
    BufferedImage[] Perifericos = new BufferedImage[NOMBRE_IMAGEN.length];
    
    public Imagen(SuperficieDeDibujo superficieDeDibujo) {
        this.superficieDeDibujo = superficieDeDibujo;
        posicionTablero = superficieDeDibujo.tablero.posicion;
        cargarImagenesP();
    }
    
    public Dupla calcularPosicion(Dupla pos) {
        int X = (int)(pos.X * ANCHO_MINO + posicionTablero.X);
        int Y = (int)(pos.Y * ALTO_MINO + posicionTablero.Y);
        return new Dupla(X, Y);
    }
    
    public void dibujarPeriferico(Dupla pos, Graphics g, int nombre) {
        g.drawImage(Perifericos[nombre], calcularPosicion(pos).intX(), calcularPosicion(pos).intY(), superficieDeDibujo);
    }
    
    private void cargarImagenesP() {
        for (int i = 0; i < Perifericos.length; i++) {
            Perifericos[i] = cargarImagen(NOMBRE_IMAGEN[i], ".png");
        }
    }
    
    public BufferedImage cargarImagen(String nombre, String extension) {
        BufferedImage imagen = null;
        
        try {
            imagen = ImageIO.read(ClassLoader.class.getResource("/images/" + nombre + extension));
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return imagen;
    }
    
}
