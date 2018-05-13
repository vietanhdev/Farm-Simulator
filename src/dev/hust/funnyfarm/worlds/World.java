package dev.hust.funnyfarm.worlds;

import java.awt.Graphics;
import java.io.InputStream;

import dev.hust.funnyfarm.Handler;
import dev.hust.funnyfarm.entities.EntityManager;
import dev.hust.funnyfarm.entities.creatures.animals.*;
import dev.hust.funnyfarm.entities.creatures.plants.*;
import dev.hust.funnyfarm.entities.statics.*;
import dev.hust.funnyfarm.tiles.Tile;
import dev.hust.funnyfarm.utils.Utils;
import sun.applet.Main;

public class World {

	private Handler handler;
	private int width, height;
	private int[][] tiles;
	//Entities
	private EntityManager entityManager;
	
	public World(Handler handler, String path){
		this.handler = handler;
		entityManager = new EntityManager(handler);
		
		Fish f = new Fish(handler, 4*64, 4*64);
		f.setLastSleepTime(1374);
		entityManager.addEntity(f);
		f = new Fish(handler, 5*64, 5*64);
		f.setLastSleepTime(456);
		entityManager.addEntity(f);
		entityManager.addEntity(new Fish(handler, 2*64, 6*64));
		
		Turtle t = new Turtle(handler, 400, 200);
		t.setLastSleepTime(1000);
		entityManager.addEntity(t);
		entityManager.addEntity(new Turtle(handler, 500, 200));
		
		entityManager.addEntity(new Pig(handler, 10*64, 2*64));
		
		Horse h1 = new Horse(handler, 14*64, 6*64);
		h1.setLastSleepTime(1145);
		entityManager.addEntity(h1);
		entityManager.addEntity(new Horse(handler, 16*64, 2*64));
		h1 = new Horse(handler, 16*64, 3*64);
		h1.setLastSleepTime(245);
		entityManager.addEntity(h1);
		
		
		Cow c = new Cow(handler, 14*64, 8*64);
		c.setLastSleepTime(500);
		entityManager.addEntity(c);
		entityManager.addEntity(new Cow(handler, 16*64, 8*64));
		c = new Cow(handler, 16*64, 10*64);
		c.setLastSleepTime(999);
		entityManager.addEntity(c);
		
		
		Dog d = new Dog(handler, 10*64, 8*64);
		d.setLastSleepTime(800);
		entityManager.addEntity(d);
		entityManager.addEntity(new Dog(handler, 8*64, 8*64));
		d = new Dog(handler, 8*64, 12*64);
		d.setLastSleepTime(1800);
		entityManager.addEntity(d);
		
		
		Chicken g = new Chicken(handler, 4*64, 8*64);
		g.setLastSleepTime(400);
		entityManager.addEntity(g);
		entityManager.addEntity(new Chicken(handler, 2*64, 8*64));
		g = new Chicken(handler, 4*64, 12*64);
		g.setLastSleepTime(1400);
		entityManager.addEntity(g);
		entityManager.addEntity(new Chicken(handler, 2*64, 10*64));
		
		entityManager.addEntity(new Flower(handler, 2*64, 7*64));
		entityManager.addEntity(new Flower(handler, 3*64, 7*64));
		entityManager.addEntity(new Flower(handler, 4*64, 7*64));
		entityManager.addEntity(new Flower(handler, 5*64, 7*64));
		
		entityManager.addEntity(new Flower(handler, 7*64, 7*64));
		entityManager.addEntity(new Flower(handler, 8*64, 7*64));
		entityManager.addEntity(new Flower(handler, 9*64, 7*64));
		entityManager.addEntity(new Flower(handler, 10*64, 7*64));
		entityManager.addEntity(new Flower(handler, 11*64, 7*64));
		
		entityManager.addEntity(new Flower(handler, 13*64, 7*64));
		entityManager.addEntity(new Flower(handler, 14*64, 7*64));
		entityManager.addEntity(new Flower(handler, 15*64, 7*64));
		entityManager.addEntity(new Flower(handler, 16*64, 7*64));
		
		
		// Add static entity into game
		entityManager.addEntity(new Mannequin(handler, 15, 300));
		entityManager.addEntity(new Mannequin(handler, 375, 300));
		entityManager.addEntity(new Mannequin(handler, 750, 300));
		entityManager.addEntity(new Mannequin(handler, 1100, 300));

		
		loadWorld(path);
		
	}
	
	public void tick(){
		entityManager.tick();
	}
	
	public void render(Graphics g){
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);
		
		for(int y = yStart;y < yEnd;y++){
			for(int x = xStart;x < xEnd;x++){
				getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}

		//Entities
		entityManager.render(g);
		
	}
	
	public Tile getTile(int x, int y){
		if(x < 0 || y < 0 || x >= width || y >= height)
			return Tile.grassTile;
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.dirtTile;
		return t;
	}
	
	private void loadWorld(String path){
		InputStream in = Main.class.getResourceAsStream(path); 
		String file = new String();
		file = Utils.convertStreamToString(in);
		
		//String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		
		tiles = new int[width][height];
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}


}








