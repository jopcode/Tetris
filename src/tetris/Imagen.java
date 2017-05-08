package tetris;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Imagen extends FiltroImagenes implements InformacionGeneral{
    
    SuperficieDeDibujo superficieDeDibujo;
    Dupla posicionTablero;
    final String[] NOMBRE_IMAGEN = {"Z", "S", "J", "L", "T", "O", "I"};
    BufferedImage[] IMAGEN_PERIFERICO = new BufferedImage[NOMBRE_IMAGEN.length];
    
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
        g.drawImage(IMAGEN_PERIFERICO[nombre], calcularPosicion(pos).intX(), calcularPosicion(pos).intY(), superficieDeDibujo);
    }
    
    private void cargarImagenesP() {
        for (int i = 0; i < IMAGEN_PERIFERICO.length; i++) {
            IMAGEN_PERIFERICO[i] = cargarImagen(NOMBRE_IMAGEN[i], ".png");
            IMAGEN_PERIFERICO[i] = escalarImagen(IMAGEN_PERIFERICO[i], ANCHO_MINO, ALTO_MINO);
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
