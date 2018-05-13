package dev.hust.funnyfarm.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import dev.hust.funnyfarm.Handler;
import dev.hust.funnyfarm.gfx.Assets;

public class UIManager {

	private Handler handler;
	private ArrayList<UIObject> objects;
	private SelectableButton selectedBtn;
	
	public UIManager(Handler handler){
		this.handler = handler;
		objects = new ArrayList<UIObject>();
		
		createButtons();
		
		this.addObject(new UIImageButton("Increase Time Speed", 128, 64, 40, 40, Assets.btn_add, new ClickListener() {
			@Override
			public void onClick() {
				int newTimeSpeed = getHandler().getGame().getTimeSpeed() + 10;
				getHandler().getGame().setTimeSpeed(newTimeSpeed);
			}
		}));
		
		this.addObject(new UIImageButton("Decrease Time Speed", 168, 64, 40, 40, Assets.btn_sub, new ClickListener() {
			@Override
			public void onClick() {
				int newTimeSpeed = getHandler().getGame().getTimeSpeed() - 10;
				if (newTimeSpeed <= 0) {
					newTimeSpeed = 1;
				}
				getHandler().getGame().setTimeSpeed(newTimeSpeed);
			}
		}));
		
		this.addObject(new UIImageButton("Reset Time Speed", 208, 64, 40, 40, Assets.btn_reset, new ClickListener() {
			@Override
			public void onClick() {
				int newTimeSpeed = getHandler().getGame().DEFAULT_TIMESPEED;
				getHandler().getGame().setTimeSpeed(newTimeSpeed);
			}
		}));
	}
	
	public void tick(){
		for(UIObject o : objects)
			o.tick();
	}
	
	public void render(Graphics g){
		
		// Draw menu bar
		g.setColor(Color.decode("#54442C"));
		g.fillRect(0, 0, 19*64, 64);
		g.setColor(Color.decode("#F5FECD"));
		g.fillRect(2, 2, 19*64-4, 64-4);
		
		g.setColor(Color.decode("#F5FECD"));
		g.fillRect(0, 64, 3*64, 40);
		
		g.setFont(new Font("TimesRoman", Font.BOLD, 16)); 
		g.setColor(Color.decode("#54442C"));
		g.drawString("Feed", 10, 32);
		
		g.drawString("Add", 10*64 + 10, 32);
		g.drawString("More", 10*64 + 2, 50);
		
		g.setColor(Color.decode("#54442C"));
		g.fillRect(0, 64, 8*64, 40);
		g.setColor(Color.decode("#F5FECD"));
		g.fillRect(2, 66, 8*64-4, 40-4);
		
		g.setColor(Color.BLACK);
		g.drawString("Time", 5, 64 + 16);
		g.drawString("Speed", 5, 64 + 32);
		g.setColor(Color.decode("#FFFFFF"));
		g.fillRect(66, 66, 64, 40-4);
		g.setColor(Color.BLACK);
		g.drawString("" + getHandler().getGame().getTimeSpeed(), 5+64, 64 + 25);
		
		g.drawString("SimTime", 252, 64 + 25);
		g.setColor(Color.decode("#FFFFFF"));
		g.fillRect(350, 66, 150, 40-4);
		g.setColor(Color.BLACK);
		g.drawString("" + getHandler().getGame().getSimTime(), 352, 64 + 25);
		
		for(UIObject o : objects)
			o.render(g);
	}
	
	public void onMouseMove(MouseEvent e){
		for(UIObject o : objects)
			o.onMouseMove(e);
	}
	
	public void onMouseRelease(MouseEvent e){
		for(UIObject o : objects)
			o.onMouseRelease(e);
	}
	
	public void addObject(UIObject o){
		objects.add(o);
	}
	
	public void removeObject(UIObject o){
		objects.remove(o);
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public ArrayList<UIObject> getObjects() {
		return objects;
	}

	public void setObjects(ArrayList<UIObject> objects) {
		this.objects = objects;
	}

	public SelectableButton getSelectedBtn() {
		return selectedBtn;
	}

	public void setSelectedBtn(SelectableButton selectedBtn) {
		if (getSelectedBtn() != null) {
			getSelectedBtn().setSelected(false);
		}
		selectedBtn.setSelected(true);
		this.selectedBtn = selectedBtn;
	}
	
	
	private void createButtons() {
		// Feed Buttons
		SelectableButton btnWater = new SelectableButton("water", 64, 0, 64, 64, Assets.btn_water);
		btnWater.setClicker(new ClickListener() {
			@Override
			public void onClick() {
				setSelectedBtn(btnWater);
			}
		});
		this.addObject(btnWater);
		
		FoodSelectButton btnFishFood = new FoodSelectButton("fishfood", 2*64, 0, 64, 64, Assets.fish_down[0]);
		btnFishFood.setClicker(new ClickListener() {
			@Override
			public void onClick() {
				setSelectedBtn(btnFishFood);
			}
		});
		this.addObject(btnFishFood);
		
		FoodSelectButton btnTurtleFood = new FoodSelectButton("turtlefood", 3*64, 0, 64, 64, Assets.turtle_right[0]);
		btnTurtleFood.setClicker(new ClickListener() {
			@Override
			public void onClick() {
				setSelectedBtn(btnTurtleFood);
			}
		});
		this.addObject(btnTurtleFood);
		
		FoodSelectButton btnCowFood = new FoodSelectButton("cowfood", 4*64, 0, 64, 64, Assets.cow_right[0]);
		btnCowFood.setClicker(new ClickListener() {
			@Override
			public void onClick() {
				setSelectedBtn(btnCowFood);
			}
		});
		this.addObject(btnCowFood);
		
		FoodSelectButton btnDogFood = new FoodSelectButton("dogfood", 5*64, 0, 64, 64, Assets.dog_right[0]);
		btnDogFood.setClicker(new ClickListener() {
			@Override
			public void onClick() {
				setSelectedBtn(btnDogFood);
			}
		});
		this.addObject(btnDogFood);
		
		FoodSelectButton btnChickenFood = new FoodSelectButton("chickenfood", 6*64, 0, 64, 64, Assets.chicken_right[0]);
		btnChickenFood.setClicker(new ClickListener() {
			@Override
			public void onClick() {
				setSelectedBtn(btnChickenFood);
			}
		});
		this.addObject(btnChickenFood);
		
		FoodSelectButton btnHorseFood = new FoodSelectButton("horsefood", 7*64, 0, 64, 64, Assets.horse_right[0]);
		btnHorseFood.setClicker(new ClickListener() {
			@Override
			public void onClick() {
				setSelectedBtn(btnHorseFood);
			}
		});
		this.addObject(btnHorseFood);
		
		FoodSelectButton btnPigFood = new FoodSelectButton("pigfood", 8*64, 0, 64, 64, Assets.pig_right[0]);
		btnPigFood.setClicker(new ClickListener() {
			@Override
			public void onClick() {
				setSelectedBtn(btnPigFood);
			}
		});
		this.addObject(btnPigFood);
		
		
		FoodSelectButton btnFlowerFood = new FoodSelectButton("flowerfood", 9*64, 0, 64, 64, Assets.flower_big[0]);
		btnFlowerFood.setClicker(new ClickListener() {
			@Override
			public void onClick() {
				setSelectedBtn(btnFlowerFood);
			}
		});
		this.addObject(btnFlowerFood);
		
		
		// Add creature buttons
		AddCreatureButton btnAddFish = new AddCreatureButton("Add Fish", 11*64, 0, 64, 64, Assets.fish_right[0]);
		btnAddFish.setClicker(new ClickListener() {
			@Override
			public void onClick() {
				setSelectedBtn(btnAddFish);
			}
		});
		this.addObject(btnAddFish);
		
		AddCreatureButton btnAddTurtle = new AddCreatureButton("Add Turtle", 12*64, 0, 64, 64, Assets.turtle_right[0]);
		btnAddTurtle.setClicker(new ClickListener() {
			@Override
			public void onClick() {
				setSelectedBtn(btnAddTurtle);
			}
		});
		this.addObject(btnAddTurtle);
		
		AddCreatureButton btnAddCow = new AddCreatureButton("Add Cow", 13*64, 0, 64, 64, Assets.cow_right[0]);
		btnAddCow.setClicker(new ClickListener() {
			@Override
			public void onClick() {
				setSelectedBtn(btnAddCow);
			}
		});
		this.addObject(btnAddCow);
		
		AddCreatureButton btnAddDog = new AddCreatureButton("Add Dog", 14*64, 0, 64, 64, Assets.dog_right[0]);
		btnAddDog.setClicker(new ClickListener() {
			@Override
			public void onClick() {
				setSelectedBtn(btnAddDog);
			}
		});
		this.addObject(btnAddDog);
				
		AddCreatureButton btnAddChicken = new AddCreatureButton("Add Chicken", 15*64, 0, 64, 64, Assets.chicken_right[0]);
		btnAddChicken.setClicker(new ClickListener() {
			@Override
			public void onClick() {
				setSelectedBtn(btnAddChicken);
			}
		});
		this.addObject(btnAddChicken);
		
		
		AddCreatureButton btnAddHorse = new AddCreatureButton("Add Horse", 16*64, 0, 64, 64, Assets.horse_right[0]);
		btnAddHorse.setClicker(new ClickListener() {
			@Override
			public void onClick() {
				setSelectedBtn(btnAddHorse);
			}
		});
		this.addObject(btnAddHorse);
		
		AddCreatureButton btnAddPig = new AddCreatureButton("Add Pig", 17*64, 0, 64, 64, Assets.pig_right[0]);
		btnAddPig.setClicker(new ClickListener() {
			@Override
			public void onClick() {
				setSelectedBtn(btnAddPig);
			}
		});
		this.addObject(btnAddPig);
		
		AddCreatureButton btnAddFlower = new AddCreatureButton("Add Flower", 18*64, 0, 64, 64, Assets.flower_big[0]);
		btnAddFlower.setClicker(new ClickListener() {
			@Override
			public void onClick() {
				setSelectedBtn(btnAddFlower);
			}
		});
		this.addObject(btnAddFlower);
	}
}
