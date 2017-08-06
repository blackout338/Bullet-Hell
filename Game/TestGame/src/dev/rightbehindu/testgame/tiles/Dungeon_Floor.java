package dev.rightbehindu.testgame.tiles;


import dev.rightbehindu.testgame.gfx.Assets;

public class Dungeon_Floor extends Tile {

	
	
	public Dungeon_Floor(int id) {
		super(Assets.Dungeon_Floor, id);
	}

	@Override
	public boolean isSolid() {
		// TODO Auto-generated method stub
		return false;
	}
	

}
