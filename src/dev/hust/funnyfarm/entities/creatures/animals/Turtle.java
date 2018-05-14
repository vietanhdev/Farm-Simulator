package dev.hust.funnyfarm.entities.creatures.animals;


import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.hust.funnyfarm.Handler;
import dev.hust.funnyfarm.entities.creatures.FoodType;
import dev.hust.funnyfarm.gfx.Animation;
import dev.hust.funnyfarm.gfx.Assets;
import dev.hust.funnyfarm.tiles.EnvironmentType;


public class Turtle extends Animal implements Swimmable, Walkable {
	
	private static EnvironmentType[] environments = {EnvironmentType.TERRESTIAL_ENVIRONMENT, EnvironmentType.WATER_ENVIRONMENT};
	public EnvironmentType[] getEnvironments() {
		return environments;
	}

	//Animations
	private Animation animSwimDown, animSwimUp, animSwimLeft, animSwimRight;

	public Turtle(Handler handler, float x, float y) {
		super(handler, x, y, Animal.getDefaultCreatureWidth(), Animal.getDefaultCreatureHeight());
		
		setSpeed(1.0f);
		// Body update info
		setHealthLostPerTick(0.005);
		setFoodLostPerTick(0.009);
		setWaterLostPerTick(0.001);
		setBounds(0, 0, 64, 64);

		//Animations
		Animation animDown = new Animation(500, Assets.turtle_down);
		Animation animUp = new Animation(500, Assets.turtle_up);
		Animation animLeft = new Animation(500, Assets.turtle_left);
		Animation animRight = new Animation(500, Assets.turtle_right);
		Animation animSleep = new Animation(500, Assets.turtle_sleep);
		Animation animDead = new Animation(500, Assets.turtle_dead);
		
		Animation animSwimDown = new Animation(500, Assets.turtle_swim_down);
		Animation animSwimUp = new Animation(500, Assets.turtle_swim_up);
		Animation animSwimLeft = new Animation(500, Assets.turtle_swim_left);
		Animation animSwimRight = new Animation(500, Assets.turtle_swim_right);
		
		super.setAnimations(animDown, animUp, animLeft, animRight, animSleep, animDead);
		this.setSwimAnimations(animSwimDown, animSwimUp, animSwimLeft, animSwimRight);
		
		setFoodType(new FoodType("turtlefood"));
	}
	
	
	public void setSwimAnimations(Animation animDown, Animation animUp, Animation animLeft, Animation animRight) {
		this.animSwimDown = animDown;
		this.animSwimUp = animUp;
		this.animSwimLeft = animLeft;
		this.animSwimRight = animRight;
	}
	
	public Animation getAnimSwimDown() {
		return animSwimDown;
	}
	public Animation getAnimSwimUp() {
		return animSwimUp;
	}
	public Animation getAnimSwimLeft() {
		return animSwimLeft;
	}
	public Animation getAnimSwimRight() {
		return animSwimRight;
	}
	
	@Override
	public void tick() {
		
		// This method should be at first in tick(): updateBodyStatus();
		updateBodyStatus();
		
		if (!isLiving()) return;
		
		sleep();
		
		if (getCurrentEnvironmentType() == EnvironmentType.WATER_ENVIRONMENT) {
			swim();
		} else {
			walk();
		}
		
	}
	
	
	public void swim() {
		if (!isSleeping()) {
			//Animations
			animSwimDown.tick();
			animSwimUp.tick();
			animSwimRight.tick();
			animSwimLeft.tick();
			
			//Movement
			getMove();
			move();
		}
	}
	
	
	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (getX() - getHandler().getGameCamera().getxOffset()), (int) (getY() -  getHandler().getGameCamera().getyOffset()), getWidth(), getHeight(), null);
		printInfo(g);
	}
	
	private BufferedImage getCurrentAnimationFrame(){
		
		if (!isLiving()) return getAnimDead().getCurrentFrame();
		
		if (isSleeping())
			return getAnimSleep().getCurrentFrame();
		
		EnvironmentType env = getCurrentEnvironmentType();

		if (env != EnvironmentType.WATER_ENVIRONMENT) {
			if(getxMove() < 0){
				return getAnimLeft().getCurrentFrame();
			} else if (getxMove() > 0){
				return getAnimRight().getCurrentFrame();
			} else if (getyMove() < 0){
				return getAnimUp().getCurrentFrame();
			} else {
				return getAnimDown().getCurrentFrame();
			}
		} else {
			if(getxMove() < 0){
				return getAnimSwimLeft().getCurrentFrame();
			} else if (getxMove() > 0){
				return getAnimSwimRight().getCurrentFrame();
			} else if (getyMove() < 0){
				return getAnimSwimUp().getCurrentFrame();
			} else {
				return getAnimSwimDown().getCurrentFrame();
			}
		}
		
	}

	@Override
	public long getSleepTime() {
		return 800;
	}

	@Override
	public long getTimeBetweenSleeps() {
		return 3000;
	}
	
	
}
