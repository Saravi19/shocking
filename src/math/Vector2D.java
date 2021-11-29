
package math;


public class Vector2D {
    
    private double x,y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public Vector2D limit(double value){
        if( getMagtitude()> value){
            return this.normalize().scale(value);
        }
        return this;
    }
    
    public Vector2D normalize(){
        
        double magnitude = getMagtitude();
        
        return new Vector2D(x / magnitude, y / magnitude);
    }
    
    public Vector2D scale(double value){
        return new Vector2D(x*value, y*value);
    }
    
    public Vector2D add(Vector2D v){
        return new Vector2D(x + v.getX(), y + v.getY());
    }
    
    public Vector2D subtract(Vector2D v){
        return new Vector2D(x - v.getX(), y - v.getY());
    }
    
    public double getMagtitude(){
        return Math.sqrt(x*x + y*y);
    }
    
    public Vector2D setDireccion(double angle){
        
        double magnitude = getMagtitude();
        
        return new Vector2D(Math.cos(angle)*magnitude,Math.sin(angle)*magnitude);
    }
    
    public Vector2D() {
        x=0;
        y=0;
    } 

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    
}
