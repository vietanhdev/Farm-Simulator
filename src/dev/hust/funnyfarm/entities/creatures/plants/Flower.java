package dev.hust.funnyfarm.entities.creatures.plants;

import dev.hust.funnyfarm.FoodType;
import dev.hust.funnyfarm.Handler;
import dev.hust.funnyfarm.gfx.Animation;
import dev.hust.funnyfarm.gfx.Assets;

public  class Flower extends Plant {

	public Flower(Handler handler, float x, float y) {
		super(handler, x, y, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT);
		
		//Animations
		Animation animBig = new Animation(500, Assets.flower_big);
		Animation animSmall = new Animation(500, Assets.flower_small);
		Animation animDead = new Animation(500, Assets.flower_dead);
		
		super.setAnimations(animSmall, animBig, animDead);
		
		setFoodType(new FoodType("flowerfood"));
	}
	
	@Override
	public String getEnvironments() {
		return "flowerpot";
	}
	
}

