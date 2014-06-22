package com.FortPinnsvin.fallingman.android;

import android.os.Bundle;
import android.widget.Gallery;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;
import com.FortPinnsvin.fallingman.AndroidRun;
import com.FortPinnsvin.fallingman.Menu;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new AndroidRun(), config);
	}
}
