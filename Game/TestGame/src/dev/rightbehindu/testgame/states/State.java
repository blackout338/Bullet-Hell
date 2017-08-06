package dev.rightbehindu.testgame.states;

import java.awt.Graphics;

import dev.rightbehindu.testgame.Game;
import dev.rightbehindu.testgame.Handler;
import dev.rightbehindu.testgame.entities.creatures.Player;

public abstract class State {
	//Bundles common things for states.
	
	private static State currentState = null;
	
	public static void setState(State state) {
		currentState = state;
	}
	public static State getState() {
		return currentState; 
	}
	
	//CLASS
	protected Game game;
	protected Handler handler;
	protected Player player1;
	
	public State(Game game, Handler handler) {
		this.game = game;
		this.handler = handler;
		
		
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	public Player getPlayer() {
		// TODO Auto-generated method stub
		return player1;
	}
	public void setPlayer(Player player) {
		player1 = player;
	}
	
}
