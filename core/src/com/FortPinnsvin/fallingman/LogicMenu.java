package com.FortPinnsvin.fallingman;

import java.util.Random;
import com.badlogic.gdx.Gdx;

public class LogicMenu {
	public float		W	= Gdx.graphics.getWidth();
	public float		H	= Gdx.graphics.getHeight();
	private float		buttonWidth;
	private float		buttonHeight;
	private float[]		buttonX;
	private float[]		buttonY;
	private Random		rand;

	public LogicMenu() {
		buttonWidth = (W - 100);
		buttonHeight = ((H / 2) - 50) / 4;
		buttonX = new float[4];
		buttonY = new float[4];
		rand = new Random();
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
				if (i == 2) AndroidRun.flagView = "Levels";
				if (i == 1) AndroidRun.flagView = "Menu";
				if (i == 0) AndroidRun.flagView = "About";
				Menu.flagScrollButton = 1;
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
		if (pos[0] == W + 120) {
			Menu.flagScrollButton = 0;
		}
	}

	public boolean checkScrollButton() {
		if (Menu.spriteButton[0].getX() > (W + 110)) return true;
		else return false;
	}

	public void balloonRun() {
		Menu.spriteBalloon.setPosition(Menu.spriteBalloon.getX() + (rand.nextInt(2) - 1), Menu.spriteBalloon.getY() + 2);
	}

	public void showButton() {
		float[] pos = new float[4];
		for (int i = 0; i < 4; i++) {
			if (i % 2 == 0) pos[i] = Menu.spriteButton[i].getX() - 20;
			else pos[i] = Menu.spriteButton[i].getX() + 20;
		}
		for (int i = 0; i < 4; i++) {
			Menu.spriteButton[i].setPosition(pos[i], buttonHeight * i + 10 * (i + 1));
		}
		if (pos[0] == 50) {
			Menu.flagScrollButton = 0;
		}
	}
}
