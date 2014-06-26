package com.FortPinnsvin.fallingman;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class GameView {
	public float			W	= Gdx.graphics.getWidth();
	public float			H	= Gdx.graphics.getHeight();
	private Texture			balloon;
	public static Sprite	spriteBalloon;
	private Texture			bg;
	private Sprite			spriteBg;
	private SpriteBatch		batch;
	private long			clickCount, meters, step;
	private BitmapFont		font;

	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont(Gdx.files.internal("data/8bit.fnt"), Gdx.files.internal("data/8bit.png"), false);
		balloon = new Texture("balloon.png");
		spriteBalloon = new Sprite(balloon);
		spriteBalloon.setSize(W / 3, H / 4);
		spriteBalloon.setPosition(W / 2 - W / 6, H / 8);
		bg = new Texture("bg.png");
		spriteBg = new Sprite(bg);
		spriteBg.setPosition(0, 0);
		spriteBg.setSize(W, H);
		clickCount = 0;
		meters = 0;
		step = 10;
	}

	public void render() {
		renderGradient();
		batch.begin();
		spriteBg.draw(batch);
		spriteBalloon.draw(batch);
		font.draw(batch, clickCount + " clicks", font.getSpaceWidth(), H - font.getSpaceWidth());
		font.draw(batch, meters + " meters", font.getSpaceWidth(), H - 2 * font.getSpaceWidth() - font.getLineHeight());
		font.draw(batch, step + " meters/click", font.getSpaceWidth(), H - 3 * font.getSpaceWidth() - 2 * font.getLineHeight());
		batch.end();
		if (meters - (step / 10) >= 0) {
			meters -= (step / 10);
			step = 10 + (int) Math.hypot(meters / 25, meters / 500);
		}
		renderGround();
		spriteBg.setPosition(0, -meters);
	}

	public void renderGradient() {
		float red, green, blue;
		if (meters > H) {
			blue = 255 - ((float) meters / 10000f) * 255;
			red = 88 - ((float) meters / 10000f) * 88;
			green = 190 - ((float) meters / 10000f) * 190;
		} else {
			blue = 255;
			green = 190;
			red = 88;
		}
		ShapeRenderer shape = new ShapeRenderer();
		shape.begin(ShapeType.Filled);
		shape.setColor(red / 255f, green / 255f, blue / 255f, 1);
		shape.rect(0, 0, W, H);
		shape.end();
	}

	public void renderGround() {
		ShapeRenderer shape = new ShapeRenderer();
		shape.begin(ShapeType.Filled);
		shape.setColor(0, 1, 0, 1);
		shape.rect(0, 0, W, H / 8 - meters);
		shape.end();
	}

	public void processClick(int x, int y) {
		if (spriteBalloon.getBoundingRectangle().contains(x, y)) {
			meters += step;
			clickCount++;
			step = 10 + (int) Math.hypot(meters / 25, meters / 500);
			spriteBg.setPosition(0, -meters);
		}
	}
}
