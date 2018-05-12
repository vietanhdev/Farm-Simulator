package dev.hust.funnyfarm.states;

import java.awt.Graphics;

import dev.hust.funnyfarm.Handler;
import dev.hust.funnyfarm.ui.UIManager;
import dev.hust.funnyfarm.worlds.World;

public class GameState extends State {
	
	private UIManager uiManager;
	private World world;
	
	public GameState(Handler handler){
		super(handler);
		world = new World(handler, "/worlds/world1.txt");
		handler.setWorld(world);
		
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);

		
	}
	
	@Override
	public void tick() {
		world.tick();
		uiManager.tick();
		
		handler.getMouseManager().setUIManager(uiManager);
		//State.setState(handler.getGame().gameState);
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		uiManager.render(g);
	}
	
	public UIManager getUIManager () {
		return uiManager;
	}

}
