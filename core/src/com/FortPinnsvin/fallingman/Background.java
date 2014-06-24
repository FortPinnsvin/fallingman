package com.FortPinnsvin.fallingman;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Background {

	public final float WIDTH = Gdx.graphics.getWidth();
	public final float HEIGHT = Gdx.graphics.getHeight();
	private Texture bg;
	private Sprite spriteBg;
	private SpriteBatch batch;

	public void create() {
		// TODO Auto-generated method stub
		batch = new SpriteBatch();
		bg = new Texture("bg.png");
		spriteBg = new Sprite(bg);
		spriteBg.setPosition(0, 0);
		spriteBg.setSize(WIDTH, HEIGHT);

	}

	public void render() {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// Рисуем наш background
		batch.begin();
		spriteBg.draw(batch);
		batch.end();

	}

}
