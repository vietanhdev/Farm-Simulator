package dev.hust.funnyfarm.gfx;

import java.awt.Font;
import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static Font font28;
	
	public static BufferedImage dirt, grass, fence, tree, rock, water, flowerpot;
	public static BufferedImage wood;
	public static BufferedImage[] fish_down, fish_up, fish_left, fish_right, fish_sleep, fish_dead;
	
	public static BufferedImage[] turtle_down, turtle_up, turtle_left, turtle_right, turtle_sleep, turtle_dead;
	public static BufferedImage[] turtle_swim_down, turtle_swim_up, turtle_swim_left, turtle_swim_right;
	
	public static BufferedImage[] flower_big, flower_small, flower_dead;
	
	public static BufferedImage[] btn_start;
	public static BufferedImage inventoryScreen;

	public static void init(){
		font28 = FontLoader.loadFont("res/fonts/slkscr.ttf", 28);
		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
		
		wood = sheet.crop(width, height, width, height);
		
		btn_start = new BufferedImage[2];
		btn_start[0] = sheet.crop(width * 6, height * 4, width * 2, height);
		btn_start[1] = sheet.crop(width * 6, height * 5, width * 2, height);
		
		fish_down = new BufferedImage[2];
		fish_up = new BufferedImage[2];
		fish_left = new BufferedImage[2];
		fish_right = new BufferedImage[2];
		fish_sleep = new BufferedImage[2];
		fish_dead = new BufferedImage[2];
		
		fish_sleep[0] = sheet.crop(width * 4, height, width, height);
		fish_sleep[1] = sheet.crop(width * 5, height, width, height);
		
		fish_dead[0] = sheet.crop(width * 6, height, width, height);
		fish_dead[1] = sheet.crop(width * 7, height, width, height);
		
		fish_down[0] = sheet.crop(width * 4, 0, width, height);
		fish_down[1] = sheet.crop(width * 5, 0, width, height);
		fish_up[0] = sheet.crop(width * 6, 0, width, height);
		fish_up[1] = sheet.crop(width * 7, 0, width, height);
		fish_right[0] = sheet.crop(width * 4, 0, width, height);
		fish_right[1] = sheet.crop(width * 5, 0, width, height);
		fish_left[0] = sheet.crop(width * 6, 0, width, height);
		fish_left[1] = sheet.crop(width * 7, 0, width, height);
		
		turtle_down = new BufferedImage[2];
		turtle_up = new BufferedImage[2];
		turtle_left = new BufferedImage[2];
		turtle_right = new BufferedImage[2];
		turtle_sleep = new BufferedImage[2];
		turtle_dead = new BufferedImage[2];
		
		turtle_dead[0] = sheet.crop(0, height * 9, 2*width, 2*height);
		turtle_dead[1] = sheet.crop(width * 7, height, width, height);
		
		turtle_down[0] = sheet.crop(0, height*5, 2*width, 2*height);
		turtle_down[1] = sheet.crop(2*width, height*5, 2*width, 2*height);
		turtle_up[0] = sheet.crop(0, height*5, 2*width, 2*height);
		turtle_up[1] = sheet.crop(2*width, height*5, 2*width, 2*height);
		turtle_right[0] = sheet.crop(0, height*3, 2*width, 2*height);
		turtle_right[1] = sheet.crop(2*width, height*3, 2*width, 2*height);
		turtle_left[0] = sheet.crop(4*width, height*3, 2*width, 2*height);
		turtle_left[1] = sheet.crop(6*width, height*3, 2*width, 2*height);
		
		turtle_sleep[0] = sheet.crop(4*width, height*5, 2*width, 2*height);
		turtle_sleep[1] = sheet.crop(6*width, height*5, 2*width, 2*height);
		
		turtle_swim_down = new BufferedImage[2];
		turtle_swim_up = new BufferedImage[2];
		turtle_swim_left = new BufferedImage[2];
		turtle_swim_right = new BufferedImage[2];
		
		
		turtle_swim_down[0] = sheet.crop(0, height*7, 2*width, 2*height);
		turtle_swim_down[1] = sheet.crop(2*width, height*7, 2*width, 2*height);
		turtle_swim_up[0] = sheet.crop(4*width, height*7, 2*width, 2*height);
		turtle_swim_up[1] = sheet.crop(6*width, height*7, 2*width, 2*height);
		turtle_swim_right[0] = sheet.crop(0, height*7, 2*width, 2*height);
		turtle_swim_right[1] = sheet.crop(2*width, height*7, 2*width, 2*height);
		turtle_swim_left[0] = sheet.crop(4*width, height*7, 2*width, 2*height);
		turtle_swim_left[1] = sheet.crop(6*width, height*7, 2*width, 2*height);
		
		flower_big = new BufferedImage[1];
		flower_big[0] = sheet.crop(2*width, height * 9, 2*width, 2*height);
		flower_small = new BufferedImage[1];
		flower_small[0] = sheet.crop(4*width, height * 9, 2*width, 2*height);
		flower_dead = new BufferedImage[1];
		flower_dead[0] = sheet.crop(6*width, height * 9, 2*width, 2*height);
		
		dirt = sheet.crop(width, 0, width, height);
		grass = sheet.crop(width * 2, 0, width, height);
		fence = sheet.crop(width * 3, 0, width, height);
		tree = sheet.crop(0, 0, width, height * 2);
		rock = sheet.crop(0, height * 2, width, height);
		water = sheet.crop(width, height, width, height);
		flowerpot = sheet.crop(width*2, height, width, height);
	}
	
}
