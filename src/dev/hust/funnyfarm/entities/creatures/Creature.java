package dev.hust.funnyfarm.entities.creatures;

import dev.hust.funnyfarm.Handler;
import dev.hust.funnyfarm.entities.Entity;

public abstract class Creature extends Entity {
	
	private int health;
	public static final int DEFAULT_HEALTH = 3;
	public static final int DEFAULT_CREATURE_WIDTH = 64,
							DEFAULT_CREATURE_HEIGHT = 64;


	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		health = DEFAULT_HEALTH;
	}
	
	
	//GETTERS SETTERS
	
	public String getEnvironments() {
		return "";
	}
	
	public boolean isRightEnvironment(String environment) {
		return getEnvironments().toLowerCase().contains(environment.toLowerCase());
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	
}
