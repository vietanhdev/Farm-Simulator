package dev.hust.funnyfarm.entities.creatures.animals;

import dev.hust.funnyfarm.Handler;
import dev.hust.funnyfarm.gfx.Animation;
import dev.hust.funnyfarm.gfx.Assets;


public class Dog extends Animal {
	
	public Dog(Handler handler, float x, float y) {
		super(handler, x, y, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT);
		
		setBounds(0,0,64,64);
		
		// Body update info
		setHealthLostPerTick(0.02);
		setFoodLostPerTick(0.005);
		setWaterLostPerTick(0.001);
		
		//Animations
		Animation animDown = new Animation(500, Assets.dog_down);
		Animation animUp = new Animation(500, Assets.dog_up);
		Animation animLeft = new Animation(500, Assets.dog_left);
		Animation animRight = new Animation(500, Assets.dog_right);
		Animation animSleep = new Animation(500, Assets.dog_sleep);
		Animation animDead = new Animation(500, Assets.dog_dead);
		
		super.setAnimations(animDown, animUp, animLeft, animRight, animSleep, animDead);
		
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
