package tetris;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

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
    
    public void dibujarPeriferico(Dupla pos, Graphics g, int nombre) {
        
        g.drawImage(cargarImagen(), calcularPosicion(pos).intX(), calcularPosicion(pos).intY(), superficieDeDibujo);
            
//        switch(tipo){
//            case 0:
//                g.setColor(new Color(228, 0, 39));
//                break;
//            case 1:
//                g.setColor(new Color(0, 228, 39));
//                break;
//            case 2:
//                g.setColor(new Color(0, 78, 228));
//                break;
//            case 3:
//                g.setColor(new Color(228, 98, 0));
//                break;
//            case 4:
//                g.setColor(new Color(158,19, 228));
//                break;
//            case 5:
//                g.setColor(new Color(228, 222, 0));
//                break;
//            case 6:
//                g.setColor(new Color(0, 228, 228));
//                break;
//        }
        

    }
    
    public BufferedImage cargarImagen() {
      
        BufferedImage imagen = null;
        
        try {
            imagen = ImageIO.read(ClassLoader.class.getResource("/images/tetrimino.png"));
            //= ImageIO.read(ClassLoader.class.getResource("images/mino.png"));
        } catch (Exception e) {
            System.out.println("Error cargando imagen!" + e);
        }
        
        return imagen;
    }
}
