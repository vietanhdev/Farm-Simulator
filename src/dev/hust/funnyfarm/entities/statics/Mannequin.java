package dev.hust.funnyfarm.entities.statics;

import java.awt.Graphics;

import dev.hust.funnyfarm.Handler;
import dev.hust.funnyfarm.gfx.Assets;
import dev.hust.funnyfarm.items.Item;
import dev.hust.funnyfarm.tiles.Tile;

public class Mannequin extends StaticEntity {

	public Mannequin(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT * 2);
		
		setBounds(10,
				(int) (getHeight() / 1.5f),
				getWidth() - 20,
				(int) (getHeight() - getHeight() / 1.5f)
				);
		
	}

	@Override
	public void tick() {
		
	}
	
	@Override
	public void die(){
		 getHandler().getWorld().getItemManager().addItem(Item.woodItem.createNew((int) x, (int) y));
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tree, (int) (x -  getHandler().getGameCamera().getxOffset()), (int) (y -  getHandler().getGameCamera().getyOffset()), getWidth(), getHeight(), null);
	}

}
