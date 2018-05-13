package dev.hust.funnyfarm.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
//import java.util.Comparator;
import java.util.Iterator;

import dev.hust.funnyfarm.Handler;
import dev.hust.funnyfarm.entities.creatures.Creature;
import dev.hust.funnyfarm.entities.creatures.FoodType;
import dev.hust.funnyfarm.entities.creatures.animals.*;
import dev.hust.funnyfarm.entities.creatures.plants.*;
import dev.hust.funnyfarm.states.GameState;
import dev.hust.funnyfarm.ui.SelectableButton;


public class EntityManager {
	
	private Handler handler;
	private ArrayList<Entity> entities;
	
	// VietAnhDev: Because a bug in sorter. I disabled this function
//	private Comparator<Entity> renderSorter = new Comparator<Entity>(){
//		@Override
//		public int compare(Entity a, Entity b) {
//			if(a.getY() + a.getHeight() < b.getY() + b.getHeight())
//				return -1;
//			return 1;
//		}
//	};
	
	public EntityManager(Handler handler){
		this.handler = handler;
		entities = new ArrayList<Entity>();
	}
	
	public void tick(){
		
		//=============================================
		// Handle click on an entity
		
		boolean isClicked = getHandler().getMouseManager().isMouseClicked();
		

		// x, y of click with game camera offset
		int xClicked = 0, yClicked = 0;
		
		if (isClicked) {
			
			xClicked = getHandler().getMouseManager().getMouseClickedX() + (int)getHandler().getGameCamera().getxOffset();
			yClicked = getHandler().getMouseManager().getMouseClickedY() + (int)getHandler().getGameCamera().getyOffset();
			
			// Skip if click area in tool bar
			if (getHandler().getMouseManager().getMouseClickedY() < 105) {
				isClicked = false;
			}
		}
		
		
		// === Click to add a creature ===
		SelectableButton selectedBtn = null;
		String name = null;
		if (isClicked) {
			GameState gameState = (GameState) getHandler().getGame().getGameState();
			selectedBtn = gameState.getUIManager().getSelectedBtn();
			
			if (selectedBtn != null) {
				name = selectedBtn.getName();
				
				if (name.contains("Add")) {
					int xPos = xClicked;
					int yPos = yClicked;
					
					Creature newEntity = null;
					switch (name) {
					case "Add Fish": newEntity = new Fish(handler, xPos, yPos);  this.addEntity(newEntity); break;
					case "Add Turtle": newEntity = new Turtle(handler, xPos, yPos);  this.addEntity(newEntity); break;
					case "Add Horse": newEntity = new Horse(handler, xPos, yPos);  this.addEntity(newEntity); break;
					case "Add Cow": newEntity = new Cow(handler, xPos, yPos);  this.addEntity(newEntity); break;
					case "Add Pig": newEntity = new Pig(handler, xPos, yPos);  this.addEntity(newEntity); break;
					case "Add Dog": newEntity = new Dog(handler, xPos, yPos);  this.addEntity(newEntity); break;
					case "Add Chicken": newEntity = new Chicken(handler, xPos, yPos);  this.addEntity(newEntity); break;
					
					// We have to round the position to grow flower
					// to have flower in the right position of flower pot
					case "Add Flower": newEntity = new Flower(handler, ((int)(xPos / 64)) * 64, ((int)(yPos / 64)) * 64);  this.addEntity(newEntity); break;
					}
					
					
					// Sound after appear
					if (newEntity instanceof Soundable) {
						((Soundable) newEntity).sound();
					}
					
					if (newEntity != null && newEntity.checkEntityCollisions(0f, 0f)) {
						
						Iterator<Entity> it = entities.iterator();
						while(it.hasNext()){
							Entity e = it.next();
							if(e == newEntity) {
								it.remove();
							}
						}
						
					}
					
					
				}
			
			}
			
		}
		
		Iterator<Entity> it = entities.iterator();
		while(it.hasNext()){
			Entity e = it.next();
			if(!e.isActive()) {
				it.remove();
			}
			
			// === Click to feed a creature ===
			if (isClicked && e instanceof Creature) {

					Rectangle bound = new Rectangle(
							(int)(e.getX()),
							(int)(e.getY()),
							e.getBounds().width, e.getBounds().height);
					
					if (bound.contains(xClicked, yClicked)) {
						Creature c = (Creature) e;
						
						if (c instanceof Soundable) {
							((Soundable) c).sound();
						}
						
						if (selectedBtn != null) {
							
							// Eat
							if (name.contains("food")) {
								if (c.eat(new FoodType(name))) {
									c.sayThankYou();
								} else {
									c.sayItsNotMyFood();
								}
							}
							
							// Drink
							if (name.contains("water")) {
								c.drink();
								c.sayThankYou();
							}
								
						}
						
						
					}

			}
				
			e.tick();
		}
		
		// VietAnhDev: comment out to avoid bug
		//entities.sort(renderSorter);
	}
	
	public void render(Graphics g){
		for(Entity e : entities){
			e.render(g);
		}
	}
	
	public void addEntity(Entity e){
		entities.add(e);
	}
	
	//GETTERS SETTERS
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}

	public int getTotalFoodNeed() {
		int totalFoodNeed = 0;
		Iterator<Entity> it = entities.iterator();
		while(it.hasNext()){
			Entity e = it.next();
			if (e instanceof Creature) {
				totalFoodNeed += ((Creature) e).getFoodNeed();
			}
		}
		return totalFoodNeed;
	}
	
	public int getTotalWaterNeed() {
		int totalWaterNeed = 0;
		Iterator<Entity> it = entities.iterator();
		while(it.hasNext()){
			Entity e = it.next();
			if (e instanceof Creature) {
				totalWaterNeed += ((Creature) e).getWaterNeed();
			}
		}
		return totalWaterNeed;
	}

	public void feedAllCreature() {
		Iterator<Entity> it = entities.iterator();
		while(it.hasNext()){
			Entity e = it.next();
			if (e instanceof Creature) {
				((Creature) e).eat(((Creature) e).getFoodType());
			}
		}
	}
	
	public void waterAllCreature() {
		Iterator<Entity> it = entities.iterator();
		while(it.hasNext()){
			Entity e = it.next();
			if (e instanceof Creature) {
				((Creature) e).drink();
			}
		}
	}

}
