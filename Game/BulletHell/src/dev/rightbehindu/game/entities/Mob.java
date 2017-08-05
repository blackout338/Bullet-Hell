package dev.rightbehindu.game.entities;

import java.awt.Graphics;

import dev.rightbehindu.game.Game;

public abstract class Mob extends Entity {

	protected int health;
	protected int status = 0;
	protected boolean alive = true;
	
	public Mob(Game game, int x, int y, int width, int height, int health, int maxTick) {
		super(game, x, y, width, height);
		this.health = health;
		this.maxTick = maxTick;
	}
	
	private void Move() {
		this.x += this.vx;
		this.y += this.vy;
	}

	@Override
	public abstract void tick();

	@Override
	public abstract void render(Graphics g);

}
