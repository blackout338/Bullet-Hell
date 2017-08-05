package dev.rightbehindu.game.worlds;

import java.awt.Graphics;

import dev.rightbehindu.game.Game;
import dev.rightbehindu.game.tiles.Tile;

public class StartingWorld extends World {

	private int[][] WORLD_MAP;
	
	public StartingWorld(Game game, int rows, int cols) {
		super(game, rows, cols);
		WORLD_MAP = new int[rows][cols];
		InitializeMap();
	}
	
	private void InitializeMap() {
		//Generate Map...
		for(int i = 0; i < this.rows; i++) {
			for(int j = 0; j < this.cols; j++) {
				this.WORLD_MAP[i][j] = 1;
			}
		}
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		for(int i = 0; i<this.rows; i++) {
			for(int j = 0; j < this.cols; j++) {
				//System.out.println(i + " " + j);
				getTile(i, j).render(g, i, j);
			}
		}
	}
	
	private Tile getTile(int x, int y) {
		return Tile.tiles[this.WORLD_MAP[x][y]];
	}

}
