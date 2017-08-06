package dev.rightbehindu.testgame;


import java.util.LinkedList;

import dev.rightbehindu.testgame.entities.Entity;
import dev.rightbehindu.testgame.states.GameState;
import dev.rightbehindu.testgame.states.MenuState;
import dev.rightbehindu.testgame.states.State;
import dev.rightbehindu.testgame.worlds.World;

public class Handler {

	LinkedList<Entity> object = new LinkedList<Entity>();
	LinkedList<Entity> projectiles = new LinkedList<Entity>();
	
	public LinkedList<Entity> getObject() {
		return object;
	}

	public void setObject(LinkedList<Entity> object) {
		this.object = object;
	}

	public LinkedList<Entity> getProjectiles() {
		return projectiles;
	}

	public void setProjectiles(LinkedList<Entity> projectiles) {
		this.projectiles = projectiles;
	}


	private State gameState;
	private State menuState;
	private Game game;
	
	public Handler(Game game) {
		this.gameState = new GameState(game, this);
		this.menuState = new MenuState(game, this);
		this.game = game;
		State.setState(gameState);
	}
	
	public void addObject(Entity e) {
		object.add(e);
	}
	public void addProjectile(Entity e) {
		projectiles.add(e);
	}
	public State getGameState() {
		return gameState;
	}

	public void setGameState(State gameState) {
		this.gameState = gameState;
	}

	public void removeProjectile(int index) {
		projectiles.remove(index);
	}
	public LinkedList<Entity> getObjects() {
		return object;
	}
	
	
	
	public void printEntities() {
		for(int i = 0; i < object.size(); i++) {
			Entity thisObj = object.get(i);
			System.out.println(thisObj.toString());
		}
		
		for(int i=0; i < projectiles.size(); i++) {
			System.out.println(projectiles.get(i).toString());
		}
	}
	
	public Game getGame() {
		return game;
	}
	
	public World getWorld() {
		State thisgame = gameState;
		
		return new World(game, "");
	}
	
	
	public void switchStateMenu() {
		State.setState(menuState);
	}
	
}
