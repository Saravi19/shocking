
package gameObject;

import States.GameState;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import math.Vector2D;


public abstract class MovingObject extends GameObject{
    
    protected Vector2D velocidad;
    protected AffineTransform at;
    protected double angle;
    protected double maxVel;
    protected int width;
    protected int height;
    protected GameState gameState;
    
    
    public MovingObject(Vector2D posicion, Vector2D velocidad,double maxVel, BufferedImage texture,
            GameState gameState) {
        super(posicion, texture);
        this.velocidad = velocidad;
        this.maxVel = maxVel;
        this.gameState = gameState;
        width = texture.getWidth();
        height = texture.getHeight();
        angle = 0;
    }
    
    protected void collidesWidth(){
        
        ArrayList<MovingObject> movingObject = gameState.getMovingobjects();
        
        for(int i = 0; i < movingObject.size(); i++){
            MovingObject m = movingObject.get(i);
            
            if(m.equals(this))
                continue;
            
            double distance = m.getCenter().subtract(getCenter()).getMagtitude();
            
            if(distance < m.width/2 + width/2 && movingObject.contains(this)){
                objectCollision(m, this);
            }
        }
            
    }
    
    private void objectCollision(MovingObject a, MovingObject b){
        
        if(!(a instanceof Meteor && b instanceof Meteor)){
            a.Destroy();
            b.Destroy();
        }
    }
    
    protected void Destroy(){
        gameState.getMovingobjects().remove(this);
    }
    
    protected Vector2D getCenter(){
        return new Vector2D(posicion.getX() + width/2, posicion.getY() + height/2);
    }
     
}
