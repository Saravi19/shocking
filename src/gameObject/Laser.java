
package gameObject;

import States.GameState;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import math.Vector2D;



public class Laser extends MovingObject{

    public Laser(Vector2D posicion, Vector2D velocidad, double maxVel, double angle, BufferedImage texture,
            GameState gameState) {
        super(posicion, velocidad, maxVel, texture, gameState);
        this.angle = angle;
        this.velocidad = velocidad.scale(maxVel);
    }

    @Override
    public void uptate() {
        posicion = posicion.add(velocidad);
        
        if(posicion.getX() < 0 || posicion.getX() > constants.WIDTH ||
                posicion.getY() < 0 || posicion.getY() > constants.HEIGHT){
            Destroy();
        }
        
        collidesWidth();
    }

    @Override
    public void Draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        
        at = AffineTransform.getTranslateInstance(posicion.getX()- width/2, posicion.getY());
        
        at.rotate(angle,width/2,0);
        
        g2d.drawImage(texture, at, null);
    }
    
    
    @Override
    public Vector2D getCenter(){
        return new Vector2D(posicion.getX() + width/2, posicion.getY() + width/2);
    }
}
