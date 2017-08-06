package dev.rightbehindu.testgame.tiles;

import java.awt.image.BufferedImage;

public class Blank extends Tile {

	public Blank(BufferedImage texture, int id) {
		super(texture, id);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isSolid() {
		return true;
	}
	
}
