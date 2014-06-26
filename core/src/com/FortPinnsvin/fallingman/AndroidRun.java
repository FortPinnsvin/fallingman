package com.FortPinnsvin.fallingman;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.HAlignment;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class AndroidRun implements ApplicationListener {
	private Menu			menu;
	public static String	flagView;
	public static GameView	game;
	private AboutView		about;
	private Background		background;
	private TimerAnimation	timerAnimation;
	private boolean			isLoaded	= false;
	public float			W;
	public float			H;
	private SpriteBatch		batch;
	private BitmapFont		font;

	@Override
	public void create() {
		flagView = "Loading";
		batch = new SpriteBatch();
		font = new BitmapFont(Gdx.files.internal("data/8bit.fnt"), Gdx.files.internal("data/8bit.png"), false);
		W = Gdx.graphics.getWidth();
		H = Gdx.graphics.getHeight();
		Gdx.input.setInputProcessor(new GameInputListener(this));
		Gdx.input.setCatchBackKey(true);
		timerAnimation = new TimerAnimation();
		// MenuView
		menu = new Menu();
		menu.create();
		// GameView
		game = new GameView();
		// BackgroundView
		background = new Background();
		background.create();
		// AboutView
		about = new AboutView();
		about.create();
		flagView = "Menu";
		isLoaded = true;
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if (isLoaded) {
			background.render();
			if (flagView == "Menu" || !timerAnimation.timer()) menu.render();
			if (flagView == "Game" && timerAnimation.timer()) game.render();
			if (flagView == "About" && timerAnimation.timer()) about.render();
		} else {
			batch.begin();
			font.drawWrapped(batch, "Loading...", 0, H / 2, W, HAlignment.CENTER);
			batch.end();
		}
	}

	@Override
	public void resize(int width, int height) {}

	@Override
	public void pause() {}

	@Override
	public void resume() {}

	@Override
	public void dispose() {}
}
