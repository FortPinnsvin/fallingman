package com.FortPinnsvin.flappymontgolfiere;

public class TimerAnimation {
	private LogicMenu	logicMenu;

	public TimerAnimation() {
		logicMenu = new LogicMenu();
	}

	public boolean timer() {
		return (logicMenu.checkScrollButton());
	}
}
