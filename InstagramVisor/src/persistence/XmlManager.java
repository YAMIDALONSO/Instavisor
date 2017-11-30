
package persistence;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class XmlManager {
    
    public ImageIcon getWebImage(String imageUrl) throws MalformedURLException, IOException{
        URL url = new URL(imageUrl);
        BufferedImage image = ImageIO.read(url);
        
        return new ImageIcon(image);
    }
}