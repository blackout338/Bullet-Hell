package dev.rightbehindu.testgame;

import dev.rightbehindu.testgame.entities.Entity;

public class Camera {
	private Game game;
	private float xOffset, yOffset, xStart, xEnd, yStart, yEnd;
	private float shakeEventTimer = 0, shakeTick = 0;
	private float shakeDuration = 0.5f;
	private boolean Shaking = false, Panning = false;
	
	private float panEventTimer = 0;
	private float panDuration = 5f;
	private float panX = 0, panY = 0;
	private Entity panEntity;
	
	private Entity focus;
	
	
	public Camera(Game game, float xOffset, float yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		this.xStart = game.getWorld().getxStart();
		this.xEnd = game.getWorld().getxEnd();
		this.yStart = game.getWorld().getyStart();
		this.yEnd = game.getWorld().getyEnd();
		this.game = game;
		
		this.focus = game.getPlayer();
	}
	
	
	public void tick() {
		setxStart(game.getWorld().getxStart());
		setyStart(game.getWorld().getyStart());
		setxEnd(game.getWorld().getxEnd());
		setyEnd(game.getWorld().getyEnd());
		
		if(this.focus != null) {
			centerOnEntity(this.focus);
		} else {
			CheckPanning();
		}
	}
	
	
	public Entity getFocus() {
		return focus;
	}


	public void setFocus(Entity focus) {
		this.focus = focus;
	}


	public float getShakeTick() {
		return shakeTick;
	}

	public void setShakeTick(float shakeTick) {
		this.shakeTick = shakeTick;
	}

	public boolean isShaking() {
		return Shaking;
	}

	public void setShaking(boolean shaking) {
		Shaking = shaking;
	}

	public float getShakeEventTimer() {
		return shakeEventTimer;
	}

	public void setShakeEventTimer(float shakeEventTimer) {
		this.shakeEventTimer = shakeEventTimer;
	}


	public float getxStart() {
		return xStart;
	}

	public void setxStart(float xStart) {
		this.xStart = xStart;
	}

	public float getxEnd() {
		return xEnd;
	}

	public void setxEnd(float xEnd) {
		this.xEnd = xEnd;
	}

	public float getyStart() {
		return yStart;
	}

	public void setyStart(float yStart) {
		this.yStart = yStart;
	}

	public float getyEnd() {
		return yEnd;
	}

	public void setyEnd(float yEnd) {
		this.yEnd = yEnd;
	}

	public void move(float xAmt, float yAmt) {
		xOffset += xAmt;
		yOffset += yAmt;
	}	
	
	public void centerOnEntity(Entity e) {
		xOffset = e.getX() - game.getWidth() / 2 + e.getWidth() / 2;
		yOffset = e.getY() - game.getHeight() / 2 + e.getHeight() / 2;
		CheckShaking();
		CheckPanning();
	
	}
	
	public void PanTo(Entity e, float duration) {
		
		if(e == this.focus)
			return;
		
		
		//Panning Math
		float dx = (e.getX() - (this.focus.getX()) - 1);
		float dy = (e.getY() - (this.focus.getY()) - 1);
		float mag = (float) Math.sqrt((dx*dx)+(dy*dy));
		
		
		
		float pixelsPerSecond = mag/duration;
		
		
		
		panX = (dx/mag) * (pixelsPerSecond/game.getFps());
		panY = (dy/mag) * (pixelsPerSecond/game.getFps());
		
		Panning = true;
		panDuration = duration;
		panEventTimer = game.getDt();
		focus = null;
		panEntity = e;
	}
	
	private void CheckPanning() {
		if(Panning) {
			if(panDuration > game.getDt() - panEventTimer) {
				xOffset += panX;
				yOffset += panY;
			} else {
				Panning = false;
				this.focus = panEntity;
			}
		}
	}
	
	private void CheckShaking() {
		if(Shaking) {
			if(shakeDuration > game.getDt() - shakeEventTimer) {
				shakeTick += 0.4;
				xOffset += 10* Math.sin(shakeTick);
			} else {
				//Finished shaking.
				Shaking = false;
				shakeTick = 0;
			}
		}
	}
	
	public void Shake(float dt, float duration) {
		Shaking = true;
		shakeEventTimer = dt;
		shakeDuration = duration;
	}

	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
}
