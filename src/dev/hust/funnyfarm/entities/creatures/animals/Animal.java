package dev.hust.funnyfarm.entities.creatures.animals;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import dev.hust.funnyfarm.Handler;
import dev.hust.funnyfarm.entities.creatures.Creature;
import dev.hust.funnyfarm.gfx.Animation;
import dev.hust.funnyfarm.tiles.Tile;

public abstract class Animal extends Creature {
	
	public static final float DEFAULT_SPEED = 5.0f;
	
	private float speed;
	private float xMove, yMove;
	
	String currentEnvironment;
	
	//Animations
	private Animation animDown, animUp, animLeft, animRight;

	public Animal(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
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
	
	public String getCurrentEnvironment() {
		return currentEnvironment;
	}
	
	public void setCurrentEnvironment(String env) {
		currentEnvironment = env;
	}
	
	public void setAnimations(Animation animDown, Animation animUp, Animation animLeft, Animation animRight) {
		this.animDown = animDown;
		this.animUp = animUp;
		this.animLeft = animLeft;
		this.animRight = animRight;
	}
	
	@Override
	public void tick() {
		//Animations
		animTick();
		
		//Movement
		getMove();
		
		move();
		//handler.getGameCamera().centerOnEntity(this);
	}
	
	
	
	protected void animTick() {
		//Animations
		getAnimDown().tick();
		getAnimUp().tick();
		getAnimRight().tick();
		getAnimLeft().tick();
	}
	
	
	public void move(){
		if(!checkEntityCollisions(xMove, 0f))
			moveX();
		if(!checkEntityCollisions(0f, yMove))
			moveY();
	}
	
	public void moveX(){
		if(xMove > 0){//Moving right
			int tx = (int) (x + xMove + getBounds().x + getBounds().width) / Tile.TILEWIDTH;
			
			if(!collisionWithTile(tx, (int) (y + getBounds().y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + getBounds().y + getBounds().height) / Tile.TILEHEIGHT)){
				x += xMove;
			}else{
				x = tx * Tile.TILEWIDTH - getBounds().x - getBounds().width - 1;
			}
			
		}else if(xMove < 0){//Moving left
			int tx = (int) (x + xMove + getBounds().x) / Tile.TILEWIDTH;
			
			if(!collisionWithTile(tx, (int) (y + getBounds().y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + getBounds().y + getBounds().height) / Tile.TILEHEIGHT)){
				x += xMove;
			}else{
				x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - getBounds().x;
			}
			
		}
	}
	
	public void moveY(){
		if(yMove < 0){//Up
			int ty = (int) (y + yMove + getBounds().y) / Tile.TILEHEIGHT;
			
			if(!collisionWithTile((int) (x + getBounds().x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + getBounds().x + getBounds().width) / Tile.TILEWIDTH, ty)){
				y += yMove;
			}else{
				y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - getBounds().y;
			}
			
		}else if(yMove > 0){//Down
			int ty = (int) (y + yMove + getBounds().y + getBounds().height) / Tile.TILEHEIGHT;
			
			if(!collisionWithTile((int) (x + getBounds().x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + getBounds().x + getBounds().width) / Tile.TILEWIDTH, ty)){
				y += yMove;
			}else{
				y = ty * Tile.TILEHEIGHT - getBounds().y - getBounds().height - 1;
			}
			
		}
	}
	
	protected boolean collisionWithTile(int x, int y){

		String env = getHandler().getWorld().getTile(x, y).getName();
		boolean rightEnv  = isRightEnvironment(env);
		
		if (rightEnv)
			setCurrentEnvironment(env);
			
		return !rightEnv;
	}
	
	protected void getMove(){

		Random randomGenerator = new Random();
		int direction;
		
		direction = randomGenerator.nextInt(60);
		
			
		if (direction == 0) {
			yMove = -speed;
		} else if (direction == 1) {
			yMove = speed;
		} else if (direction == 2) {
			xMove = -speed;
		} else if (direction == 3) {
			xMove = speed;
		} else if (direction == 4) {
			xMove = 0;
			yMove = 0;
		}
		
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x -  getHandler().getGameCamera().getxOffset()), (int) (y -  getHandler().getGameCamera().getyOffset()), getWidth(), getWidth(), null);
	}
	
	private BufferedImage getCurrentAnimationFrame(){
		if(xMove < 0){
			return animLeft.getCurrentFrame();
		} else if (xMove > 0){
			return animRight.getCurrentFrame();
		} else if (yMove < 0){
			return animUp.getCurrentFrame();
		} else {
			return animDown.getCurrentFrame();
		}
	}

	
	@Override
	public String getEnvironments() {
		return "water grass dirt";
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
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	@Override
	public void die(){
		this.setHealth(0);
	}
	
}