package dev.rightbehindu.testgame.states;

import java.awt.Graphics;
import java.util.LinkedList;

import dev.rightbehindu.testgame.Game;
import dev.rightbehindu.testgame.Handler;
import dev.rightbehindu.testgame.entities.Entity;
import dev.rightbehindu.testgame.entities.creatures.Player;
import dev.rightbehindu.testgame.entities.items.Potion;
import dev.rightbehindu.testgame.entities.projectiles.TestProjectile;
import dev.rightbehindu.testgame.worlds.World;

public class GameState extends State {

	private Player player;
	
	private World world;
	
	private float rot;
	
	private Game game;
	
	private LinkedList<Potion> testPotions = new LinkedList<Potion>();
	
	public GameState(Game game, Handler handler) {
		super(game, handler);

		world = new World(game,"");
		player = new Player(game, 100,100); 
		
		this.setPlayer(player);
		
		this.game = game;
		this.rot = 0;
		

		
		
		//Create all objects.
		createWorldObjects(game);
		
		
		//Handler Functions
		handler.addObject(player);
		handler.printEntities();
		
		game.setWorld(world);
	}
	
	@Override
	public void tick() {
		game.getCamera().tick();
		player.tick();
		world.tick();
		//Update Potions
		for(int i = 0; i < handler.getObject().size(); i++ ) {
			Entity ent = handler.getObject().get(i);
			ent.tick();
		}
		for(int i = 0; i < handler.getProjectiles().size(); i++) {
			TestProjectile projectile = (TestProjectile) handler.getProjectiles().get(i);
			if(projectile.isDestroyed()) {
				handler.removeProjectile(i);
			} else {
				projectile.tick();
			}
		}
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		player.render(g);

		for(int i = 0; i < handler.getObject().size(); i++ ) {
			handler.getObject().get(i).render(g);
		}
		for(int i = 0; i < handler.getProjectiles().size(); i++) {
			handler.getProjectiles().get(i).render(g);
		}
		
	}
	
	public World getWorld() {
		return world;
	}
	
	private void createWorldObjects(Game game) {
		//Potions
		for(int i = 0; i < 1; i++) {
			Potion newPot = new Potion(game, (int) (Math.random()*game.getWidth()), (int) (Math.random()*game.getHeight()));
			handler.addObject(newPot);
		}
	}
	
	public Player getPlayer() {
		return player;
	}
	
}
