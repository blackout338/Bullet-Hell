package dev.rightbehindu.game.states;

import java.awt.Graphics;

import dev.rightbehindu.game.Game;
import dev.rightbehindu.game.gfx.Assets;
import dev.rightbehindu.game.worlds.StartingWorld;
import dev.rightbehindu.game.worlds.World;

public class GameState extends State {

	private World currentWorld;
	
	public GameState(Game game) {
		super(game);
		InitGameState();
	}

	
	private void InitGameState() {
		this.currentWorld = new StartingWorld(this.game, 100, 100);
		
		Assets.init();
	}
	
	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		this.currentWorld.render(g);
	}

}
