package com.FortPinnsvin.fallingman;

import com.badlogic.gdx.Gdx;

public class LogicMenu {
	private boolean[] flagCloude;
	private float[] cloudeX;
	private float[] cloudeY;
	private float[] cloudeW;
	private float[] cloudeH;
	private Menu menu;
	
	public LogicMenu(){
		Menu menu = new Menu();
		cloudeX = new float[3];
		cloudeY = new float[3];
		cloudeW = new float[3];
		cloudeH = new float[3];
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
		//menu.initializeCloude(cloudeX, cloudeY, cloudeW, cloudeH);
	}
}
