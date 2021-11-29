
package shocking;

import States.GameState;
import gameObject.constants;
import graphics.Assets;
import input.KeyBoard;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;


public class Shocking extends JFrame implements Runnable{
    
    private Canvas canvas;
    // se crea un hilo para la logica del juego
    private Thread thread;
    private boolean running = false;
    //objetos para dibujar
    private BufferStrategy bs;
    private Graphics g;
    //control de fotogramas
    private final int FPS=60;
    //1segundo = 1000milisegundos = 1000000000nanosegundos
    private double TARGETTIME = 1000000000/FPS;
    //tiempo transcurrido
    private double delta = 0;
    //captura los fotogramas por segundo
    private int AVERAGEFPS = FPS;
    private GameState gameState;
    private KeyBoard keyBoard;
    
    
    public Shocking(){
        //titulo de la ventana
        setTitle("shocking colorful meteors"); 
        //ancho y alto de la ventana
        setSize(constants.WIDTH, constants.HEIGHT);
        //permitir que se pueda cerrar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // para que la ventana no se pueda redimensionar
        setResizable(false); 
        //permitir que la ventana se despliegue en el centro de la ventana
        setLocationRelativeTo(null); 
        
        //crea un area donde podemos dibujar
        canvas = new Canvas();
        keyBoard = new KeyBoard();
        
        canvas.setPreferredSize(new Dimension(constants.WIDTH, constants.HEIGHT));
        canvas.setMaximumSize(new Dimension(constants.WIDTH, constants.HEIGHT));
        canvas.setMinimumSize(new Dimension(constants.WIDTH, constants.HEIGHT));
        //permite entrada por parte del teclado
        canvas.setFocusable(true);
        
        //se agrega a la ventana
        add(canvas);
        
        canvas.addKeyListener(keyBoard);
        
        //para hacer visible la ventana
        setVisible(true);
    }

    
    public static void main(String[] args) {
       new Shocking().Start();
    }
    
  
    public void update(){
        keyBoard.update();
        gameState.update();
    }
    
    public void Draw(){
        bs = canvas.getBufferStrategy();
        
        if(bs==null){
            canvas.createBufferStrategy(3);
            return;
        }
        
        g = bs.getDrawGraphics();
        // ----inicio-dibujo---------
        
        //limpiar posicion con g.clearRect(0, 0, WIDTH, HEIGHT);
        
        g.fillRect(0, 0, constants.WIDTH, constants.HEIGHT);
        //color y posicion del contador
        g.setColor(Color.BLACK);
        
        //dibujamos el jugador
        gameState.Draw(g);
        
        g.drawString("" + AVERAGEFPS , 100, 100);
        
        //------fin-didbujo----------
        g.dispose();
        bs.show();
    }
    
    private void init(){
        Assets.init();
        gameState = new GameState();
    }

    @Override
    public void run() {
        
        long now = 0;
        long lastTime = System.nanoTime();
        int frames = 0;
        long time = 0;
        
        init();
        
        while(running){
            now = System.nanoTime();
            delta += (now - lastTime)/TARGETTIME;
            time += (now - lastTime);
            lastTime = now;
            
            if(delta>=1){
                update();
                Draw();
                delta --;
                frames ++;
            }
            
            if(time >= 1000000000){
                AVERAGEFPS = frames; 
                frames = 0;
                time = 0;
            }
                    
        }
        
        Stop();
    }
    
    private void Start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }
    
    private void Stop(){
        try {
            thread.join();
            running = false;
        } catch (InterruptedException e) {
        }
    }
    
}
