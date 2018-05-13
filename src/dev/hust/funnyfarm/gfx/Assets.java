package dev.hust.funnyfarm.gfx;

import java.awt.Font;
import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static Font font28;
	
	public static BufferedImage heart, hamburger, water_drop;
	public static BufferedImage dirt, grass, fence, tree, rock, water, flowerpot;
	public static BufferedImage wood;
	public static BufferedImage[] fish_down, fish_up, fish_left, fish_right, fish_sleep, fish_dead;
	public static BufferedImage[] cow_down, cow_up, cow_left, cow_right, cow_sleep, cow_dead;
	public static BufferedImage[] dog_down, dog_up, dog_left, dog_right, dog_sleep, dog_dead;
	public static BufferedImage[] chicken_down, chicken_up, chicken_left, chicken_right, chicken_sleep, chicken_dead;
	public static BufferedImage[] horse_down, horse_up, horse_left, horse_right, horse_sleep, horse_dead;
	public static BufferedImage[] pig_down, pig_up, pig_left, pig_right, pig_sleep, pig_dead;
	public static BufferedImage[] turtle_down, turtle_up, turtle_left, turtle_right, turtle_sleep, turtle_dead;
	public static BufferedImage[] turtle_swim_down, turtle_swim_up, turtle_swim_left, turtle_swim_right;
	public static BufferedImage[] flower_big, flower_small, flower_dead;
	
	public static BufferedImage inventoryScreen;
	
	public static BufferedImage[] btn_water;
	public static BufferedImage[] btn_foodbag;
	public static BufferedImage[] btn_empty;
	public static BufferedImage[] btn_add;
	public static BufferedImage[] btn_sub;
	public static BufferedImage[] btn_reset;

	public static void init(){
		font28 = FontLoader.loadFont("/fonts/slkscr.ttf", 28);
		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
		SpriteSheet buttonSheet = new SpriteSheet(ImageLoader.loadImage("/textures/buttons.png"));
		
		
		btn_water = new BufferedImage[3];
		btn_water[0] = buttonSheet.crop(0, 0, 64, 64);
		btn_water[1] = buttonSheet.crop(64, 0, 64, 64);
		btn_water[2] = buttonSheet.crop(64*2, 0, 64, 64);
		
		btn_foodbag = new BufferedImage[3];
		btn_foodbag[0] = buttonSheet.crop(0, 64, 64, 64);
		btn_foodbag[1] = buttonSheet.crop(64, 64, 64, 64);
		btn_foodbag[2] = buttonSheet.crop(64*2, 64, 64, 64);
		
		btn_empty = new BufferedImage[3];
		btn_empty[0] = buttonSheet.crop(0, 2*64, 64, 64);
		btn_empty[1] = buttonSheet.crop(64, 2*64, 64, 64);
		btn_empty[2] = buttonSheet.crop(64*2, 2*64, 64, 64);
		
		btn_add = new BufferedImage[3];
		btn_add[0] = buttonSheet.crop(0, 3*64, 64, 64);
		btn_add[1] = buttonSheet.crop(64, 3*64, 64, 64);
		btn_add[2] = buttonSheet.crop(64*2, 3*64, 64, 64);
		
		btn_sub = new BufferedImage[3];
		btn_sub[0] = buttonSheet.crop(0, 4*64, 64, 64);
		btn_sub[1] = buttonSheet.crop(64, 4*64, 64, 64);
		btn_sub[2] = buttonSheet.crop(64*2, 4*64, 64, 64);
		
		btn_reset = new BufferedImage[3];
		btn_reset[0] = buttonSheet.crop(0, 5*64, 64, 64);
		btn_reset[1] = buttonSheet.crop(64, 5*64, 64, 64);
		btn_reset[2] = buttonSheet.crop(64*2, 5*64, 64, 64);
		
		
		wood = sheet.crop(width, height, width, height);
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
		
		
		cow_down = new BufferedImage[2];
		cow_up = new BufferedImage[2];
		cow_left = new BufferedImage[2];
		cow_right = new BufferedImage[2];
		cow_sleep = new BufferedImage[2];
		cow_dead = new BufferedImage[1];
		cow_right[0] = sheet.crop(0, 11*height, 2*width, 2*height);
		cow_right[1] = sheet.crop(2*width, 11*height, 2*width, 2*height);
		cow_left[0] = sheet.crop(4*width, 11*height, 2*width, 2*height);
		cow_left[1] = sheet.crop(6*width, 11*height, 2*width, 2*height);
		cow_down[0] = sheet.crop(0, 13*height, 2*width, 2*height);
		cow_down[1] = sheet.crop(2*width, 13*height, 2*width, 2*height);
		cow_up[0] = sheet.crop(4*width, 13*height, 2*width, 2*height);
		cow_up[1] = sheet.crop(6*width, 13*height, 2*width, 2*height);
		cow_sleep[0] = sheet.crop(0, 15*height, 2*width, 2*height);
		cow_sleep[1] = sheet.crop(2*width, 15*height, 2*width, 2*height);
		cow_dead[0] = sheet.crop(4*width, 15*height, 2*width, 2*height);
		
		
		dog_down = new BufferedImage[2];
		dog_up = new BufferedImage[2];
		dog_left = new BufferedImage[2];
		dog_right = new BufferedImage[2];
		dog_sleep = new BufferedImage[2];
		dog_dead = new BufferedImage[1];
		dog_right[0] = sheet.crop(0, 17*height, 2*width, 2*height);
		dog_right[1] = sheet.crop(2*width, 17*height, 2*width, 2*height);
		dog_left[0] = sheet.crop(4*width, 17*height, 2*width, 2*height);
		dog_left[1] = sheet.crop(6*width, 17*height, 2*width, 2*height);
		dog_down[0] = sheet.crop(0, 19*height, 2*width, 2*height);
		dog_down[1] = sheet.crop(2*width, 19*height, 2*width, 2*height);
		dog_up[0] = sheet.crop(4*width, 19*height, 2*width, 2*height);
		dog_up[1] = sheet.crop(6*width, 19*height, 2*width, 2*height);
		dog_sleep[0] = sheet.crop(0, 21*height, 2*width, 2*height);
		dog_sleep[1] = sheet.crop(2*width, 21*height, 2*width, 2*height);
		dog_dead[0] = sheet.crop(4*width, 21*height, 2*width, 2*height);
		
		
		chicken_down = new BufferedImage[2];
		chicken_up = new BufferedImage[2];
		chicken_left = new BufferedImage[2];
		chicken_right = new BufferedImage[2];
		chicken_sleep = new BufferedImage[2];
		chicken_dead = new BufferedImage[1];
		chicken_right[0] = sheet.crop(0, 23*height, 2*width, 2*height);
		chicken_right[1] = sheet.crop(2*width, 23*height, 2*width, 2*height);
		chicken_left[0] = sheet.crop(4*width, 23*height, 2*width, 2*height);
		chicken_left[1] = sheet.crop(6*width, 23*height, 2*width, 2*height);
		chicken_down[0] = sheet.crop(0, 25*height, 2*width, 2*height);
		chicken_down[1] = sheet.crop(2*width, 25*height, 2*width, 2*height);
		chicken_up[0] = sheet.crop(4*width, 25*height, 2*width, 2*height);
		chicken_up[1] = sheet.crop(6*width, 25*height, 2*width, 2*height);
		chicken_sleep[0] = sheet.crop(0, 27*height, 2*width, 2*height);
		chicken_sleep[1] = sheet.crop(2*width, 27*height, 2*width, 2*height);
		chicken_dead[0] = sheet.crop(4*width, 27*height, 2*width, 2*height);
		
		
		horse_down = new BufferedImage[2];
		horse_up = new BufferedImage[2];
		horse_left = new BufferedImage[2];
		horse_right = new BufferedImage[2];
		horse_sleep = new BufferedImage[2];
		horse_dead = new BufferedImage[1];
		horse_right[0] = sheet.crop(0, 29*height, 2*width, 2*height);
		horse_right[1] = sheet.crop(2*width, 29*height, 2*width, 2*height);
		horse_left[0] = sheet.crop(4*width, 29*height, 2*width, 2*height);
		horse_left[1] = sheet.crop(6*width, 29*height, 2*width, 2*height);
		horse_down[0] = sheet.crop(0, 31*height, 2*width, 2*height);
		horse_down[1] = sheet.crop(2*width, 31*height, 2*width, 2*height);
		horse_up[0] = sheet.crop(4*width, 31*height, 2*width, 2*height);
		horse_up[1] = sheet.crop(6*width, 31*height, 2*width, 2*height);
		horse_sleep[0] = sheet.crop(0, 33*height, 2*width, 2*height);
		horse_sleep[1] = sheet.crop(2*width, 33*height, 2*width, 2*height);
		horse_dead[0] = sheet.crop(4*width, 33*height, 2*width, 2*height);
		
		pig_down = new BufferedImage[2];
		pig_up = new BufferedImage[2];
		pig_left = new BufferedImage[2];
		pig_right = new BufferedImage[2];
		pig_sleep = new BufferedImage[2];
		pig_dead = new BufferedImage[1];
		pig_right[0] = sheet.crop(0, 35*height, 2*width, 2*height);
		pig_right[1] = sheet.crop(2*width, 35*height, 2*width, 2*height);
		pig_left[0] = sheet.crop(4*width, 35*height, 2*width, 2*height);
		pig_left[1] = sheet.crop(6*width, 35*height, 2*width, 2*height);
		pig_down[0] = sheet.crop(0, 37*height, 2*width, 2*height);
		pig_down[1] = sheet.crop(2*width, 37*height, 2*width, 2*height);
		pig_up[0] = sheet.crop(4*width, 37*height, 2*width, 2*height);
		pig_up[1] = sheet.crop(6*width, 37*height, 2*width, 2*height);
		pig_sleep[0] = sheet.crop(0, 39*height, 2*width, 2*height);
		pig_sleep[1] = sheet.crop(2*width, 39*height, 2*width, 2*height);
		pig_dead[0] = sheet.crop(4*width, 39*height, 2*width, 2*height);
		
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
		
		heart = sheet.crop(width, height * 2, width, height);
		hamburger = sheet.crop(2*width, height * 2, width, height);
		water_drop = sheet.crop(3*width, height * 2, width, height);
	}
	
}
