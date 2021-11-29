
package gameObject;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import math.Vector2D;


public abstract class GameObject {
    
    protected BufferedImage texture;
    protected Vector2D posicion;

    public GameObject(Vector2D posicion, BufferedImage texture) {
        this.texture = texture;
        this.posicion = posicion;
    }
    
    public abstract void uptate();
    
    public abstract void Draw(Graphics g);

    public Vector2D getPosicion() {
        return posicion;
    }

    public void setPosicion(Vector2D posicion) {
        this.posicion = posicion;
    }
    
    
}
