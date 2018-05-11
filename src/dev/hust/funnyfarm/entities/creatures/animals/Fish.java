package dev.hust.funnyfarm.entities.creatures.animals;

import dev.hust.funnyfarm.Handler;
import dev.hust.funnyfarm.gfx.Animation;
import dev.hust.funnyfarm.gfx.Assets;


public class Fish extends Animal {
	
	public Fish(Handler handler, float x, float y) {
		super(handler, x, y, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT);
		
		setBounds(0,0,64,64);
		
		// Body update info
		setHealthLostPerTick(0.01);
		setFoodLostPerTick(0.009);
		setWaterLostPerTick(0.001);
		
		//Animations
		Animation animDown = new Animation(500, Assets.fish_down);
		Animation animUp = new Animation(500, Assets.fish_up);
		Animation animLeft = new Animation(500, Assets.fish_left);
		Animation animRight = new Animation(500, Assets.fish_right);
		Animation animSleep = new Animation(500, Assets.fish_sleep);
		Animation animDead = new Animation(500, Assets.fish_dead);
		
		super.setAnimations(animDown, animUp, animLeft, animRight, animSleep, animDead);
		
	}
	
	@Override
	public String getEnvironments() {
		return "water";
	}
	
	@Override
	public void tick() {
		if (!isLiving()) return;
		
		sleep();
		
		//Animations
		swim();
		drink(5);
		updateBodyStatus();
		
	}
	
	public void swim() {
		if (!isSleeping()) {
			//Animations
			getAnimDown().tick();
			getAnimUp().tick();
			getAnimRight().tick();
			getAnimLeft().tick();
			
			//Movement
			getMove();
			move();
		}
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
