package game;

import java.awt.Graphics;
import java.awt.Image;



public class Sprite {
	private Image image;
	private int xoffset;
	private int yoffset;
	
	public Sprite (Image image) {
		this.image = image;
		this.xoffset = getWidth() /2;
		this.yoffset = getHeight()/2;
	}
	
	public Sprite (Image image, int xoffset, int yoffset) {
		this.image = image;
		this.xoffset = xoffset;
		this.yoffset = yoffset;
		
	}
	

	public void draw (Graphics g, int x, int y) {
		g.drawImage(image, x - xoffset, y - yoffset, null);
	}
	
	//getter setter
	
	public int getWidth()  {
		 return image.getWidth(null);
	 }
		  
	public int getHeight()  {
		 return image.getHeight(null);
	}
		  
	public int getXOff ()  {
	    return xoffset;
	}
		  
	public int getYOff ()  {
		 return yoffset;
	}
	
	public Image getImage() {
		return image;
	}
	
	
}
