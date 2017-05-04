package tetris;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

public class SuperficieDeDibujo extends Canvas{
    private BufferStrategy buffer;
    private Graphics g;
    
    Imagen imagen;
    Tablero tablero;
    Pieza pieza;
    
    public SuperficieDeDibujo(int ancho, int alto) {
        setSize(ancho, alto);
        tablero = new Tablero(this);
        imagen = new Imagen(this);
        tablero.imagen = imagen;
        pieza = new Pieza(this);
        capturarTeclas();
        setFocusable(true);
    }
    
    public void dibujar() {
        buffer = getBufferStrategy();
        
        if(buffer==null) {
            createBufferStrategy(2);
            return;
        }
    
        g = buffer.getDrawGraphics();
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        
        tablero.dibujar((Graphics2D)g);
        
        pieza.dibujar(g);
        
        g.dispose();
        buffer.show();
    }
    
    public void capturarTeclas() {
        addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                   pieza.moverDerecha();
                   return;
                }
                if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                   pieza.moverIzquierda();
                   return;
                }
                if(e.getKeyCode() == KeyEvent.VK_UP) {
                   pieza.girarDerecha();
                   return;
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN) {
                   pieza.moverAbajo();
                   return;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });
    }
}
