package game;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInputHandler extends MouseAdapter {
	
	private boolean leftClicked = false;
	private boolean rightClicked = false;
	private int x = 0;
	private int y = 0;
	
	

	public MouseInputHandler() {}
	
	public void mousePressed (MouseEvent e) {
		x = e.getX();
		y = e.getY();
		
		if (e.getButton() == MouseEvent.BUTTON1) {
			leftClicked = true;
			//System.out.println ("left!"  + x + ", " +  y);
		}
		if (e.getButton() == MouseEvent.BUTTON3) {
			rightClicked = true;
			//System.out.println ("right!" + x + ", " +  y);
		}
	}
	
	
	public void mouseReleased (MouseEvent e) {
		x = e.getX();
		y = e.getY();
		
		if (e.getButton() == MouseEvent.BUTTON1) {
			leftClicked = false;
		}
		if (e.getButton() == MouseEvent.BUTTON3) {
			leftClicked = false;
		}
		
	}
	
	public void mouseMoved (MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}
	
	
	
	//getter setter
	
	public boolean getLeft () {
		return leftClicked;
	}
	
	public boolean getRight () {
		return rightClicked;
	}
	
	public int getX () {
		return x;
	}
	public int getY () {
		return y;
	}
	
	
	

}
