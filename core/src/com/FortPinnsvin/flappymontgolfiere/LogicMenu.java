package com.FortPinnsvin.flappymontgolfiere;

import java.util.Random;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Disposable;

public class LogicMenu implements Disposable {
	public float	W	= Gdx.graphics.getWidth();
	public float	H	= Gdx.graphics.getHeight();
	private float	buttonWidth;
	private float	buttonHeight;
	private float[]	buttonX;
	private float[]	buttonY;
	private Random	rand;

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

	public void processClick(int x, int y) {
		for (int i = 0; i < 4; i++) {
			if (x >= buttonX[i] && x <= (buttonX[i] + buttonWidth) && Gdx.graphics.getHeight() - y > buttonY[i]
					&& Gdx.graphics.getHeight() - y < (buttonY[i] + buttonHeight)) {
				if (i == 3) {
					AndroidRun.flagView = "Game";
					AndroidRun.game.create();
				}
				if (i == 2) {
					AndroidRun.flagView = "Scores";
				}
				if (i == 1) {
					AndroidRun.flagView = "About";
				}
				if (i == 0) System.exit(0);
				Menu.flagScrollButton = 1;
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
		if (Menu.spriteButton[0].getX() > (W + 110)) {
			return true;
		} else return false;
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

	@Override
	public void dispose() {
		rand = null;
	}
}
