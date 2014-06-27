package com.FortPinnsvin.flappymontgolfiere;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.HAlignment;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScoreView {
	public float		W	= Gdx.graphics.getWidth();
	public float		H	= Gdx.graphics.getHeight();
	private BitmapFont	font;
	private SpriteBatch	batch;

	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont(Gdx.files.internal("data/8bit.fnt"), Gdx.files.internal("data/8bit.png"), false);
	}

	public void render() {
		int[] arr = LocalStorage.loadResults();
		batch.begin();
		font.setColor(0, 0, 1, 1);
		font.drawWrapped(batch, "Best results", 0, H - font.getSpaceWidth(), W, HAlignment.CENTER);
		if (arr.length < 1) font.drawWrapped(batch, "Play at least one game", 0, H / 2, W, HAlignment.CENTER);
		else for (int i = 0; i < arr.length && i < 15; i++)
			font.drawWrapped(batch, (i + 1) + "      " + arr[i], 0, H - H / 5 - (font.getSpaceWidth() + font.getLineHeight()) * i, W,
					HAlignment.CENTER);
		batch.end();
		arr = null;
	}

	public void dispose() {
		batch.dispose();
		font.dispose();
	}
}
