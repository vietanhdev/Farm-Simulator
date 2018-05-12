package dev.hust.funnyfarm.entities.creatures.animals;

import dev.hust.funnyfarm.FoodType;
import dev.hust.funnyfarm.Handler;
import dev.hust.funnyfarm.gfx.Animation;
import dev.hust.funnyfarm.gfx.Assets;


public class Cow extends Animal {
	
	public Cow(Handler handler, float x, float y) {
		super(handler, x, y, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT);
		
		setBounds(0,0,64,64);
		
		// Body update info
		setHealthLostPerTick(0.005);
		setFoodLostPerTick(0.009);
		setWaterLostPerTick(0.001);
		
		//Animations
		Animation animDown = new Animation(500, Assets.cow_down);
		Animation animUp = new Animation(500, Assets.cow_up);
		Animation animLeft = new Animation(500, Assets.cow_left);
		Animation animRight = new Animation(500, Assets.cow_right);
		Animation animSleep = new Animation(500, Assets.cow_sleep);
		Animation animDead = new Animation(500, Assets.cow_dead);
		
		super.setAnimations(animDown, animUp, animLeft, animRight, animSleep, animDead);
		
		setFoodType(new FoodType("cowfood"));
	}
	
	@Override
	public String getEnvironments() {
		return "dirt grass";
	}


	@Override
	public long getSleepTime() {
		return 500;
	}


	@Override
	public long getTimeBetweenSleeps() {
		return 2000;
	}
	

}
