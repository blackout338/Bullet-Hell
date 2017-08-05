package dev.rightbehindu.game.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Dungeon_Floor extends Tile {

	public Dungeon_Floor(BufferedImage texture, int id) {
		super(texture, id);
	}

	@Override
	public boolean isSolid() {
		return false;
	}

	@Override
	public void render(Graphics g, int x, int y) {
		g.drawImage(this.texture, x * TILE_SIZE, y * TILE_SIZE, null);
	}



}
