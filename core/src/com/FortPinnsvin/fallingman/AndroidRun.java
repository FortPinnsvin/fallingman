package com.FortPinnsvin.fallingman;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;

public class AndroidRun implements ApplicationListener {
	private Menu			menu;
	public static String	flagView;
	private GameView		game;
	private LevelsView		levels;
	private AboutView       about;
	private Background		background;
	private TimerAnimation	timerAnimation;

	@Override
	public void create() {
		flagView = "Menu";
		timerAnimation = new TimerAnimation();
		// MenuView
		menu = new Menu();
		menu.create();
		// GameView
		game = new GameView();
		game.create();
		// BackgroundView
		background = new Background();
		background.create();
		// LevelsView
		levels = new LevelsView();
		levels.create();
		// AboutView
		about = new AboutView();
		about.create();
		Gdx.input.setInputProcessor(new GameInputListener());
		Gdx.input.setCatchBackKey(true);
	}

	@Override
	public void render() {
		background.render();
		if (flagView == "Menu" || !timerAnimation.timer()) menu.render();
		if (flagView == "Game" && timerAnimation.timer()) game.render();
		if (flagView == "Levels" && timerAnimation.timer()) levels.render();
		if (flagView == "About" && timerAnimation.timer()) about.render();
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
