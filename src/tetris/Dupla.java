package tetris;

public class Dupla {
    double X,Y;

    public Dupla(double x, double y) {
        this.X = x;
        this.Y = y;
    }
    
    
    public void moverDerecha() {
        X++;
    }
    public void moverIzquierda() {
        X--;
    }
    
    public void moverAbajo() {
        Y++;
    }
    
    public void moverArriba() {
        Y--;
    }
    
    public void girarDerecha() {
        double temp = X;
        X = -Y;
        Y = temp;
    }
    
    public void girarIzquierda() {
        double temp = X;
        X = Y;
        Y = -temp;
    }
    
    public double getX() {
        return X;
    }

    public void setX(double x) {
        this.X = x;
    }

    public double getY() {
        return Y;
    }

    public void setY(double y) {
        this.Y = y;
    }
    
    public int intX() {
        return (int)X;
    }

    public int intY() {
        return (int)Y;
    }
}
