package com.FortPinnsvin.fallingman;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Menu extends AndroidRun {
	public float W = Gdx.graphics.getWidth();
	public float H = Gdx.graphics.getHeight();
	public static float[] cloudeX;
	public static float[] cloudeY;
	public static float[] cloudeW;
	public static float[] cloudeH;
	private SpriteBatch batch;
	public static Sprite[] spriteButton;
	private Texture button;
	private Texture balloon;
	public static Sprite spriteBalloon;
	public static boolean flagScrollButton;
	private BitmapFont font;
	private float buttonWidth;
	private float buttonHeight;
	private Sprite[] spriteCloude;
	private Texture[] cloude;
	private GameInputListener inputListener;
	private LogicMenu logicMenu;

	@Override
	public void create() {

		flagScrollButton = false;

		batch = new SpriteBatch();

		font = new BitmapFont();

		inputListener = new GameInputListener();
		logicMenu = new LogicMenu();

		balloon = new Texture("balloon.png");
		spriteBalloon = new Sprite(balloon);
		spriteBalloon.setSize(W/3, H/4);
		spriteBalloon.setPosition(W/2, -H/4);
	

		button = new Texture("button.png");
		// ������� 4 ������ (���������� �� ������� � ������� � ����������� ��
		// �������� ������
		spriteButton = new Sprite[4];
		buttonWidth = (W - 100);
		buttonHeight = ((H / 2) - 50) / 4;
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
		// TODO Auto-generated method stub
		// ������ ������
		batch.begin();

		logicMenu.balloonRun();
		spriteBalloon.draw(batch);

		for (int i = 0; i < 3; i++) {
			spriteCloude[i].draw(batch);
		}
		// inputListener.initializeCloude(cloudeX, cloudeY, cloudeW, cloudeH);
		setCloude();

		for (int i = 0; i < 4; i++) {
			spriteButton[i].draw(batch);
		}

		batch.end();
		if (flagScrollButton)
			logicMenu.scrollButton();

	}

	private void setCloude() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 3; i++) {
			spriteCloude[i].setPosition(cloudeX[i], cloudeY[i]);
			spriteCloude[i].setSize(cloudeW[i], cloudeH[i]);
		}

	}

}
