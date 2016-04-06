package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class KeyInputHandler extends KeyAdapter{
	private boolean leftPressed  = false;
	private boolean rightPressed = false;
	private boolean upPressed    = false;
	private boolean downPressed  = false;
	  
	  
	public KeyInputHandler ()  {  }
	public void keyPressed (KeyEvent e)  {
		
		if (e.getKeyCode() == KeyEvent.VK_LEFT)  {
	      leftPressed = true;
	    }
	    if (e.getKeyCode() == KeyEvent.VK_RIGHT)  {
	      rightPressed = true;
	    }
	    if (e.getKeyCode () == KeyEvent.VK_UP)  {
	      upPressed = true;
	    }
	    if (e.getKeyCode () == KeyEvent.VK_DOWN)  {
	      downPressed = true;
	    }
	    
	}
	  
	  public void keyReleased (KeyEvent e)  {
	    if (e.getKeyCode() == KeyEvent.VK_LEFT)  {
	      leftPressed = false;
	    }
	    if (e.getKeyCode() == KeyEvent.VK_RIGHT)  {
	      rightPressed = false;
	    }
	    if (e.getKeyCode () == KeyEvent.VK_UP)  {
	      upPressed = false;
	    }
	    if (e.getKeyCode () == KeyEvent.VK_DOWN)  {
	      downPressed = false;
	    }
	    
	    if (e.getKeyChar () == 27)  {
	      System.exit(0);
	    }
	  }
	  
	  public boolean getLeft ()  {
	    return leftPressed;
	  }
	  public boolean getRight ()  {
	    return rightPressed;
	  }
	  public boolean getUp ()  {
	    return upPressed;
	  }
	  public boolean getDown ()  {
	    return downPressed;
	  }
}
