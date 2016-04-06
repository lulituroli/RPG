package game.entity;

import game.Entity;
import game.Sprite;
import game.SpriteStore;

public class Player extends Entity {

	public Player(Sprite sprite, double x, double y) {
		super(sprite, x, y);
		setControlled(true);
		setColliding(true);
		
		for (int i = 0; i < 32; i++)  {
		      getInv().add(new Item (SpriteStore.get().getSprite("res/axe.png"), 200, 200));
		}
		getInv().setOpen (true);
		
	}
	
	
	
	
	
	
	
	
	
	

}
