package dev.hust.funnyfarm.entities.creatures.plants;

import dev.hust.funnyfarm.Handler;
import dev.hust.funnyfarm.entities.creatures.FoodType;
import dev.hust.funnyfarm.gfx.Animation;
import dev.hust.funnyfarm.gfx.Assets;
import dev.hust.funnyfarm.tiles.EnvironmentType;

public  class Flower extends Plant {
	
	private static EnvironmentType[] environments = {EnvironmentType.TERRESTIAL_ENVIRONMENT, EnvironmentType.FLOWERPOT};
	public EnvironmentType[] getEnvironments() {
		return environments;
	}

	public Flower(Handler handler, float x, float y) {
		super(handler, x, y, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT);
		
		//Animations
		Animation animBig = new Animation(500, Assets.flower_big);
		Animation animSmall = new Animation(500, Assets.flower_small);
		Animation animDead = new Animation(500, Assets.flower_dead);
		
		super.setAnimations(animSmall, animBig, animDead);
		
		setFoodType(new FoodType("flowerfood"));
	}
	
}

