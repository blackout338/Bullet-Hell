package dev.rightbehindu.testgame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.rightbehindu.testgame.display.Display;
import dev.rightbehindu.testgame.entities.creatures.Player;
import dev.rightbehindu.testgame.gfx.Assets;
import dev.rightbehindu.testgame.input.KeyManager;
import dev.rightbehindu.testgame.states.State;
import dev.rightbehindu.testgame.utils.Utils;
import dev.rightbehindu.testgame.worlds.World;

public class Game implements Runnable{
	//Main game class. Handles most game running logic.
	
	private Display display;
	private Thread thread;
	private boolean running = false;
	private World world;
	private BufferStrategy bs;
	private Graphics g;
	
	private double deltaTime;
	private float fps;
	private float dt;
	private float startTime;
	
	public Utils utils;
	
	//Input
	private KeyManager keyManager;
	
	//States
	
	public static Handler handler;

	
	private String title;
	private int width, height;
	
	//Camera
	private Camera camera;
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		//this.Ihack = this;
		handler = new Handler(this);
		keyManager = new KeyManager(handler);	
		
		//display = new Display(title, width, height);
		utils = new Utils(this);
		
	}
	
	private void init() {
		//Game initialization.
		display = new Display(title,width,height);
		Assets.init(); 
		
		camera = new Camera(this, 0,0);
	
	}
	
	public void run() {
		
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
			setDt((now / 1000000000) - startTime);
			
			if(deltaTime >= 1) {
				tick();
				render();
				ticks++;
				deltaTime--;
			}
			
			if(timer >= 1000000000) {
				//If timer has been running for one second.
				//System.out.println(ticks);
				this.fps = ticks;
				ticks = 0;
				timer = 0;
				
			}
		}
		
		stop();
	}
	
	public double getDeltaTime() {
		return deltaTime;
	}

	public float getFps() {
		return fps;
	}

	public float getDt() {
		return dt;
	}

	public void setDt(float dt) {
		this.dt = dt;
	}

	int x = 0;
	
	private void tick() {
		keyManager.tick();
		
		//Update things here.
			State.getState().tick();
		
		
		checkStates();
	}
	
	
	private void render() {
		//Draw things here.
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		
		//Begin Drawing...
		//----------------
		
		//Clear screen.
		g.clearRect(0,0,width,height);
		//g.drawImage(Assets.Dungeon_Floor, 50, 50, null);
		if(State.getState() != null) {
			State.getState().render(g);
		}
		//End Drawing...
		//---------------
		bs.show();
		g.dispose();
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
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
	
	public Player getPlayer() {
		return handler.getGameState().getPlayer();	
	}
	
	public void checkStates() {
		/*
		boolean[] keys = keyManager.getKeys();
		if(keys[KeyEvent.VK_E]) {
			if(State.getState() == menuState)
				return;
			State.setState(menuState);
		}
		
		if(keys[KeyEvent.VK_ESCAPE]) {
			if(State.getState() == gameState) 
				return;
			State.setState(gameState);
			
			
		}
		*/
	}
	
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	
	public Camera getCamera() {
		return camera;
	}
	
	public Handler getHandler() {
		return handler;
	}
	
	public void setWorld(World world) {
		this.world = world;
	}
	public World getWorld() {
		return world;
	}
	
	
}
