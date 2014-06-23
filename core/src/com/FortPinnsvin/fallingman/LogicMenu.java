package com.FortPinnsvin.fallingman;

import com.badlogic.gdx.Gdx;

public class LogicMenu {
	public float W = Gdx.graphics.getWidth();
	public float H = Gdx.graphics.getHeight();
	private boolean[] flagCloude;
	private float[] cloudeX;
	private float[] cloudeY;
	private float[] cloudeW;
	private float[] cloudeH;
	private Menu menu;
	private float buttonWidth;
	private float buttonHeight;
	private float[] buttonX;
	private float[] buttonY;

	public LogicMenu() {
		Menu menu = new Menu();
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
			if (screenX >= buttonX[i]
					&& screenX <= (buttonX[i] + buttonWidth)
					&& Gdx.graphics.getHeight() - screenY > buttonY[i]
					&& Gdx.graphics.getHeight() - screenY < (buttonY[i] + buttonHeight)) {
				if (i == 3) AndroidRun.flagView = "Game";
				if (i == 2) AndroidRun.flagView = "Menu";
				if (i == 1) AndroidRun.flagView = "Menu";
				if (i == 0) AndroidRun.flagView = "Menu";
			}
		}
	}

	public void initializeCloude(float[] x, float[] y, float[] w, float[] h) {
		for (int i = 0; i < 3; i++) {
			this.cloudeX[i] = x[i];
			this.cloudeY[i] = y[i];
			this.cloudeW[i] = w[i];
			this.cloudeH[i] = h[i];
		}
	}

	public void draggedCloude(int screenX, int screenY) {
		for (int i = 0; i < 3; i++) {
			if (screenX >= Menu.cloudeX[i]
					&& screenX <= (Menu.cloudeX[i] + Menu.cloudeW[i])
					&& Gdx.graphics.getHeight() - screenY > Menu.cloudeY[i]
					&& Gdx.graphics.getHeight() - screenY < (Menu.cloudeY[i] + Menu.cloudeH[i])) {
				Menu.cloudeX[i] = screenX - Menu.cloudeW[i] / 2;
				Menu.cloudeY[i] = Gdx.graphics.getHeight() - screenY
						- Menu.cloudeH[i] / 2;
			}
		}
		// menu.initializeCloude(cloudeX, cloudeY, cloudeW, cloudeH);
	}
}
