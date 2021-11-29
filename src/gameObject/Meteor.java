
package gameObject;

import States.GameState;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import math.Vector2D;


public class Meteor extends MovingObject{
    
    private Size size;

    public Meteor(Vector2D posicion, Vector2D velocidad, double maxVel, BufferedImage texture, 
            GameState gameState, Size size) {
        super(posicion, velocidad, maxVel, texture, gameState);
        this.size = size;
        this.velocidad = velocidad.scale(maxVel);
    }

    @Override
    public void uptate() {
        
        posicion = posicion.add(velocidad);
        
        if(posicion.getX()> constants.WIDTH)
            posicion.setX(-width);
        if(posicion.getY()> constants.HEIGHT)
            posicion.setY(-height);
        
        if(posicion.getX()< -width)
            posicion.setX(constants.WIDTH);
        if(posicion.getY()< -height)
            posicion.setY(constants.HEIGHT);
        
        angle += constants.DELTAANGLE/2;
    }
    
    @Override
    public void Destroy(){
      gameState.divideMeteor(this);
      super.Destroy();
    }

    @Override
    public void Draw(Graphics g) {
        
        Graphics2D g2d = (Graphics2D)g;
        
        at = AffineTransform.getTranslateInstance(posicion.getX(), posicion.getY());
        at.rotate(angle, width/2, height/2 );
        g2d.drawImage(texture, at, null);
    }
    
    public Size getSize(){
        return size;
    }
    
}
