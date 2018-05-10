package dev.hust.funnyfarm.worlds;

import java.awt.Graphics;

import dev.hust.funnyfarm.Handler;
import dev.hust.funnyfarm.entities.EntityManager;
import dev.hust.funnyfarm.entities.creatures.animals.*;
import dev.hust.funnyfarm.entities.statics.Mannequin;
import dev.hust.funnyfarm.items.ItemManager;
import dev.hust.funnyfarm.tiles.Tile;
import dev.hust.funnyfarm.utils.Utils;

public class World {

	private Handler handler;
	private int width, height;
	private int[][] tiles;
	//Entities
	private EntityManager entityManager;
	// Item
	private ItemManager itemManager;
	
	public World(Handler handler, String path){
		this.handler = handler;
		entityManager = new EntityManager(handler);
		entityManager.addEntity(new Fish(handler, 90, 90));
		entityManager.addEntity(new Fish(handler, 164, 164));
		entityManager.addEntity(new Fish(handler, 240, 240));
		entityManager.addEntity(new Fish(handler, 500, 500));
		entityManager.addEntity(new Turtle(handler, 300, 200));
		
		itemManager = new ItemManager(handler);
		
		// Add static entity into game
		entityManager.addEntity(new Mannequin(handler, 15, 300));
		entityManager.addEntity(new Mannequin(handler, 375, 300));
		entityManager.addEntity(new Mannequin(handler, 750, 300));
		entityManager.addEntity(new Mannequin(handler, 1100, 300));
		
		loadWorld(path);
		
	}
	
	public void tick(){
		itemManager.tick();
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
		// Items
		itemManager.render(g);
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
		String file = Utils.loadFileAsString(path);
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

	public ItemManager getItemManager() {
		return itemManager;
	}

	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}
	
}








