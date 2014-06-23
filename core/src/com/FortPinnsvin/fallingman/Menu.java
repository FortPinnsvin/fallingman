package com.FortPinnsvin.fallingman;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class Menu extends AndroidRun {
	public float W = Gdx.graphics.getWidth();
	public float H = Gdx.graphics.getHeight();
	public static float[] cloudeX;
	public static float[] cloudeY;
	public static float[] cloudeW;
	public static float[] cloudeH;
	private SpriteBatch batch;
	private Sprite[] spriteButton;
	private Texture button;
	private BitmapFont font;
	private float buttonWidth;
	private float buttonHeight;
	private boolean flagButton;
	private Sprite[] spriteCloude;
	private Texture[] cloude;
	private GameInputListener inputListener;

	@Override
	public void create() {

		flagButton = false;
		batch = new SpriteBatch();

		font = new BitmapFont();

		inputListener = new GameInputListener();

		button = new Texture("button.png");
		// Создаем 4 кнопки (присваивая им размеры и позицию в зависимости от
		// размеров экрана)
		spriteButton = new Sprite[4];
		buttonWidth = (W - 100);
		buttonHeight = ((H / 2) - 50) / 4;
		for (int i = 0; i < 4; i++) {
			spriteButton[i] = new Sprite(button);
			spriteButton[i].setPosition(50, buttonHeight * i + 10 * (i + 1));
			spriteButton[i].setSize(buttonWidth, buttonHeight);
		}

		spriteCloude = new Sprite[3];
		cloude = new Texture[3];
		for (int i = 0; i < 3; i++) {
			cloude[i] = new Texture("cloude" + (i + 1) + ".png");
			spriteCloude[i] = new Sprite(cloude[i]);
		}
		cloudeX = new float[3];
		cloudeY = new float[3];
		cloudeW = new float[3];
		cloudeH = new float[3];
		cloudeX[0] = (float) (W / 20);
		cloudeY[0] = (float) (H / 1.3);
		cloudeX[1] = (float) (W / 19);
		cloudeY[1] = (float) (H / 1.7);
		cloudeX[2] = (float) (W / 2);
		cloudeY[2] = (float) (H / 1.5);
		cloudeW[0] = (float) (W / 2.2);
		cloudeH[0] = H / 7;
		cloudeW[1] = (float) (W / 3);
		cloudeH[1] = H / 9;
		cloudeW[2] = (float) (W / 2);
		cloudeH[2] = H / 12;
		setCloude();

	}

	@Override
	public void render() {
		// TODO Auto-generated method stub

		// Рисуем кнопки
		batch.begin();
		for (int i = 0; i < 3; i++) {
			spriteCloude[i].draw(batch);
		}
		// inputListener.initializeCloude(cloudeX, cloudeY, cloudeW, cloudeH);
		setCloude();

		for (int i = 0; i < 4; i++) {
			spriteButton[i].draw(batch);
		}
		batch.end();

		if (Gdx.input.isTouched()) {
			flagButton = true;
		}
		if (flagButton)
			scrollButton();
	}

	private void setCloude() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 3; i++) {
			spriteCloude[i].setPosition(cloudeX[i], cloudeY[i]);
			spriteCloude[i].setSize(cloudeW[i], cloudeH[i]);
		}

	}

	public void scrollButton() {
		float[] pos = new float[4];

		for (int i = 0; i < 4; i++) {
			if (i % 2 == 0)
				pos[i] = spriteButton[i].getX() + 20;
			else
				pos[i] = spriteButton[i].getX() - 20;
		}
		for (int i = 0; i < 4; i++) {
			spriteButton[i]
					.setPosition(pos[i], buttonHeight * i + 10 * (i + 1));
		}
		if (spriteButton[0].getX() > Gdx.graphics.getWidth())
			flagButton = false;
	}

	public void initializeCloude(float[] x, float[] y, float[] w, float[] h) {
		for (int i = 0; i < 3; i++) {
			this.cloudeX[i] = x[i];
			this.cloudeY[i] = y[i];
			this.cloudeW[i] = w[i];
			this.cloudeH[i] = h[i];
		}
	}

}
