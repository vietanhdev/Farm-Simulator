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

		// Feed Buttons
		SelectableButton btnWater = new SelectableButton("water", 64, 0, 64, 64, Assets.btn_water);
		btnWater.setClicker(new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
				uiManager.setSelectedBtn(btnWater);
			}
		});
		uiManager.addObject(btnWater);
		
		FoodSelectButton btnFishFood = new FoodSelectButton("fishfood", 2*64, 0, 64, 64, Assets.fish_down[0]);
		btnFishFood.setClicker(new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
				uiManager.setSelectedBtn(btnFishFood);
			}
		});
		uiManager.addObject(btnFishFood);
		
		FoodSelectButton btnTurtleFood = new FoodSelectButton("turtlefood", 3*64, 0, 64, 64, Assets.turtle_right[0]);
		btnTurtleFood.setClicker(new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
				uiManager.setSelectedBtn(btnTurtleFood);
			}
		});
		uiManager.addObject(btnTurtleFood);
		
		FoodSelectButton btnCowFood = new FoodSelectButton("cowfood", 4*64, 0, 64, 64, Assets.cow_right[0]);
		btnCowFood.setClicker(new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
				uiManager.setSelectedBtn(btnCowFood);
			}
		});
		uiManager.addObject(btnCowFood);
		
		FoodSelectButton btnDogFood = new FoodSelectButton("dogfood", 5*64, 0, 64, 64, Assets.dog_right[0]);
		btnDogFood.setClicker(new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
				uiManager.setSelectedBtn(btnDogFood);
			}
		});
		uiManager.addObject(btnDogFood);
		
		FoodSelectButton btnChickenFood = new FoodSelectButton("chickenfood", 6*64, 0, 64, 64, Assets.chicken_right[0]);
		btnChickenFood.setClicker(new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
				uiManager.setSelectedBtn(btnChickenFood);
			}
		});
		uiManager.addObject(btnChickenFood);
		
		FoodSelectButton btnHorseFood = new FoodSelectButton("horsefood", 7*64, 0, 64, 64, Assets.horse_right[0]);
		btnHorseFood.setClicker(new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
				uiManager.setSelectedBtn(btnHorseFood);
			}
		});
		uiManager.addObject(btnHorseFood);
		
		FoodSelectButton btnPigFood = new FoodSelectButton("pigfood", 8*64, 0, 64, 64, Assets.pig_right[0]);
		btnPigFood.setClicker(new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
				uiManager.setSelectedBtn(btnPigFood);
			}
		});
		uiManager.addObject(btnPigFood);
		
		
		// Add creature buttons
		AddCreatureButton btnAddFish = new AddCreatureButton("Add Fish", 10*64, 0, 64, 64, Assets.fish_right[0]);
		btnAddFish.setClicker(new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
				uiManager.setSelectedBtn(btnAddFish);
			}
		});
		uiManager.addObject(btnAddFish);
		
		AddCreatureButton btnAddTurtle = new AddCreatureButton("Add Turtle", 11*64, 0, 64, 64, Assets.turtle_right[0]);
		btnAddTurtle.setClicker(new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
				uiManager.setSelectedBtn(btnAddTurtle);
			}
		});
		uiManager.addObject(btnAddTurtle);
		
		AddCreatureButton btnAddCow = new AddCreatureButton("Add Cow", 12*64, 0, 64, 64, Assets.cow_right[0]);
		btnAddCow.setClicker(new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
				uiManager.setSelectedBtn(btnAddCow);
			}
		});
		uiManager.addObject(btnAddCow);
		
		AddCreatureButton btnAddDog = new AddCreatureButton("Add Dog", 13*64, 0, 64, 64, Assets.dog_right[0]);
		btnAddDog.setClicker(new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
				uiManager.setSelectedBtn(btnAddDog);
			}
		});
		uiManager.addObject(btnAddDog);
				
		AddCreatureButton btnAddChicken = new AddCreatureButton("Add Chicken", 14*64, 0, 64, 64, Assets.chicken_right[0]);
		btnAddChicken.setClicker(new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
				uiManager.setSelectedBtn(btnAddChicken);
			}
		});
		uiManager.addObject(btnAddChicken);
		
		
		AddCreatureButton btnAddHorse = new AddCreatureButton("Add Horse", 15*64, 0, 64, 64, Assets.horse_right[0]);
		btnAddHorse.setClicker(new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
				uiManager.setSelectedBtn(btnAddHorse);
			}
		});
		uiManager.addObject(btnAddHorse);
		
		AddCreatureButton btnAddPig = new AddCreatureButton("Add Pig", 16*64, 0, 64, 64, Assets.pig_right[0]);
		btnAddPig.setClicker(new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
				uiManager.setSelectedBtn(btnAddPig);
			}
		});
		uiManager.addObject(btnAddPig);
		
		
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
