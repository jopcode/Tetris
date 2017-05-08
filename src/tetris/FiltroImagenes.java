package tetris;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class FiltroImagenes {
    public BufferedImage escalarImagen(BufferedImage imagenOriginal, int AnchoNuevo, int AltoNuevo) {
        Dupla TamañoImagenOriginal 
                = new Dupla(imagenOriginal.getWidth(), imagenOriginal.getHeight());
    
        BufferedImage ImagenEscalada 
                = new BufferedImage(AnchoNuevo, AltoNuevo, BufferedImage.TYPE_INT_ARGB);
        AffineTransform Transformaciones = new AffineTransform();
        Transformaciones.scale(AnchoNuevo/TamañoImagenOriginal.X, AltoNuevo/TamañoImagenOriginal.Y);
        AffineTransformOp operacion = new AffineTransformOp(Transformaciones, AffineTransformOp.TYPE_BILINEAR);
        operacion.filter(imagenOriginal, ImagenEscalada);
        
        return ImagenEscalada;
    }
}
