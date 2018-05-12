package dev.hust.funnyfarm.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import dev.hust.funnyfarm.FoodType;
import dev.hust.funnyfarm.Handler;
import dev.hust.funnyfarm.entities.creatures.Creature;
import dev.hust.funnyfarm.states.GameState;


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
		int xClicked = 0, yClicked = 0;
		if (isClicked) {
			xClicked = getHandler().getMouseManager().getMouseClickedX() + (int)getHandler().getGameCamera().getxOffset();
			yClicked = getHandler().getMouseManager().getMouseClickedY() + (int)getHandler().getGameCamera().getyOffset();
			
			// Skip if click area in toolbar
			if (yClicked < 64) {
				isClicked = false;
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
						GameState gameState = (GameState) getHandler().getGame().getGameState();
						
						if (gameState.getUIManager().getSelectedBtn() != null) {
							String name = gameState.getUIManager().getSelectedBtn().getName();
							
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
