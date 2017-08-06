package dev.rightbehindu.testgame.utils;

import dev.rightbehindu.testgame.Game;

public class Utils {

	private Game game;
	
	public Utils(Game game) {
		this.game = game;
	}
	
	public static float map(float x, float a, float b, float c, float d) {
		
		return (x-a)/(b-a) * (d-c) + c;
		
		
		
	}
}
