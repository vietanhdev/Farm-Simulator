package dev.hust.funnyfarm.entities.creatures.animals;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import dev.hust.funnyfarm.Handler;
import dev.hust.funnyfarm.entities.creatures.Creature;
import dev.hust.funnyfarm.gfx.Animation;
import dev.hust.funnyfarm.tiles.EnvironmentType;
import dev.hust.funnyfarm.tiles.Tile;

public abstract class Animal extends Creature {
	
	private float speed;
	private float xMove, yMove;
	
	// Sleeping animal
	private boolean isSleeping = false; 
	private long lastSleepTime;
	private long sleepTimeRemaining;
	private long lastSleepTimeCheck;
	
	//Animations
	private Animation animDown, animUp, animLeft, animRight;
	private Animation animSleep;
	private Animation animDead;

	public Animal(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		speed = getDefaultSpeed();
		xMove = 0;
		yMove = 0;
	}
	
	
	abstract public long getSleepTime();
	abstract public long getTimeBetweenSleeps();
	
	
	public long getLastSleepTime() {
		return lastSleepTime;
	}
	
	public void setLastSleepTime(long t) {
		lastSleepTime = t;
	}
	
	public boolean isSleeping() {
		return isSleeping;
	}
	
	public void setSleeping(boolean sleeping) {
		this.isSleeping = sleeping;
	}
	
	public Animation getAnimDown() {
		return animDown;
	}
	public Animation getAnimUp() {
		return animUp;
	}
	public Animation getAnimLeft() {
		return animLeft;
	}
	public Animation getAnimRight() {
		return animRight;
	}
	public Animation getAnimSleep() {
		return animSleep;
	}
	public Animation getAnimDead() {
		return animDead;
	}
	

	
	public void setAnimations(Animation animDown, Animation animUp, Animation animLeft, Animation animRight, Animation animSleep, Animation animDead) {
		this.animDown = animDown;
		this.animUp = animUp;
		this.animLeft = animLeft;
		this.animRight = animRight;
		this.animSleep = animSleep;
		this.animDead = animDead;
	}
	
	@Override
	public void tick() {
		
		// This method should be at first in tick(): updateBodyStatus();
		updateBodyStatus();
		if (!isLiving()) return;
		
		sleep();
		walk();
		
		
	}
	
	public void sleep() {
		long currentTime = getHandler().getGame().getSimTime();
		if (isSleeping()) {
			
			long delta = currentTime - lastSleepTimeCheck;
			sleepTimeRemaining -= delta;
			
			
			// Finish sleeping
			if (sleepTimeRemaining <= 0) {
				setLastSleepTime(currentTime);
				setSleeping(false);
				
				// After sleeping, the animals receive health
				increaseHealth(30);
			}
			
			lastSleepTimeCheck = currentTime;
			return;
		}
		
		
		if (currentTime - getLastSleepTime() >= getTimeBetweenSleeps()) {
			setSleeping(true);
			sleepTimeRemaining = getSleepTime();
			lastSleepTimeCheck = currentTime;
		}
	}
	
	
	public void walk() {
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
	
	
	public void move(){
		if(!checkEntityCollisions(xMove, 0f))
			moveX();
		if(!checkEntityCollisions(0f, yMove))
			moveY();
	}
	
	public void moveX(){
		if(xMove > 0){//Moving right
			int tx = (int) (getX() + xMove + getBounds().x + getBounds().width) / Tile.getTileWidth();
			
			if(!collisionWithTile(tx, (int) (getY() + getBounds().y) / Tile.getTileHeight()) &&
					!collisionWithTile(tx, (int) (getY() + getBounds().y + getBounds().height) / Tile.getTileHeight())){
				setX(getX() + xMove);
			}else{
				setX(tx * Tile.getTileWidth() - getBounds().x - getBounds().width - 1);
			}
			
		}else if(xMove < 0){//Moving left
			int tx = (int) (getX() + xMove + getBounds().x) / Tile.getTileWidth();
			
			if(!collisionWithTile(tx, (int) (getY() + getBounds().y) / Tile.getTileHeight()) &&
					!collisionWithTile(tx, (int) (getY() + getBounds().y + getBounds().height) / Tile.getTileHeight())){
				setX(getX() + xMove);
			}else{
				setX(tx * Tile.getTileWidth() + Tile.getTileWidth() - getBounds().x);
			}
			
		}
	}
	
	public void moveY(){
		if (yMove < 0) { //Up
			int ty = (int) (getY() + yMove + getBounds().y) / Tile.getTileHeight();
			
			if(!collisionWithTile((int) (getX() + getBounds().x) / Tile.getTileWidth(), ty) &&
					!collisionWithTile((int) (getX() + getBounds().x + getBounds().width) / Tile.getTileWidth(), ty)){
				setY(getY() + yMove);
			}else{
				setY(ty * Tile.getTileHeight() + Tile.getTileHeight() - getBounds().y);
			}
			
		} else if (yMove > 0){ //Down
			int ty = (int) (getY() + yMove + getBounds().y + getBounds().height) / Tile.getTileHeight();
			
			if(!collisionWithTile((int) (getX() + getBounds().x) / Tile.getTileWidth(), ty) &&
					!collisionWithTile((int) (getX() + getBounds().x + getBounds().width) / Tile.getTileWidth(), ty)){
				setY(getY() + yMove);
			}else{
				setY(ty * Tile.getTileHeight() - getBounds().y - getBounds().height - 1);
			}
			
		}
	}
	
	protected boolean collisionWithTile(int x, int y){
		EnvironmentType env = getHandler().getWorld().getTile(x, y).getEnvironmentType();
		boolean rightEnv  = isRightEnvironment(env);
			
		return !rightEnv;
	}
	
	protected void getMove(){

		Random randomGenerator = new Random();
		int direction;
		
		direction = randomGenerator.nextInt(60);
			
		if (direction == 0) {
			yMove = -getSpeed();
		} else if (direction == 1) {
			yMove = getSpeed();
		} else if (direction == 2) {
			xMove = -getSpeed();
		} else if (direction == 3) {
			xMove = getSpeed();
		} else if (direction == 4) {
			xMove = 0;
			yMove = 0;
		}
		
	}
	
	@Override
	public void render(Graphics g) {
		printInfo(g);
		g.drawImage(getCurrentAnimationFrame(), (int) (getX() -  getHandler().getGameCamera().getxOffset()), (int) (getY() -  getHandler().getGameCamera().getyOffset()), getWidth(), getHeight(), null);
	}
	
	private BufferedImage getCurrentAnimationFrame(){
		
		if (!isLiving()) return getAnimDead().getCurrentFrame();
		
		if (isSleeping())
			return getAnimSleep().getCurrentFrame();
		if(xMove < 0){
			return getAnimLeft().getCurrentFrame();
		} else if (xMove > 0){
			return animRight.getCurrentFrame();
		} else if (yMove < 0){
			return getAnimUp().getCurrentFrame();
		} else {
			return getAnimDown().getCurrentFrame();
		}
	}
	
	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}
	
	public float getSpeed() {
		float retSpeed = speed;
		
		if (getHealth() < 50) retSpeed *= 0.6;
		if (getFood() < 50) retSpeed *= 0.6;
		if (getWater() < 50) retSpeed *= 0.6;
		
		return retSpeed;
		
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	public abstract  EnvironmentType[] getEnvironments();


	abstract public float getDefaultSpeed();

	abstract public void setDefaultSpeed(float speed);
	
	
}