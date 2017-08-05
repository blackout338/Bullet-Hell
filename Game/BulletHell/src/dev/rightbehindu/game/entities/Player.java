package dev.rightbehindu.game.entities;

import java.awt.Graphics;

import dev.rightbehindu.game.Game;
import dev.rightbehindu.game.gfx.Assets;

public class Player extends Mob {

	private String name;
	private int level;
	
	public Player(Game game, int x, int y, int width, int height, int health) {
		super(game, x, y, width, height, health, 4);
		this.level = 1;
		this.name = "Test bot :3";
	}

	@Override
	public void tick() {
		this.animTick += 0.8;
		System.out.println(this.animTick);
		if(this.animTick > this.maxTick) {
			this.animTick = 0;
			
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.Player_Anims[this.status][(int) this.animTick], this.x - (this.width/2), this.y - (this.height/2), null);
		
	}

}
