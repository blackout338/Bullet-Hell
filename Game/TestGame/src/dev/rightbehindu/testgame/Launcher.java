package dev.rightbehindu.testgame;

public class Launcher {
	public static void main(String[] args) {
		//new Display("My Title", 300, 300);
		Game game = new Game("Game title!", 640, 640);
		game.start();
	}
}
