package com.FortPinnsvin.fallingman;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class LocalStorage {
	public static void saveResults(int[] arr) {
		Preferences prefs = Gdx.app.getPreferences("scores");
		prefs.putInteger("size", arr.length);
		for (int i = 0; i < arr.length; i++)
			prefs.putInteger("i" + i, arr[i]);
		prefs.flush();
	}

	public static int[] loadResults() {
		Preferences prefs = Gdx.app.getPreferences("scores");
		int[] arr = new int[prefs.getInteger("size", 0)];
		for (int i = 0; i < arr.length; i++)
			arr[i] = prefs.getInteger("i" + i, 0);
		return arr;
	}
}
