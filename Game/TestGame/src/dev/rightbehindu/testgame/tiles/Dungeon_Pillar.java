package dev.rightbehindu.testgame.tiles;

import dev.rightbehindu.testgame.gfx.Assets;

public class Dungeon_Pillar extends Tile {

	public Dungeon_Pillar(int id) {
		super(Assets.Dungeon_Pillar, id);
	}
	
	public boolean isSolid() {
		return true;
	}

}
