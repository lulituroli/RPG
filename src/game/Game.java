package game;

import game.entity.Block;
import game.entity.Item;
import game.entity.Player;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.Canvas;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends Canvas {
  

	private static final long serialVersionUID = 1L;
	
	private final int WIDTH = 800;
	private final int HEIGHT= 600;
	private final String NAME = "Game";
  
	private long delta = 0;
	private long desiredFPS = 60;
	private long desiredDelta = 1000 / desiredFPS;
	private long lastLoopTime = System.currentTimeMillis();
	
	ArrayList entities = new ArrayList();
	private SpriteStore store = new SpriteStore();
	KeyInputHandler kih;
	MouseInputHandler mih;
	
	private boolean running = false;
	private boolean init = true;
	private boolean debug = false;
	
	private int x = 0;
	
	
	
	private BufferStrategy strategy;
	
	
  
  
	public Game () {
		
		running = true;
    
		JFrame frame = new JFrame (NAME);
		JPanel panel = (JPanel) frame.getContentPane();
    
	    panel.setPreferredSize (new Dimension (WIDTH, HEIGHT));
	    panel.setLayout (null);
	    
	    setBounds (0, 0, WIDTH, HEIGHT);
	    panel.add (this);
	    
	    setIgnoreRepaint (true);
	    
	    frame.pack ();
	    frame.setResizable (false);
	    frame.setVisible (true);
	    
	    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	    
	    frame.requestFocus();
	    
	    createBufferStrategy (2);
	    strategy = getBufferStrategy();
	    
	    kih = new KeyInputHandler();
	    addKeyListener(kih);
	    
	    mih = new MouseInputHandler();
	    addMouseListener(mih);
	    
	}
	
	
	public void init () {
		Entity e = new Player(SpriteStore.get().getSprite("res/tree.png"),200,200);
		entities.add(e);
		for (int i= 0;i<20;i++) {
			e = new Block(SpriteStore.get().getSprite("res/deblock.png"), 50+(i*16), 400);
			entities.add(e);
		}
		e = new Item(SpriteStore.get().getSprite("res/axe.png"),250,200);
		entities.add(e);
		
	}
	
	public void tick() {
		if (init) {
			init = false;
			init();
		}
		
		
//		System.out.println("Tick!");
		
		for (int i = 0; i< entities.size(); i++) {
			Entity e = (Entity) entities.get(i);
			e.update(kih, entities);
		}
		
	}
	
	public void render() {
		
		Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		for (int i = 0; i < entities.size(); i++) {
			Entity e = (Entity)entities.get(i);
			e.draw(g);
			if (debug) {
				e.getMask().draw(g);
			}
			
			
		}
		
		strategy.show();
		
	}
	
	
	public void gameLoop () {
		while (running)	{
			delta = System.currentTimeMillis() - lastLoopTime;
			lastLoopTime = System.currentTimeMillis();
			
			tick ();
			render ();
			
			while (delta <= desiredDelta) {
				try {
					Thread.sleep (2);
				} catch (Exception e) {
					System.out.println (e.getMessage());
				}
				delta +=2;
			}
		}
	}
	  
	public static void main (String[] args) {
		Game game = new Game();
		game.gameLoop();
	    
	  }
	  
}