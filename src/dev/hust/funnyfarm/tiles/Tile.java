package dev.hust.funnyfarm.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	//STATIC STUFF HERE
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(0, "grass");
	public static Tile dirtTile = new DirtTile(1, "dirt");
	public static Tile fenceTile = new FenceTile(2, "fence");
	public static Tile waterTile = new WaterTile(3, "water");
	public static Tile flowerPotTile = new FlowerPotTile(4, "flowerpot");
	
	//CLASS
	
	public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
	
	protected BufferedImage texture;
	protected final int id;
	protected String name;
	
	public Tile(BufferedImage texture, int id, String name){
		this.texture = texture;
		this.id = id;
		this.name = name;
		
		tiles[id] = this;
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	
	public String getName(){
		return name;
	}

	
	public int getId(){
		return id;
	}
	
}
