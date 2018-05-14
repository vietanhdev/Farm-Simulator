package dev.hust.funnyfarm.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	private EnvironmentType environmentType;
	
	public EnvironmentType getEnvironmentType() {
		return environmentType;
	}

	public void setEnvironmentType(EnvironmentType environmentType) {
		this.environmentType = environmentType;
	}


	//STATIC STUFF HERE
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(0, EnvironmentType.TERRESTIAL_ENVIRONMENT);
	public static Tile dirtTile = new DirtTile(1, EnvironmentType.TERRESTIAL_ENVIRONMENT);
	public static Tile fenceTile = new FenceTile(2, EnvironmentType.FENCE);
	public static Tile waterTile = new WaterTile(3, EnvironmentType.WATER_ENVIRONMENT);
	public static Tile flowerPotTile = new FlowerPotTile(4, EnvironmentType.FLOWERPOT);
	
	//CLASS
	
	public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
	private BufferedImage texture;
	private final int id;
	
	public Tile(BufferedImage texture, int id, EnvironmentType type){
		this.texture = texture;
		this.id = id;
		setEnvironmentType(type);
		
		tiles[id] = this;
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}

	
	public int getId(){
		return id;
	}
	
}
