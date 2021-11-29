
package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoard implements KeyListener{
  
    private final boolean [] keys;
    
    public static boolean UP, LEFT, RIGHT, SHOOT;
    
    public KeyBoard(){
        this.keys = new boolean[256];
        UP = false;
        LEFT = false;
        RIGHT = false;
        SHOOT = false;
    }
    
    public void update(){
        UP = keys[KeyEvent.VK_UP];
        LEFT = keys[KeyEvent.VK_LEFT];
        RIGHT = keys[KeyEvent.VK_RIGHT];
        SHOOT = keys[KeyEvent.VK_SPACE];
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        keys[ke.getKeyCode()]=true;
    }

    @Override
    public void keyReleased(KeyEvent ke) {
       keys[ke.getKeyCode()]=false;
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
        
    }
}
