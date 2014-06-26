package com.FortPinnsvin.fallingman;

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
	private BitmapFont		font, fontTitle;
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
	private float 			yText;
	
	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont(Gdx.files.internal("data/8bit.fnt"), Gdx.files.internal("data/8bit.png"), false);
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
		float xtext1 = fontTitle.getBounds("by FortPinnsvin").width;
		float xtext2 = fontTitle.getBounds("Danik Tsyrkunov").width;
		float xtext3 = fontTitle.getBounds("Alex Saskevich").width;
		float xtext4 = fontTitle.getBounds("2014").width;
		yText += 2;
		if (yText > H+90 ) yText = -10;
		fontTitle.drawWrapped(batch,"by FortPinnsvin", (W-xtext1)/2 ,  yText , W - 20);
		fontTitle.drawWrapped(batch,"Danik Tsyrkunov", (W-xtext2)/2 ,  yText-30 , W - 20);
		fontTitle.drawWrapped(batch,"Alex Saskevich", (W-xtext3)/2 ,  yText-60 , W - 20);
		fontTitle.drawWrapped(batch,"2014", (W-xtext4)/2 ,  yText-90 , W - 20);
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
}
