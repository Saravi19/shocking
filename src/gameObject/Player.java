
package gameObject;

import States.GameState;
import graphics.Assets;
import input.KeyBoard;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import math.Vector2D;


public class Player extends MovingObject{

    private Vector2D heading;
    private Vector2D Acceleration;
    private boolean accelerating = false;
    private Chronometer fireRate;
    
    public Player(Vector2D posicion, Vector2D velocidad,double maxVel, BufferedImage texture, GameState gameState) {
        super(posicion, velocidad, maxVel, texture, gameState);
        heading = new Vector2D(0,1);
        Acceleration = new Vector2D();
        fireRate = new Chronometer();
    }

    @Override
    public void uptate() {
        
        if(KeyBoard.SHOOT && !fireRate.isRunning()){
            gameState.getMovingobjects().add(0,new Laser(
                    getCenter().add(heading.scale(width)), 
                    heading, 
                    constants.LASER_VEL, 
                    angle, 
                    Assets.redLaser,
                    gameState));
            fireRate.run(constants.FIRERATE);
        }
        
        if(KeyBoard.RIGHT)
            angle += constants.DELTAANGLE ;
        if(KeyBoard.LEFT)
            angle -= constants.DELTAANGLE;
        if(KeyBoard.UP){
            Acceleration = heading.scale(constants.ACC);
            accelerating = true;
        }
        else{
            if(velocidad.getMagtitude()!= 0){
                Acceleration = (velocidad.scale(-1).normalize()).scale(constants.ACC);
                accelerating = false;
            }
        }
        
        velocidad = velocidad.add(Acceleration);
        velocidad = velocidad.limit(maxVel);
        heading = heading.setDireccion(angle - Math.PI/2);
        posicion = posicion.add(velocidad);
        
        if(posicion.getX()> constants.WIDTH)
            posicion.setX(0);
        if(posicion.getY()> constants.HEIGHT)
            posicion.setY(0);
        
        if(posicion.getX()< 0)
            posicion.setX(constants.WIDTH);
        if(posicion.getY()< 0)
            posicion.setY(constants.HEIGHT);
        
        fireRate.update();
        collidesWidth();
        
    }

    @Override
    public void Draw(Graphics g) {
        
        Graphics2D g2d = (Graphics2D)g;
        
        AffineTransform at1 = AffineTransform.getTranslateInstance(posicion.getX() + width/2 + 5,
                posicion.getY() + height/2 + 10);
        AffineTransform at2 = AffineTransform.getTranslateInstance(posicion.getX() + 5, posicion.getY() + height/2 + 10);
        at1.rotate(angle, -5, -10);
        at2.rotate(angle,width/2 - 5, - 10);
        
        if(accelerating){
            g2d.drawImage(Assets.speed, at1, null);
            g2d.drawImage(Assets.speed, at2, null);
        }
        
        
        at = AffineTransform.getTranslateInstance(posicion.getX(), posicion.getY());
        at.rotate(angle, width/2, height/2 );
        g2d.drawImage(texture, at, null);
        
    }
    
}
