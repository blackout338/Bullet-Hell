package dev.rightbehindu.game.entities;

import java.awt.Graphics;

import dev.rightbehindu.game.Game;

public abstract class Entity {

	protected Game game;
	protected int x, y, width, height, vx, vy;
	protected float speed;
	protected boolean exists;
	
	//Animation Variables
	protected float animTick = 0;
	protected float lastTick = 0;
	protected int maxTick;
	
	public Entity(Game game, int x, int y, int width, int height) {
		this.game = game;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
}
