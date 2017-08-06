package dev.rightbehindu.testgame.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage player_left1, player_left2, player_left3, player_left4,
								player_right1, player_right2, player_right3, player_right4,
								player_up1, player_up2, player_up3, player_up4,
								player_down1, player_down2, player_down3, player_down4,
								Dungeon_Floor, Dungeon_Floor2, Dungeon_Pillar,
								
								potion, stoneWall;
	
	
	public static BufferedImage[][] Player_Anims = new BufferedImage[5][4];
	public static int IDLE = 0, RIGHT = 1, LEFT = 2, UP = 3, DOWN = 4;

	public static void init() {
		Spritesheet sheet = new Spritesheet(ImageLoader.loadImage("/textures/spritesheet.png"));
		
		player_left1 = sheet.crop(0, 96, width, height);
		player_left2 = sheet.crop(32, 96, width, height);
		player_left3 = sheet.crop(64, 96, width, height);
		player_left4 = sheet.crop(96, 96, width, height);
		
		player_right1 = sheet.crop(0, 32*2, width, height);
		player_right2 = sheet.crop(32*1, 32*2, width, height);
		player_right3 = sheet.crop(32*2, 32*2, width, height);		
		player_right4 = sheet.crop(32*3, 32*2, width, height);
		
		player_down1 = sheet.crop(0, 32*0, width, height);
		player_down2 = sheet.crop(32*1, 32*0, width, height);
		player_down3 = sheet.crop(32*2, 32*0, width, height);
		player_down4 = sheet.crop(32*3, 32*0, width, height);
		
		player_up1 = sheet.crop(0, 32*1, width, height);
		player_up2 = sheet.crop(32*1, 32*1, width, height);
		player_up3 = sheet.crop(32*2, 32*1, width, height);
		player_up4 = sheet.crop(32*3, 32*1, width, height);

		Player_Anims[IDLE][0] = player_left1;
		Player_Anims[IDLE][1] = player_left1;
		Player_Anims[IDLE][2] = player_left1;		
		Player_Anims[IDLE][3] = player_left1;
		
		Player_Anims[RIGHT][0] = player_right1;
		Player_Anims[RIGHT][1] = player_right2;
		Player_Anims[RIGHT][2] = player_right3;
		Player_Anims[RIGHT][3] = player_right4;

		Player_Anims[LEFT][0] = player_left1;
		Player_Anims[LEFT][1] = player_left2;
		Player_Anims[LEFT][2] = player_left3;
		Player_Anims[LEFT][3] = player_left4;

		Player_Anims[UP][0] = player_up1;
		Player_Anims[UP][1] = player_up2;
		Player_Anims[UP][2] = player_up3;
		Player_Anims[UP][3] = player_up4;
		
		Player_Anims[DOWN][0] = player_down1;
		Player_Anims[DOWN][1] = player_down2;
		Player_Anims[DOWN][2] = player_down3;
		Player_Anims[DOWN][3] = player_down4;
		
		
		potion = ImageLoader.loadImage("/textures/potion.png");
		
		Spritesheet spritesheet2 = new Spritesheet(ImageLoader.loadImage("/textures/tileset2.png"));
		
		stoneWall = spritesheet2.crop(42*32, 18*32, width, height);
		
		Spritesheet worldSheet = new Spritesheet(ImageLoader.loadImage("/textures/tileset.png"));
		
		Dungeon_Floor = worldSheet.crop(3*32,8*32, width, height);
		Dungeon_Floor2 = worldSheet.crop(32,8*32, width, height);
		Dungeon_Pillar = worldSheet.crop(4*32, 8*32, width, height);
	}
}
