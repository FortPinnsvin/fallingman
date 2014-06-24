package com.FortPinnsvin.fallingman;

import java.util.Random;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LevelsView {
	public float			W		= Gdx.graphics.getWidth();
	public float			H		= Gdx.graphics.getHeight();
	private SpriteBatch		batch;
	private BitmapFont		font;
	private float			buttonWidth;
	private float			buttonHeight;
	private Sprite[][]		buttons;
	private Texture			buttonTexture;
	private Texture			balloon;
	public static Sprite	spriteBalloon;
	private Random			rand	= new Random();

	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont();
		buttonTexture = new Texture("button.png");
		buttonWidth = buttonHeight = (Math.min(W, H) / 5) * 0.8f;
		buttons = new Sprite[5][5];
		float fontHeight = font.getLineHeight();
		float scale = (buttonHeight / fontHeight);
		float delta = Math.abs(W - H) / 2;
		float tile = Math.min(W, H) / 5;
		float microDelta = (tile - buttonHeight) / 2;
		font.setScale(scale * 0.6f);
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++) {
				buttons[i][j] = new Sprite(buttonTexture);
				buttons[i][j].setPosition(tile * j + microDelta, delta + tile * i + microDelta);
				buttons[i][j].setSize(buttonWidth, buttonHeight);
			}
		balloon = new Texture("balloon.png");
		spriteBalloon = new Sprite(balloon);
		spriteBalloon.setSize(W / 3, H / 4);
		spriteBalloon.setPosition(W / 2, -H / 4);
	}

	public void render() {
		batch.begin();
		spriteBalloon.draw(batch);
		balloonRun();
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++) {
				buttons[i][j].draw(batch);
				float x = buttons[i][j].getX();
				float y = buttons[i][j].getY() + buttons[i][j].getHeight();
				int counter = (4 - i) * 5 + j + 1;
				TextBounds bounds = font.getBounds("" + counter);
				float dX = (buttons[i][j].getWidth() - bounds.width) / 2;
				float dY = (buttons[i][j].getHeight() - bounds.height) / 2;
				font.draw(batch, "" + counter, x + dX, y - dY);
			}
		batch.end();
	}

	public void balloonRun() {
		spriteBalloon.setPosition(spriteBalloon.getX() + (rand.nextInt(2) - 1), spriteBalloon.getY() + 2);
		if (spriteBalloon.getY() > H) spriteBalloon.setPosition(W / 2, -H / 4);
	}
}
