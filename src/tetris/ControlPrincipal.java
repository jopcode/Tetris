    package tetris;
/*
* Author: @jopcode
*/
public class ControlPrincipal {
    private static SuperficieDeDibujo superficieDeDibujo;
    private static Ventana ventana;
    private static int APS = 0;
    private static int FPS = 0;
   
    public static void main(String[] args) {
        iniciarJuego();
    }
    
    public static void iniciarJuego() {
        crearVentana(950, 600, "Tetris | @jopcode");
        iterarBuclePrincipal();
    }
    
    public static void actualizar() {
        APS++;
        superficieDeDibujo.dibujar();
    }
    
    public static void dibujar() {
        FPS++;
    }
    
    public static void crearVentana(int ancho, int alto, String Nombre) {
        superficieDeDibujo = new SuperficieDeDibujo(ancho, alto);
        ventana = new Ventana(Nombre, superficieDeDibujo);
    }
    
    public static void iterarBuclePrincipal() {
        final int NS_POR_SEGUNDO = 1000000000;
        final int APS_OBJETIVO = 120;
        final int NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO;
        
        long tiempoDeReferenciaActualizacion = System.nanoTime(); 
        long tiempoDeReferenciaContador = System.nanoTime();
                
        double delta = 0;
        double tiempoSinProcesar;
        
        while(true) {
            long tiempoInicial = System.nanoTime();
            tiempoSinProcesar = tiempoInicial - tiempoDeReferenciaActualizacion;
            tiempoDeReferenciaActualizacion = tiempoInicial;
            delta += tiempoSinProcesar/NS_POR_ACTUALIZACION;
            
            while(delta >= 1) {
                delta--;
                actualizar();
            }
         
            dibujar();
           
            if(System.nanoTime() - tiempoDeReferenciaContador > NS_POR_SEGUNDO) {
                System.out.println("APS: " + APS + " FPS: " + FPS);
                tiempoDeReferenciaContador = System.nanoTime();
                
                APS = 0;
                FPS = 0;
            }
        }
        
    }
}


