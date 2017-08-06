package dev.rightbehindu.testgame.entities.items;

import java.awt.Graphics;

import dev.rightbehindu.testgame.Game;
import dev.rightbehindu.testgame.entities.Entity;

public abstract class Item extends Entity {
	
	protected float bobAnim = (float) ((float) Math.random() * Math.random() * 10.0);
	
	public Item(Game game, int x, int y, int width, int height) {
		super(game, x, y, width, height);
	}

	public abstract void tick();
	public abstract void render(Graphics g);
}
