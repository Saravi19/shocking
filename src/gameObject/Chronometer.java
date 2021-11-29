
package gameObject;


public class Chronometer {
    
    private long delta,lastTame;
    private long time;
    private boolean running;
    
    public Chronometer(){
        delta = 0;
        lastTame = 0;
        running = false; 
    }
    
    public void run(long time){
        running = true;
        this.time = time;
    }
    
    public void update(){
        if(running)
            delta += System.currentTimeMillis() - lastTame;
        if(delta >= time){
            running = false;
            delta = 0;
        }
        
        lastTame = System.currentTimeMillis();
            
    }
    
    public boolean isRunning(){
        return running;
    }
}
