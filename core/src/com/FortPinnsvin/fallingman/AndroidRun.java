package com.FortPinnsvin.fallingman;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;

public class AndroidRun implements ApplicationListener {
	private Menu			menu;
	public static String	flagView;
	private GameView		game;
	private LevelsView		levels;
	private Background		background;
	private TimerAnimation	timerAimation;

	@Override
	public void create() {
		flagView = "Menu";
		timerAimation = new TimerAnimation();
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
		Gdx.input.setInputProcessor(new GameInputListener());
	}

	@Override
	public void render() {
		background.render();
		if (flagView == "Menu" || !timerAimation.timer()) menu.render();
		if (flagView == "Game" && timerAimation.timer()) game.render();
		if (flagView == "Levels" && timerAimation.timer()) levels.render();
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
