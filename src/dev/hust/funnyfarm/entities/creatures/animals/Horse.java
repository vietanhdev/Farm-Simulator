package dev.hust.funnyfarm.entities.creatures.animals;


import dev.hust.funnyfarm.Handler;
import dev.hust.funnyfarm.entities.creatures.FoodType;
import dev.hust.funnyfarm.gfx.Animation;
import dev.hust.funnyfarm.gfx.Assets;
import dev.hust.funnyfarm.tiles.EnvironmentType;


public class Horse extends Animal implements Walkable, Soundable  {
	
	
	private static float DEFAULT_SPEED = 1.0f;

	private static EnvironmentType[] environments = {EnvironmentType.TERRESTIAL_ENVIRONMENT};
	public EnvironmentType[] getEnvironments() {
		return environments;
	}
	
	
	public Horse(Handler handler, float x, float y) {
		super(handler, x, y, getDefaultCreatureWidth(), getDefaultCreatureHeight());
		
		setBounds(0,0,64,64);
		
		// Body update info
		setHealthLostPerTick(0.005);
		setFoodLostPerTick(0.009);
		setWaterLostPerTick(0.001);
		
		//Animations
		Animation animDown = new Animation(500, Assets.horse_down);
		Animation animUp = new Animation(500, Assets.horse_up);
		Animation animLeft = new Animation(500, Assets.horse_left);
		Animation animRight = new Animation(500, Assets.horse_right);
		Animation animSleep = new Animation(500, Assets.horse_sleep);
		Animation animDead = new Animation(500, Assets.horse_dead);
		
		super.setAnimations(animDown, animUp, animLeft, animRight, animSleep, animDead);
		
		setFoodType(new FoodType("horsefood"));
	}
	


	@Override
	public long getSleepTime() {
		return 500;
	}


	@Override
	public long getTimeBetweenSleeps() {
		return 2000;
	}
	
	@Override
	public void sound() {
		Assets.sound_horse.play();
	}
	
	public float getDefaultSpeed() {
		return DEFAULT_SPEED;
	}

	public void setDefaultSpeed(float speed) {
		DEFAULT_SPEED = speed;
	}
	

}
