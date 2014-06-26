package com.FortPinnsvin.flappymontgolfiere.android;

import android.os.Bundle;
import com.FortPinnsvin.flappymontgolfiere.AndroidRun;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new AndroidRun(), config);
	}
}
