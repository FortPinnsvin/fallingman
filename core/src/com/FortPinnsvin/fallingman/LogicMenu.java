package com.FortPinnsvin.fallingman;

import com.badlogic.gdx.Gdx;

public class LogicMenu {
	public float		W	= Gdx.graphics.getWidth();
	public float		H	= Gdx.graphics.getHeight();
	private boolean[]	flagCloude;
	private float[]		cloudeX;
	private float[]		cloudeY;
	private float[]		cloudeW;
	private float[]		cloudeH;
	private float		buttonWidth;
	private float		buttonHeight;
	private float[]		buttonX;
	private float[]		buttonY;

	public LogicMenu() {
		cloudeX = new float[3];
		cloudeY = new float[3];
		cloudeW = new float[3];
		cloudeH = new float[3];
		buttonWidth = (W - 100);
		buttonHeight = ((H / 2) - 50) / 4;
		buttonX = new float[4];
		buttonY = new float[4];
		for (int i = 0; i < 4; i++) {
			buttonX[i] = 50;
			buttonY[i] = buttonHeight * i + 10 * (i + 1);
		}
	}

	public void buttonClick(int screenX, int screenY) {
		for (int i = 0; i < 4; i++) {
			if (screenX >= buttonX[i] && screenX <= (buttonX[i] + buttonWidth) && Gdx.graphics.getHeight() - screenY > buttonY[i]
					&& Gdx.graphics.getHeight() - screenY < (buttonY[i] + buttonHeight)) {
				if (i == 3) AndroidRun.flagView = "Game";
				if (i == 2) AndroidRun.flagView = "Menu";
				if (i == 1) AndroidRun.flagView = "Menu";
				if (i == 0) AndroidRun.flagView = "Menu";
				Menu.flagScrollButton = true;
			}
		}
	}

	public void draggedCloude(int screenX, int screenY) {
		for (int i = 0; i < 3; i++) {
			if (screenX >= Menu.cloudeX[i] && screenX <= (Menu.cloudeX[i] + Menu.cloudeW[i])
					&& Gdx.graphics.getHeight() - screenY > Menu.cloudeY[i]
					&& Gdx.graphics.getHeight() - screenY < (Menu.cloudeY[i] + Menu.cloudeH[i])) {
				Menu.cloudeX[i] = screenX - Menu.cloudeW[i] / 2;
				Menu.cloudeY[i] = Gdx.graphics.getHeight() - screenY - Menu.cloudeH[i] / 2;
			}
		}
	}

	public void scrollButton() {
		float[] pos = new float[4];
		for (int i = 0; i < 4; i++) {
			if (i % 2 == 0) pos[i] = Menu.spriteButton[i].getX() + 20;
			else pos[i] = Menu.spriteButton[i].getX() - 20;
		}
		for (int i = 0; i < 4; i++) {
			Menu.spriteButton[i].setPosition(pos[i], buttonHeight * i + 10 * (i + 1));
		}
	}

	public boolean checkScrollButton() {
		if (Menu.spriteButton[0].getX() > Gdx.graphics.getWidth()) return true;
		else return false;
	}

	public void balloonRun() {
		Menu.spriteBalloon.setPosition(100, Menu.spriteBalloon.getY() + 2);
	}
}
