package dev.rightbehindu.testgame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import dev.rightbehindu.testgame.Handler;
import dev.rightbehindu.testgame.entities.projectiles.TestProjectile;

public class KeyManager implements KeyListener {

	private boolean[] keys;
	private Handler handler;
	
	public boolean up, down, left, right;
	
	public KeyManager(Handler handler) {
		keys = new boolean[256];
		this.handler = handler;
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
