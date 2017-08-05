package dev.rightbehindu.game.managers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import dev.rightbehindu.game.Game;


public class KeyManager implements KeyListener {

	private boolean[] keys;
	private Game game;
	public boolean up, down, left, right;
	
	public KeyManager(Game game) {
		keys = new boolean[256];
	}
	
	public void tick() {
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		
		
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		
		if (e.VK_E == e.getKeyCode()) {
			System.out.println("Magic");
		}
	}

	public boolean[] getKeys() {
		return keys;
	}


	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//Don't need atm.
	}

}