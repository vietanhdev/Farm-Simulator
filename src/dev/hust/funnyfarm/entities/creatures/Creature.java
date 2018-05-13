package dev.hust.funnyfarm.entities.creatures;

import java.awt.Graphics;
import java.util.Arrays;

import dev.hust.funnyfarm.Handler;
import dev.hust.funnyfarm.entities.Entity;
import dev.hust.funnyfarm.gfx.Assets;
import dev.hust.funnyfarm.gfx.Text;
import dev.hust.funnyfarm.tiles.EnvironmentType;
import dev.hust.funnyfarm.tiles.Tile;


public abstract class Creature extends Entity {
	
	private boolean isLiving;
	
	private FoodType foodType;
	
	private double health;
	private double food;
	private double water;
	private long age;
	
	private long timeToDisapear;
	public static final long DEFAULT_TIME_TO_DISAPEAR_AFTER_DEAD = 500;
	public static final double DEFAULT_HEALTH = 100.0;
	public static final double DEFAULT_FOOD = 100.0;
	public static final double DEFAULT_WATER = 100.0;
	public static final int DEFAULT_CREATURE_WIDTH = 64,
			DEFAULT_CREATURE_HEIGHT = 64;
	
	public double healthLostPerTick = 0.005;
	public double foodLostPerTick = 0.009;
	public double waterLostPerTick = 0.001;

	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		health = DEFAULT_HEALTH;
		food = DEFAULT_FOOD;
		water = DEFAULT_WATER;
		foodType = new FoodType("");
		setTimeToDisapear(0);
		setLiving(true);
	}
	
	
	//GETTERS SETTERS
	public double getHealthLostPerTick () {
		return healthLostPerTick;
	}
	public void setHealthLostPerTick (double value) {
		healthLostPerTick = value;
	}
	public double getFoodLostPerTick () {
		return foodLostPerTick;
	}
	public void setFoodLostPerTick (double value) {
		foodLostPerTick = value;
	}
	public double getWaterLostPerTick () {
		return waterLostPerTick;
	}
	public void setWaterLostPerTick (double value) {
		waterLostPerTick = value;
	}
	
	
	public boolean isLiving() {
		return isLiving;
	}
	
	public void setLiving(boolean isLiving) {
		this.isLiving = isLiving;
	}
	
	
	public boolean isRightEnvironment(EnvironmentType enviromment) {
		if (getEnvironments() == null) {
			System.out.println("Null environments!");
			return false;
		}
		
		return Arrays.asList(getEnvironments()).contains(enviromment);
	}

	public double getHealth() {
		return health;
	}

	public void setHealth(double health){
		this.health = health;
	}
	
	
	// This method should be at first in tick(): updateBodyStatus();
	public void updateBodyStatus() {
		
		if (!isLiving) {
			if (getTimeToDisapear() <= 0) {
				setActive(false);
			}
			
			setTimeToDisapear(getTimeToDisapear()-1);
			// Not update body status after dead
			return;
		}
		
		// Die right after living in wrong environment
		if (!isRightEnvironment(getCurrentEnvironmentType())) {
			System.out.println("Wrong environment");
			die();
		}
		
		// If the creature in water environment, it can drink the water here
		if (getCurrentEnvironmentType() == EnvironmentType.WATER_ENVIRONMENT) {
			drink(5);
		}
		
		
		increaseAge();
		
		this.health -= getHealthLostPerTick();
		this.food -= getFoodLostPerTick();
		this.water -= getWaterLostPerTick();
		if (food < 30) {
			this.health -= 0.05;
		}
		
		if (water < 30) {
			this.health -= 0.05;
		}
		
		if (health < 0) health = 0;
		if (food < 0) food = 0;
		if (water < 0) water = 0;
		
		if (health > 100) health = 100;
		if (food >  100) food = 100;
		if (water > 100) water = 100;
		

		if (getHealth() < 1) {
			die();
			setLiving(false);
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
	
	public void drink() {
		this.water = DEFAULT_WATER;
	}
	
	public void drink(double amount) {
		this.water += amount;
	}
	
	public EnvironmentType getCurrentEnvironmentType() {
		int tileX = (int) (getX() + getBounds().x) / Tile.TILEWIDTH;
		int tileY = (int) (getY() + getBounds().y) / Tile.TILEHEIGHT;
		return getHandler().getWorld().getTile(tileX, tileY).getEnvironmentType();
	}
	
	public double getFood() {
		return food;
	}

	public void setFood(double health) {
		this.food = health;
	}
	
	public boolean eat(FoodType ft) {
		if (ft.getName().equals(getFoodType().getName())) {
			setFood(DEFAULT_FOOD);
			setHealth(getHealth()+10);
			return true;
		} else {
			return false;
		}
	}

	public void printInfo(Graphics g) {
		g.drawImage(Assets.heart, 
				(int) (getX() - getHandler().getGameCamera().getxOffset()),
				(int) (getY() - getHandler().getGameCamera().getyOffset() - 32),
				16, 16, null);
		Text.drawString(g, "" + (int)getHealth()
		, (int) (getX() - getHandler().getGameCamera().getxOffset() + 20)	
		, (int) (getY() - getHandler().getGameCamera().getyOffset() - 16)
		, 0);
		g.drawImage(Assets.hamburger, 
				(int) (getX() - getHandler().getGameCamera().getxOffset()),
				(int) (getY() - getHandler().getGameCamera().getyOffset() - 16),
				16, 16, null);
		Text.drawString(g, "" + (int)getFood()
		, (int) (getX() - getHandler().getGameCamera().getxOffset() + 20)	
		, (int) (getY() - getHandler().getGameCamera().getyOffset())
		, 0);
		g.drawImage(Assets.water_drop, 
				(int) (getX() - getHandler().getGameCamera().getxOffset()),
				(int) (getY() - getHandler().getGameCamera().getyOffset()),
				16, 16, null);
		Text.drawString(g, "" + (int)getWater()
		, (int) (getX() - getHandler().getGameCamera().getxOffset() + 20)	
		, (int) (getY() - getHandler().getGameCamera().getyOffset() + 16)
		, 0);
	}
	
	@Override
	public void die() {
		setHealth(0);
		isLiving = false;
		setTimeToDisapear(DEFAULT_TIME_TO_DISAPEAR_AFTER_DEAD);
		Assets.sound_die.play();
	}
	

	public long getAge() {
		return age;
	}


	public void setAge(long age) {
		this.age = age;
	}
	
	public void increaseAge() {
		this.age += 1;
	}


	public FoodType getFoodType() {
		return foodType;
	}


	public void setFoodType(FoodType foodType) {
		this.foodType = foodType;
	}


	public long getTimeToDisapear() {
		return timeToDisapear;
	}


	public void setTimeToDisapear(long timeToDisapear) {
		this.timeToDisapear = timeToDisapear;
	}
	
	public int getFoodNeed() {
		return (int)(DEFAULT_FOOD - getFood());
	}
	
	public int getWaterNeed() {
		return (int)(DEFAULT_WATER - getWater());
	}
	
	public void sayThankYou() {
		Assets.sound_thankyou.play();
	}
	
	public void sayItsNotMyFood() {
		Assets.sound_itsnotmyfood.play();
	}


	public abstract  EnvironmentType[] getEnvironments();

	
}
