package dev.hust.funnyfarm;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.hust.funnyfarm.display.Display;
import dev.hust.funnyfarm.gfx.Assets;
import dev.hust.funnyfarm.gfx.GameCamera;
import dev.hust.funnyfarm.input.KeyManager;
import dev.hust.funnyfarm.input.MouseManager;
import dev.hust.funnyfarm.states.GameState;
import dev.hust.funnyfarm.states.State;

public class Game implements Runnable {

	public final int DEFAULT_TIMESPEED = 60;
	
	int timeSpeed = DEFAULT_TIMESPEED; // fps
	private Display display;
	private int width, height;
	public String title;
	
	private long simTime;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//States
	public State gameState;
	
	//Input
	private KeyManager keyManager;
	private MouseManager mouseManager;
	
	//Camera
	private GameCamera gameCamera;
	
	//Handler
	private Handler handler;
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
		simTime = 0;
	}
	
	private void init(){
		
		// Game display
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		Assets.init();

		
		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);
		
		gameState = new GameState(handler);
		State.setState(gameState);
		
		
		
	}
	
	private void tick(){
		keyManager.tick();
		
		if(handler.getKeyManager().up)
			handler.getGameCamera().move(0, -10);
		
		if(handler.getKeyManager().down)
			handler.getGameCamera().move(0, 10);
		
		if(handler.getKeyManager().left)
			handler.getGameCamera().move(-10, 0);
		
		if(handler.getKeyManager().right)
			handler.getGameCamera().move(10, 0);
		
		if(State.getState() != null)
			State.getState().tick();
		
	}
	
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//Clear Screen
		g.clearRect(0, 0, width, height);
		//Draw Here!
		
		if(State.getState() != null)
			State.getState().render(g);
		
		//End Drawing!
		bs.show();
		g.dispose();
	}
	
	public void run(){
		
		init();
		
		
		double timePerTick = 1000000000 / getTimeSpeed();
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		
		while(running){
			now = System.nanoTime();
			timePerTick = 1000000000 / getTimeSpeed();
			delta += (now - lastTime) / timePerTick * 2;
			lastTime = now;
			
			if(delta >= 1){
				tick();
				render();
				delta--;
				increaseSimTime(1);
			}
			

			if (getSimTime() > 1000000000000000l) {
				setSimTime(0);
			}
			
			// Handle clicks
			if(getHandler().getMouseManager().isMouseClicked()) {
				int clickedX = getHandler().getMouseManager().getMouseClickedX();
				int clickedY = getHandler().getMouseManager().getMouseClickedY();
				
				System.out.println(clickedX + "   " + clickedY);
			}
			
		}
		
		stop();
		
	}
	
	public KeyManager getKeyManager(){
		return keyManager;
	}
	
	public MouseManager getMouseManager(){
		return mouseManager;
	}
	
	public GameCamera getGameCamera(){
		return gameCamera;
	}
	
	
	public void setTimeSpeed(int s) {
		timeSpeed = s;
	}
	
	public int getTimeSpeed() {
		return timeSpeed;
	}
	
	public long getSimTime() {
		return simTime;
	}
	
	public void setSimTime(long simTime) {
		this.simTime = simTime;
	}
	
	public void increaseSimTime(long amount) {
		this.simTime += amount;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public Handler getHandler() {
		return handler;
	}
	
	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}











