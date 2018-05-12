package dev.hust.funnyfarm.states;

import java.awt.Graphics;

import dev.hust.funnyfarm.Handler;
import dev.hust.funnyfarm.gfx.Assets;
import dev.hust.funnyfarm.ui.AddCreatureButton;
import dev.hust.funnyfarm.ui.ClickListener;
import dev.hust.funnyfarm.ui.FoodSelectButton;
import dev.hust.funnyfarm.ui.SelectableButton;
import dev.hust.funnyfarm.ui.UIManager;
import dev.hust.funnyfarm.worlds.World;

public class GameState extends State {
	
	private UIManager uiManager;
	private World world;
	
	public GameState(Handler handler){
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
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

}
