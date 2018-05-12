package dev.hust.funnyfarm.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import dev.hust.funnyfarm.FoodType;
import dev.hust.funnyfarm.Handler;
import dev.hust.funnyfarm.entities.creatures.Creature;
import dev.hust.funnyfarm.entities.creatures.animals.*;
import dev.hust.funnyfarm.entities.creatures.plants.*;
import dev.hust.funnyfarm.states.GameState;
import dev.hust.funnyfarm.ui.SelectableButton;


public class EntityManager {
	
	private Handler handler;
	private ArrayList<Entity> entities;
	private Comparator<Entity> renderSorter = new Comparator<Entity>(){
		@Override
		public int compare(Entity a, Entity b) {
			if(a.getY() + a.getHeight() < b.getY() + b.getHeight())
				return -1;
			return 1;
		}
	};
	
	public EntityManager(Handler handler){
		this.handler = handler;
		entities = new ArrayList<Entity>();
	}
	
	public void tick(){
		boolean isClicked = getHandler().getMouseManager().isMouseClicked();
		
		// x, y of click calculated by window
		int xClicked_win = 0, yClicked_win = 0;
		
		// x, y of click with game camera offset
		int xClicked = 0, yClicked = 0;
		
		if (isClicked) {
			
			xClicked_win = getHandler().getMouseManager().getMouseClickedX();
			yClicked_win = getHandler().getMouseManager().getMouseClickedY();
			
			xClicked = xClicked_win + (int)getHandler().getGameCamera().getxOffset();
			yClicked = yClicked_win + getHandler().getMouseManager().getMouseClickedY() + (int)getHandler().getGameCamera().getyOffset();
			
			// Skip if click area in toolbar
			if (yClicked_win < 64) {
				isClicked = false;
			}
		}
		
		SelectableButton selectedBtn = null;
		String name = null;
		if (isClicked) {
			GameState gameState = (GameState) getHandler().getGame().getGameState();
			selectedBtn = gameState.getUIManager().getSelectedBtn();
			
			if (selectedBtn != null) {
				name = selectedBtn.getName();
				
				if (name.contains("Add")) {
					int xPos = xClicked_win;
					int yPos = yClicked_win;
					
					System.out.println(name);
					
					Entity newEntity = null;
					switch (name) {
					case "Add Fish": newEntity = new Fish(handler, xPos, yPos);  this.addEntity(newEntity); break;
					case "Add Turtle": newEntity = new Turtle(handler, xPos, yPos);  this.addEntity(newEntity); break;
					case "Add Horse": newEntity = new Horse(handler, xPos, yPos);  this.addEntity(newEntity); break;
					case "Add Cow": newEntity = new Cow(handler, xPos, yPos);  this.addEntity(newEntity); break;
					case "Add Pig": newEntity = new Pig(handler, xPos, yPos);  this.addEntity(newEntity); break;
					case "Add Dog": System.out.println("Da add con dog");newEntity = new Dog(handler, xPos, yPos);  entities.add(newEntity); break;
					case "Add Chicken": newEntity = new Chicken(handler, xPos, yPos);  this.addEntity(newEntity); break;
					case "Add Flower": newEntity = new Flower(handler, xPos, yPos);  this.addEntity(newEntity); break;
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
			
			if (isClicked) {
				
				// Check if clicked a creature
				if (e instanceof Creature) {

					Rectangle bound = new Rectangle(
							(int)(e.getX()),
							(int)(e.getY()),
							e.getBounds().width, e.getBounds().height);
					

					if (bound.contains(xClicked, yClicked)) {
						Creature c = (Creature) e;
						
						
						if (selectedBtn != null) {
							
							// Eat
							if (name.contains("food"))
								c.eat(new FoodType(name));
							
							// Drink
							if (name.contains("water"))
								c.drink();
						}
						
						System.out.println(xClicked + "  " + yClicked);
						System.out.println(bound);
						
						
					}
				}
			}
				
			e.tick();
		}
		entities.sort(renderSorter);
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

}
