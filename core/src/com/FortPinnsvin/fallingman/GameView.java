package com.FortPinnsvin.fallingman;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameView {
	public float			W	= Gdx.graphics.getWidth();
	public float			H	= Gdx.graphics.getHeight();
	private Texture			balloon;
	public static Sprite	spriteBalloon;
	private SpriteBatch		batch;
	private long			clickCount;
	private BitmapFont		font;

	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont(Gdx.files.internal("data/8bit.fnt"), Gdx.files.internal("data/8bit.png"), false);
		balloon = new Texture("balloon.png");
		spriteBalloon = new Sprite(balloon);
		spriteBalloon.setSize(W / 3, H / 4);
		spriteBalloon.setPosition(W / 2 - W / 6, H / 8);
		clickCount = 0;
	}

	public void render() {
		batch.begin();
		spriteBalloon.draw(batch);
		spriteBalloon.translateY(-1f);
		font.draw(batch, clickCount + " clicks", font.getSpaceWidth(), H - font.getLineHeight() - font.getSpaceWidth());
		batch.end();
	}

	public void processClick(int x, int y) {
		if (spriteBalloon.getBoundingRectangle().contains(x, y)) {
			spriteBalloon.translateY(10);
			clickCount++;
		}
	}
}
