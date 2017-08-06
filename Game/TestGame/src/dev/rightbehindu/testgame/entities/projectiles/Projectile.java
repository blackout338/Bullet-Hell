package dev.rightbehindu.testgame.entities.projectiles;

import java.awt.Graphics;

import dev.rightbehindu.testgame.Game;
import dev.rightbehindu.testgame.entities.Entity;

public abstract class Projectile extends Entity {
	
	protected float vx, vy;
	protected int width, height;
	protected Game game;
	
	public Projectile(Game game, float x, float y, float vx, float vy, int width, int height) {
		super(game,x,y,width,height);
		this.game = game;
		this.x = x;
		this.y = y;
		this.vx = vx;
		this.vy = vy;
		this.width = width;
		this.height = height;
		
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
}
