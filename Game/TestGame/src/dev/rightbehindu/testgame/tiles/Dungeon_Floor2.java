package dev.rightbehindu.testgame.tiles;

import dev.rightbehindu.testgame.gfx.Assets;

public class Dungeon_Floor2 extends Tile {

	public Dungeon_Floor2(int id) {
		super(Assets.Dungeon_Floor2, id);
	}

	@Override
	public boolean isSolid() {
		return false;
	}
	
	
}
