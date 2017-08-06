package dev.rightbehindu.testgame.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import dev.rightbehindu.testgame.Game;
import dev.rightbehindu.testgame.entities.Entity;
import dev.rightbehindu.testgame.gfx.Assets;
import dev.rightbehindu.testgame.tiles.Tile;

public class Player extends Creature {
	
	
	public static int IDLE = 0, RIGHT = 1, LEFT = 2, UP = 3, DOWN = 4;
	
	
	private int animTick = 0;
	private float animTickInc = 0.0f;
	private int direction = 0;
	public Player(Game game, float x, float y) {
		super(game, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		this.hitbox = new Rectangle();
		this.hitbox.x = (int) (x + Creature.DEFAULT_CREATURE_WIDTH/4);
		this.hitbox.y = (int) (y + Creature.DEFAULT_CREATURE_HEIGHT/4);
		this.hitbox.width =  Creature.DEFAULT_CREATURE_WIDTH/2;
		this.hitbox.height = (int) (Creature.DEFAULT_CREATURE_HEIGHT*0.75);
	}
	
	
	
	// Getters and Setters //
	
	public Rectangle getHitbox() {
		return this.hitbox;
	}
	
	public int[] getBounds() {
		int[] hbx = new int[4];
		hbx[0] = (int) this.x + (this.width/4);
		hbx[1] = (int) this.y + (this.height/4);
		hbx[2] = (int) this.width/2;
		hbx[3] = (int) (this.height*0.75);
		return hbx;
	}
	
	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public void getInput() {
		xMove = 0;
		yMove = 0;
		
		if(game.getKeyManager().up) {
			setyMove(-speed);
			direction = UP;
		} else if(game.getKeyManager().down) {
			setyMove(speed);
			direction = DOWN;
		} else if(game.getKeyManager().left) {
			setxMove(-speed);
			direction = LEFT;
		} else if(game.getKeyManager().right) {
			setxMove(speed);
			direction = RIGHT;
		} else {
			direction = IDLE;
		}
		
	}
	
	@Override
	public void tick() {
		getInput();
		updatePlayer();
		if(canMove()) {
			move();
		}
		getCollisions();
		
		//game.getCamera().centerOnEntity(this);
	}
	
	private void getCollisions() {
		//Potions
		LinkedList<Entity> potions = game.getHandler().getObject();
		for(int i = 0; i < potions.size(); i++) {
			if(potions.get(i).getHitbox().intersects(getHitbox())) {
				System.out.println("HITTING");
			}
		}
	}
	
	private boolean canMove() {
		
		int testX = (int) ((this.getX() + this.getxMove()) / 32) + 1;
		int testY = (int) ((this.getY() + this.getyMove()) / 32) + 1;
		
		Tile testTile = game.getWorld().getTile(testX, testY);
		if(testTile.isSolid()) {
			System.out.println(testTile.getId());
			return false;
		}
		
		return true;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.Player_Anims[direction][animTick], (int) (x - game.getCamera().getxOffset()), (int) (y - game.getCamera().getyOffset()), width, height, null);
		this.drawHitbox(g);
	}
	


	public void updatePlayer() {
		animTickInc += 0.1;
		animTick = (int) Math.floor(animTickInc);

		if(animTick > 3) {
			animTick = 0;
			animTickInc = 0;
		}
	}
}
