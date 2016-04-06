package game;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class SpriteStore {
	
	private static SpriteStore single = new SpriteStore();
	
	public static SpriteStore get() {
		return single;
	}
	
	private HashMap sprites = new HashMap();
	private BufferedImage sourceImage = null;
	
	public Sprite getSprite (String ref) {
		if (sprites.get(ref) != null) {
			return (Sprite) sprites.get(ref);
		}
		
		try {
			sourceImage = ImageIO.read (new FileInputStream(ref));
		} catch (Exception e) {
			System.out.println (e.getMessage());
		}
		
		GraphicsConfiguration gc =
			GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
	     		Image image = gc.createCompatibleImage(sourceImage.getWidth(), sourceImage.getHeight(), Transparency.BITMASK);
	     	image.getGraphics().drawImage(sourceImage, 0, 0, null);
		
		Sprite sprite = new Sprite (image);
		sprites.put(ref, sprite);
		
		return sprite;
		
	}
	
	
	
	
	
	
	

}
