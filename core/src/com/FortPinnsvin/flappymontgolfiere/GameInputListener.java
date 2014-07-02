package com.FortPinnsvin.flappymontgolfiere;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

public class GameInputListener implements InputProcessor {
	public final float	W	= Gdx.graphics.getWidth();
	public final float	H	= Gdx.graphics.getHeight();
	private LogicMenu	logicMenu;
	private AndroidRun	androidRun;

	public GameInputListener(AndroidRun androidRun) {
		this.logicMenu = new LogicMenu();
		this.androidRun = androidRun;
	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		if (keycode == Keys.BACK) {
			if (AndroidRun.flagView.equals("Scores")) {
				AndroidRun.flagView = "Menu";
				AndroidRun.score.dispose();
				Menu.flagScrollButton = -1;
			} else if (AndroidRun.flagView.equals("About")) {
				AndroidRun.flagView = "Menu";
				AndroidRun.about.dispose();
				Menu.flagScrollButton = -1;
			} else if (AndroidRun.flagView.equals("Menu")) {
				AndroidRun.menu.dispose();
				System.exit(0);
			} else if (AndroidRun.flagView.equals("Game")) {
				AndroidRun.flagView = "Menu";
				AndroidRun.game.dispose();
				Menu.flagScrollButton = -1;
			}
		}
		System.gc();
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		if (AndroidRun.flagView.equals("Menu")) logicMenu.processClick(screenX, screenY);
		if (AndroidRun.flagView.equals("Game")) androidRun.game.processClick(screenX, (int) H - screenY);
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// logicMenu.draggedCloude(screenX, screenY);
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}
