package dev.rightbehindu.game.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.rightbehindu.game.gfx.Assets;

public abstract class Tile {
	
	public static int TILE_SIZE = 32;
	
	public static Tile[] tiles = new Tile[256];
	
	protected int id;
	protected BufferedImage texture;
	public static Tile Dungeon_Floor = new Dungeon_Floor(Assets.Dungeon_Floor, 1);
	
	public Tile(BufferedImage texture, int id) {
		
		this.texture = texture;
		
		tiles[id] = this;
	}
	
	public abstract void render(Graphics g, int x, int y);
	
	public abstract boolean isSolid();
	
	
}
