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

public class Menu extends AndroidRun {
	public  float W = Gdx.graphics.getWidth();
	public  float H = Gdx.graphics.getHeight();
	public  float x = (float)(W / 20);
	public  float y = (float)(H / 1.3);
	private SpriteBatch batch;
	private Sprite spriteBg;
	private Sprite[] spriteButton;
	private Texture bg;
	private Texture button;
	private BitmapFont font;
	private float buttonWidth;
	private float buttonHeight;
	private boolean flagButton;
	private Sprite[] spriteCloude;
	private Texture[] cloude;

	@Override
	public void create() {

		flagButton = false;
		batch = new SpriteBatch();

		font = new BitmapFont();

		bg = new Texture("bg.png");
		spriteBg = new Sprite(bg);
		spriteBg.setPosition(0, 0);
		spriteBg.setSize(W, H);
		
		

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
		spriteCloude[0].setPosition(x, y);
		spriteCloude[0].setCenter(spriteCloude[0].getWidth()/2, spriteCloude[0].getHeight()/2);
		spriteCloude[0].setSize((float)(W/2.2),H/7);
		spriteCloude[1].setPosition((float)(W / 19), (float)(H / 1.7));
		spriteCloude[1].setSize((float)(W/3), H/9);
		spriteCloude[2].setPosition((float)(W / 2), (float)(H / 1.5));
		spriteCloude[2].setSize((float)(W/2), H/12);

		
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// Рисуем наш background
		batch.begin();
		spriteBg.draw(batch);
		batch.end();

		// Рисуем кнопки
		batch.begin();
		for (int i = 0; i < 3; i++) {
			spriteCloude[i].draw(batch);
		}
		spriteCloude[0].setPosition(x, y);
		
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

}
