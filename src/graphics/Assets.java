
package graphics;

import java.awt.Font;
import java.awt.image.BufferedImage;


public class Assets {
    
    public static BufferedImage player;
    
    //efectos
    public static BufferedImage speed;
    
    //laser
    public static BufferedImage blueLaser, greenLaser, redLaser;
    
    //meteoros
    public static BufferedImage[] bigs = new BufferedImage[4];
    public static BufferedImage[] meds = new BufferedImage[2];
    public static BufferedImage[] smalls = new BufferedImage[2];
    public static BufferedImage[] tinies = new BufferedImage[2];
    
    public static BufferedImage blueBtn;
    public static BufferedImage greyBtn;
    
    //fuentes 
    public static Font fontMed;
    public static Font fontsmall;
    public static Font fonttitle;
    public static void init() {
        player = Loader.ImageLoader("/ships/player.png");
        speed = Loader.ImageLoader("/effects/fire08.png");
        blueLaser = Loader.ImageLoader("/lasers/laserBlue01.png");
        greenLaser = Loader.ImageLoader("/lasers/laserGreen11.png");
        redLaser = Loader.ImageLoader("/lasers/laserRed01.png");
        
        
        //fuentes titulo menu 
        fonttitle = Loader.loadFont("/fonts/futureFont.ttf", 42);
        
        //fuente botones
        fontMed = Loader.loadFont("/fonts/futureFont.ttf", 20);
        //fuente titulos h2
        fontsmall = Loader.loadFont("/fonts/futureFont.ttf", 16);
        //imagenes de los botones 
        greyBtn = Loader.ImageLoader("/ui/grey_button.png");
        blueBtn = Loader.ImageLoader("/ui/blue_button.png");
        
        for(int i = 0; i < bigs.length ; i++)
            bigs[i] = Loader.ImageLoader("/meteors/big"+(i+1)+".png");
        
        for(int i = 0; i < meds.length ; i++)
            meds[i] = Loader.ImageLoader("/meteors/med"+(i+1)+".png");
        
        for(int i = 0; i < smalls.length ; i++)
            smalls[i] = Loader.ImageLoader("/meteors/small"+(i+1)+".png");
        
        for(int i = 0; i < tinies.length ; i++)
            tinies[i] = Loader.ImageLoader("/meteors/tiny"+(i+1)+".png");
    }
}
