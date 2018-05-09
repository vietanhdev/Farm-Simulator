package dev.hust.funnyfarm.entities.statics;

import dev.hust.funnyfarm.Handler;
import dev.hust.funnyfarm.entities.Entity;

public abstract class StaticEntity extends Entity {
	
	public StaticEntity(Handler handler, float x, float y, int width, int height){
		super(handler, x, y, width, height);
	}

}
