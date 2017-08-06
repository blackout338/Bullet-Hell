package dev.rightbehindu.testgame.entities.projectiles;

import java.awt.Color;
import java.awt.Graphics;

import dev.rightbehindu.testgame.Camera;
import dev.rightbehindu.testgame.Game;
import dev.rightbehindu.testgame.entities.Entity;

public class TestProjectile extends Projectile {

	private int index;
	private float sizeIncrementor = 0.1f;
	private float size;
	private float sizeAnimSpeed = 10;
	
	public TestProjectile(Game game, float x, float y, float vx, float vy, int width, int height, int index) {
		super(game, x, y, vx, vy, width, height);
		this.index = index;
		this.destroyed = false;
		this.size = 10;
	}

	@Override
	public void tick() {
		x += vx;
		y += vy;
		
		if(this.size < 5) {
			this.sizeIncrementor = 0.1f;
		} else if(this.size > 32) {
			this.sizeIncrementor = -0.1f;
		}
		
		this.size += this.sizeIncrementor * this.sizeAnimSpeed;
		
		if(!isInScreen(this)) {
			//game.getHandler().removeProjectile(this.index);
			this.destroyed = true;
			//System.out.println("OUTOFSCREN");
		}
	}

	public boolean isDestroyed() {
		return destroyed;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillOval((int) (x - game.getCamera().getxOffset()), (int) (y - game.getCamera().getyOffset()), (int) size, (int) size);
		
	}
	
	private boolean isInScreen(Entity e) {
		Camera camera = game.getCamera();
		if(e.getX() < camera.getxStart() || e.getX() > camera.getxEnd() || e.getY() < camera.getyStart() || e.getY() > camera.getyEnd())
			return false;
		
		return true;
	}

}
