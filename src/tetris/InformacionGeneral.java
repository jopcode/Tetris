package tetris;

public interface InformacionGeneral {
   int TETRIMINO_Z = 0,
       TETRIMINO_S = 1,
       TETRIMINO_J = 2,
       TETRIMINO_L = 3,
       TETRIMINO_T = 4,
       TETRIMINO_O = 5,
       TETRIMINO_I = 6;
   int NO_TETRIMINO = -1;
   
   int[] TETRIMINOS_NOMBRE = {TETRIMINO_Z, TETRIMINO_S, TETRIMINO_J, TETRIMINO_L, 
       TETRIMINO_T, TETRIMINO_O, TETRIMINO_I, NO_TETRIMINO};
   
   int COLUMNAS = 10, FILAS = 20;
   
   int ANCHO_MINO = 28,
       ALTO_MINO = 28;
   
   int ANCHO_TABLERO = COLUMNAS * ANCHO_MINO,
       ALTO_TABLERO = FILAS * ALTO_MINO;
   
}
