package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class CollisionMask {
	private int w;
	private int h;
	private double x = 0;
	private double y = 0;

	public CollisionMask (int w, int h) {
		this.w = w;
		this.h = h;
	}
	
	public CollisionMask () {	}
	
	
	
	public void setLocation (double x, double y) {
		this.x = x - w/2;
		this.y = y - h/2;
	}
	
	
	public CollisionMask (Sprite sprite) {
		w = sprite.getWidth();
		h = sprite.getHeight();
	}
	
	
	public Rectangle getRect() {
		Rectangle r = new Rectangle((int)x, (int)y, w, h);
		return r;
	}
	
	
	public void centerOnEntity (Entity e) {
		x = e.getX() - w/2;
		y = e.getY() -h/2;
		
	}
	
	public void draw (Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.red);
		g2d.draw(getRect());
	}
	

}
