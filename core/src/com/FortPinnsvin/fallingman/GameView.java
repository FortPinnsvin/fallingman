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
	private long			clickCount, meters;
	private BitmapFont		font;

	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont(Gdx.files.internal("data/8bit.fnt"), Gdx.files.internal("data/8bit.png"), false);
		balloon = new Texture("balloon.png");
		spriteBalloon = new Sprite(balloon);
		spriteBalloon.setSize(W / 3, H / 4);
		spriteBalloon.setPosition(W / 2 - W / 6, H / 8);
		clickCount = 0;
		meters = 0;
	}

	public void render() {
		batch.begin();
		spriteBalloon.draw(batch);
		if (meters - 1 >= 0) {
			meters -= 1;
		}
		font.draw(batch, clickCount + " clicks", font.getSpaceWidth(), H - font.getSpaceWidth());
		font.draw(batch, meters + " meters", font.getSpaceWidth(), H - 2 * font.getSpaceWidth() - font.getLineHeight());
		batch.end();
	}

	public void processClick(int x, int y) {
		if (spriteBalloon.getBoundingRectangle().contains(x, y)) {
			meters += 10;
			clickCount++;
		}
	}
}
