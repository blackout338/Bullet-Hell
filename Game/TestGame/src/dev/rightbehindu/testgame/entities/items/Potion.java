package dev.rightbehindu.testgame.entities.items;

import java.awt.Graphics;
import java.awt.Rectangle;

import dev.rightbehindu.testgame.Game;
import dev.rightbehindu.testgame.gfx.Assets;

public class Potion extends Item {
	
	
	public Potion(Game game, int x, int y) {
		super(game, x, y, 16, 16);
		this.hitbox = new Rectangle();
		this.hitbox.x = x;
		this.hitbox.y = y;
		this.hitbox.width = x + 16;
		this.hitbox.height = y + 16;
	}

	public void tick() {
		animate();
	}

	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(Assets.potion, (int) (x - game.getCamera().getxOffset() - width/2), (int) (y - game.getCamera().getyOffset()) - height/2, width, height, null);
		this.drawHitbox(g);
	}
	
	private void animate() {
		this.bobAnim += 0.06;
		this.y = (float) (this.y +  Math.sin(this.bobAnim)/4);
		
		this.hitbox.y = (int) (this.y + Math.sin(this.bobAnim)/4);
	}

}
