package dev.hust.funnyfarm.entities.creatures.plants;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.hust.funnyfarm.Handler;
import dev.hust.funnyfarm.entities.creatures.*;
import dev.hust.funnyfarm.gfx.Animation;

public abstract class Plant extends Creature {
	
	private long growUpTime;
	private Animation animSmall, animBig;
	private Animation animDead;

	public Plant(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		setHealthLostPerTick(0.0);
		setGrowUpTime(1000);
	}

	@Override
	public void tick() {
		updateBodyStatus();
	}

	@Override
	public void render(Graphics g) {
		printInfo(g);
		g.drawImage(getCurrentAnimationFrame(), (int) (getX() -  getHandler().getGameCamera().getxOffset()), (int) (getY() -  getHandler().getGameCamera().getyOffset()), getWidth(), getWidth(), null);
	}
	
	private BufferedImage getCurrentAnimationFrame(){
		if (!isLiving()) return getAnimDead().getCurrentFrame();
		if (getAge() < getGrowUpTime()) {
			return getAnimSmall().getCurrentFrame();
		} else {
			return getAnimBig().getCurrentFrame();
		}
	}
	
	
	public void setAnimations(Animation animSmall, Animation animBig, Animation animDead) {
		this.animSmall = animSmall;
		this.animBig = animBig;
		this.animDead = animDead;
	}
	
	public Animation getAnimDead() {
		return animDead;
	}
	
	public Animation getAnimSmall() {
		return animSmall;
	}
	
	public Animation getAnimBig() {
		return animBig;
	}


	public long getGrowUpTime() {
		return growUpTime;
	}

	public void setGrowUpTime(long growUpTime) {
		this.growUpTime = growUpTime;
	}

}
