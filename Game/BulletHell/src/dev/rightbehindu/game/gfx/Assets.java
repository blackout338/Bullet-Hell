package dev.rightbehindu.game.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage player_left1, player_left2, player_left3, player_left4,
								player_right1, player_right2, player_right3, player_right4,
								player_up1, player_up2, player_up3, player_up4,
								player_down1, player_down2, player_down3, player_down4,
								Dungeon_Floor, Dungeon_Floor2, Dungeon_Pillar,
								
								potion, stoneWall;
	
	
	public static BufferedImage[][] Player_Anims = new BufferedImage[5][5];
	public static int IDLE = 0, RIGHT = 1, LEFT = 2, UP = 3, DOWN = 4;

	public static void init() {
		
		for(int i = 0; i < 5; i++) {
			Player_Anims[RIGHT][i] = ImageLoader.loadImage("/textures/wizard/3_RUN_00" + i + ".png");
			Player_Anims[LEFT][i] = ImageLoader.loadImage("/textures/wizard/3_RUN_00" + i + ".png");
			Player_Anims[UP][i] = ImageLoader.loadImage("/textures/wizard/3_RUN_00" + i + ".png");
			Player_Anims[DOWN][i] = ImageLoader.loadImage("/textures/wizard/3_RUN_00" + i + ".png");
			Player_Anims[IDLE][i] = ImageLoader.loadImage("/textures/wizard/3_RUN_00" + i + ".png");
		}		
		
		Spritesheet worldSheet = new Spritesheet(ImageLoader.loadImage("/textures/tileset.png"));
		
		
		Dungeon_Floor = worldSheet.crop(3*32,8*32, width, height);
		Dungeon_Floor2 = worldSheet.crop(32,8*32, width, height);
		Dungeon_Pillar = worldSheet.crop(4*32, 8*32, width, height);
	}
}
