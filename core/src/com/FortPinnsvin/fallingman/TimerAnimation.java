package com.FortPinnsvin.fallingman;

public class TimerAnimation {
	private LogicMenu	logicMenu;

	public TimerAnimation() {
		logicMenu = new LogicMenu();
	}

	public boolean timer() {
		return (logicMenu.checkScrollButton());
	}
}
