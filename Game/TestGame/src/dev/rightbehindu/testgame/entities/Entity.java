package dev.rightbehindu.testgame.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import dev.rightbehindu.testgame.Game;


public abstract class Entity {
	
	protected float x, y;
	protected Game game;
	protected int width, height;
	protected int hbX, hbY, hbW, hbH;
	protected Rectangle hitbox;
	public Rectangle getHitbox() {
		return hitbox;
	}

	public void setHitbox(Rectangle hitbox) {
		this.hitbox = hitbox;
	}

	protected boolean destroyed;

	
	public Entity(Game game, float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.game = game;
		this.width = width;
		this.height = height;
	}
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	protected void drawHitbox(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int) (this.hitbox.x - game.getCamera().getxOffset()), (int) (this.hitbox.y - game.getCamera().getyOffset()), this.hitbox.width, this.hitbox.height);
	}

	public abstract void tick();
	
	public abstract void render(Graphics g);
	
}
