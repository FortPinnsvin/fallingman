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
	private SpriteBatch batch;
	private Sprite spriteBg;
	private Sprite[] spriteButton;
	private Texture bg;
	private Texture button;
	private BitmapFont font;
	private float buttonWidth;
	private float buttonHeight;
	private boolean flagButton;

	@Override
	public void create() {

		flagButton = false;
		batch = new SpriteBatch();

		font = new BitmapFont();

		bg = new Texture("bg.png");
		spriteBg = new Sprite(bg);
		spriteBg.setPosition(0, 0);
		spriteBg.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		button = new Texture("button.png");
		// Создаем 4 кнопки (присваивая им размеры и позицию в зависимости от
		// размеров экрана)
		spriteButton = new Sprite[4];
		buttonWidth = (Gdx.graphics.getWidth() - 100);
		buttonHeight = ((Gdx.graphics.getHeight() / 2) - 50) / 4;
		for (int i = 0; i < 4; i++) {
			spriteButton[i] = new Sprite(button);
			spriteButton[i].setPosition(50, buttonHeight * i + 10 * (i + 1));
			spriteButton[i].setSize(buttonWidth, buttonHeight);
		}

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
