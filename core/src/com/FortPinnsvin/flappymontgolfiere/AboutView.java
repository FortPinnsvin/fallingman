package com.FortPinnsvin.flappymontgolfiere;

import java.util.Random;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.HAlignment;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class AboutView {
	public final float		W		= Gdx.graphics.getWidth();
	public final float		H		= Gdx.graphics.getHeight();
	private BitmapFont		fontTitle;
	private SpriteBatch		batch;
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
	private float			yText;

	public void create() {
		batch = new SpriteBatch();
		fontTitle = new BitmapFont(Gdx.files.internal("data/8bit.fnt"), Gdx.files.internal("data/8bit.png"), false);
		fontTitle.setScale((float) 0.7);
		fontTitle.setColor(Color.BLUE);
		yText = -10;
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
		yText += 2;
		if (yText > H * 1.2) yText = -10;
		fontTitle.drawWrapped(batch, "by FortPinnsvin\nDanik Tsyrkunov\nAlex Saskevich\n2014\n"
				+ "\n\nTap on a balloon to send it into space\n\nMake it faster as you can\n\n"
				+ "Every second and click counts\n\nHave fun", 0, yText, W, HAlignment.CENTER);
		batch.end();
		timer = timer + 0.03f;
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

	public void dispose() {
		batch.dispose();
		balloon.dispose();
		for (int i = 0; i < cloude.length; i++)
			cloude[i].dispose();
		for (int i = 0; i < spriteCloude.length; i++)
			spriteCloude[i] = null;
		fontTitle.dispose();
	}
}
