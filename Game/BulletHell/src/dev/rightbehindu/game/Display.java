package dev.rightbehindu.game;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {
	
	public static JFrame frame;
	private Canvas canvas;
	
	
	
	private String title;
	private int width, height;
	
	public Display(String title, int width, int height) {
		
		this.title = title;
		this.width = width;
		this.height = height;
		
		createDisplay();
	}
	
	private void createDisplay() {
	
		//Initializing the Jframe, setting its size, location etc...
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	
		//Initializing Canvas, setting it's size.
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width,height));
		canvas.setMaximumSize(new Dimension(width,height));
		canvas.setMinimumSize(new Dimension(width,height));
		canvas.setFocusable(false);
		//Add the canvas to the main JFrame, the 'pack' it.
		frame.add(canvas);
		frame.pack();
		
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
	
	public JFrame getFrame() {
		return frame;
	}
}
