package game;

import game.content.Inventory;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Entity {
	private double x;
	private double y;
	private double dx = 0;
	private double dy = 0;
	private double speed = 1;
	
	
	private boolean controlled = false;
	private boolean collides = false;
	private boolean collided = false;
	
	
	private CollisionMask mask;
	private Sprite sprite;
	private Inventory inv = new Inventory(20);
	
	public Entity (Sprite sprite, double x, double y) {
		this.sprite = sprite;
		this.x = x;
		this.y = y;
		mask = new CollisionMask(sprite);
		
		System.out.println (this.toString() + ", " + sprite.toString() + " @ " + x + ", "+ y);
		
		
	}
	
	public void control(KeyInputHandler kih) {
		if (kih.getLeft()) {
			dx = -1;
		}
		
		if (kih.getRight()) {
			dx = 1;
		}
		
		if (kih.getUp()) {
			dy = -1;
		}
		
		if (kih.getDown()) {
			dy = 1;
		}
	}
	
	
	public void move (ArrayList e) {
		if(!collides) {
			x += dx * speed;
			y += dy * speed;
		}
		else {
			mask.setLocation (x+dx,y);
			if(!collidesWithAny(e)) {
				x += dx;
			}
			else {
				collided = true;
			}
			mask.setLocation (x,y+dy);
			if (!collidesWithAny(e)) {
				y += dy;
			}
			else {
				collided = true;
			}
			mask.setLocation (x,y);
		}
		
		
		
			}
	
	
	public boolean collidesWith (Entity e) {
		Rectangle r = mask.getRect();
		
		
		//System.out.println("bumm!");
		return r.intersects(e.getMask().getRect());
		
		
	}
	
	public boolean collidesWithAny (ArrayList e) {
		for (int i = 0; i < e.size(); i++) {
			if ((this!=(Entity)e.get(i)) && collidesWith((Entity) e.get(i))) {
				return true;
			}
		}
		return false;
		
	}
	
	
	public void update(KeyInputHandler kih, ArrayList e) {
		dx = 0;
		dy = 0;
		
		
		if (controlled) {
			control(kih);
		}
		
		
		move(e);
		mask.centerOnEntity(this);
	}
		
	public void draw (Graphics g) {
		sprite.draw(g, (int)x, (int)y);
		inv.draw(g);
	}
	
	
	
	
	//getter setter
	
	
	public CollisionMask getMask() {
		return mask;
	}

	public Sprite getSprite () {
		return sprite;
	}

	public boolean isControlled() {
		return controlled;
	}
	
	public Inventory getInv() {
		return inv;
	}
	
 	public void setControlled(boolean controlled) {
		this.controlled = controlled;
	}
	
	public double getX () {
		return x;
	}
	
	public double getY () {
		return y;
	}
	
	public void setX (double x) {
		this.x = x;
	}
	
	public void setY (double y) {
		this.y = y;
	}
	
	public boolean isColliding () {
		return collides;
	}

	public void setColliding (boolean collides ) {
		this.collides = collides;
	}
	
}
