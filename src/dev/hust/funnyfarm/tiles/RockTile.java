package dev.hust.funnyfarm.tiles;

import dev.hust.funnyfarm.gfx.Assets;

public class RockTile extends Tile {

	public RockTile(int id) {
		super(Assets.stone, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}
