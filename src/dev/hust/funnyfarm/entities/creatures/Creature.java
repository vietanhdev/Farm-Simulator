package dev.hust.funnyfarm.entities.creatures;

import java.awt.Graphics;

import dev.hust.funnyfarm.Handler;
import dev.hust.funnyfarm.entities.Entity;
import dev.hust.funnyfarm.gfx.Text;


public abstract class Creature extends Entity {
	
	private boolean isLiving = true;
	
	private double health;
	private double food;
	private double water;
	
	public static final double DEFAULT_HEALTH = 100.0;
	public static final double DEFAULT_FOOD = 100.0;
	public static final double DEFAULT_WATER = 100.0;
	
	public static final int DEFAULT_CREATURE_WIDTH = 64,
							DEFAULT_CREATURE_HEIGHT = 64;


	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		health = DEFAULT_HEALTH;
		food = DEFAULT_FOOD;
		water = DEFAULT_WATER;
	}
	
	
	//GETTERS SETTERS
	
	public boolean isLiving() {
		return isLiving;
	}
	
	public String getEnvironments() {
		return "";
	}
	
	public boolean isRightEnvironment(String environment) {
		return getEnvironments().toLowerCase().contains(environment.toLowerCase());
	}

	public double getHealth() {
		return health;
	}

	public void setHealth(double health){
		this.health = health;
	}
	
	public void updateBodyStatus() {
		this.health -= 0.005;
		this.food -= 0.009;
		this.water -= 0.001;
		if (food < 30) {
			this.health -= 0.01;
		}
		
		if (water < 30) {
			this.health -= 0.01;
		}
		
		if (health < 0) health = 0;
		if (food < 0) food = 0;
		if (water < 0) water = 0;
		
		if (health > 100) health = 100;
		if (food >  100) food = 100;
		if (water > 100) water = 100;
		
		
		System.out.println(getHealth());
		if (getHealth() < 1) {
			die();
			isLiving = false;
		}
		
		
		
	}
	
	public void increaseHealth(double am) {
		this.health += am;
	}
	
	public double getWater() {
		return water;
	}

	public void setWater(double health) {
		this.water = health;
	}
	
	public void drink(double amount) {
		this.water += amount;
		if (this.water > 100) this.water = 100;
	}
	
	public double getFood() {
		return food;
	}

	public void setFood(double health) {
		this.food = health;
	}
	
	public void eat(double amount) {
		this.food += amount;
	}

	public void printInfo(Graphics g) {
		Text.drawString(g, "Health: " + (int)getHealth()
			+ "\n Food: " + (int)getFood()
			+ " Water: " + (int)getWater()
		, (int)getX(), (int)getY(), 0);
	}
	
	@Override
	public void die() {
		isLiving = false;
	}
	
}
