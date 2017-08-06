package dev.rightbehindu.testgame.worlds;

import java.awt.Graphics;

import dev.rightbehindu.testgame.Game;
import dev.rightbehindu.testgame.tiles.Tile;

public class World {
	private int[][] GAME_MAP;
    private Game game;
	private int width, height;
	private int xStart, xEnd, yStart, yEnd;
	
	public World(Game game, String path) {
		this.game = game;

		loadWorld(path);
	}
	
	public void tick() {


	}
	
	public void render(Graphics g) {
	    this.xStart = (int) (game.getCamera().getxOffset());
		
		this.xEnd = (int) (game.getCamera().getxOffset() + game.getWidth());
		this.yStart = (int) (game.getCamera().getyOffset());
		this.yEnd = (int) (game.getCamera().getyOffset() + game.getHeight());
		
		int xTileStart = this.xStart / Tile.TILEWIDTH - 1;
		int xTileEnd = this.xEnd / Tile.TILEWIDTH + 1;
		int yTileStart = this.yStart / Tile.TILEHEIGHT - 1;
		int yTileEnd = this.yEnd / Tile.TILEHEIGHT + 1;
		//System.out.println((game.getCamera().getxOffset() + game.getWidth()) / Tile.TILEWIDTH);
		for(int y = yTileStart; y < yTileEnd; y++) {
			for(int x = xTileStart; x < xTileEnd; x++) {
				getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - game.getCamera().getxOffset()), (int) (y * Tile.TILEHEIGHT - game.getCamera().getyOffset()));
			}
		}
	}
	
	public int getxStart() {
		return xStart;
	}

	public void setxStart(int xStart) {
		this.xStart = xStart;
	}

	public int getxEnd() {
		return xEnd;
	}

	public void setxEnd(int xEnd) {
		this.xEnd = xEnd;
	}

	public int getyStart() {
		return yStart;
	}

	public void setyStart(int yStart) {
		this.yStart = yStart;
	}

	public int getyEnd() {
		return yEnd;
	}

	public void setyEnd(int yEnd) {
		this.yEnd = yEnd;
	}

	public Tile getTile(int x, int y) {
		if( x < 0 || y < 0 || x >= width || y >= height) {
			return Tile.blank;
		}
		
		Tile t = Tile.tiles[GAME_MAP[x][y]];
		
		if(t == null) {
			return Tile.dungeonFloor;
		}
		
		return t;
	}
	
	public int getTileId(int x, int y) {
		if( x < 0 || y < 0 || x >= width || y >= height) {
			return Tile.blank.getId();
		}
		
		Tile t = Tile.tiles[GAME_MAP[x][y]];
		
		if(t == null) {
			return Tile.dungeonFloor.getId();
		}
		
		return t.getId();
	}
	
	private void loadWorld(String path) {
		width = 20;
		height = 20;
		GAME_MAP = new int[width][height];
		
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				//int temp = (Math.random() <= 0.5) ? 0 : 3;
				if(x == 0 || y == 0 || x == width-1 || y == height - 1) {
					GAME_MAP[x][y] = 3;
				} else {
					GAME_MAP[x][y] = 0;
				}
			}
		}
		
	}
	
	
}
