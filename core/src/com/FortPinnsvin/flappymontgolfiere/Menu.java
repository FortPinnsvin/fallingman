package com.FortPinnsvin.flappymontgolfiere;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.HAlignment;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Menu extends AndroidRun {
	public float			W			= Gdx.graphics.getWidth();
	public float			H			= Gdx.graphics.getHeight();
	public static float[]	cloudeX;
	public static float[]	cloudeY;
	public static float[]	cloudeW;
	public static float[]	cloudeH;
	private SpriteBatch		batch;
	public static Sprite[]	spriteButton;
	private Texture			button;
	private Texture			balloon;
	public static Sprite	spriteBalloon;
	public static int		flagScrollButton;
	private BitmapFont		font;
	private float			buttonWidth;
	private float			buttonHeight;
	private Sprite[]		spriteCloude;
	private Texture[]		cloude;
	private LogicMenu		logicMenu;
	private final String[]	BTN_LABELS	= {"Play", "Scores", "About", "Exit"};
	public String			app_name	= "Flappy Montgolfiere";
	private float			timer		= 0.0f;

	@Override
	public void create() {
		flagScrollButton = 0;
		batch = new SpriteBatch();
		font = new BitmapFont(Gdx.files.internal("data/8bit.fnt"), Gdx.files.internal("data/8bit.png"), false);
		logicMenu = new LogicMenu();
		balloon = new Texture("balloon.png");
		spriteBalloon = new Sprite(balloon);
		spriteBalloon.setSize(W / 3, H / 4);
		spriteBalloon.setPosition(W / 2, -H / 4);
		button = new Texture("button.png");
		spriteButton = new Sprite[4];
		buttonWidth = (W - 100);
		buttonHeight = ((H / 2) - 50) / 4;
		float fontHeight = font.getLineHeight();
		float scale = (buttonHeight / fontHeight * 0.8f);
		font.setScale(scale * 0.6f);
		for (int i = 0; i < 4; i++) {
			spriteButton[i] = new Sprite(button);
			spriteButton[i].setPosition(50, buttonHeight * i + 10 * (i + 1));
			spriteButton[i].setSize(buttonWidth, buttonHeight);
		}
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

	@Override
	public void render() {
		batch.begin();
		logicMenu.balloonRun();
		spriteBalloon.draw(batch);
		for (int i = 0; i < 3; i++) {
			float delta = (float) (Math.sin(timer * (i + 1)) * (W / 10.0f));
			spriteCloude[i].setX(spriteCloude[i].getX() + delta);
			spriteCloude[i].draw(batch);
			spriteCloude[i].setX(spriteCloude[i].getX() - delta);
		}
		for (int i = 0; i < 4; i++) {
			spriteButton[i].draw(batch);
			float x = spriteButton[i].getX();
			float y = spriteButton[i].getY() + spriteButton[i].getHeight();
			TextBounds bounds = font.getBounds(BTN_LABELS[BTN_LABELS.length - i - 1]);
			float dX = (spriteButton[i].getWidth() - bounds.width) / 2;
			float dY = (spriteButton[i].getHeight() - bounds.height) / 2;
			font.draw(batch, BTN_LABELS[BTN_LABELS.length - i - 1], x + dX, y - dY);
		}
		font.setScale(1.2f);
		font.setColor(0, 0, 1, 1);
		font.drawWrapped(batch, app_name, 0, H - H / 10, W, HAlignment.CENTER);
		font.setScale(1f);
		float fontHeight = font.getLineHeight();
		float scale = (buttonHeight / fontHeight * 0.8f);
		font.setScale(scale * 0.6f);
		font.setColor(1, 1, 1, 1);
		batch.end();
		timer = timer + 0.03f;
		if (flagScrollButton == 1) logicMenu.scrollButton();
		if (flagScrollButton == -1) logicMenu.showButton();
	}

	private void setCloude() {
		for (int i = 0; i < 3; i++) {
			spriteCloude[i].setPosition(cloudeX[i], cloudeY[i]);
			spriteCloude[i].setSize(cloudeW[i], cloudeH[i]);
		}
	}
	
	public void dispose(){
		batch.dispose();
		button.dispose();
		balloon.dispose();		
		font.dispose();
		for(int i = 0; i<cloude.length; i++ )cloude[i].dispose();
		for(int i = 0; i<spriteCloude.length; i++ )spriteCloude[i] = null;
		for(int i = 0; i<spriteButton.length; i++ )spriteButton[i] = null;
	}
}
