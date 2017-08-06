package dev.rightbehindu.testgame.tiles;


import dev.rightbehindu.testgame.gfx.Assets;

public class Stone_Wall extends Tile {

	public Stone_Wall(int id) {
		super(Assets.stoneWall, id);
	}
	public boolean isSolid() {
		return true;
	}
}
