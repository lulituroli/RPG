package game.content;

import game.Sprite;
import game.entity.Item;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Inventory {
	private ArrayList items = new ArrayList();
	public int size;
	private boolean open = false;
	
	public Inventory (int size) {
		this.size = size;
	}
	
	public void add (Item item) {
		items.add(item);
	}
	
	public void set (int i, Item item) {
		items.set(i, item);
	}
	
	public boolean setIfEmpty (int i, Item item) {
		if(items.isEmpty()) {
			items.set(i, item);
			return true;
		}
		return false;
	}
	
	public boolean isFull () {
		for(int i=0;i<size;i++) {
			if (items.get(i)==null) {
				return false;
			}
		}
		return true;
	}
	
	
	public Item read (int i) {
		return ((Item)items.get(i));
	}
	
	public void draw (Graphics g) {
		if (!open) {
			return;
		}
		int cellsize = 16;
		int columns = 9;
		g.setColor(Color.gray);
		g.fillRect(0, 0, cellsize*columns,cellsize *((size) % columns));
		
		
		for (int i = 0; i < size; i++)  {
		      int x = cellsize * (i % columns);
		      int y = cellsize * ((int)(i / columns));
		      if (i%2 == 0)  {
		        g.setColor(Color.LIGHT_GRAY);
		        g.fillRect(x, y, cellsize, cellsize);
		      }
		}
		
		
		for (int i = 0; i < items.size();i++) {
			Item item = (Item)items.get(i);
			Sprite sprite = item.getSprite();
			int x = cellsize * (i %columns);
			int y = cellsize *(int)(i/columns);
			g.drawImage(sprite.getImage(),x,y,null);
			
		}
	}

	public void setOpen(boolean b) {
		open = true;
		
	}
	
	
	

}
