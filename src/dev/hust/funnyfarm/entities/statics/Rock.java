package dev.hust.funnyfarm.entities.statics;

import java.awt.Graphics;

import dev.hust.funnyfarm.Handler;
import dev.hust.funnyfarm.gfx.Assets;
import dev.hust.funnyfarm.tiles.Tile;

public class Rock extends StaticEntity {

	public Rock(Handler handler, float x, float y) {
		super(handler, x, y, Tile.getTileWidth(), Tile.getTileHeight());
		
		setBounds(3,
				(int) (getHeight() / 2f),
				getWidth() - 6,
				(int) (getHeight() - getHeight() / 2f)
				);
	}

	@Override
	public void tick() {
		
	}
	
	@Override
	public void die(){

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.rock, (int) (getX() -  getHandler().getGameCamera().getxOffset()), (int) (getY() -  getHandler().getGameCamera().getyOffset()), getWidth(), getHeight(), null);
	}

}
