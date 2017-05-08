package tetris;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Ventana extends JFrame{

    public Ventana(String nombre, SuperficieDeDibujo superficieDeDibujo) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(nombre);
        this.setIconImage(superficieDeDibujo.imagen.cargarImagen("icon", ".png"));
        //this.setSize(600,600);
        this.setResizable(true);
        this.setLayout(new BorderLayout());
        this.add(superficieDeDibujo);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
}
