
package States;

import gameObject.Meteor;
import gameObject.MovingObject;
import gameObject.Player;
import gameObject.Size;
import gameObject.constants;
import graphics.Assets;
import graphics.Text;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import math.Vector2D;


public class GameState extends State{//se agrega la clase estado que es la clase del menú.
    
    private Player player;
    private ArrayList<MovingObject> movingobjects = new ArrayList<MovingObject>();
    
    private int meteors;
    
    public GameState (){
        player = new Player(new Vector2D(100,500),new Vector2D(), constants.PLAYER_MAX_VEL, Assets.player,this);
        movingobjects.add(player);
        
        meteors = 1;
        
        startWave();
    }
    
    public void divideMeteor(Meteor meteor){
        
        Size size = meteor.getSize();
        
        BufferedImage[] texture = size.textures;
        
        Size newSize = null;
        
        switch(size){
            case BIG:
                newSize = Size.MED;
                break;
            
            case MED:
                newSize = Size.SMALL;
                break;
                
            case SMALL:
                newSize = Size.TINY;
                break;
            
            default:
                break;
        }
        
        for(int i = 0; i < size.quantity; i++){
            
          movingobjects.add(new Meteor(
                    meteor.getPosicion(), 
                    new Vector2D(0,1).setDireccion(Math.random()*Math.PI*2), 
                    constants.METEOR_VEL*Math.random()+1, 
                    texture[(int)(Math.random()*texture.length)], 
                    this, 
                    newSize));  
        }
    }
    
    private void startWave(){
        
        double x, y;
        
        for(int i = 0; i < meteors; i++){
            x = i % 2 == 0 ? Math.random()*constants.WIDTH : 0;
            y = i % 2 == 0 ? 0 : Math.random()*constants.HEIGHT;
            
            BufferedImage texture = Assets.bigs[(int)(Math.random()*Assets.bigs.length)];
            
            movingobjects.add(new Meteor(
                    new Vector2D(x,y), 
                    new Vector2D(0,1).setDireccion(Math.random()*Math.PI*2), 
                    constants.METEOR_VEL*Math.random()+1, 
                    texture, 
                    this, 
                    Size.BIG ));
        }
        meteors ++;
    }
    
    public void update(){
        for(int i = 0; i<movingobjects.size();i++)
            movingobjects.get(i).uptate();
        
        for(int i = 0; i<movingobjects.size();i++)
            if(movingobjects.get(i) instanceof Meteor)
                return;
        
        startWave();
    }
    
    public void draw(Graphics g){
        
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                
        for(int i = 0; i<movingobjects.size();i++)
            movingobjects.get(i).Draw(g);
        
        
    }

    public ArrayList<MovingObject> getMovingobjects() {
        return movingobjects;
    }

    public void setMovingobjects(ArrayList<MovingObject> movingobjects) {
        this.movingobjects = movingobjects;
    }



   
    
}
