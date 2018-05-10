package dev.hust.funnyfarm.entities.creatures.animals;

import dev.hust.funnyfarm.Handler;
import dev.hust.funnyfarm.gfx.Animation;
import dev.hust.funnyfarm.gfx.Assets;


public class Fish extends Animal {

	public Fish(Handler handler, float x, float y) {
		super(handler, x, y, Animal.DEFAULT_CREATURE_WIDTH, Animal.DEFAULT_CREATURE_HEIGHT);
	
		setBounds(0,0,64,64);
		
		//Animations
		Animation animDown = new Animation(500, Assets.fish_down);
		Animation animUp = new Animation(500, Assets.fish_up);
		Animation animLeft = new Animation(500, Assets.fish_left);
		Animation animRight = new Animation(500, Assets.fish_right);
		super.setAnimations(animDown, animUp, animLeft, animRight);
		
	}
	
	
	@Override
	public String getEnvironments() {
		return "water";
	}

	
	@Override
	public void die(){
		System.out.println("You lose");
	}
	

}
