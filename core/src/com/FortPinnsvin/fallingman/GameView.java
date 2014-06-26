package com.FortPinnsvin.fallingman;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameView {
	public final int HEIGHT_BALLOON = 10000;
	public float W = Gdx.graphics.getWidth();
	public float H = Gdx.graphics.getHeight();
	private Texture balloon;
	private Texture shkala;
	public static Sprite spriteBalloon;
	private SpriteBatch batch;
	private Sprite spriteShkala;
	public static Sprite spriteMiniBalloon;
	private long clickCount, meters;
	private BitmapFont font;

	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont(Gdx.files.internal("data/8bit.fnt"),
				Gdx.files.internal("data/8bit.png"), false);
		balloon = new Texture("balloon.png");
		shkala = new Texture("Shkala.png");
		spriteBalloon = new Sprite(balloon);
		spriteBalloon.setSize(W / 3, H / 4);
		spriteBalloon.setPosition(W / 2 - W / 6, H / 8);
		spriteShkala = new Sprite(shkala);
		spriteShkala.setPosition((float) (W / 1.05), 0);
		spriteShkala.setSize(W - (float) (W / 1.05), H);
		spriteMiniBalloon = new Sprite(balloon);
		spriteMiniBalloon.setPosition((float) (W / 1.05), 5);
		spriteMiniBalloon.setSize(W - (float) (W / 1.05), H / 27);

		clickCount = 0;
		meters = 0;
	}

	public void render() {
		batch.begin();
		spriteBalloon.draw(batch);
		if (meters - 1 >= 0) {
			meters -= 1;
		}
		spriteShkala.draw(batch);
		spriteMiniBalloon.draw(batch);
		font.draw(batch, clickCount + " clicks", font.getSpaceWidth(),
				H - font.getSpaceWidth());
		font.draw(batch, meters + " meters", font.getSpaceWidth(),
				H - 2 * font.getSpaceWidth() - font.getLineHeight());
		
		spriteMiniBalloon.setY((H*meters)/HEIGHT_BALLOON);
		batch.end();
	}

	public void processClick(int x, int y) {
		if (spriteBalloon.getBoundingRectangle().contains(x, y)) {
			meters += 10;
			clickCount++;
		}
	}
}
