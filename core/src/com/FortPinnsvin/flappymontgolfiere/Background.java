package com.FortPinnsvin.flappymontgolfiere;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Background {
	public final float	WIDTH	= Gdx.graphics.getWidth();
	public final float	HEIGHT	= Gdx.graphics.getHeight();
	private Texture		bg;
	private Sprite		spriteBg;
	private SpriteBatch	batch;

	public void create() {
		batch = new SpriteBatch();
		bg = new Texture("bg-1-mini.png");
		spriteBg = new Sprite(bg);
		spriteBg.setPosition(0, 0);
		spriteBg.setSize(WIDTH, HEIGHT);
	}

	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		spriteBg.draw(batch);
		batch.end();
	}
}
