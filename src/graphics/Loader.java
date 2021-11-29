
package graphics;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class Loader {
    
    public static BufferedImage ImageLoader(String path){
        try {
            return ImageIO.read(Loader.class.getResource(path));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
