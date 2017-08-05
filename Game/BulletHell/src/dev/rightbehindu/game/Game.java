package dev.rightbehindu.game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.rightbehindu.game.gfx.Assets;
import dev.rightbehindu.game.managers.KeyManager;
import dev.rightbehindu.game.states.GameState;
import dev.rightbehindu.game.states.State;

public class Game implements Runnable {

	
	// Game Window Variables //
	private int width, height;
	private boolean running = false;
	private String title;
	
	// Display Variables //
	private Display display;
	private BufferStrategy bs;
	private Graphics g;
	
	// Managers //
	
	private KeyManager keyManager;
	
	// State Variables //
	
	private State currentState;
	private State gameState;
	
	// Thread and timing variables //
	private int fps;
	private Thread thread;
	private float startTime, deltaTime;

	
	public Game(String title, int WindowWidth, int WindowHeight) {
		this.width = WindowWidth;
		this.height = WindowHeight;
		this.title = title;
	}
	
	@Override
	public void run() {
		//Run by the Start function.
		//Initialize all game components
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps; // Amount of time to be able to run updates over.
		//double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		float dt = 0;
		startTime = System.nanoTime() / 1000000000;
		
		while(running) { 
			now = System.nanoTime();
			deltaTime += (now-lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(deltaTime >= 1) {
				tick();
				render();
				ticks++;
				deltaTime--;
			}
			
			if(timer >= 1000000000) {
				//If timer has been running for one second.
				System.out.println(ticks);
				this.fps = ticks;
				ticks = 0;
				timer = 0;
				
			}
		}
		
		stop();
	}
	
	private void tick() {
		if(getState() != null) {
			getState().tick();
		}
	}
	
	private void render() {
		//Draw things here.
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		
		
		g.clearRect(0,0,width,height);
		//g.drawImage(Assets.Dungeon_Floor, 50, 50, null);
		if(getState() != null) {
			getState().render(g);
			g.drawImage(Assets.Dungeon_Floor, 0, 0, null);
			//g.fillRect(10,  10, 100,  100);
		}
		//End Drawing...
		//---------------
		bs.show();
		g.dispose();
	}
	


	private void init() {
		this.keyManager = new KeyManager(this);
		//Initialize the display.
		this.display = new Display(title, width, height);
		this.display.getFrame().addKeyListener(keyManager);

		//Initialize the game state.
		this.gameState = new GameState(this);
		setState(gameState);
		
	}
	
	public synchronized void start() {
		//If the game is already running, return.
		if(running) 
			return;
		running = true;
		//Create a new thread and add an instance of the game to it.
		thread = new Thread(this);
		
		//Start the thread (runs the run function).
		thread.start();
	}
	
	public synchronized void stop() {
		if(!running) 
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
	//Other functions
	
	private void setState(State newState) {
		this.currentState = newState;
	}
	private State getState() {
		return this.currentState;
	}
	
	
}
