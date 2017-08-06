package dev.rightbehindu.testgame.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Tile {
	
	//STATIC STUFF
	
	public static Tile[] tiles = new Tile[256];
	public static Tile blank = new Blank(null, 4);
	public static Tile dungeonFloor = new Dungeon_Floor(0);
	public static Tile dungeonFloor2 = new Dungeon_Floor2(1);
	public static Tile dungeonPillar = new Dungeon_Pillar(2);
	public static Tile stoneWall = new Stone_Wall(3);
	
	//CLASS
	
	public static final int TILEWIDTH = 32, TILEHEIGHT = 32;
	
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	
	public void tick() {
		//Tile updates.
		
		
	}
	
	public void render(Graphics g, int x, int y) {
		if(id != 4) {
			g.drawImage(texture,  x, y, TILEWIDTH, TILEHEIGHT, null);
		} else {
			g.fillRect(x, y, TILEWIDTH, TILEHEIGHT);
		}
	}
	
	public abstract boolean isSolid();
	
	
	// Getters and Setters //
	
	public int getId() {
		return id;
	}
}
