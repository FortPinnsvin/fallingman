package com.FortPinnsvin.fallingman;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class AboutView {
	public final float		W		= Gdx.graphics.getWidth();
	public final float		H		= Gdx.graphics.getHeight();
	private BitmapFont		font, fontTitle;
	private SpriteBatch		batch;
	
	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont(Gdx.files.internal("data/8bit.fnt"), Gdx.files.internal("data/8bit.png"), false);
		fontTitle = new BitmapFont(Gdx.files.internal("data/8bit.fnt"), Gdx.files.internal("data/8bit.png"), false);
		fontTitle.setScale(fontTitle.getLineHeight()/ 6f);
		fontTitle.setColor(Color.BLUE);
	}

	public void render() {}
}
