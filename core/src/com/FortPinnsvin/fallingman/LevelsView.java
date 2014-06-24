package com.FortPinnsvin.fallingman;

import java.util.Random;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LevelsView {
	public float			W		= Gdx.graphics.getWidth();
	public float			H		= Gdx.graphics.getHeight();
	private SpriteBatch		batch;
	private BitmapFont		font, fontTitle;
	private float			buttonWidth;
	private float			buttonHeight;
	private Sprite[][]		buttons;
	private Texture			buttonTexture;
	private Texture			balloon;
	public static Sprite	spriteBalloon;
	private Random			rand	= new Random();
	public static float[]	cloudeX;
	public static float[]	cloudeY;
	public static float[]	cloudeW;
	public static float[]	cloudeH;
	private Sprite[]		spriteCloude;
	private Texture[]		cloude;
	private float			timer	= 0.0f;

	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont(Gdx.files.internal("data/8bit.fnt"), Gdx.files.internal("data/8bit.png"), false);
		fontTitle = new BitmapFont(Gdx.files.internal("data/8bit.fnt"), Gdx.files.internal("data/8bit.png"), false);
		buttonTexture = new Texture("button.png");
		buttonWidth = buttonHeight = (Math.min(W, H) / 4) * 0.8f;
		buttons = new Sprite[6][4];
		float fontHeight = font.getLineHeight();
		float scale = (buttonHeight / fontHeight);
		float delta = buttonHeight * 0.25f;
		float tile = Math.min(W, H) / 4;
		float microDelta = (tile - buttonHeight) / 2;
		float space = H - (delta + tile * 5 + microDelta);
		font.setScale(scale * 0.4f);
		fontTitle.setScale((space / fontTitle.getLineHeight()) / 6f);
		fontTitle.setColor(Color.BLUE);
		for (int i = 0; i < 6; i++)
			for (int j = 0; j < 4; j++) {
				buttons[i][j] = new Sprite(buttonTexture);
				buttons[i][j].setPosition(tile * j + microDelta, delta + tile * i + microDelta);
				buttons[i][j].setSize(buttonWidth, buttonHeight);
			}
		balloon = new Texture("balloon.png");
		spriteBalloon = new Sprite(balloon);
		spriteBalloon.setSize(W / 3, H / 4);
		spriteBalloon.setPosition(W / 2, -H / 4);
		spriteCloude = new Sprite[3];
		cloude = new Texture[3];
		for (int i = 0; i < 3; i++) {
			cloude[i] = new Texture("cloude" + (i + 1) + ".png");
			spriteCloude[i] = new Sprite(cloude[i]);
		}
		cloudeX = new float[3];
		cloudeY = new float[3];
		cloudeW = new float[3];
		cloudeH = new float[3];
		cloudeX[0] = (float) (W / 20);
		cloudeY[0] = (float) (H / 1.3);
		cloudeX[1] = (float) (W / 19);
		cloudeY[1] = (float) (H / 1.7);
		cloudeX[2] = (float) (W / 2);
		cloudeY[2] = (float) (H / 1.5);
		cloudeW[0] = (float) (W / 2.2);
		cloudeH[0] = H / 7;
		cloudeW[1] = (float) (W / 3);
		cloudeH[1] = H / 9;
		cloudeW[2] = (float) (W / 2);
		cloudeH[2] = H / 12;
		setCloude();
	}

	public void render() {
		batch.begin();
		spriteBalloon.draw(batch);
		balloonRun();
		for (int i = 0; i < 3; i++) {
			float delta = (float) (Math.sin(timer * (i + 1)) * (W / 10.0f));
			spriteCloude[i].setX(spriteCloude[i].getX() + delta);
			spriteCloude[i].draw(batch);
			spriteCloude[i].setX(spriteCloude[i].getX() - delta);
		}
		for (int i = 0; i < 6; i++)
			for (int j = 0; j < 4; j++) {
				buttons[i][j].draw(batch);
				float x = buttons[i][j].getX();
				float y = buttons[i][j].getY() + buttons[i][j].getHeight();
				int counter = (5 - i) * 6 + j + 1;
				TextBounds bounds = font.getBounds("" + counter);
				float dX = (buttons[i][j].getWidth() - bounds.width) / 2;
				float dY = (buttons[i][j].getHeight() - bounds.height) / 2;
				font.draw(batch, "" + counter, x + dX, y - dY);
			}
		drawTitle();
		batch.end();
		timer = timer + 0.05f;
	}

	private void drawTitle() {
		float delta = buttonHeight * 0.25f;
		float tile = Math.min(W, H) / 4;
		float microDelta = (tile - buttonHeight) / 2;
		float space = H - (delta + tile * 6 + microDelta);
		TextBounds bounds = fontTitle.getBounds("Select level:");
		float dX = bounds.width / 2;
		float dY = bounds.height / 2;
		fontTitle.draw(batch, "Select level:", W / 2 - dX, H - space / 2 - dY);
	}

	public void balloonRun() {
		spriteBalloon.setPosition(spriteBalloon.getX() + (rand.nextInt(2) - 1), spriteBalloon.getY() + 2);
		if (spriteBalloon.getY() > H) spriteBalloon.setPosition(W / 2, -H / 4);
	}

	private void setCloude() {
		for (int i = 0; i < 3; i++) {
			spriteCloude[i].setPosition(cloudeX[i], cloudeY[i]);
			spriteCloude[i].setSize(cloudeW[i], cloudeH[i]);
		}
	}
}
