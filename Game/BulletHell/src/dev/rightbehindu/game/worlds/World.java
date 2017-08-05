package dev.rightbehindu.game.worlds;

import java.awt.Graphics;

import dev.rightbehindu.game.Game;

public abstract class World {

	protected Game game;
	protected int rows, cols;
	protected int width, height;
	
	private int GAME_TILE_SIZE = 32;
	
	public World(Game game, int rows, int cols) {
		this.game = game;
		this.rows = rows;
		this.cols = cols;
		this.width = cols * GAME_TILE_SIZE;
		this.height = rows * GAME_TILE_SIZE;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
}
